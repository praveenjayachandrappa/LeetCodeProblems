import java.util.*;

public class InterSectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set=new HashSet<>();

        for (int x:nums1){
            set.add(x);
        }

        //HashSet<Integer> intersection=new HashSet<>();
        ArrayList<Integer> intersection=new ArrayList<>();
        for (Integer x: nums2) {
            if(set.contains(x)) {
                intersection.add(x);
                set.remove(x);
            }
        }

        int[] res = intersection.stream().mapToInt(x -> x).toArray();

        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int min=Math.min(nums1.length, nums2.length);
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for (int x:
             nums1) {
            map1.put(x,map1.getOrDefault(x,0)+1);
        }
        for (int x:
                nums2) {
            map2.put(x,map2.getOrDefault(x,0)+1);
        }
        boolean flag=min== nums1.length?true:false;
        ArrayList<Integer> res=new ArrayList<>();
        if (flag == true) {
            findIntersection(map1, map2, res);
        } else {
            findIntersection(map2, map1, res);
        }
        return res.stream().mapToInt(x->x).toArray();
    }

    private void findIntersection(HashMap<Integer,Integer> minMap,HashMap<Integer,Integer> maxMap,ArrayList<Integer> res){
        for (Map.Entry<Integer,Integer> entry: minMap.entrySet()) {
            if(maxMap.containsKey(entry.getKey())){
                int min = Math.min(entry.getValue(), maxMap.get(entry.getKey()));
                for (int i = 0; i <min ; i++) {
                    res.add(entry.getKey());
                }
            }
        }
    }

    public static void main(String[] args) {

/*        int[] a={1,2,2,4};
        int[] b={2,4,8,9};
        InterSectionOfTwoArrays obj=new InterSectionOfTwoArrays();
        int[] intersection = obj.intersection(a, b);

        System.out.println(Arrays.toString(intersection));*/

        int[] a={1,2,2,1};
        int[] b={2,2};

        InterSectionOfTwoArrays obj=new InterSectionOfTwoArrays();
        int[] intersect = obj.intersect(a, b);

        System.out.println(Arrays.toString(intersect));


    }
}
