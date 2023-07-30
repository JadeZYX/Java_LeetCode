public class P0055JumpGame {
  public boolean canJump(int[] nums) {//O(n)+ O(1)
    //如果就一个元素，那么直接返回true
        if(nums.length ==1) return true;
        int lastGoodPosition = nums.length -1;
        for(int i = nums.length-2;i>=0;i--){
            //从前一个位置起跳加上能跳的步数，如果大于等于当前假设能跳到的位置，则继续更新能跳到的位置check
            if(i+nums[i]>=lastGoodPosition){//不能写成i+1
                lastGoodPosition = i;
            }
        }
        return lastGoodPosition == 0;//倒着跳是否能跳回起点
    }
}
/*from backward to forward的方法来做 看从终点是否能回到起点
[2,3,1,1,4] 首先考虑我们从index= 3 的位置能否调到终点，答案是可以的，位置是3，能跳1步即3+1 = 4 正好调到了position是4的位置，再看index = 2的位置是否能跳到终点，即2+能跳1步=能跳到poison index=3的位置，以此类推，继续向前
其实最后一个位置上的步数是用不上的，只需要关注从前一个位置➕步数能否跳到下一个index position
例子：【2，0，0】
lastPosition  i   nums[i]   reachPosition
2             1   0         1(原地)
2             0   2         2
0            -1退出循环
*/
