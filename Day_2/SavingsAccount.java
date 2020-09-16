class SavingsAccount{
    int accno;
    String name;
    double balance;
    String ifsc;
    String state,city;
    int pin;
    
    SavingsAccount(int ac,String n,String c,String s,int p)
    {
        accno = ac;
        name = n;
        ifsc = "HSBC001";
        state = s;
        city = c;
        pin = p;
        balance = 0.0;

    }
    SavingsAccount(int ac,String n,String c,String s,double b,int p)
    {
        accno = ac;
        name = n;
        balance = b;
        state = s;
        city  = c;
        pin=p;
        ifsc = "HSBC001";
    }
    void withdraw(int amt)
    {

        if(amt>balance)
        {
            System.out.println("Sorry not enough balance");
        }
        else
        { balance-=amt;
            System.out.println("The new balace = "+balance);
        }
    } 
    void deposit(double amt)
    {
        balance+=amt;
        System.out.println("The new Balance = "+balance);

    }
    void display()
    {
        System.out.println(name+" has Acc. no = "+ accno+" in "+state+" with IFSC :"+ifsc);
        System.out.println("Balance is=  "+balance);
    }
}
