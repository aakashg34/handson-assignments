public abstract class Employee extends Person{
    private int id;
    //private String name;
    //private long accountNumber;
   // private double balance;
    //private String doBirth;
    private double salary;
    //private String designation;

    Employee(int id, double salary, String name, String dob, long phone,Address address)
    {
        super(name,dob,phone,address);
        this.id= id;
        //this.name = name;
        //this.accountNumber=accountNumber;
        //this.doBirth = doBirth;
        this.salary = salary;
        //this.designation = designation;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
 
      
//     public void setdob(String doBirth)
//     {
//         this.doBirth = doBirth;
//     }
//     public void setSalary(){
//         salary+=salary*0.1;
//     }
//     public void Information()
//     {
//         System.out.println("Name: "+name+" with id "+id+" salary = "+salary+" with designation "+designation );
//     }
// }

//  abstract class Account {
//         private long accountNumber;
//         private double balance;
//         public Account(long accountNumber,double balance)
//         {
//             this.accountNumber = accountNumber;
//             this.balance = balance;
//         }
//         public void setBalance(double balance)
//         {
//             this.balance = balance;
//         }
//         public double getBalance(){
//             return balance;
//         }
//         public long getAccountNumber(){
//             return this.accountNumber;
//         }
//         public abstract void  update();

//         public void accountInfo()
//         {
//             System.out.println("---------Account infor------------");
//             System.out.println("Account num - "+accountNumber+" balance = "+balance);
            
//         }
        
        
//     }
    public int getId(){
        return id;
    }
    public double getsalary(){
        return salary;
    }
public abstract void display();

    //   class Address {
    
        // String city,state;
        // int pin;
        // public Address(String city,  String state,int pin)
        // {
        //     this.city = city;
        //     this.state = state;
        //     this.pin = pin;
        // }
        // public  void  getAddress()
        // {
        //     System.out.println("Address is: "+city+" state- "+state+ " pincode "+pin);
        //     //+" state "+state+" pin "+pin);
        // }
    
    // }
        }

 