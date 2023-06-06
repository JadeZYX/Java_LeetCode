public class P0035BinarySearch {
    public int searchInsert(int[]nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}  //时间复杂度O(logn) 没有占用额外的空间
      //P0035BinarySearch p35=new P0035BinarySearch();
       //System.out.println((p35.searchInsert(new int[]{1,3,5,6}, -2)));
