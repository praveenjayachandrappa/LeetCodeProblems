package inheritance.HASRelationship;



public class Employee {
    private int empId;
    private String name;
    private double salary;
    private Address address; //HAS-A relationship

    public Employee(int empId, String name, double salary, Address address) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public void display(){
        System.out.println(this.empId+": "+this.name+":"+this.salary+":"+this.address);
    }
}

