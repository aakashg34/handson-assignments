public class Account {
    private long accountNumber;
    private double balance;
    public Account(long accountNumber,double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public long getAccountNumber(){
        return this.accountNumber;
    }
}