public class P1480RunningSum {
    public int[] runningSum(int[]nums){
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;
    }
}
/*
        P1480RunningSum p1480=new P1480RunningSum();
        int[]res=p1480.runningSum(new int[]{1,2,3,4,4});
        for(int i:res){
            System.out.print(i+" ");
        }
*/