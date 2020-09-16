 class Employee {
    int id;
    String name;
    double salary;
    Address address;
    Employee(int id,String name,double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    Employee(int id,String name,double salary, Address address)
    {
        this(id,name,salary);
        this.address = address;
    }
    static void display(Employee[] e)
    {
        for(Employee empl : e)
        {
            if(empl.salary>=50000.0)
            {
                System.out.println(empl.name+" has salary > 50K with salaary = "+empl.salary);
            }
        }
    }
    static void display2(Employee[] e)
    {
        for(Employee empl : e)
        {
            if(empl.address != null)
            {
                System.out.println(empl.name+" has address as "+empl.address);
            }
        
        }
    }
}
class Address{

    String state,city;
    int pin;
    Address(String state, String city, int pin)
    {
        this.state = state;
        this.city = city;
        this.pin = pin;
    }
}