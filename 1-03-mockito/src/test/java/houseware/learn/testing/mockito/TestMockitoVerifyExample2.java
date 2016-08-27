package houseware.learn.testing.mockito;


import org.junit.Test;

import static org.mockito.Mockito.*;


/**
 * @author fphilip@houseware.es
 */
public class TestMockitoVerifyExample2 extends TestMockitoVerifyExample1 {

    @Test
    public void withdraw() throws NotEnoughFundsException {
        long balanceAmount3000 = 3000L;

        p("Train getBalance(account) to return " + balanceAmount3000);
        when(accountManager.getBalance(account)).thenReturn(balanceAmount3000);

        printBalance(balanceAmount3000);

        p("Customer.withdraw(" + withdrawlAmount2000 + ")");
        customer.withdraw(withdrawlAmount2000);

        verify(accountManager, times(2)).getBalance(account);
        p("Verified getBalance(account) is called twice");

        verify(accountManager).withdraw(account, withdrawlAmount2000);
        p("Verified withdraw(account, " + withdrawlAmount2000 + ") is called just once");

        verify(accountManager, atLeastOnce()).findAccount(customer);
        p("Verified findAccount(account) is called atleast once");
    }


}
