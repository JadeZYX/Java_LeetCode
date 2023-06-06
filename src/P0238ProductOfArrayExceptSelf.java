public class P0238ProductOfArrayExceptSelf {
    public int[]productExceptSelf(int[]nums){
        int[]ans=new int[nums.length];
        int tempLeft=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=tempLeft;
            tempLeft*=nums[i];
        }
        int tempRight=1;
        for(int j=nums.length-1;j>=0;j--){
            ans[j]=ans[j]*tempRight;
            tempRight*=nums[j];
        }
        return ans;
    }

    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[]leftPart = new int[len];// 求左部分的乘机
        int[]rightPart = new int[len];//求右部分的乘机
        leftPart[0]=1;
        rightPart[len-1]=1;
        for(int i = 1;i<len;i++){
            leftPart[i]=nums[i-1]*leftPart[i-1];//当前位的左部分的乘机= 它的前一位数字*前一位数的左侧的product
        }
        for(int j = len-2;j>=0;j--){
            //当前位的右部分的乘机= 它的右侧第一位数字*右侧第一位数字之前的右侧的product
            rightPart[j]=nums[j+1]*rightPart[j+1];
        }
        int[]ans = new int[len];//合并总结果 左*右
        for(int k = 0;k<len;k++){
            ans[k]=leftPart[k]*rightPart[k];
        }
        return ans;
    }

}
//第一轮循环先求出第i位的左边的乘积，从前往后扫，第二轮循环求出第i位右边的乘积，从后往前扫。
