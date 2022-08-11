package oopPrinciples;

public class SavingsAccount extends Account {
    private double interestRate;
    private double accountNumber;
    public SavingsAccount (int accountNumber) {
        this.accountNumber = accountNumber;
        this.interestRate = 3.99;
    }

    public void addInterest() {
        this.deposit(this.getBalance()*this.interestRate);
    }
    @Override
    void withdraw(double amount) throws Exception {
        if (amount > this.getBalance()) {
            throw new Exception("No no no. money not enough");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }
}
