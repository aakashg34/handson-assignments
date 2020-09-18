public class Address {
    String city,state;
        int pin;
        public Address(String city,  String state,int pin)
        {
            this.city = city;
            this.state = state;
            this.pin = pin;
        }
        public String getCity() {
            return city;
        }
        public String getState() {
            return state;
        }
        public int getPin() {
            return pin;
        }
}