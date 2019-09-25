import { MoneyUiPage } from './app.po';

describe('money-ui App', () => {
  let page: MoneyUiPage;

  beforeEach(() => {
    page = new MoneyUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
