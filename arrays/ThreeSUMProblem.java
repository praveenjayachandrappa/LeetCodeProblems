package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSUMProblem {

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Example 2:
     *
     * Input: nums = []
     * Output: []
     * Example 3:
     *
     * Input: nums = [0]
     * Output: []
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList();
        int n=nums.length;

        if(n<3) return res;

        Arrays.sort(nums);
        /*//TC-o(n^3);
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        if(!res.contains(list))
                        res.add(list);
                    }
                }
            }
        }*/


        //Linear Time solution
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            if(i==0 || nums[i]!=nums[i-1]){
                while(l<r){
                    int sum=nums[i]+nums[l]+nums[r];
                    if(sum==0){
                        List<Integer> temp=Arrays.asList(nums[i],nums[l],nums[r]);
                        res.add(temp);
                        l++;
                        r--;
                        //Check from the right side  if they are same ,lead to same duplicate triplets
                        while(r>l && nums[r]==nums[r+1]){
                            r--;
                        }
                        while(l<r && nums[l]==nums[l-1]){
                            l++;
                        }
                    }
                    else if(sum>0){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
            }

        }


        return res;
    }

}
