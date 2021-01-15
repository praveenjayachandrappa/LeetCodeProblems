public enum Department {
    CS(null, "Andy","BlockA"),ECE(null, "Bob","blockB"),MECH(null,null,"djdjdj");
    private String head;
    private String location;
    Department(Object o, String s, String block) {
        this.head=s;
        this.location=block;
    }

    public String getHead() {
        return head;
    }

    public String getLocation() {
        return location;
    }
}

class EnumDemo{
    public static void main(String[] args) {
        Department department = Department.MECH;

        System.out.println(department.getHead());
        System.out.println(department.getLocation());
    }
}

