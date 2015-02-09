import com.luxoft.bankapp.BankApplicationTest;
import com.luxoft.bankapp.model.BankTest;
import com.luxoft.bankapp.model.ClientTest;
import com.luxoft.bankapp.model.SavingAccountTest;
import com.luxoft.bankapp.model.Task1Test;
import com.luxoft.bankapp.service.BankServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Task1Test.class, BankTest.class, ClientTest.class, SavingAccountTest.class, BankApplicationTest.class, BankServiceImplTest.class})
public class Task2TestSuite {
}
