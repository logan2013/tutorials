1. webpack默认会找项目根目录下的webpack.config.js
2. entry类型可以是string或者object，string类型表示单个entry point，object类型表示多个entry point
key可以在output-filename作为name参数使用，以区分生成的文件名
3. context定义当前路径（.），则entry中的.开头路径相对于这个上下文路径
4. webpack --watch 监听变化（只监听entry文件？），自动打包文件
5. preset可以写在webpack.config.js，query属性；可以单独写在.babelrc文件；可以写在package.json
6. inline:true表示html的内容不用显示在iframe里面
7. stats: "errors-only"表示webpack-dev-server启动时只显示错误信息