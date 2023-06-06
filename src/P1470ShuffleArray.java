import java.util.ArrayList;

public class P1470ShuffleArray {
    public int[] shuffle(int[]nums,int n){
        ArrayList<Integer> list =new ArrayList<>(2*n);
        for(int i=0;i<n;i++){
           list.add(nums[i]);
           list.add(nums[i+n]); 
        }
        for(int i=0;i<2*n;i++){
            nums[i]=list.get(i);
        }
        return nums;
        //return list.stream().mapToInt(Integer::intValue).toArray();
    //或者是将array list转换成array 然后返回
    //int[] arr = list.stream().mapToInt(i -> i).toArray();
    //return arr;
    }
    public int[] shuffle1(int[] nums, int n) {//two pointers optimal solution
        int[]res=new int[nums.length];
        int left=0;
        int right=n;
        int i=0;
        while(left<n&&right<nums.length){
            res[i]=nums[left];
            res[i+1]=nums[right];
            left++;
            right++;
            i+=2;
        }
        return res;
    }
}
//         P1470ShuffleArray p1470=new P1470ShuffleArray();
//         int[]res=p1470.shuffle(new int[]{2,5,1,3,4,7}, 3);
//         for(int i:res){
//             System.out.print(i);
//         }
