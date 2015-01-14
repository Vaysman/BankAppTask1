import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SavingAccountTest {

    public static final float ONE_EURO = 1.0f;
    public static final float TWO_EURO = 2.0f;
    public static final float ZERO_EURO = 0.0f;
    public static final float ERROR_DELTA = 0.00001f;

    @Test
    public void testDeposit() throws Exception {
        Account account = new SavingAccount(ZERO_EURO);

        account.deposit(ONE_EURO);
        assertThat((double) account.getBalance(), closeTo(ONE_EURO, ERROR_DELTA));
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        assertThat((double) account.getBalance(), closeTo(ONE_EURO, ERROR_DELTA));
    }

    @Test
    public void testGetReport() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        assertThat(account.getReport(), stringContainsInOrder(Arrays.asList("Saving", "1.0")));
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        account.withdraw(ONE_EURO);

        assertThat((double) account.getBalance(), is(closeTo(ZERO_EURO, ERROR_DELTA)));
    }

    @Test
    public void testWithdrawWithAmountGreaterThanBalance() throws Exception {
        Account account = new SavingAccount(ONE_EURO);

        account.withdraw(TWO_EURO);

        assertThat((double) account.getBalance(), is(closeTo(ONE_EURO, ERROR_DELTA)));
    }

    @Test
    public void shouldImplementsAccount() throws Exception {
        SavingAccount account = new SavingAccount(ONE_EURO);

        assertThat(account, instanceOf(Account.class));
    }

}