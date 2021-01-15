package inheritance.HASRelationship;

public class MainDemo {


    public static void main(String[] args) {
        Address address1=new Address("anavatti","karanataka","India");
        System.out.println(address1); //by default Object is parent class for all other classes.
        Employee employee1=new Employee(100,"andy",55000,address1);
        employee1.display();

    }
}

