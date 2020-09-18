public class Programmer extends Employee {
    String progLanguage;
     Programmer(int id,String name,String dob, double salary,long phone,Address address,String progLanguage)
    {
    super(id,salary,name,dob,phone,address);
        this.progLanguage = progLanguage;
    }
    public String getProgLanguage() {
        return progLanguage;
    }
    @Override
    public void display(){
       
            System.out.println("Name - " +getName()+" dob - "+getdob()+" ID - "+getId()+" with salary "+getsalary()+" profficient in " +getProgLanguage());
        addressDetail();
        }
    
}