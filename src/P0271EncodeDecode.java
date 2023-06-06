import java.util.ArrayList;
import java.util.List;

// aaaaabbbbcccc
// hello word
// h#1e#1l#2o#1+w#1o#1r#1
// 32#1|45#1|21#2|78#2|
// a#5b#4c#4
public class P0271EncodeDecode {
  public String encode(List<String> strs){
    StringBuilder sb = new StringBuilder();
    //hello world 5#hello5#world
    for(String word:strs){
      sb.append(word.length()).append("#").append(word);
    }
    return sb.toString();
  }

  public List<String> decode(String s){
    ArrayList<String> res = new ArrayList<>();
    //use indexof method to find hash sign #
    //5#hello5#world10#abcdefjiwe
    int index = 0;
    while(index<s.length()){
      int hashsign = s.indexOf("#", index);//先找到#的位置，前面是单词的长度，后面是单词
      int wordSize = Integer.valueOf(s.substring(index, hashsign));//将string类型转成数字类型
      String word =s.substring(hashsign+1,hashsign+wordSize+1);
      res.add(word);
      index=hashsign+wordSize+1;
    }
    return res;
  }
}
/*
 * P0271EncodeDecode code = new P0271EncodeDecode();
        ArrayList<String> ex = new ArrayList<>();
        ex.add("Hello");
        ex.add("whole");
        ex.add("world");
        ArrayList<String> ex1 = new ArrayList<>(Arrays.asList("good","night","whole","world"));
        code.decode(code.encode(ex));
 */