import java.util.ArrayList;
import java.util.List;
public class P0039CombinationSum {
    List<List<Integer>> list;
    //时间复杂度最差情况就是N*N的N次方
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       //initializes the ans list to store the result
        list = new ArrayList<>();
        if(candidates.length<=0) return list;
        //Arrays.sort(candidates); 这里不需要sort
        backtrack(new ArrayList<>(),candidates,target,0);//list to track the current combination.
        return list;
    }

    public void backtrack(List<Integer>tempList, int[]nums,int remain, int start){
        if(remain < 0) return;
        else if(remain == 0){
            list.add(new ArrayList<>(tempList));
        }
        else{//目标余额大于0
            for(int i = start; i<nums.length;i++){
              tempList.add(nums[i]);
              backtrack(tempList,nums,remain-nums[i],i);
              tempList.remove(tempList.size()-1);
            }
        }
    }
}
/*
The backtrack method performs the backtracking. It takes the array,temp list,  the remaining target value, and the starting index as parameters.

The base case is when the target value becomes zero. In this case, it means that the current combination in templist sums up to the target. Therefore, a copy of ls is added to the ans list as a valid combination.

The for loop iterates through the elements in the array, starting from the given index start.

Within the loop, the element nums[i] is added to the ans list, and the helper function method is recursively called with the updated target (subtracting nums[i]) and the same starting index i to allow reusing the same element in subsequent combinations.

After the recursive call, the last element is removed from temp list using ls.remove(ls.size() - 1). This step is crucial for backtracking, as it ensures that the correct elements are considered for the next iteration of the loop.

The process continues with the next element in the loop until all combinations have been explored.
*/