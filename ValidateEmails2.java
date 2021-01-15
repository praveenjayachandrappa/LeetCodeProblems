import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmails2 {


    public static boolean isValidEmailId(String emailId){
        String specialAllowedChar=".*#%";
        String regex="[A-Za-z0-9"+specialAllowedChar+"]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher mat = pattern.matcher(emailId.trim());
        if (mat.matches()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String email="praveen12j@microfocus..com";
        System.out.println(isValidEmailId(email));
    }
}
