import java.util.Arrays;

public class P0977SortedArray {
    public int[] sortedSquares0(int[]nums){
        int[] squaresArray=new int[nums.length];//开出新数组存储平方值
        for(int i=0;i<nums.length;i++){
            squaresArray[i]=nums[i]*nums[i];
        }
        Arrays.sort(squaresArray);//内置排序
        return squaresArray;
    }
    public int[]sortedSquares(int[]nums){ //two pointers双指针法速度更快
        int left=0,right=nums.length-1;
        int point=nums.length-1;//指针从后往前移动，因为要查看绝对值大的越靠后。
        //不能从前往后添加平方和，因为如果负数0整数，那么0就不会放在最前面
        int[] res=new int[nums.length];
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                res[point]=nums[left]*nums[left];
                point--;
                left++;
            }
            else{
                res[point]=nums[right]*nums[right];
                point--;
                right--;
            }
        }
        return res;
    }
}
/*
      P0977SortedArray p977=new P0977SortedArray();
       int[]res=p977.sortedSquares(new int[]{-7,-3,2,3,11});
       for(int i:res){
           System.out.print(i+" ");
       }
*/
