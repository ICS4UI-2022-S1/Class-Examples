public class Person {
    private String name;
    private String address;
    private String phoneNumber;

    public Person(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void changeAddress(String newAddress){
        this.address = newAddress;
    }

    public String toString(){
        String output = this.name + "\n" + this.address + "\n" + this.phoneNumber;
        return output;
    }
}
