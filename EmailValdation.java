import java.sql.Struct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValdation {

    /*public static boolean isValidEmailId(String emailId){
        String specialAllowedChar="-._#'*";
        String regex="[A-Za-z0-9"+specialAllowedChar+"]+@[A-Za-z0-9-]+(\\.[A-Za-z]{2,4}){1,2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher mat = pattern.matcher(emailId.trim());
        if (mat.matches()) {
            return true;
        }
        return false;
    }





    public static void main(String[] args) {
    String emailId="Shyam-vishwalingam.Muruganantham@microfocus.com";
    String emailID2="Shyam-vishwalingam.Muruganantham@microfocus.com";
    String emailID3="Kamleshkumar.Patel@morgan-stanley.com.in";  //com.in scenario
    String emailID4="DSmailta2@dsteam.com";
    String emailID5="administrator@dsteam.qa.co";
    String emailID6="praveen.jayachandrappa@gmail.com";
  *//*      System.out.println(emailId+":"+isValidEmailId(emailId));
        System.out.println(emailID2+":"+isValidEmailId(emailID2));
  *//*      System.out.println(emailID3+":"+isValidEmailId(emailID3));
    *//*    System.out.println(emailID4+":"+isValidEmailId(emailID4));
        System.out.println(emailID5+":"+isValidEmailId(emailID5));
        System.out.println(emailID6+":"+isValidEmailId(emailID6));
*//*
    }*/


    private static String extractAndGetEmail(String primaryTextVal) {
        String emailId = null;
        try {
            if(primaryTextVal.contains("<")) {
                String[] emailText = primaryTextVal.split("<");
                emailId = emailText[emailText.length - 1].replace(">", "");
            } else {
                /*String[] emailText = primaryTextVal.split(":");
                emailId = emailText[emailText.length - 1];
                */
                int index = primaryTextVal.indexOf(":");
                return primaryTextVal.substring(index+1);
            }
            return emailId;
        } catch (Exception e) {
         //   logger.error("Error occurred while extracting and getting email ");
            return null;
        }
    }


   /* public static String removeSpecialCharacterIfAny(String str) {
        String[] split = string.split(":");
        //int idx=string.indexOf(":");
        int i;
        for ( i = 0; i <split.length ; i++) {
            if(split[i].isEmpty() && Character.isLetterOrDigit(split[i].charAt(0))){
                break;
            }

        }*/
    public static void main(String[] args) {

            String string="To:abc@gmail.com";
        System.out.println(extractAndGetEmail(string));
        }
    }

