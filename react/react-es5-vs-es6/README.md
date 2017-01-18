ReactJs es5和es6的对比

https://dzone.com/articles/comparing-react-with-es5-versus-react-with-es6

1. 创建组件方式
ES5：
. 使用React.createClass()方法
. 通过getInitialState()定义组件状态
. 通过module.exports将组件作为模块导出

ES6：
. 使用ES6的class
. 在constructor()方法中使用this.state定义组件状态
. 通过export或者export default将组件作为模块导出

2. render方法是类似的

3. props和"this"
ES5：
. props是隐式的
. 函数中隐式绑定了"组件的this"对象

ES6：
. props通过constructor()方法传入组件，并需调用super(props)
. 在构造函数中显式地绑定"组件的this"对象，使用this.functionname.bind(this)