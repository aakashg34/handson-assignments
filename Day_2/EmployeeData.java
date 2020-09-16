public class EmployeeData {
 public static void main(String[] args)
 {
     Address a1 = new Address("PUNJAB","JALANDHAR",144001);
     Address a2 = new Address("RAJASTHAN","JAIPUR",560023);
    Employee[] e = new Employee[5];
    e[0] = new Employee(101,"A",45000.0);
    e[1] = new Employee(102,"B",50000.0,a1);
    e[2] = new Employee(103,"C",47000.0);
    e[3] = new Employee(104,"D",51000.0);
    e[4] = new Employee(105,"E",40000.0,a2);
    Employee.display(e);
    Employee.display2(e);
    
 }   
}