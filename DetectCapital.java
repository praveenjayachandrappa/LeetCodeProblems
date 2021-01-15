public class DetectCapital {

    /**
     Intuition

     Hey, if we want to do pattern matching, why don't we use Regular Expression (Regex)? Regex is a great way to match a given pattern to a string.

     Algorithm

     The pattern of case 1 in regex is [A-Z]* where [A-Z] matches one char from 'A' to 'Z', *∗ represents repeat the pattern before it at least 0 times. Therefore, this pattern represents "All capital".

     The pattern of case 2 in regex is [a-z]*, where similarly, [a-z][a−z] matches one char from 'a' to 'z'. Therefore, this pattern represents "All not capital".

     Similarly, the pattern of case 3 in regex is [A-Z][a-z]*

     Take these three pattern together, we have [A-Z]*|[a-z]*|[A-Z][a-z]*[A−Z]∗∣[a−z]∗∣[A−Z][a−z]∗, where "|" represents "or".

     Still, we can combine case 2 and case 3, and we get .[a-z]*.[a−z]∗, where "." can matches any char.

     Therefore, the final pattern is [A-Z]*|.[a-z]*[A−Z]∗∣.[a−z]∗.

     */

    public boolean detectCapitalUse(String word) {
       // word.matches("[A-Z]*|[a-z]*|[A-Z][a-z]*");
        if(validateAllUperCaseLetters(word))
            return true;
        if(ValidateLowerCaseLetter(word))
            return true;

        if(validateFirstCharacter(word))
            return true;

        return false;
    }

    private boolean validateAllUperCaseLetters(String word){

        for(char c:word.toCharArray()){
            if(!(c>=65 && c<=90))
                return false;
        }

        return true;
    }

    private boolean ValidateLowerCaseLetter(String word){

        for(char c:word.toCharArray()){

            if(!(c>=97 && c<=122))
                return false;

        }

        return true;
    }

    private boolean validateFirstCharacter(String word){

        if(word.charAt(0)>=65 && word.charAt(0)<=90){

            for(int i=1;i<word.length();i++){
                if(!(word.charAt(i)>=97 && word.charAt(i)<=122))
                    return false;

            }

        }
        else{
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String str="ffffffffffffffffffffF";
        DetectCapital detectCapital=new DetectCapital();
        boolean res = detectCapital.detectCapitalUse(str);
        System.out.println(res);
    }
}
