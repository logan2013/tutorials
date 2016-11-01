

# kanban_app



## Usage

## Node
npm maintains a directory where it installs possible executables of packages.
You can display the exact path using npm bin. Most likely it points at .../node_modules/.bin.

Try executing Webpack from there through terminal using node_modules\.bin\webpack

bin: lists the executables provided by this package
scripts: defines commands that you can execute via npm run

Given executing node_module\.bin\webpack is a little verbose, we should do something about it.
npm and package.json double as a task runner with some configuration. "npm run build"

运行npm start或者npm run start启动服务器可以访问8080

HMR(Hot Module Replace)提供了一种简单的方式来自动刷新浏览器，当我们改变文件的时候