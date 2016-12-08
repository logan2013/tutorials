https://www.sitepoint.com/understanding-es6-modules/

概要：文章会给你基本的概述，关于modules在ES6中如何使用。最后我们也会看到如何转换ES6 modules为ES5，这样它们可以作用于当今的浏览器



1. 定义在module中的函数或变量对外是不可见的，除非你显式地export这些值

2. 使用es6-module-transpiler转换ES6 module为ES5，命令如下：

compile-modules convert -I . -o out app.js --format commonjs

-I 表示输入目录，-o 表示输出目录