import java.util.ArrayList;
import java.util.List;

public class Client implements Report {

    private List<Account> accounts;
    private String name;

    public Client(String name) {
        accounts = new ArrayList<>();
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Client: ").append(name).append(System.lineSeparator());
        for (Account account : accounts) {
            report.append(account.getReport()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
