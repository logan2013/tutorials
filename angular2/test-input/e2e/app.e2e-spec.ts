import { TestInputPage } from './app.po';

describe('test-input App', function() {
  let page: TestInputPage;

  beforeEach(() => {
    page = new TestInputPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
