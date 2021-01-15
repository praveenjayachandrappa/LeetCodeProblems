import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {


/*
    public static boolean isValidEmailId(String emailId){
        String specialAllowedChar="-_.#'*";
        String regex="[A-Za-z0-9"+specialAllowedChar+"]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher mat = pattern.matcher(emailId);
        if (mat.matches()) {
            return true;
        }
        return false;
    }
*/



    public static boolean isValidEmailId(String emailId){
        String specialAllowedChar=".-_#";
        String regex="[A-Za-z0-9"+specialAllowedChar+"]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,4}";
    /* String regex="(^[a-zA-Z0-9]+[-_.#'*]{0,1})+([a-zA-Z0-9]+[-_.#'*]{0,1})*([a-zA-Z0-9]+)@([a-zA-Z0-9]+[-]?[a-zA-Z0-9]+)+((\\.{1,1}?[a-zA-Z0-9]+){2,4}(\\.?[a-zA-Z]){2,4}){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mat = pattern.matcher(emailId.trim());
        if (mat.matches()) {
            return true;
        }
        return false;
*/

    return false;
    }

    public static void main(String[] args) {
/*
praveen@gmail.com

pra-een@gma-il.com

pra-een@gma-il.com.in


p-r-a-ee-n@g-ma-il.com.in

p.r.av-een123@gmail.com

p.r.av-een123@gmail.com.in.in.c --->this is not valid email ID

 */
        //String email="prave.en123@gmail.comsjsjss.inhgff";
        //System.out.println(isValidEmailId(email));

        String s1="a";
        System.out.println(s1.matches("[a-z]{2,3}"));
    }
}
