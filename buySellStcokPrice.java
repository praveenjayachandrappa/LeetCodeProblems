import javax.imageio.stream.ImageInputStream;
import java.util.PriorityQueue;

public class buySellStcokPrice {


    /*public static int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxprofit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            maxprofit = Math.max(maxprofit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return maxprofit;
    }


    public static void main(String[] args) {

        int[] nums={7,1,5,3,6,4};

        int maxProfit = maxProfit(nums);
        System.out.println(maxProfit);


    }*/

    //Second Problem for Buy & Stock Price II
    /*public int maxProfit(int[] prices) {

        int maxProfit=0;

        for(int i=1;i<prices.length;i++){

            if(prices[i]>prices[i-1])
                maxProfit+=prices[i]-prices[i-1];
        }

        return maxProfit;
    }*/



    //Buy & Sell stock Price Problem 4


    public static  int maxProfit(int k, int[] prices) {
        int maxProfit=0;
        int[] kres=new int[k];

        PriorityQueue<Integer> pq=new PriorityQueue(k);
        for(int l=0;l<k;l++)
            pq.add(Integer.MIN_VALUE);
        int buy=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            int dayprofit=prices[i]-buy;
            buy=Math.min(buy,prices[i]);
            if(!pq.isEmpty() && dayprofit>pq.peek()){
                pq.poll();
                pq.add(dayprofit);
            }
        }
        while (!pq.isEmpty()) {
            int ele=pq.poll();
            if(ele>0)
            maxProfit += ele;
        }

        return maxProfit;

    }


    public static void main(String[] args) {
/*

       int[] prices = {3,2,6,5,0,3};
       // int[] prices={2,4,1};
        int k=2;

        int maxProfit = maxProfit(k, prices);

        System.out.println(maxProfit);
*/



        String str="text/html;\n" +
                "\tcharset=\"iso-2022-jp\"";
        if(str.contains("iso-2022-jp")){
            System.out.println("yes it contains");
        }
        str=str.replace("iso-2022-jp","utf-8");

        System.out.println(str);
    }



}
