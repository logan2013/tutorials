package com.imtzp.javasisst;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Mnemonic;

public class JavassistTest {

	/**
	 * 
	 * 使用Javassist创建class文件
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SecurityException
	 * @throws CannotCompileException
	 * @throws RuntimeException
	 */
	@Test
	public void givenJavasisstAPI_whenConstructClass_thenGenerateAClassFile()
			throws FileNotFoundException, IOException, SecurityException, CannotCompileException, RuntimeException {

		// given
		String classWithPackage = "com.imtzp.JavassistGeneratedClass";

		ClassFile cf = new ClassFile(false, classWithPackage, null);
		cf.setInterfaces(new String[] { Cloneable.class.getName() });

		FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
		f.setAccessFlags(AccessFlag.PUBLIC);
		cf.addField(f);

		// when
		String className = "JavassistGeneratedClass";
		cf.write(new DataOutputStream(new FileOutputStream(className)));

		// then
		ClassPool classPool = ClassPool.getDefault();
		/**
		 * 反射
		 */
		Field[] fields = classPool.makeClass(cf).toClass().getFields();
		Assert.assertEquals("id", fields[0].getName());

		String classContent = new String(Files.readAllBytes(Paths.get(className)));
		Assert.assertTrue(classContent.contains("java/lang/Cloneable"));
	}

	/**
	 * 使用Javassist操作已有的class文件
	 * 
	 * @throws NotFoundException
	 * @throws BadBytecode
	 */
	@Test
	public void givenJavaClass_whenLoadAtByJavassist_thenTraversWholeClass() throws NotFoundException, BadBytecode {

		// given
		ClassPool cp = ClassPool.getDefault();
		ClassFile cf = cp.get("com.imtzp.javasisst.Point").getClassFile();
		MethodInfo minfo = cf.getMethod("move");

		CodeAttribute ca = minfo.getCodeAttribute();
		CodeIterator ci = ca.iterator();

		// when
		List<String> operations = new LinkedList<>();
		while (ci.hasNext()) {
			int index = ci.next();
			int op = ci.byteAt(index);

			/**
			 * 
			 * 数组的位置表示指令的int值
			 * 
			 * 数组位置对应的值表示字符串值
			 */
			operations.add(Mnemonic.OPCODE[op]);
		}

		// then
		Assert.assertEquals(operations,
				Arrays.asList("aload_0", "iload_1", "putfield", "aload_0", "iload_2", "putfield", "return"));
	}

	/**
	 * 给已存在的class增加field
	 * 
	 * @throws NotFoundException
	 * @throws SecurityException
	 * @throws CannotCompileException
	 * @throws RuntimeException
	 */
	@Test
	public void givenTableOfInstructions_whenAddNewInstruction_thenShouldConstructProperSequence()
			throws NotFoundException, SecurityException, CannotCompileException, RuntimeException {

		// given
		ClassFile cf = ClassPool.getDefault().get("com.imtzp.javasisst.ThreeDimensionalPoint").getClassFile();

		// when
		FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
		f.setAccessFlags(AccessFlag.PUBLIC);
		cf.addField(f);

		ClassPool classPool = ClassPool.getDefault();
		Field[] fields = classPool.makeClass(cf).toClass().getFields();
		List<String> fieldsList = Stream.of(fields).map(Field::getName).collect(Collectors.toList());

		Assert.assertTrue(fieldsList.contains("id"));
	}

	/**
	 * 给已存在的class增加构造方法
	 * 
	 * @throws NotFoundException
	 * @throws DuplicateMemberException
	 * @throws BadBytecode
	 */
	@Test
	public void givenLoadedClass_whenAddConstructorToClass_shouldCreateClassWithConstructor()
			throws NotFoundException, DuplicateMemberException, BadBytecode {

		// given
		ClassFile cf = ClassPool.getDefault().get("com.imtzp.javasisst.Point").getClassFile();
		Bytecode code = new Bytecode(cf.getConstPool());
		code.addAload(0);
		code.addInvokespecial("java/lang/Object", MethodInfo.nameInit, "()V");
		code.addReturn(null);

		// when
		MethodInfo minfo = new MethodInfo(cf.getConstPool(), MethodInfo.nameInit, "()V");
		minfo.setCodeAttribute(code.toCodeAttribute());
		cf.addMethod(minfo);

		// then
		CodeIterator ci = code.toCodeAttribute().iterator();
		List<String> operations = new LinkedList<>();
		while (ci.hasNext()) {
			int index = ci.next();
			int op = ci.byteAt(index);
			operations.add(Mnemonic.OPCODE[op]);
		}

		Assert.assertEquals(operations, Arrays.asList("aload_0", "invokespecial", "return"));
	}

}
