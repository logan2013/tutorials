/**
 * Created by Logan on 2016/12/7.
 */
var cat = {
    name : 'foo',
    age : 12,
    canRun : function(){
        console.log("can run");
    }
};

/**
 *
 * 1. 默认情况下，对象所有的属性enumerable都设为true，可以通过Object.getOwnPropertyDescriptor打印出来
 *
 */

console.log("1. 查看属性的descriptor，比如是否可以枚举------");

console.log(Object.getOwnPropertyDescriptor(cat, "canRun"));
console.log(Object.getOwnPropertyDescriptor(cat, "name"));

/**
 * 2. 使用for in 打印初所有enumerable属性，包括继承过来的属性
 */

var animal = {
    color: "blue"
};

cat.__proto__ = animal;

Object.defineProperty(cat, "sex", {enumerable : false});
Object.defineProperty(cat, "job", {enumerable : true});

console.log("2. for...in打印对象所有可迭代的属性------");
for (var prop in cat) {
    console.log(prop);
}

/**
 * 打印对象特有的属性，也就是说不包含继承过来的属性
 */
console.log("3. 打印对象特有的属性------");
console.log(Object.keys(cat));


/**
 * 4. 打印对象特有的方法
 */
console.log("4. 打印对象特有的方法------");
console.log(getAllMethods(cat));
function getAllMethods(obj) {
    return Object.getOwnPropertyNames(obj).filter(function (p) {
        return typeof obj[p] === "function";
    });
}