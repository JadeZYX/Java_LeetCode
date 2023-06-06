import java.util.ArrayList;
import java.util.List;

public class P0442DuplicatesInArray {
   public List<Integer> findDuplicate(int[]nums){
    ArrayList<Integer>list=new ArrayList<>();
    for(int i=0;i<nums.length;i++){
        int index=Math.abs(nums[i])-1;
        if(nums[index]<0){
            list.add(-nums[index]);
           // list.add(Math.abs(index)+1);
               //如果小于0，说明这个索引位置出现过，因为之前我们-1得出来的索引，所以现在+1
        }
        nums[index]=-nums[index];
    }
     return list;
   }
   
    public List<Integer> findDuplicates1(int[]nums){
        ArrayList<Integer>list=new ArrayList<>();
        int[]arr=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                list.add(i);
            }
        }
        return list;
    }
}
/*
       P0442DuplicatesInArray p442=new P0442DuplicatesInArray();
        List<Integer>res=p442.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        for(int i:res){
            System.out.print(i+" ");
        }
//这类题可以通过借助于开出一个新的数组空间，空间长度就是nums.length+1，因为题目是从1～N，
所以如果开到nums.length则第一个是0，取不到最后的N。然后将nums里面的数组以下标的形式添加到复制数组里。
因为复制数组里的初始化都是0，但是下标是按从0～N的顺序，所以可以利用copy数组来记录nums里元素出现的次数。
最后找出出现2次的元素的下标即可。


*/