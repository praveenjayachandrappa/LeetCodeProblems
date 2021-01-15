import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EqualsIgnoreCase {




    public static boolean isValidEmailId(String emailId){
         String specialAllowedChar="._#-'*";
      //  String regex2="(^[a-zA-Z0-9]+["+specialAllowedChar+"]?)+([a-zA-Z0-9]+["+specialAllowedChar+"]?)*([a-zA-Z0-9])+@(([a-zA-Z0-9]+[-]?)+[a-zA-Z0-9]+\\.)+([a-zA-Z0-9]+\\.)*([a-zA-Z]{2,4})$";
       String regex2="(^[a-zA-Z0-9]+["+specialAllowedChar+"]?)+([a-zA-Z0-9]+["+specialAllowedChar+"]?)*([a-zA-Z0-9])+@(([a-zA-Z0-9]+[-]?)+[a-zA-Z0-9]+\\.)+([a-zA-Z0-9]+\\.)*([a-zA-Z]{2,4})$";
        Pattern pattern = Pattern.compile(regex2);
        System.out.println(regex2);
        System.out.println(pattern);
        Matcher mat = pattern.matcher(emailId);
        if (mat.matches()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
       // String email="praveen@gmai-jdhdhdl.co";

        String email="pr.av-eenj@microfocus.com.in";

        System.out.println(isValidEmailId(email.trim()));


    }
}
