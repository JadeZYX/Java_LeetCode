public class P0033SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    // corner case
    if (nums.length == 0)
      return -1;
    // find out the most low pivot,记录下它的索引位置和值
    int[] pivot = findPivot(nums);
    int result = -1;
    if (pivot[1] == target) {// 如果最低值和目标值一致，直接返回最低值的索引
      return pivot[0];// 索引
    } // 这里不需要考虑target会小于最小值的情况，因为找到的最小值就已经是array里的最小值了
    else {// pivot[1]>target 只会有等于和大于两种情况。所以用if,else。
      // 需要对比target和right位置上的值，然后缩减范围
      if (target <= nums[nums.length - 1]) {// target在最低点与right之间，则找pivot+1，到length-1
        result = binarySearch(nums, pivot[0] + 1, nums.length - 1, target);
      } else {// target 大于 处在最right点的值，则说明是rotated array，target在pivot左侧
        result = binarySearch(nums, 0, pivot[0], target);
      }
    }
    return result;
  }

  public int[] findPivot(int[] nums) {// 记录它的索引位置和value
    int[] res = new int[2];// index, value
    if (nums.length == 0) {
      return res;
    }
    if (nums.length == 1) {
      res[0] = 0;
      res[1] = nums[0];
      return res;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[left] <= nums[right]) {
        res[0] = left;
        res[1] = nums[left];
        return res;
      } else if (nums[mid] < nums[right]) {
        right = mid;
      } else {// nums[mid]>nums[right]
        left = mid + 1;
      }
    }
    res[0] = left;
    res[1] = nums[left];
    return res;
  }

  public int binarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
/*
 P0033SearchInRotatedSortedArray p33 = new P0033SearchInRotatedSortedArray();
 System.out.println(p33.search(new int[]{4,5,6,7,0,1,2}, 0));
 */