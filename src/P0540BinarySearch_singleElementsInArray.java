public class P0540BinarySearch_singleElementsInArray {
    public int singleNonDuplicate(int[]nums){
        int left=0, right=nums.length-1;
        while(left<right){//当left等于right的时候，说明只剩下一个数，找到了答案。退出循环
            //[left,right]因为最后落在一个点上，所以借助left会落在right上
            int mid=left+(right-left)/2;
            if(nums[mid]==nums[mid+1]){
                mid=mid-1;
            }
            int leftpart=mid-left+1;
            //int rightpart=right-(mid+1)+1;看左右两部分哪部分为单数，则结果就在那个部分
            if(leftpart%2==0){//若能被2整除，则在右bufen，left改变成mid+1
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return nums[left];
    }

    public int singleNonDuplicate1(int[]nums){//XOR
        int res=0;
        for(int i:nums){
            res=res^i;
        }
        return res;
    }
    public int singleNonDuplicate2(int[]nums){
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (mid == right) {//这里点right是右边界，最终left和right一起的位置
                return nums[mid];
            }
            
            if(nums[mid]==nums[mid+1]){
                mid=mid-1;
            }
            
            int leftpart=mid-left+1;
            //int rightpart=right-(mid+1)+1;看左右两部分哪部分为单数，则结果就在那个部分
            if(leftpart%2==0){//若能被2整除，则在右bufen，left改变成mid+1
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return -1;//循环内肯定会返回
    }
}
//P0540BinarySearch_singleElementsInArray s = new P0540BinarySearch_singleElementsInArray();
// s.singleNonDuplicate2(new int[] {1,1,2,3,3,4,4,8,8});