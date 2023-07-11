
import java.util.Arrays;
import java.util.HashSet;

public class P0268MissingNumber {
    public int missingNumber0(int[] nums) {
        Arrays.sort(nums);// 排序 O(nlogn)
        for (int i = 0; i <= nums.length; i++) { // O(N)
            if (i < nums.length && nums[i] != i) { // 防止i与其长度一致时，nums[i]溢出
                return i;
            }
            if (i == nums.length) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber1(int[] nums) {
        int[] arr = new int[nums.length + 1];// 开出比原数组大1个空间的新数组
        Arrays.sort(nums);
        for (int j = 0; j < arr.length; j++) {// 往新数组里添加数字
            arr[j] = j;
        }
        for (int i = 0; i < nums.length; i++) {// 在原数组的范围内查找缺失
            if (nums[i] != arr[i]) {
                return arr[i];
            }
        }
        return arr[nums.length];// 若超出原数组范围，则返回新数组的最后一位
    }

    public int missingNumber2(int[] nums) { // 时间和空间都是O(n)
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);// 原数组的数添加到set里
        } // hashset的遍历也可用for
        for (int i = 0; i <= nums.length; i++) {// hashset的长度应为nums.length+1,所以下标取到nums.length
            if (set.contains(i)) {
                continue;
            } else {
                return i;
            }
            // if(!set.contains(i))return i;
        }
        return -1;
    }

    public int missingNumber(int[] nums) { // XOR做法 a^b^b=a a^a=0 a^0=a 0^0=0
        int ans = 0;
        for (int i = 0; i <= nums.length; ++i) {//0到N前后都为闭区间时进行每个数到位异或
            ans = ans ^ i;//0^0 = 0, 0^1=1...//0^1^2^3^4^5......^nums.length
        }
        for (int n : nums) { //上面的结果与缺少某个数的数组的元素进行位异或，得出的数就是缺少的数
            ans = ans ^ n;//a^a=0 最终会得到0^x=x而x就是我们需要的结果
        }
        return ans;
    }

    public int missingNumber3(int[] nums) { // 等差数列求和方法
        int l = nums.length;
        int sum1 = (1 + l) * l / 2;//等差数列求和从1到N，前面的0不影响结果
        int sum2 = 0;//传入参数的数组和
        for (int n : nums) {
            sum2 += n;
        }
        return sum1 - sum2;//两个和相减就是要找的数
    }
    public int missingNumber4(int[] nums) {
        int res=0;
         for(int i=0;i<=nums.length;i++){
           if(i<nums.length){
               res=res^i^nums[i];
           }
             if(i==nums.length){
                 res^=i;
             }
         }
        return res;
     }
}
/*
       P0268MissingNumber p268=new P0268MissingNumber();
       System.out.println(p268.missingNumber(new int[]{2,0,1}));
       System.out.println(p268.missingNumber(new int[]{0,1}));
       System.out.println(p268.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
       System.out.println(p268.missingNumber(new int[]{0}));
    */