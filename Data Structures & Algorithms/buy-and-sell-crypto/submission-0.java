class Solution {
    public int maxProfit(int[] prices) {
        //best time to buy and sell sotck
        if(prices.length==0)
        return 0;
        int cur=prices[0],maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int curProfit=prices[i]-cur;
            if(curProfit<0){
                cur=prices[i];
            }
            maxProfit=Math.max(maxProfit,curProfit);
        }
        return maxProfit;
        
    }
}
