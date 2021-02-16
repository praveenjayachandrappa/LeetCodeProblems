package string;

public class AddTwoStrings {

    public static String addStrings(String num1, String num2) {

        int i=num1.length()-1;
        int j=num2.length()-1;
        StringBuilder sb=new StringBuilder();
        int carry=0;
        while(i>=0 || j>=0){
            int n1=i>=0?num1.charAt(i)-'0':0;
            int n2=j>=0?num2.charAt(j)-'0':0;
            int sum=n1+n2+carry;
            carry=sum/10;
            sb.insert(0,sum%10);
            i--;
            j--;
        }

        if(carry!=0)
            sb.insert(0,carry);

        //return sb.reverse().toString();

        return sb.toString();
    }

    public static void main(String[] args) {
        String s="1789";
        String m="15";
        System.out.println(addStrings(s,m));
    }
}
