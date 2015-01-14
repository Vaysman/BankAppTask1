import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class BankApplicationTest {
    @Test
    public void threeStaticMethodsTest() throws Exception {
        Method[] methods = BankApplication.class.getDeclaredMethods();
        List<String> names = new ArrayList<>();

        for (Method method : methods) {
            names.add(method.getName());
        }

        assertThat(names, containsInAnyOrder("initialize", "printBankReport", "modifyBank"));
    }
}