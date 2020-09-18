public class Student extends Person {
   String grade;
   long roll;
   //String designation; 
    
    public Student(String grade,long roll, String name, String dob, long phone,Address address ){
        super(name,dob,phone,address);
        this.grade = grade;
        this.roll = roll;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    public void updateGrade(String grade)
    {
        this.grade = grade;
    }
    public String getGrade() {
        return grade;
    }
    public long getRoll() {
        return roll;
    }
    @Override
    public void display(){
        System.out.println("Name - " +getName()+" dob - "+getdob()+" in class "+getGrade()+" with salary "+getRoll()+" Phone no "+getphone());
        addressDetail();

    }
}