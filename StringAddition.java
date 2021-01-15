import java.util.Arrays;

public class StringAddition {

    /*public static void main(String[] args) {

        String s="abc";

        StringBuilder stringBuilder=new StringBuilder("abc");
        stringBuilder.setCharAt(1,'x');
        System.out.println(stringBuilder);
        StringBuilder sb2=new StringBuilder("axc");
        if(stringBuilder.toString().equals(sb2.toString()))
            System.out.println("Both String Builder objects are equal");
    }*/

    private static String checkAndRemoveAngleBrackets(String primaryText) {
        if(primaryText.contains("<"))
            primaryText=primaryText.replaceAll("<","");
        if(primaryText.contains(">"))
            primaryText=primaryText.replaceAll(">","");
        return primaryText;
    }



    private static String extractAndGetEmail(String primaryTextVal) {
        String emailId = null;
        try {
            if(primaryTextVal.contains("<")) {
                String[] emailText = primaryTextVal.split("<");
                emailId = emailText[emailText.length - 1].replace(">", "");
            } else {
                String[] emailText = primaryTextVal.split(":");
                emailId = emailText[emailText.length - 1];
            }
            return emailId;
        } catch (Exception e) {
     //       logger.error("Error occurred while extracting and getting email ");
            return null;
        }
    }


    public static void main(String[] args) {

        //String str="<<<<abc@gmail.com>>>>";
    /*    String str="<abc@gmail.com>";
        System.out.println(checkAndRemoveAngleBrackets(str));
    */

        //String str="From:From:abc@gmail.com";
        /*String str="To:abc@xyz.com";
        String s = extractAndGetEmail(str);
        System.out.println(s);
        */


    }

}
