https://dzone.com/articles/communication-between-components-using-input-in-an

组件间相互通讯包含以下方式：
1. 使用@Input()
2. 使用@Output()
3. 使用Services
4. 父组件调用ViewChild
5. 父组件使用本地变量与子组件交互


@Input()装饰器常用于将参数从父组件传递到子组件
1. 子组件中的属性使用@Input()装饰器，该属性的值可以通过父组件设置
[被修饰的属性]="父组件的属性"
如：<appchild [greetMessage]="childmessage"></appchild>

2. 子组件中的属性setter方法也可以使用@Input()装饰器


ngOnChanges可以监听父组件传给@Input的属性的变化




# TestInput

This project was generated with [angular-cli](https://github.com/angular/angular-cli) version 1.0.0-beta.21.

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
