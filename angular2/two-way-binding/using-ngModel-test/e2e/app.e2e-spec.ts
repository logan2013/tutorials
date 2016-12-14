import { UsingNgModelTestPage } from './app.po';

describe('using-ng-model-test App', function() {
  let page: UsingNgModelTestPage;

  beforeEach(() => {
    page = new UsingNgModelTestPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
