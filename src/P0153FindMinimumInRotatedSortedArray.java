public class P0153FindMinimumInRotatedSortedArray {
  public int findMin1(int[] nums) {
    if(nums.length==0)return -1;//不存在
        if(nums.length==1)return nums[0];
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;//(left+right)/2
            if(nums[mid]>=nums[left]){//[4,5,6,7,2,3]
                min = Math.min(nums[left],min);
                left = mid+1;
                //如果中间值大于等于最左边的，因为是生序，则最左边的就是最小值，然后继续找右侧
            }
            else{//mid < nums[left] [4,5,6,7,2,3] 当[7,2,3], 也可以是[6,7,2,3,4]
               min =Math.min(nums[mid],min);
               right = mid-1;
            }
        }
        return min;
    }

    public int findMin(int[] nums) {
      if(nums.length==0)return -1;
      if(nums.length==1)return nums[0];
      int left = 0;
      int right = nums.length-1;
      while(left<right){
          int mid = left+(right-left)/2;
          //防溢出 如果当前查到的中间值比前一个值要小，则恭喜找到了目标
          //in a sorted array the number is never less than the number before it
          if(mid>0 && nums[mid] <nums[mid-1]){
              return nums[mid];
          }
          else if(nums[mid]>=nums[left] && nums[mid]>nums[right]){//it's sorted on the left side
              left = mid+1;
          }
          else{//left part wasn't sorted so adjust the right boundary to go towards the left
              right = mid-1;
          }
      }
      return nums[left];//this is the boundary
  }

  public int findMin2(int[] nums) {
    if(nums.length==0)return -1;
    if(nums.length==1)return nums[0];
    int left = 0;
    int right = nums.length-1;
    while(left<=right){//当只剩下一个元素的时候left和right会在同一个点上
       if(nums[left]<=nums[right]){//说明就是升序没有rotate 当仅剩下一个元素的时候也会停止循环
           return nums[left];
       }
       int mid = left+(right-left)/2;
       if(nums[mid]>nums[right]){//说明最低点应该在mid的右侧,在rotate的那条线上
           left = mid+1;
       }
       else{//nums[mid]<nums[right] 最低点可能是mid,也可能在mid的左侧
           right = mid;
       }
    }
    return nums[left];//本题目是升序，所以要找到符合条件的最左侧的值
  }
}
/*
 *
 P0153FindMinimumInRotatedSortedArray p153 = new P0153FindMinimumInRotatedSortedArray();
         System.out.println(p153.findMin2(new int[]{2,1}));
 */