import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalTriAngle {


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList();
        List<Integer> dummy=new ArrayList<>(1);
        dummy.add(-1);
        List<Integer> list=new ArrayList<>();
        list.add(1);
        List<Integer> list2=new ArrayList<>();
        list2.add(1);
        list2.add(1);
        res.add(0,dummy);
        res.add(1,list);
        res.add(2,list2);

        for(int i=3;i<=numRows;i++){
            List<Integer> formList=new ArrayList<>(i);
            for (int j = 0; j <i-1 ; j++) {
                formList.add(1);
            }
            int j=i-2;
            while (j>0){
                List<Integer> sublist=res.get(i-1);
                if(j%2!=0) {
                    int sum = sublist.get(j) + sublist.get(j - 1);
                    formList.add(j, sum);
                }else{
                    //if it is even
                    int sum=sublist.get(i-j)+sublist.get(j-1);
                    formList.add(j,sum);
                }
                j--;
            }
            formList.add(i-1,1);
            res.add(new ArrayList<>(formList));
        }

        return res;
    }

    public static void main(String[] args) {


        int numRows=5;
        List<List<Integer>> generate = generate(numRows);
        //generate.stream().forEach(li->li.stream().forEach(x-> System.out.println(x)));
        Iterator<List<Integer>> iterator = generate.iterator();
        while (iterator.hasNext()){
            List<Integer> next = iterator.next();
            for (int x:
                 next) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
