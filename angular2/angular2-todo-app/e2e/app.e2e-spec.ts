import { Angular2TodoAppPage } from './app.po';

describe('angular2-todo-app App', function() {
  let page: Angular2TodoAppPage;

  beforeEach(() => {
    page = new Angular2TodoAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
