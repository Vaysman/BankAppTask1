import org.junit.Test;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class Task1Test {
    @Test
    public void accountTest() throws Exception {
        Class clazz = getInterface("Account");

        Method[] methods = clazz.getDeclaredMethods();
        assertThat("Account must have 3 methods", methods.length, is(3));

        testMethodWithoutParams(methods, "float", "getBalance");
        testMethodWithOneParam(methods, "void", "deposit", "float");
        testMethodWithOneParam(methods, "void", "withdraw", "float");
    }

    @Test
    public void reportTest() throws Exception {
        Class clazz = getInterface("Report");

        Method[] methods = clazz.getDeclaredMethods();
        assertThat("\"String getReport()\" method not found in Report", methods.length, is(1));

        testMethodWithoutParams(methods, "java.lang.String", "getReport");
    }

    private Class getInterface(String name) {
        Class clazz = null;

        try {
            clazz = Class.forName(name);
        } catch (ClassNotFoundException ex) {
            fail("Interface " + name + " not found");
        }

        return clazz;
    }

    private void testMethodWithoutParams(Method[] methods, String returnType, String name) {
        String failMessage = "\"" + returnType + " " + name + "()" + "\" method not found in Account";

        Method method = findMethod(methods, name, failMessage);
        assertThat(failMessage, method.getReturnType().getCanonicalName(), is(returnType));
        assertThat(failMessage, method.getParameterCount(), is(0));
    }

    private void testMethodWithOneParam(Method[] methods, String returnType, String name, String paramType) {
        String failMessage = "\"" + returnType + " " + name + "(" + paramType + ")" + "\" method not found in Account";

        Method method = findMethod(methods, name, failMessage);

        assertThat(failMessage, method.getReturnType().getCanonicalName(), is(returnType));
        assertThat(failMessage, method.getParameterCount(), is(1));
        assertThat(failMessage, method.getParameters()[0].getType().getCanonicalName(), is(paramType));
    }

    private Method findMethod(Method[] methods, String name, String failMessage) {
        Method method = null;
        for (Method m : methods) {
            if (m.getName().equals(name)) {
                method = m;
                break;
            }
        }

        assertThat(failMessage, method, is(notNullValue()));

        return method;
    }
}
