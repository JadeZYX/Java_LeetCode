import java.util.ArrayList;
import java.util.HashMap;

public class P0350_IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } 
            else {
                map.put(num, 1);
            }
        }
        for (int result : nums2) {
            if (map.containsKey(result)&& map.get(result)>0) {
                list.add(result);
                map.put(result, map.get(result) - 1);// 这步相当于更新map，不能只写map.get(result)-1
            }
        }
        int[] retVal = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            retVal[i] = list.get(i);
        }
        return retVal;
    }
}
/*
P0350_IntersectionOfTwoArrays2 p350 = new P0350_IntersectionOfTwoArrays2();
        int res[] = p350.intersect(new int[] { 4,9,5 }, new int[] {9,4,9,8,4});
        //int res1[] = p350.intersect(new int[] { 1,2 }, new int[] { 1,1 });
        for (int i : res) {
            System.out.println(i);
        }
*/
// map.merge(num, 1, (a,b)->a+b);//可以替换第一层循环
//如果 key 对应的 value 不存在，则返回该 value 值，如果存在，则返回通过remappingFunction 重新计算后的值。
// map.put(num, map.getOrDefault(num, 0)+1);//可以替换第二层循环
//getOrDefault() 方法获取指定 key 对应对value，如果找不到 key ，则返回设置的默认值。