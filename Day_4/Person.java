public abstract class Person {
    private String name,dob;
    private long phone;
    private Address address;
   public Person(String name,String dob,long phone,Address address)
    {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }
    public abstract void display();
    public String  getName()
    {
        return name;
    }
    public String getdob()
    {
        return dob;
    }
    public long getphone()
    {
        return phone;
    }

    public void addressDetail(){
        System.out.println("State : "+address.getState());
        System.out.println("City : "+address.getCity());
        System.out.println("Pincode : "+address.getPin());
    }
    // public abstract

}