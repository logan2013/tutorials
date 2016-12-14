import { SpringoneSamplePage } from './app.po';

describe('springone-sample App', function() {
  let page: SpringoneSamplePage;

  beforeEach(() => {
    page = new SpringoneSamplePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
