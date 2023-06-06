public class P0905SortArrayByParity {
    public int[]sortArrayByParity(int[]nums){
        int[]res=new int[nums.length];
        int left=0,right=nums.length-1;//双向指针
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                res[left]=nums[i];
                left++;
            }
            else{
                res[right]=nums[i];
                right--;
            }
        }
        return res;
    }
    public int[] sortArrayByParity1(int[]nums){
        int i=0,j=nums.length-1;
        while(i<j){//双向指针两头走，每次前进一步，结束条件是当两指针重合指向同一个位置。
            if(nums[i]%2==0)i++;
            else {
               swap(i, j, nums);
               j--;
            }
        }
        return nums;
    }
    private void swap(int m,int n,int[]nums){
        int temp=nums[m];
        nums[m]=nums[n];
        nums[n]=temp;
    } 
}
/*
        P0905SortArrayByParity p905=new P0905SortArrayByParity();
        int[]res=p905.sortArrayByParity(new int[]{3,1,2,4});
        for(int val:res){
            System.out.print(val + " ");
        }
        System.out.println();
*/
