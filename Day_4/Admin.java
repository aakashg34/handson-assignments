public class Admin extends Employee {
    String category;
    public Admin(int id,String name,String dob,double salary,long phone,Address address,String category)
    {
    super(id,salary,name,dob,phone,address);
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    @Override
    public void display()
    {
            System.out.println("Name - " +getName()+" dob - "+getdob()+" ID - "+getId()+" with salary "+getsalary()+" in category " +getCategory());
        addressDetail();
    }
}