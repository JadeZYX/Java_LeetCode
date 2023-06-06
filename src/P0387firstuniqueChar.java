import java.util.HashMap;
public class P0387firstuniqueChar {
    public int firstUniq(String s){//时间复杂度O（N）遍历2遍长度为N的字符串   空间复杂度 O（1）因为有26个英文字母
        int res=-1;
        HashMap<Character,Integer> map = new HashMap<>(s.length());//统计每个char出现的次数
        for(int i=0;i<s.length();++i){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0;i<s.length();i++){//再次遍历S，但是这次是查看map里面对应Key也就是Char的value是否是1
            if(map.get(s.charAt(i))==1){
                res=i; //是1，则说明首次出现不重复的字母，直接返回i
                return res;
            }
        }
        return res;
    }
    public int firstUniq1(String s){
        int[] charsfrequence=new int[26];//统计单词里每个字母出现的次数
        for(int i=0;i<s.length();++i){
            charsfrequence[s.charAt(i)-'a']++;//char-'a'得出数
        }
        for(int j=0;j<s.length();++j){
            if(charsfrequence[s.charAt(j)-'a']==1){
                return j;//首次不重复字母的下标
            }
        }
        return -1;
    }
}
    //   P0387firstuniqueChar p387=new P0387firstuniqueChar();
    //    System.out.println(p387.firstUniq("leetcode"));