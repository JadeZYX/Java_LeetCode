import java.util.HashMap;

public class P0409LongestPalindrome {
    public int longestPalindrome(String s){
        if(s.length()==0)return 0;
        int[]char_counts=new int[128];
        for(char c:s.toCharArray()){
            char_counts[c]++;//计数
        }
        int res=0;
        for(int char_count:char_counts){
            res+=(char_count/2*2);//比如3%2=1*2=2计算可以配成几对
            if(res%2==0 && char_count %2 ==1){//回文里允许有一个单，所以如果和为偶数且有单数出现的字母，则+1；
                res++;
            }
        }
        return res;
    }
    
    public int longestPalindrome1(String s){
        int sum=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(Character letter:s.toCharArray()){
             map.put(letter, map.getOrDefault(letter,0)+1);
        }
        int odd=0;//记录单数的个数
        for(int count:map.values()){
            if (count % 2 == 0) {
                sum += count;
            }
            else {
                sum += (count - 1);
                odd++;
            }
        }
        if(odd==0) {//当没有基数的时候，直接返回结果。
            return sum;
        }
        else{//若基数的个数大于0，则取一个即可。因为回文里允许有一个无需配对的字母
            return sum+1;
        }
    }
}
      //P0409LongestPalindrome p409=new P0409LongestPalindrome();
       //System.out.println(p409.longestPalindrome("abccccdd"));
       //System.out.println(p409.longestPalindrome("bbbr"));
