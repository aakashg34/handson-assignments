public class Manager extends Employee {
    //String designation;
    int teamMembers;
    public Manager(int id,String name, String dob, double salary,long phone,Address address,int teamMembers )
    {
        super(id,salary,name,dob,phone,address);
        this.teamMembers = teamMembers;
    }
    public int getTeamMembers() {
        return teamMembers;
    }
                
    // @Override
    // public void update()
    // {
    //     System.out.println("Updating the salary"); 
    // }
    @Override
    public void display(){
        
            System.out.println("Name - " +getName()+" dob - "+getdob()+" ID - "+getId()+" with salary "+getsalary()+" with "+getTeamMembers()+" team members ");
            addressDetail();
    }
    
}