import java.util.Arrays;
import java.util.HashMap;

public class P1365array {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[]res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    count++;
                }
            }
            res[i]=count;
        }
        return res;
    }
    public int[] smallerNumbersThanCurrent1(int[]nums){
        int[]copy=nums.clone();//克隆
        Arrays.sort(copy);//排序
        HashMap<Integer,Integer>map=new HashMap<>(copy.length);
        for(int i=0;i<copy.length;i++){
            map.putIfAbsent(copy[i], i);//将copy里的元素按顺序添加到map里，且去重，所以此时value相当于下标
        }//对nums里的元素进行访问并从map里找到对应的下标，也就是从小到大排放的位置
        for(int i=0;i<nums.length;i++){
            copy[i]=map.get(nums[i]);
        }
        return copy;
    }//比如nums=[7,2,5，2], copy=[2,2，5,7], map是2-0，5-1，7-2 所以比2小的有0个，比5小的有1个，比7小的有2个

    public int[] SmallerNumbersThanCurrent2(int[]nums){
        int[]res=new int[nums.length];
        int[]copy=nums.clone();
        Arrays.sort(copy);
        for(int i=0;i<nums.length;i++){
            int pos=binarySearch(copy,nums[i]);
            res[i]=pos;
        }
        return res;
    }
    private int binarySearch(int[]nums,int target){
        int left=0,right=nums.length-1;
         int record=-1;
        while(left<=right){
           int mid=left+(right-left)/2;
           if(nums[mid]==target){
               record=mid;//记录当前目标值的位置，但也许是重复数字的第二次出现的位置，所以需要继续查询
               right=mid-1;//继续往左查询
            }
           else if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<=target){
                left=mid+1;
            }
        }
       return record;
    }
}//这道题目是考察的一个无序的数组和其对应的有序数组，如何利用排好序的数组找到无序数组里每个元素位于有序数组的位置
/*
        P1365array p1365=new P1365array();
        int[]res=p1365.SmallerNumbersThanCurrent2(new int[]{8,1,2,2,3});
        for(int i: res){
            System.out.print(i+" ");
        }
        System.out.println();
*/