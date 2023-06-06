public class P0922SortArrayByParity2 {
    
    public int[] sortArrayByParity1(int[]nums){//间隔指针
        int evenIndex=0;
        int oddIndex=1;
        while(evenIndex<nums.length&&oddIndex<nums.length){
            if(nums[evenIndex]%2==0){
                evenIndex+=2;
            }
            else if (nums[oddIndex]%2==1){
                oddIndex+=2;
            }
            else {//通过前两步找出不符合要求的位置，然后交换
                swap(oddIndex, evenIndex, nums);
                evenIndex+=2;//交换后的数已经确保会符合要求了，所以指针都前进两步
                oddIndex+=2;
            }            
        }
        return nums;
    }
    private void swap(int m,int n, int[]nums){
        int temp=nums[m];
        nums[m]=nums[n];
        nums[n]=temp;
    }
}
/*
       P0922SortArrayByParity2 p922=new P0922SortArrayByParity2();
        int[]res=p922.sortArrayByParity1(new int[]{5,7,2,4});
        for(int i:res){
            System.out.print(i+" ");
        }
*/