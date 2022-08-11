package oopPrinciples;

public class UseAccount {
    public static void main(String[] args) throws Exception {
        Account newAccount2 = new SavingsAccount(2431234);
        newAccount2.withdraw(1000);
        System.out.println(newAccount2.getBalance());
    }
}
