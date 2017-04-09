import { TzbTabsPage } from './app.po';

describe('tzb-tabs App', () => {
  let page: TzbTabsPage;

  beforeEach(() => {
    page = new TzbTabsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
