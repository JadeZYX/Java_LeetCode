import java.util.HashMap;
import java.util.HashSet;

public class P0219ContainsDuplicate2 {
    public boolean containsNearbyDuplicate0(int[] nums, int k) {// 由于超时无法通过！
        for (int i = 0; i < nums.length; i++) {
            int point = i + 1;
            while (point <= nums.length - 1) {
                if (nums[i] == nums[point] && Math.abs(i - point) <= k) {
                    return true;
                }
                point++;
            }
        }
        return false;
    }// for循环遍历整个数组，指针从i的下一个开始，查找与索引代表相同的数，且判断绝对值差小于等于K。

    public boolean containsNearbyDuplicate(int[] nums, int k) {// O(n)+S(k)最优解法 sliding window
        if (nums.length < 2)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {// set的长度最多为K个，一旦超过就删除前面多出的
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {// O(n)+S(n) 第二优解法
        if (nums.length < 2)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {// i是当前索引位置，map.get出来的是以前的索引位置
                    return true;
                }
            }
            map.put(nums[i], i);// 这里包含两层意思：1若不包含直接添加值和索引；2若包含但不满足i-j<=k则更新map里之前的索引值
        }
        return false;
    }
}
