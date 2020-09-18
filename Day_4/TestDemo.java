public class TestDemo {
    public static void main(String[] args)
    {
        Manager m = new Manager(101,"A","20-02-1967",50000.0,89748787,new Address("jal","punjab",144001),10);
        Programmer p = new Programmer(101,"B","20-12-1953",60000.0,7848787,new Address("jk","raja",52678),"JAVA");
        Student s = new Student("8th",109238,"ram","13-03-1997",893747,new Address("BG","KA",52678));
        Customer c = new Customer("ab","10-9-1299",8986787,"JK PAPER",new Account(555L,518978.0),new Address("kashmir","kj",17836));
        Admin a = new Admin(101,"A","20-02-1967",60500.0,789475,new Address("jal","punjab",144001),"Systems");
        
        System.out.println("Detail of manager-------------------");
        show(m);
        System.out.println("Programmer detail----------------------");
        show(p);
        System.out.println("Student detail-------------------");
        show(s);
        System.out.println("Customer detail----------------");
        show(c);
        System.out.println("Admin detail-------------------------");
        show(a);

        System.out.println("update manager-------------------------");
        update(m);
        System.out.println("update programmer-------------------------");
        update(p);
        System.out.println("update admin-------------------------");
        update(a);
        System.out.println("update grade of student-------------------------");
        update(s);
        System.out.println("showing updated student info-------------------------");
        show(s);
        System.out.println("update customer company-------------------------");
        update(c);
        System.out.println("showing updated coustomer compny-------------------------");
        show(c);
    
    
    
    }
    public static void show(Person p)
    {
        p.display();
    }
    
    public static void update(Person people){
        //update manager salary
        if(people instanceof Manager){
            Manager manager=(Manager)people;
            double Salary= manager.getsalary();
            Salary += Salary*0.1;
            System.out.println("Salary increased by 10% "+Salary);
            manager.setSalary(Salary);
        }

        //pdate Programmer salary
        if(people instanceof Programmer){
            Programmer p  = (Programmer)people;
            double Salary= p.getsalary();
            Salary += Salary*0.1;
            System.out.println("Salary increased by 10% "+Salary);
            p.setSalary(Salary);
        }
        //update  Admin salary   
        if(people instanceof Admin){
            Admin a  = (Admin)people;
            double Salary= a.getsalary();
            Salary += Salary*0.1;
            System.out.println("Salary increased by 10% "+Salary);
            a.setSalary(Salary);
        }


        //Updating Student Grade
        if(people instanceof Student){
            Student st=(Student)people;
            st.updateGrade("seventh");
            
        }


        //Updating Customer Balance
        if(people instanceof Customer){
            Customer cus=(Customer)people;
            cus.updateCompany("FINOLEX");
        }

    }
}