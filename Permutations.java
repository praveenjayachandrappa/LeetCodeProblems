import java.util.ArrayList;
import java.util.List;

public class Permutations {


    List<List<Integer>> permute;
    boolean visited[];
    public List<List<Integer>> permute(int[] nums) {

        permute=new ArrayList<>();
        visited=new boolean[nums.length];
        findPermute(nums,new ArrayList<Integer>());

        return permute;
    }

    private void findPermute(int[] nums,List<Integer> p){

        if(p.size()==nums.length){
            permute.add(new ArrayList<>(p));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i]=true;
            p.add(nums[i]);
            findPermute(nums,p);
            //backtracking
            p.remove(p.size()-1);
            visited[i]=false;
        }
    }

    public static void main(String[] args) {

        int[] nums={1,2,3};

        Permutations permutations=new Permutations();
        List<List<Integer>> permute = permutations.permute(nums);
        permute.stream().forEach(list->list.forEach(a-> System.out.println(a)));
    }

    /*


public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res=new ArrayList();

        permute(nums,0,res);
        return res;
    }

    private void permute(int[] nums,int start,List<List<Integer>> res){

        if(start==nums.length){
            List<Integer> list=Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(list);
        }

        for(int i=start;i<nums.length;i++){

            swap(nums,i,start);
            permute(nums,start+1,res);
            swap(nums,i,start); //back tracking
        }

    }


    private void swap(int[] nums,int i,int j){

        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

     */
}
