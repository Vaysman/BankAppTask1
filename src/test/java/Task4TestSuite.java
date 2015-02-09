import com.luxoft.bankapp.BankApplicationTest;
import com.luxoft.bankapp.model.*;
import com.luxoft.bankapp.service.BankServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Task1Test.class, BankTest.class, ClientTest.class, SavingAccountTest.class, BankApplicationTest.class,
        BankServiceImplTest.class, AbstractAccountTest.class, CheckingAccountTest.class, GenderTest.class
})
public class Task4TestSuite {
}
