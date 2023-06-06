import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class P0217hashSet {
    public boolean containsDuplicate1(int[]nums){
        HashSet<Integer> sites=new HashSet<>();//空间复杂度O(N) N为数组长度
        for(int i=0;i<nums.length;i++){// 时间复杂度O(N) N为数组长度
            if(sites.contains(nums[i])){
                return true;
            }
            else{
                sites.add(nums[i]);
            }
        }
        return false;
    }
    public boolean containsDuplicate(int[]nums){
        Arrays.sort(nums);//排序O(NlogN)
        for(int i=0;i<nums.length-1;i++){//暴力for循环
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        //coner case
        if(nums.length <= 1){
            return false;
        }
        HashMap <Integer,Integer> map = new HashMap <>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],1)+1);
            if(map.get(nums[i])>1){
                return true;
            }
        }
        return false;
    }
} //这道题目还可以用Arrays.sort(nums)对数组先排序，然后一层for循环看相邻两个数是否相同。时间复杂度为O(NlogN)
    //   P0217hashSet p217=new P0217hashSet();
    //   System.out.println(p217.containsDuplicate(new int[]{1,2,3,1}));
    //   System.out.println(p217.containsDuplicate(new int[]{1,2,3,4}));
//hashset与arraylist不同是hashset是无序无重复的