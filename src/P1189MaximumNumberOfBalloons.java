import java.util.Arrays;
import java.util.HashMap;
public class P1189MaximumNumberOfBalloons {
    public int MaximumNumberOfBalloons(String text){
        if(text.length()==0)return 0;
        HashMap<Character,Integer>map=new HashMap<>();
        String s="balloon";
        for(char letter:s.toCharArray()){
            map.put(letter, 0);
        }
        for(int i=0;i<text.length();++i){
            if(text.charAt(i)=='b'){
                map.put('b', map.getOrDefault('b',0) +1);
                continue;
            }
            else if(text.charAt(i)=='a'){
                map.put('a', map.getOrDefault('a',0) +1);
                continue;
            }
            else if(text.charAt(i)=='l'){
                map.put('l', map.getOrDefault('l',0) +1);
                continue;
            }
            else if(text.charAt(i)=='o'){
                map.put('o', map.getOrDefault('o',0) +1);
                continue;
            }
            else if (text.charAt(i)=='n'){
                map.put('n', map.getOrDefault('n',0) +1);
                continue;
            }
            else{
                continue;
            }
        }
        //要把统计出来的‘l' 'o'的个数除以2 
        map.put('l', map.get('l')/2);
        map.put('o', map.get('o')/2);
        int[]res=new int[5];
        int k=0;
        for(int count:map.values()){
            res[k]=count;
            k++;
        }
        Arrays.sort(res);
        return res[0];
    }
    public int MaximumNumberOfBalloons1(String text){//最优解
        if(text.length()==0)return 0;
        int[]chars=new int[26];
        for(char ch:text.toCharArray()){
            chars[ch-'a']++;
        }
        int res=Integer.MAX_VALUE;
        res=Math.min(res, chars['b'-'a']);
        res=Math.min(res, chars['a'-'a']);
        res=Math.min(res, chars['l'-'a']/2);
        res=Math.min(res, chars['o'-'a']/2);
        res=Math.min(res, chars['n'-'a']);
        return res;
    }
    public int MaximumNumberOfBalloons2(String text){
        if(text.length()==0)return 0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(char letter:"ballon".toCharArray()){
            map.put(letter, 0);
        }
        for(char word:text.toCharArray()){//统计字符串里含有balloon的每个字母的个数
            if(map.containsKey(word)){
                map.put(word, map.getOrDefault(word,0)+1);
            }
        }
        map.put('l', map.get('l')/2);//单词里需要2个"l"所以除以2
        map.put('o', map.get('o')/2);
        int[]res=new int[5];
        int k=0;
        for(int count:map.values()){//map里的数放入array里
            res[k]=count;
            k++;
        }
        Arrays.sort(res);//排序并取出最小值
        return res[0];
    }
}
       //P1189MaximumNumberOfBalloons p1189=new P1189MaximumNumberOfBalloons();
       //System.out.println(p1189.MaximumNumberOfBalloons("hpitp"));
