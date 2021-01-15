
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum3 {


    /*public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result=new ArrayList<>();

        if(k<0 || k>n)
            return result;

        List<Integer> tempList=new ArrayList<>();
        int[] digits={1,2,3,4,5,6,7,8,9};

        dfs(digits,0,0,k,n,tempList,result);
        return  result;
    }

    private void dfs(int[] digits, int startIndex, int currentSum, int k, int n, List<Integer> tempList, List<List<Integer>> result) {
        if(startIndex>digits.length) {
            return;
        }
        if(currentSum>n){
            return;
        }
            if(tempList.size()==k){
                List<Integer> x=new ArrayList<>();
                int totalSum=0;
                for (int i = 0; i <tempList.size() ; i++) {
                    totalSum+=tempList.get(i);
                    x.add(tempList.get(i));
                }
                if(n!=totalSum){
                    return;
                }
                Collections.sort(x);
                if(result.contains(x)){
                    result.add(x);
                }
                return;
            }

        for (int i = startIndex; i <digits.length ; i++) {
            if(currentSum+digits[i]>n) return;
            currentSum+= digits[i];
            tempList.add(digits[i]);
            dfs(digits, i+1, currentSum, k, n, tempList, result);
            int y=tempList.get(tempList.size()-1);
            tempList.remove(tempList.size()-1);
            currentSum=-y;
        }
    }
*/


    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result=new ArrayList<>();
        if(n==0 || k>n) return result;
        List<Integer> tempList=new ArrayList<>();
        dfs(1,k,n,tempList,result);
        return result;
    }

    private void dfs(int start, int k,int n, List<Integer> tempList, List<List<Integer>> result) {
        if(tempList.size()==k){
            if(n==0){
                List<Integer> list=new ArrayList<>();
                list.addAll(tempList);
                result.add(list);
                return;
            }
            if(n<0) return;
            return;
        }

        for(int i=start;i<=9;){
            tempList.add(i);
            dfs(i+1, k, n-i, tempList, result);
            tempList.remove(tempList.size()-1);
            i++;
        }
    }

    public static void main(String[] args) {

        CombinationSum3 combinationSum3=new CombinationSum3();
        List<List<Integer>> listList = combinationSum3.combinationSum3(3, 9);
        for (List<Integer> list:
             listList) {
            System.out.println(list);
        }
    }
}
