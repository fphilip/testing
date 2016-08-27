package houseware.learn.testing.mockito;

import lombok.Getter;
import lombok.Setter;

/**
 * @author fphilip@houseware.es
 */
public class Customer {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    private AccountManager accountManager;

    public long withdraw(long amount) throws NotEnoughFundsException {
        Account account = accountManager.findAccount(this);
        long balance = accountManager.getBalance(account);
        if (balance < amount) {
            throw new NotEnoughFundsException();
        }
        accountManager.withdraw(account, amount);
        return accountManager.getBalance(account);
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
}