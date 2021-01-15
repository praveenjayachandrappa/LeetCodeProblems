import java.util.HashSet;

public class Division {



    public static String divide(int dividend, int divisor) {
        // Write your code here
        //
        //return String.valueOf(dividend/divisor);
        if(dividend%divisor==0){
            int ans=dividend/divisor;
            return String.valueOf(ans);
        }

        Float a=Float.valueOf(dividend);
        Float b=Float.valueOf(divisor);
        Float res=a/b;
        //System.out.println(res);

        String ans=String.valueOf(res);
        String[] split = ans.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        if(split[1].length()>2){
            HashSet<Integer> set=new HashSet();
            stringBuilder.append("(");
            for (int i=0;i<split[1].length();i++) {
                char c = split[1].charAt(i);
                String string = Character.toString(c);
                int val=Integer.parseInt(string);
                if(!set.contains(val)){
                    stringBuilder.append(val);
                    set.add(val);
                }
                else{
                    stringBuilder.append(")");
                    return split[0]+"."+stringBuilder.toString();
                }
            }
        }
        // stringBuilder.append(split[1].charAt(0));
        // System.out.println(stringBuilder.toString());
        //System.out.println(split[0]);
        return ans;
    }

    public static void main(String[] args) {

        int a=229;
        int b=990;

        String divide = divide(a, b);
        System.out.println(divide);

        String s="088373??57565";
        int index = s.indexOf("?");
        System.out.println(index);

        /*char c='5';
        int v=Integer.parseInt(c);
        System.out.println(v);
*/
    }
}
