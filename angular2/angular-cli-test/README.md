https://www.sitepoint.com/ultimate-angular-cli-reference/

# AngularCliTest

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


Angular CLI的功能
. 创建新的Angular应用
. 使用LiveReload运行一个开发server，以供在开发中预览应用
. 对已存在的项目添加特性
. 运行应用的单元测试
. 构建项目以发布到生产环境
. 部署应用到server


ng serve背后发生的事
1 Angular CLI加载angular-cli.json配置
2 Angular CLI运行webpack构建和打包所有的Javascript和CSS代码
3 Angular CLI启动webpack dev server，预览结果到localhost:4200
