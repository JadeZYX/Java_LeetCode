import java.util.Arrays;
import java.util.HashMap;

public class P169MajorityElement {
    public int majorityElement0(int[]nums){
        if(nums.length==0){  // 题目默认长度为1时返回唯一元素
            return -1;
        }
        HashMap<Integer,Integer> count=new HashMap<Integer,Integer>();
        int l=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(count.containsKey(nums[i])){
                count.put(nums[i], (count.get(nums[i])+1));
            }
            else{
                count.put(nums[i], 1);
            }
            if(count.get(nums[i])>l/2){ //根据题意可以写出来这一步，关键！！
                return nums[i];
            }
        }
        return -1;
    }
    public int majorityElement1(int[]nums){
        if(nums.length==0){  // 题目默认长度为1时返回唯一元素
            return -1;
        }
        HashMap<Integer,Integer> count=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(count.containsKey(nums[i])){
                count.put(nums[i], (count.get(nums[i])+1));
            }
            else{
                count.put(nums[i], 1);
            }  
        }
        int maxValue=Integer.MIN_VALUE;//假设最大值的Value
        int maxKey=-1;//假设最大值的Key
        for(int key:count.keySet()){
            if(count.get(key)>maxValue){
                maxValue=count.get(key);
                maxKey=key;
            }
        }
        return maxKey;
    }
    public int majorityElement2(int[]nums){
        if(nums.length==0){ 
            return -1;
        }
        Arrays.sort(nums);//内置排序
        return nums[nums.length/2];//若一个数的存在在数组里超过一半，则在一半的位置一定是要求的数
    }
    public int majorityElement(int[]nums){//打擂台打方法
        int master=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==master){
                count++;
            }
           else {//nums[i]!=master
               if(count>0){
                  count--;
               }
               else{//count==0
                   master=nums[i];
                   count=1;
               }
           }
        }
        return master;
    }
}
/*
       P169MajorityElement p169=new P169MajorityElement();
       System.out.println(p169.majorityElement(new int[]{3,2,3}));
       System.out.println((p169.majorityElement(new int[]{2,2,1,1,1,2,2})));
       System.out.println(p169.majorityElement(new int[]{1,3}));
       */