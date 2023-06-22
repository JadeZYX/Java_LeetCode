import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P0015Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3){
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i>0&&nums[i]==nums[i-1])continue;//题目中要求的去重复
            int target=0-nums[i];
            int j=i+1,k=len-1;//双向指针
            while(j!=k){//双向指针循环条件，内部的while循环都是在去重复
                //List<Integer>list=new ArrayList<>();
                if(nums[j]+nums[k]==target){
                ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    // list.add(nums[i]);
                    // list.add(nums[j]);
                    // list.add(nums[k]);
                    // ans.add(list);
                    j++;
                    k--;
                    while(j!=k&&nums[j]==nums[j-1]) j++;
                    while(j!=k&&nums[k]==nums[k+1]) k--;
                }
                else if(nums[j]+nums[k]>target){
                    k--;
                    while(j!=k&&nums[k]==nums[k+1]) k--;
                }
                else{
                    j++;
                    while(j!=k&&nums[j]==nums[j-1]) j--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>>threeSum1(int[]nums){
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);
        for(int a=0;a<nums.length-2;a++){
            if (a > 0 && nums[a] == nums[a-1]) continue;
            for(int b=a+1;b<nums.length-1;b++){
                if (b > a+1 && nums[b] == nums[b-1]) continue;
                int c=(nums[a]+nums[b])*-1;
                if (binarysearch(nums,b+1,nums.length,c)){
                   list.add(Arrays.asList(nums[a], nums[b], c));
                }
            }
        }
        return list;
    }
    public boolean binarysearch(int[]nums,int left,int right,int target){
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        if(nums.length<3 || nums==null)return list;//corner case
        Arrays.sort(nums);//O(n*logn)
        for(int i = 0;i<nums.length;i++){//o(n)
            int currentNum = nums[i];
            //第一次去重，比如[-2,0,0,2,2],当取0作为第一个数的时候，index=3的时候再次出现0可作为第一个数，所以需要判断
            if(i>0 && nums[i-1]== currentNum) continue;
            if(nums[i]>0) return list;//如果当前数已经大于0了，数组是有序排序，所以不会存在三个数相加等于0
                int target = 0-currentNum;
                int leftPoint = i+1;
                int rightPoint = nums.length-1;
                while(leftPoint<rightPoint ){
                    //避免重复[-1,0,1,2,-1,-4,-2,-3,3,0,4]->[-4,-3,-3,-1,-1,0,0,1,2,3]:
                    //当-4作为第一个数，-3作为第二个数时候，原数组-3的后面还是-3，没必要再进行一次查找
                    //但是当-3作为第一个数时，第二个数-3是不能skip的，所以不能用leftPoint>1这个条件作为限定,只能是leftPoint-1>i,也就是第一个数所在的位置
                    if(leftPoint-1>i && nums[leftPoint]==nums[leftPoint-1]){
                        leftPoint++;
                    }
                    else if(nums[leftPoint]+nums[rightPoint]==target){
                        list.add(Arrays.asList(currentNum,nums[leftPoint],nums[rightPoint]));
                        leftPoint++;
                        rightPoint--;
                    }
                    else if(nums[leftPoint]+nums[rightPoint]<target){
                        leftPoint++;
                    }
                    else {
                        rightPoint--;
                    }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if(nums.length<3)return res;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2;i++){
            if(i>0 && nums[i-1]==nums[i])continue;
            if(nums[i]>0)return res;
            int target = 0-nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<nums.length-1 && left<right){
                if(nums[left]+nums[right]==target){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){//这里判定重复的时候必须用left<right，因为【0，0，0】，left会不断的➕超出length
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(nums[left]+nums[right]>target){
                    right--;
                     while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else{
                    left++;
                     while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
            }
        }
        return res;
    }

}
/*
P0015Sum3 p15=new P0015Sum3();
List<List<Integer>>res=new ArrayList<>();
res=p15.threeSum(new int[]{-1,0,1,2,-1,-4});
for(List<Integer> list:res){
    for(int num:list){
        System.out.print(num);
    }
}
P0015Sum3 p15 = new P0015Sum3();
System.out.println(p15.threeSum2(new int[]{-1,0,1,2,-1,-4}));
*/