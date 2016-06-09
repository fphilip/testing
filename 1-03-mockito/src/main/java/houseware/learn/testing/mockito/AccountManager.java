package houseware.learn.testing.mockito;
/**
 * @author fphilip@houseware.es
 */
public interface AccountManager {

	long getBalance(Account account);

	long withdraw(Account account, long amount);

	Account findAccount(Customer customer);

}