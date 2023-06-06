public class P1413MinValueToGetStepsByStepSum {
    public int minStartValue(int[]nums){
        int min=Integer.MAX_VALUE;
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            min=Math.min(min,prefixSum);
        }
        if(min>=0)return 1;//如果找到的最小和>=0，则直接返回1即可。[0,0]--[1,1]
        return Math.abs(min)+1;//否则就要用绝对值+1. 等于0的时候也需要是1.
    }
    //要想保证每一步的prefix和都大于1.我们可以找出最小和，然后只要保证这个最小值加上某个数是大于1的
    //那么其他的位置肯定是大于1的。
}

//P1413MinValueToGetStepsByStepSum p1413=new P1413MinValueToGetStepsByStepSum();
//System.out.println(p1413.minStartValue(new int[]{-3,2,-3,4,2}));