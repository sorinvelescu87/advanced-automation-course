package oopPrinciples;

public class CheckingAccount extends Account implements newAccount {
    private int accountNumber;

    public CheckingAccount(int accountNumber) {
        this.setBalance(0);
        this.accountNumber = accountNumber;
    }
    @Override
    void withdraw(double amount) {
        this.setBalance(this.getBalance() - amount);
    }

    @Override
    public void deleteAccount() {

    }
}
