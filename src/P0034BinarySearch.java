
public class P0034BinarySearch {
    public int[]searchRange(int[]nums,int target){
        int[]res=new int[2];
        res[0]=firstPosition(nums, target);
        res[1]=lastPosition(nums, target);
        return res;

    }
    public int firstPosition(int[]nums,int target){
        int left=0,right=nums.length-1;
        int res=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else {//记录左边出现的目标值，并不断的更新，当left大于right时候返回的就是第一次出现的
                res = mid;//记录下当前的下标
                right=mid-1;
            }
        }
        return res;
    }
    public int lastPosition(int[]nums,int target){
        int left=0,right=nums.length-1;
        int res=-1;//假设不存在
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{//记录右边出现的目标值并不断更新，当left大于right时返回最后一次出现的位置
                res=mid;//记录下当前的下标并改变不断往后寻找取值范围
                left=mid+1;
            }
        }
        return res;
    }
}
    //   P0034BinarySearch p34=new P0034BinarySearch();
    //   int[]res=p34.searchRange(new int[]{5,7,7,8,8,10}, 6);
    //   for(int num:res){
    //       System.out.print(num+" ");
    //   }
