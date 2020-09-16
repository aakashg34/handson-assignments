public class Account {
    public static void main(String[] args)
    {
        SavingsAccount u1 = new SavingsAccount(12345678,"A","jal","punjab",4000.0,144001);
        u1.display();
        u1.withdraw(200);
        SavingsAccount u2 = new SavingsAccount(87654321,"B","jal","punjab",144003);
        u2.display();
        u2.deposit(2000.0);
        
    }
}