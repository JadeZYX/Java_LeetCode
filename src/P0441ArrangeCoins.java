public class P0441ArrangeCoins {
    public int arrangeCoins(int n){
        int left=1;
        int right=n;//第N行
        int steps=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            double totalcoinsAtmid=1.0*mid*(mid+1)/2;
            if(totalcoinsAtmid==n){
                return mid;
            }
            if(totalcoinsAtmid>n){
                right=mid-1;
            }
            else{//totalcoinsAtmid<n
                steps=mid;//当前的硬币数还够，先记录下当前完整的层数，继续向右查找，如果有更接近的数，当前阶层数会被替换
                left=mid+1;
            }
        }
        return steps;
    }
    public int arrangeCoins1(int n) {
        int i=0;
        int count=0;
        while(n>=i+1){//保证再次count++是满足n超过下一行，也就是i+1行所需要的
            i++;
            count++;
            n-=i;//当前行消耗coin后剩下的coin数量
        }
        return count;
    }
}
