package houseware.learn.testing.mockito;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author fphilip@houseware.es
 */
public class TestMockitoVerifyExample1 {
    protected Customer customer;
    protected AccountManager accountManager;
    protected Account account;
    protected long withdrawlAmount2000 = 2000L;

    protected static void p(String text) {
        System.out.println(text);
    }

    @Before
    public void setupMock() {
        customer = new Customer();
        accountManager = mock(AccountManager.class);
        customer.setAccountManager(accountManager);
        account = mock(Account.class);
        when(accountManager.findAccount(customer)).thenReturn(account);
    }

    @Test(expected = NotEnoughFundsException.class)
    public void withdrawButNotEnoughFunds() throws NotEnoughFundsException {
        long balanceAmount200 = 200L;

        p("Train getBalance(account) to return " + balanceAmount200);
        when(accountManager.getBalance(account)).thenReturn(balanceAmount200);

        printBalance(balanceAmount200);
        try {
            p("Customer.withdraw(" + withdrawlAmount2000 + ") should fail with NotEnoughFundsException");
            customer.withdraw(withdrawlAmount2000);
        } catch (NotEnoughFundsException e) {
            p("NotEnoughFundsException is thrown");

            verify(accountManager).findAccount(customer);
            p("Verified findAccount(customer) is called");

            verify(accountManager, times(0)).withdraw(account, withdrawlAmount2000);
            p("Verified withdraw(account, " + withdrawlAmount2000 + ") is not called");

            throw e;
        }
    }

    protected void printBalance(long balance) {
        p("Balance is " + balance + " and withdrawl amount " + withdrawlAmount2000);
    }
}