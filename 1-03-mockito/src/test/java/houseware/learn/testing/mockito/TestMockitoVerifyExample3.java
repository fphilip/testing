package houseware.learn.testing.mockito;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

/**
 * @author fphilip@houseware.es
 */
public class TestMockitoVerifyExample3 extends TestMockitoVerifyExample2 {

    @Test
    public void withdrawAndVerifyOrder() throws NotEnoughFundsException {

        long balanceAmount3000 = 3000L;

        p("Train getBalance(account) to return " + balanceAmount3000);
        when(accountManager.getBalance(account)).thenReturn(balanceAmount3000);

        printBalance(balanceAmount3000);
        p("Customer.withdraw(" + withdrawlAmount2000 + ")");
        customer.withdraw(withdrawlAmount2000);
        p("Verify order of method calls");
        InOrder order = inOrder(accountManager);
        order.verify(accountManager).findAccount(customer);
        p("Verified findAccount(account) is called");
        order.verify(accountManager).getBalance(account);
        p("Verified getBalance(account) is called");
        order.verify(accountManager).withdraw(account, withdrawlAmount2000);
        p("Verified withdraw(account, " + withdrawlAmount2000 + ") is called");
        order.verify(accountManager).getBalance(account);
        p("Verified getBalance(account) is called one more time after withdrawl");

    }

}
