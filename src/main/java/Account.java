public interface Account extends Report {
    float getBalance();
    void deposit(float amount);
    void withdraw(float amount);
}
