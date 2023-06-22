public class P0424LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k){
    if(s.length()<=1)return s.length();
    int maxlen = 0;
    int[]freq = new int[26];//统计大写字母出现的频率
    int mostFrequency = 0;
    int left = 0;
    int right = 0;
    while(right<s.length()){
      freq[s.charAt(right)-'A']++;
      int currentFrequency = freq[s.charAt(right)-'A'];
      mostFrequency = Math.max(mostFrequency, currentFrequency);
      //int windowSize = right-left+1;
      //窗口长度-目前为止最大频率个数=需要替换的字母个数,若需要替换的字母个数比K也就是要操作的次数要大，则说明没法讲当前窗口的所有字母变成全部一样的字母。当前窗口不合法，要shrink 窗口，移动left指针。若需要替换的字母个数小于或者等于需要操作的K次限制，则说明操作K次或者不到K次即可将当前窗口的所有字母变成一致的，则更新最大长度且expand window
      while(left<right && right-left+1-mostFrequency>k){
        freq[s.charAt(left)-'A']--;
        left++;
      }
      maxlen = Math.max(maxlen, right-left+1);//历史最大值和当前字母一致的窗口的size
      right++;
    }
    return maxlen;
  }
}
/*
 P0424LongestRepeatingCharacterReplacement p424 = new P0424LongestRepeatingCharacterReplacement();
     // System.out.println(p424.characterReplacement("ABC", 1));
      System.out.println(p424.characterReplacement("AABCABBB", 2));

用ASC统计每个字母出现的频率，每遍历到一个新的元素，都要更新历史频率最高数值 + sliding window
*/