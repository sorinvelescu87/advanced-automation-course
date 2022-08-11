package oopPrinciples;

public abstract class Account {
    double balance;
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    abstract void withdraw(double amount) throws Exception;
    public void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }
}
