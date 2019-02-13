public class Account {
    private double balance;
    private double interest;
    private int accountNumber;
    private static int numberOfAccounts =1000000;


    public Account() {
         accountNumber = numberOfAccounts++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    
}
