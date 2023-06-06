import java.util.HashMap;

//bruse force
public class P0001_twoSum1 {
    public int[] twoSum(int[] nums, int target) {
       int[]res=new int[2];
        for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<nums.length;j++){
               if(nums[i]+nums[j]==target){
                  res[0]=i;
                  res[1]=j; 
                  return res;
               }
           }
       }
       return null;
    }
    //hashmap
    public int[]twosum(int[]nums,int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[]res=new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}

/*
    P0001_twoSum1 p = new P0001_twoSum1(); 类的实例化
    P0001_twoSum1 p1=new P0001_twoSum1();
    int[] res = p.twoSum(new int[] {2,7,11,15}, 9); //调用函数 传入的数组声明+初始化，要有类型方括号初始值
    int[]res1=p.twosum(new int[]{3,5,7,4}, 12);
    for (int i : res1) {    java里数组不能直接打印，需要借助for将数组里的元素呈现出来
        System.out.println(i); 
    }
    for(int j:res){
        System.out.println(j);
    }
*/
