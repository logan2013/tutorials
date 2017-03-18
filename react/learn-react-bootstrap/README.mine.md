reactjs与bootstrap整合学习

https://dzone.com/articles/adding-react-bootstrap-to-a-react-app

1. 安装react-bootstrap
npm intall --save react-bootstrap

2. 引入bootstrap样式

官网给出的原因：以为React-Bootstrap并不依赖某一个准确版本的Bootstrap，我们不会整合任何bootstrap包含的样式。
然而，使用这些组件的话，有些样式是必须的。怎么和包含哪些Bootstrap取决你自己，但最简单的方式是从CDN中包含最新的样式

使用npm的方式：
npm install --save bootstrap