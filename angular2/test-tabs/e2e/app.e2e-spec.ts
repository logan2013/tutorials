import { DynamicComponentPage } from './app.po';

describe('dynamic-component App', () => {
  let page: DynamicComponentPage;

  beforeEach(() => {
    page = new DynamicComponentPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
