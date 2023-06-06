import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P0448DisappearedNumInArray {
    public List<Integer> findDisappearedNumbers(int[]nums){
        ArrayList<Integer>res=new ArrayList<>(nums.length);
        HashSet<Integer>set=new HashSet<>(nums.length);//创建hashset将应该出现的数从1到N逐个传入
        int i=1;
        while(i<=nums.length){
            set.add(i);
            i++;
        }
        for(int j=0;j<nums.length;++j){
            if(set.contains(nums[j])){
               set.remove(nums[j]);//若hashset里包含数组里的数，则删除，这样hashset里保留下来的数就是答案
            }
        }
       for(int k:set){//将hashset里的数传入要求返回的list里
           res.add(k);
       }
       return res;  
    }
    public List<Integer> findDisappearedIntegers1(int[]nums){
        ArrayList<Integer> res=new ArrayList<>();
        int[]copynums=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            copynums[nums[i]]++;//copy数组里的初始值都是0，这里将原数组里的元素以下标形式传入copy数组里。
        }  //比如原数组第一个数字是3，则copy数组下标为3的位置就传入1.所以如果不存在，返回i即可
        for(int i=1;i<copynums.length;i++){
            if(copynums[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
/*
        P0448DisappearedNumInArray p448=new P0448DisappearedNumInArray();
        List<Integer>res=p448.findDisappearedIntegers1(new int[]{4,3,2,7,8,2,3,1});
        for(int num:res){
            System.out.print(num+" ");
        }
*/
