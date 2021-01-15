import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMethod {
    public static String getEmailFromDisplayName(final String displayName) {
        String email = displayName;
        if (email != null) {
            final int startPos = email.lastIndexOf('<');
            if (startPos >= 0) {
                final int atPos = email.lastIndexOf('@');
                if (atPos > startPos) {
                    final int endPos = email.lastIndexOf('>');
                    if (endPos > atPos) {
                        email = email.substring(startPos + 1, endPos);
                        if (isBlank(email) || email.length() < 3) email = displayName;
                    }
                }
            }
        }
        return email;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
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
          //  logger.error("Error occurred while extracting and getting email ");
            return null;
        }
    }

    public static boolean isValidEmailId(String emailId){
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-<]+@[A-Za-z0-9.-]+\\.[A-Za-z>]{2,4}");
        Matcher mat = pattern.matcher(emailId.trim());
        if (mat.matches()) {
            return true;
        }
        return false;
    }


    public static String removeAngleBracktes(String email){

        if (email!=null && !email.isEmpty()) {
            if(email.contains("<"))
            email=email.replaceAll("<","");
            if(email.contains(">"))
                email=email.replaceAll(">","");
        }
        return email;
    }

    public static void main(String[] args) {
        /*String email="hello AND From:administrator@dsteam.qa OR To:abchffkf@mail.com";
        //System.out.println(extractAndGetEmail(email));
        System.out.println(removeAngleBracktes(email));

        System.out.println(extractAndGetEmail(email));
        */

        /*String email2="To:praveen@gmail.com AND Subject:helloWorld";
        String res=extractAndGetEmail(email2);
        boolean validEmailId = isValidEmailId(res);
        System.out.println(validEmailId);
        */
        String email="Shyam-vishwalingam.Muruganantham@microfocus.com";
        System.out.println(isValidEmailId(email));
    }

}
