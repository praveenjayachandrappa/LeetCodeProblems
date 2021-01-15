import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitCharacters {

    public static String[] splitAndTrimOnUnquotedUnescapedChars(final String s, final String splitChars) {
       // if (logger.isDebugEnabled()) logger.debug("splitAndTrimOnUnquotedUnescapedChars() called with: " + s + ", " + splitChars);

        if (s == null) return new String[0];

        final List<String> sli = new ArrayList<String>();
        boolean inQuotes = false;
        boolean isEscaped = false;
        int startPosition;
        int endPosition = -1;

        for (int count = 0; count < s.length(); count++) {
            final char test = s.charAt(count);
            if (test == '\\') {
                isEscaped = !isEscaped;
            } else if (test == '"' && !isEscaped) {
                inQuotes = !inQuotes;
            } else if (splitChars.indexOf(test) >= 0 && !inQuotes && !isEscaped) {
                startPosition = endPosition + 1;
                endPosition = count;
                sli.add(s.substring(startPosition, endPosition).trim());
                isEscaped = false;
            } else if (isEscaped) {
                isEscaped = false;
            }
        }
        sli.add(s.substring(endPosition + 1).trim());
        String[] arrReturn = sli.toArray(new String[sli.size()]);
      //  if (logger.isDebugEnabled()) logger.debug("splitAndTrimOnUnquotedUnescapedChars() returning: " + StringUtils.join(arrReturn, ","));
        //System.out.println("splitAndTrimOnUnquotedUnescapedChars() returning: " + StringUtils.join(arrReturn, ","));
        return arrReturn;
    }

    public static void main(String[] args) {

    String s="これは、テストメールです。";
        System.out.println("Initial length : "+s.length());
        String[] terms = splitAndTrimOnUnquotedUnescapedChars(s, " ");
        StringBuilder sb = new StringBuilder();
        for (final String term : terms) {
            if (!term.equals("*")) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(term);
            }
        }
        System.out.println(Arrays.toString(terms) +" : ");

        System.out.println(sb.toString().equals(s));
        System.out.println(sb.toString()+": "+sb.length());
    }

}
