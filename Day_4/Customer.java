public class Customer extends Person {
    String company;
    Account account;
    public Customer(String name,String dob,long phone,String company,Account account,Address address)
    {
    super(name,dob,phone,address);
        this.company = company;
        this.account = account;
    }
    public String getCompany() {
        return company;
    }
    public Account getAccount() {
        return account;
    }
    public void display()
    {
        System.out.println("Name - "+getName()+" dob -  "+getdob()+" phone = "+getphone()+"in company ="+getCompany());
        addressDetail();
        System.out.println("-------------Accoubt----------");
        System.out.println("Account no : "+ account.getAccountNumber()+ " with balance "+account.getBalance());

    } 
     public void updateCompany(String company){
         this.company = company; 
    }
}