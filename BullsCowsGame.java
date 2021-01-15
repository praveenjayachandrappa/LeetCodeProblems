import java.util.HashMap;

public class BullsCowsGame {
    public static String getHint(String s, String g) {
        /*if(s.equals(g))
            return s.length()+"A"+0+"B";
        int bulls=0;
        int cows=0;
        StringBuilder se=new StringBuilder(s);
        StringBuilder gu=new StringBuilder(g);
        for(int i=0;i<se.length();i++){
            if(se.charAt(i)==gu.charAt(i)){
                bulls++;
                    //se=se.replaceFirst(new String(String.valueOf(se.charAt(i))),"$");
                    //gu=gu.replaceFirst(new String(String.valueOf(gu.charAt(i))),"$");
                    se.setCharAt(i,'$');
                    gu.setCharAt(i,'$');
                    }
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for (char ch:se.toString().toCharArray()) {
            if(ch!='$')
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (char ch:gu.toString().toCharArray()){
            if(ch=='$') continue;
            if(map.containsKey(ch) && map.get(ch)!=0){
                cows++;
                map.put(ch,map.get(ch)-1);
            }
        }
        return bulls+"A"+cows+"B";
*/

        int bulls=0;
        int cows=0;
        int numbers[]=new int[10];
        for (int i = 0; i <s.length() ; i++) {
            int se=s.charAt(i)-'0';
            int gu=g.charAt(i)-'0';
            if(se==gu)
                bulls++;
            else {
            if(numbers[se]<0) cows++;
            if(numbers[gu]>0) cows++;
            numbers[se]++;
            numbers[gu]--;
            }
        }

        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {

    /*    String s="1123";
        String cows="0111";
        *//*String s="11";
        String cows="11";
    *//*    System.out.println(getHint(s,cows));

    */

        String secret="1807";
        String guess="7810";
        System.out.println(getHint(secret,guess));
    }

}
