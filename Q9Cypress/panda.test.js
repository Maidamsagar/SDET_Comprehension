
describe('automation panda test', () => {
  before(() => {
    // Runs once before all tests in the block
    cy.visit('https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/');
  });

  it('should verify the title of the page', () => {
    cy.title().should('eq', 'Want to Practice Test Automation? Try These Demo Sites!');
  });

  context('Speaking Page', () => {
    before(() => {
      // Runs before each test in the context block
      cy.get('a[href="/speaking/"]').click();
    });

    it('should verify the title of the Speaking page', () => {
      cy.title().should('eq', 'Speaking – Automation Panda');
    });

    it('should verify Keynote Addresses presence and text', () => {
      cy.contains('Keynote Addresses').should('exist');
      cy.fixture('keynoteAddressesText.json').then((expectedText) => {
        cy.contains('Keynote Addresses').invoke('text').should('eq', expectedText);
      });
    });
  });
});
