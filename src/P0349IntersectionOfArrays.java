import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class P0349IntersectionOfArrays {
    public int[] intersection0(int[]nums1,int[]nums2){
        if(nums1.length>nums2.length){
            int[]temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
              int res=binary(nums2, nums1[i]);
              if(res!=-1){
                if(!set.contains(nums1[res])){
                    set.add(nums1[res]);
                }
            }
        }
       int[]arr=new int[set.size()];
       int j=0;
       for(int i:set){
           arr[j]=i;
           j++;
       }
       return arr;

    }
    public int binary(int[]nums,int target){
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return -1;
    }

    public int[] intersection(int[]nums1,int[]nums2){
        HashSet<Integer> set1=new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        HashSet<Integer>res=new HashSet<>();
        for(int j:nums2){
            if(set1.contains(j)){
                res.add(j);
                set1.remove(j);
            }
        }
        int[]arr=new int[res.size()];
        int count=0;
        for(int element:res){
                arr[count++]=element;
        }
        return arr;
    }
    //最优解法：用两个hashset
    public int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer>set1=new HashSet<>();
        HashSet<Integer>set2=new HashSet<>();
        ArrayList<Integer>list=new ArrayList<>();
        for(int n1:nums1){
            set1.add(n1);
        }
        for(int n2:nums2){
            set2.add(n2);
        }
        for(int n:set1){
            if(set2.contains(n)){
               list.add(n); 
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();//list to array
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        ArrayList<Integer>res=new ArrayList<>();
         if(nums1.length>nums2.length){
             int[] temp=nums1;
             nums1=nums2;
             nums2=temp;
         }
         for(int i=0;i<nums1.length;i++){
             int pos=binary(nums2,nums1[i]);
             if(pos!=-1){
                 if(!res.contains(nums1[i])){
                 res.add(nums1[i]);
                 }
             } 
         }
         return res.stream().mapToInt(Integer::intValue).toArray();
     }  
    
}
//P0349IntersectionOfArrays p349=new P0349IntersectionOfArrays();
//System.out.println(p349.intersection3(new int[]{2,6,2,9,1}, new int[]{7,1}));
