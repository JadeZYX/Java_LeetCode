import java.util.HashMap;
import java.util.HashSet;

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
    public int lengthOfLongestSubstring1(String s) { //hashmap+sliding window
        if(s.length()<=1){
            return s.length();
        }
        int maxlen = 0;
        int start = 0;
        int end = 0;
        HashMap<Character,Integer>map = new HashMap<>();
        while(end<s.length()){
            char letter = s.charAt(end);
            map.put(letter,map.getOrDefault(letter,0)+1);//先添加到map里，在check。所以value不是1就是2.
            while(map.get(letter)>1){//如果value是2，则缩小窗口
                char cur = s.charAt(start);
                map.put(cur,map.get(cur)-1);
                start++;
            }
            maxlen = Math.max(maxlen,end-start+1);//如果map里value没有大于1的，说明都是unique的keys，则更新长度
            end++;//然后expand window
        }
        return maxlen;
    }
    public int lengthOfLongestSubstring2(String s) {
        if(s.length()<=1)return s.length();
        int left = 0;
        int right = 0;
        int len = 0;
        HashSet<Character>set = new HashSet<>();
        while(right<s.length()){
            char letter = s.charAt(right);
            if(!set.contains(letter)){
                set.add(letter);
                len = Math.max(set.size(),len);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return len;
    }

    public int lengthOfLongestSubstring3(String s) {
        if(s.length()<=1)return s.length();
        int left = 0;
        int right = 0;
        int len = 0;
        HashSet<Character>set = new HashSet<>();
        while(right<s.length()){
           while(set.contains(s.charAt(right))){//只要有重复元素就缩小窗口
               set.remove(s.charAt(left));
               left++;
           }
           set.add(s.charAt(right));//否则的话扩大窗口
           len = Math.max(set.size(),len);
           right++;
        }
        return len;
    }

}
       //P0003LongestSubstringWithoutRepeatingCh p3=new P0003LongestSubstringWithoutRepeatingCh();
       //System.out.println(p3.lengthOfLongestSubstring("tmmzuxt"));
//使用快慢指针。保证快慢指针之间的元素是不重复的。所以当遇到重复的元素，慢指针要移动hashmap里get到的此元素所在位置的下一个。
//若快慢指针所在的元素不重复，则更新最大值。  快指针每次都要前进且更新记录hashmap里的信息。
/*
 * 使用hashmap做这道题目的时候是先把当前元素添加到map里，然后再check它的value是不是大于1，如果大于1则说明有重复的元素。（所以其实map里的value最大也就是2.）发现有重复的，我们要shrink window（改变慢指针），直到map里get到那个key的值小于1为止。然后我们更新length，同时expand window（前进快指针）
 */