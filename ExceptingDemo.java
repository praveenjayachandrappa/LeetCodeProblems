public class ExceptingDemo {


    public String sayHello(String str) throws Exception,IndexOutOfBoundsException{

        try {
            if(str==null)
                throw new IndexOutOfBoundsException("null");
            str=str.concat("World");

        } catch (NullPointerException e) {
            throw new Exception("Null pointer");  //when I throw exception here No one to catch here
        }
        catch (Exception e){
            System.out.println("Exception occured !");
            throw new Exception("Error");
        }
        return str;
    }

    public static void main(String[] args) {

        ExceptingDemo exceptingDemo = new ExceptingDemo();
        try {
            String hello = exceptingDemo.sayHello(null);

            System.out.println(hello);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
