import java.util.HashMap;

public class P0003LongestSubstringWithoutRepeatingCh {
    public int lengthOfLongestSubstring(String s){
        int slow=0,fast=0, maxLen=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(fast<s.length()){
            if(map.containsKey(s.charAt(fast))){
                if(slow<=map.get(s.charAt(fast))){
                    slow=1+map.get(s.charAt(fast));
                }
                else{//slow>map.get(s.charAt(fast))
                    maxLen=Math.max(maxLen, fast-slow+1); 
                }
            }
            else {
               maxLen=Math.max(maxLen, fast-slow+1);
            }
            map.put(s.charAt(fast), fast);
            fast++;
        }
        return maxLen;
    }
}
       //P0003LongestSubstringWithoutRepeatingCh p3=new P0003LongestSubstringWithoutRepeatingCh();
       //System.out.println(p3.lengthOfLongestSubstring("tmmzuxt"));  
//使用快慢指针。保证快慢指针之间的元素是不重复的。所以当遇到重复的元素，慢指针要移动hashmap里get到的此元素所在位置的下一个。
//若快慢指针所在的元素不重复，则更新最大值。  快指针每次都要前进且更新记录hashmap里的信息。
