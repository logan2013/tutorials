https://www.sitepoint.com/angular-2-tutorial/

# Angular CLI
. 生成Angular2应用的样板代码
. 给已存在的Angular2应用增加特性（components, directives, services, pipes, etc)

# Todo application
. Todo class表示单个的todo
. TodoService对todos进行增删改
. TodoApp组件显示用户接口

# Angular's template syntax
. [property] = "expression": 设置property的值为expression的结果
. (event) = "statement": 当event发生的时候执行statement
. [(property)] = "expression": 通过expression创建双向绑定
. [class.special] = "expression": 当expression结果为true时，给元素增加special的CSS类
. [style.color] = "expression": 设置CSS的corlor属性为expression的结果

# expression context 表达式上下文
一个组件的表达式上下文是指这个组件的实例

# Angular2TodoApp

This project was generated with [angular-cli](https://github.com/angular/angular-cli) version 1.0.0-beta.20-4.

## Development server
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive/pipe/service/class`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

## Deploying to Github Pages

Run `ng github-pages:deploy` to deploy to Github Pages.

## Further help

To get more help on the `angular-cli` use `ng --help` or go check out the [Angular-CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
