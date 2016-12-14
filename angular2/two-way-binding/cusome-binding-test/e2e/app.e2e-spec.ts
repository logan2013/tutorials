import { CusomeBindingTestPage } from './app.po';

describe('cusome-binding-test App', function() {
  let page: CusomeBindingTestPage;

  beforeEach(() => {
    page = new CusomeBindingTestPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
