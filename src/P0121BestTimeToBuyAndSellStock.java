public class P0121BestTimeToBuyAndSellStock {
  public int maxProfit(int[]prices){
    if(prices.length==0)return 0;
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int n:prices){
      if(n<minPrice){
        minPrice=n;
      }
      maxProfit=Math.max(maxProfit, n-minPrice);
    }
    return maxProfit;
  }
  public int maxProfit1(int[] prices) {
    if(prices.length==0)return 0;
    int minPrice = Integer.MAX_VALUE;
    int result = 0;
    for(int n:prices){
        minPrice = Math.min(minPrice,n);
        result = Math.max(result,n-minPrice);
    }
    return result;
}
}
