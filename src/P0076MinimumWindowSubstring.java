public class P0076MinimumWindowSubstring {
  public String minWindow(String s, String t){
    //corner case
    if(s==null || s.length()==0)return "";
    int needCount = t.length();
    int[] needCharF = new int[128];//初始值都是0
    char[]charT = t.toCharArray();
    for(char letter:charT){//统计T中出现字母的频率
      needCharF[letter]++;
    }
    int minLen = Integer.MAX_VALUE;
    String minSub = "";
    int left = 0;
    int right = 0;
    while(right<s.length()){
      char cur = s.charAt(right);
      if(needCharF[cur]>0){
        needCount--;//在S中找到T中相同的字母
      }
      //将遍历到的字符都添加到窗口里，如果是无关字符，则频率从0变成负数，如果是需要的字符，则会出现两种情况，第一种是减1，第二种是对于重复出现的也会变成负数
      needCharF[cur]--;
      if(needCount==0){//说明区间已经拿到所有需要的字符，尝试shrink window
        //去掉多余的字符，一种是去掉压根不在T中的字符，一种是去掉重复的字符
        //如果是不需要的字符，则从-1变成0还是不需要，但是如果是重复的字符，从-1变成0，再次出现重复字符的时候频率是0就跳出此while循环了
        while(left<right && needCharF[s.charAt(left)]<0){
          needCharF[s.charAt(left)]++;
          left++;
        }
        if(right-left+1 < minLen){//去掉多余字符后更新结果
          minLen = right-left+1;
          minSub=s.substring(left, right+1);
        }
        //将左边界右移动，由于当前字符是需要的字符，相当于减少了一位需要的字符
        needCharF[s.charAt(left)]++;//所以记录成+1相当于继续找此位置上的字符
        left++;//当前窗口下已经查询完毕
        needCount++;
      }
      right++;//expand window
    }
    return minSub;
  }
}
/*
P0076MinimumWindowSubstring p76 = new P0076MinimumWindowSubstring();
        System.out.println(p76.minWindow("EAADBOBECODEBANC", "ABC"));
窗口扩展时寻找可行解：不断滑动右指针直到窗口包含了T中的所有元素，记得频率array--
窗口收缩时优化可行解：此时窗口包含了T的所有元素，因此滑动左指针扔掉不需要的及重复的元素
 * 例如“EAADBOBECODEBANC”，T=“ABC”，需要1个A，1个B，1个C
 * 字母E，不需要，所以从0个变成-1个，字母A，需要，所以从1变成0表示需要0个A，之后还需要1个B，1个C，字母A，已经有了1个，不在需要，所以从0变成-1.。。。。。。
 */