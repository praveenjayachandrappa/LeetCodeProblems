import java.util.HashMap;

public class ProtectedClass {


    public static void main(String[] args) {

        HashMap<String,Object> map=new HashMap<>();

        Object val = map.put("praveen", new Object());

        boolean praveen = map.put("asdfasdf", new Object()) == null;

        System.out.println(praveen);




    }

}


class A{
    protected static  void  display(){
        System.out.println("Protected parent class");
    }
}

class  B extends  A{

    public void  print(){
        display();
    }

}
