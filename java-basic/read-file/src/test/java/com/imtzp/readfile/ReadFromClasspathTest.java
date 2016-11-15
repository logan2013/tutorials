package com.imtzp.readfile;

import java.io.IOException;
import java.io.InputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ReadFromClasspathTest extends BaseTest {

	@Test
	public void test() throws IOException {

		String expectedData = "Hello World from fileTest.txt!!!";

		Class<?> clazz = ReadFromClasspathTest.class;

		/**
		 * When used agaist a Class instance, the path could be relative to the package, or an absolute path, which is hinted by the leading slash.
		 */
		InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt");
		String data = readFromInputStream(inputStream);

		Assert.assertThat(data, CoreMatchers.containsString(expectedData));
	}
}
