import java.util.HashMap;

public class P0205IsomophicStrings { //同结构字符串
    public boolean isIsomophic(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> chars=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char charS=s.charAt(i);
            char charT=t.charAt(i);
            if(chars.containsKey(charS)){
                if(chars.get(charS)!=charT){
                    return false;
                }
            }
            else if(chars.containsValue(charT)){//反向查看当前charS下，对应的charT是否存在与map中的value中。
                return false;
            }
            else{
                chars.put(charS, charT);
            }
        }
        return true;
    }
    public boolean isIsomophic1(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> chars=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char charS=s.charAt(i);
            char charT=t.charAt(i);
            if(chars.containsKey(charS)){
                if(chars.get(charS)!=charT){
                    return false;
                }
            }
            else{
                if(!chars.containsValue(charT)){
                    chars.put(charS, charT);
                }
                else{//chars.containsValue(charT)
                    return false;
                }
            }
            // !chars.containsKey(charS) 
            //map里不包含key值时分两种：如果也不包含将要映射的value值，则put,
            //若包含将要映射的value值，则返回false。说明不是一一映射关系。
        }
        return true;
    }
}
////同构词 一个字母对应一个映射关系，bijection双射，如单词里的E全都映射成A，单词里的字母G全都映射成D。第二个例子里字母F映射
//成字母B，字母O映射成字母A，但第三个字母O最后一次映射却改变成字母R，不再是字母A，所以是false。
//但注意“badc"和"baba"这种模式，b->b,a->a成立，但d->b,c->a不成立。与b对应但映射关系是b,与a对应但映射关系是a,不是c
        // P0205IsomophicStrings p205=new P0205IsomophicStrings();
        // System.out.println(p205.isIsomophic("badc", "baba"));
        // System.out.println(p205.isIsomophic("foo", "bar"));
        // System.out.println(p205.isIsomophic("paper","title"));