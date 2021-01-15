package permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {


    List<List<Integer>> permute;
    boolean visited[];
    public List<List<Integer>> permute(int[] nums) {

        permute=new ArrayList<>();
        visited=new boolean[nums.length];
        findPermute(nums,new ArrayList<Integer>());

        return permute;
    }

    private void findPermute(int[] nums, List<Integer> p) {

        if (p.size() == nums.length && !permute.contains(p)) {
            permute.add(new ArrayList<>(p));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                p.add(nums[i]);
                findPermute(nums, p);
                p.remove(p.size() - 1);
                visited[i] = false;
            }
        }

    }


    public static void main(String[] args) {

        int[] nums={1,1,2};

        Permutations46 permutations46 = new Permutations46();
        List<List<Integer>> lists = permutations46.permute(nums);

        System.out.println(lists.toString());

    }
}
