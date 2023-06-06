public class P1672Grib_RichestCustomer {
    public int maximumWealth(int[][]accounts){
        int maxnum=Integer.MIN_VALUE;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
            for(int j=0;j<accounts[i].length;j++){
                sum+=accounts[i][j];
            }
            maxnum=Math.max(maxnum,sum);
        }
        return maxnum;
    }
}
