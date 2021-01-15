import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PartitionLables {

  /*  public static List<Integer> partitionLabels(String str) {
        List<Integer> res=new ArrayList();
        int n=str.length();
        int s=0;
        int last=str.lastIndexOf(str.charAt(0));
        int i=1;
        int len=0;
        if(s==last){
            res.add(last-s+1);
              s=1;
              last=str.lastIndexOf(str.charAt(1));
           }
           while(i<n){
            int l=str.lastIndexOf(str.charAt(i));
            if(l<last){
                i++;
                continue;
            }
            else {
                last = l;
            }
            if(i==last) {
                    res.add(last-s+1);
                s=last+1;
                if(s<n) {
                    last = str.lastIndexOf(str.charAt(s));
                }
            }
            i++;
        }

        return res;
    }*/


    public static List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        for(int i=0; i<S.length(); i++){
            arr[S.charAt(i)-'a'] = i;
        }


        List<Integer> ans = new ArrayList<>();
        int anchor=0,j=0;
        for(int i=0; i<S.length(); i++){
            j = Math.max(j,arr[S.charAt(i)-'a']);
            if(i == j){
                ans.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        //String str="ababcbacadefegdehijhklij";
      String str="caedbdedda";
        List<Integer> list = partitionLabels(str);
        System.out.println(list);
        int[] nums={1};
    }


}
