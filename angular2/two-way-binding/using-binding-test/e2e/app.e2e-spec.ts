import { UsingBindingTestPage } from './app.po';

describe('using-binding-test App', function() {
  let page: UsingBindingTestPage;

  beforeEach(() => {
    page = new UsingBindingTestPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
