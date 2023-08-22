import java.util.ArrayList;
import java.util.List;
public class P0046Permutations {
  public List<List<Integer>>permute(int[]nums){//O(n*n!) + O(n!)
    List<List<Integer>>ans = new ArrayList();
    backtrack(ans,new ArrayList<>(),nums);
    return ans;
  }

  public void backtrack(List<List<Integer>>list,List<Integer>tempList,int[]nums){
    if(tempList.size()==nums.length){
      list.add(new ArrayList<>(tempList));
      return;
    }
    for(int i = 0;i<nums.length;i++){
      if(tempList.contains(nums[i]))continue;
      //否则会出现[1,1,1][2,2,2], [1,1,2]deng的情况
      tempList.add(nums[i]);
      backtrack(list, tempList, nums);
      tempList.remove(tempList.size()-1);
    }
  }
}
/*排列组合问题，这里每个temList size要与nums长度一致，所以每次都要从i = 0开始，
已经在templist里的要排除，再把没出现过的添加进去。
所以不需要设置start index
P0046Permutations p46 = new P0046Permutations();
System.out.println(p46.permute(new int[]{1,2,3}));

                      [ ]
             1         2        3
          2     3    1   3    1   2
          3     2    3   1    2   1
从上面的1开始，到 1，2 到 1，2，3 添加结果并返回
把2删除，走成1,3, 到 1,3,2
*/