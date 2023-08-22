import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P0047Permutation2 {
  List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[]used = new boolean[nums.length];
        backtrack(new ArrayList<>(),nums,used);
        return ans;
    }

    public void backtrack(List<Integer>tempList,int[]nums,boolean[]used){
        if(tempList.size()==nums.length){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            //如果没有!used[i-1]这个条件则答案是空集合。因为如果有重复元素则总是used[i]=true,所以无法添加结果集合为array同等的size
            tempList.add(nums[i]);
            used[i]=true;
            backtrack(tempList,nums,used);
            used[i]=false;
            tempList.remove(tempList.size()-1);
        }
    }
}
/*
P0047Permutation2 p47 = new P0047Permutation2();
System.out.println(p47.permuteUnique(new int[]{1,1,2}));

 */