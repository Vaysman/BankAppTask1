import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SavingAccountTest {

    @Test
    public void testDeposit() throws Exception {
        Account account = new SavingAccount(0.0f);

        account.deposit(1.0f);
        assertThat((double) account.getBalance(), closeTo(1.0, 0.00001));
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new SavingAccount(1.0f);

        assertThat((double) account.getBalance(), closeTo(1.0, 0.00001));
    }

    @Test
    public void testGetReport() throws Exception {
        Account account = new SavingAccount(1.0f);

        assertThat(account.getReport(), stringContainsInOrder(Arrays.asList("Saving", "1.0")));
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new SavingAccount(1.0f);

        account.withdraw(1.0f);

        assertThat((double) account.getBalance(), is(closeTo(0.0, 0.00001)));
    }
}