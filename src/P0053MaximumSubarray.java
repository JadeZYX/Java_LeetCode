public class P0053MaximumSubarray {
  public int maxSubArray(int[]nums){
    int maxSum = Integer.MIN_VALUE;
    if(nums.length==0 || nums == null) return maxSum;
    int sum = 0;
    for(int i = 0;i<nums.length;i++){
      sum+=nums[i];
      maxSum = Math.max(maxSum, sum);//必须先更新结果在判断sum是否小于0，否则[-1]这种就会返回错误结果0
      if(sum<0){
        sum = 0;
      }
    }
    return maxSum;
  }

  public int maxSubArrayDP(int[]nums){
    int[]dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0];//如果只有一个元素，根本就不能进入for循环，所以要直接返回第一个结果
    for(int i = 1;i<nums.length;i++){
      if(dp[i-1]<0){
        dp[i-1]=0;
      }
      dp[i]=dp[i-1]+nums[i];
      max = Math.max(max,dp[i]);
    }
    return max;
  }
}
/*
        P0053MaximumSubarray p53 = new P0053MaximumSubarray();
        System.out.println(p53.maxSubArrayDP(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(p53.maxSubArrayDP(new int[]{1}));
 如果遍历到当前的数时，求出的和为0，则舍弃重新记录
 [-2,1,-3,4,-1]
         i   nums[i]    sum          MaxSum
         0    -2        -2  (0)         -2
         1     1         1              1
         2    -3         -2(0)          1
         3     4         4              4
         4    -1         3              4

DP解法
DP的定义是一维的，只要有了dp[i]就可以。dp[i]和它前面的数字dp[i-1]相关
dp[i]它指的是遇到那个位置上的数字的时候最大值是多少，到现在这个节点为止，它用到当前数字能达到的最大值
 nums:   [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 dp:     [-2, 1, -2, 4,  3, 5, 6,  1, 5]
dp[i]是dp[i-1]+当前数字，若dp[i-1]是个负数，不管是负数加负数还是正数+负数都会变小，所以直接舍去dp[i-1]的值
 */