import java.util.Arrays;
import java.util.HashSet;

public class P0720LongestWordInDictionaryHashSet {
  public String longestWord(String[] words) {
    // 因为没有说array里面的单词是unique的，所以借用hashset来去重复，且set的查找速度是O(1)
    HashSet<String> dic = new HashSet<>();
    dic.add("");
    for (String s : words) {
      dic.add(s);
    }
    // sort array through words's length and alphabetical order
    Arrays.sort(words, (a, b) -> {
      if (a.length() != b.length()) {// 按照字符串长度从小到大排序
        return a.length() - b.length();
      } else {// 若长度一致，按照字母顺序从大到小排列，这样我们能先取到字母顺序从小到大的单词
        return b.compareTo(a);
      }
    });
    String res = "";
    // 将array里面的单词按照长度和字母顺序从大到小排序，这样从后面开始找假设答案assuming answer
    for (int i = words.length - 1; i >= 0; i--) {
      if (buildWord(dic, words[i])) {// 查看这个单词从0到len-1的位置是否在dic里,是否能被拆分
        res = words[i];
        return res;
      }
    }
    return res.length() == 1 ? "" : res;// 如果找到的结果就是一个字母如"w"，则返回空
  }

  public boolean buildWord(HashSet<String> set, String word) {// split word 拆分单词看set里是否有sub
    for (int i = 0; i < word.length(); i++) {
      String sub = word.substring(0, i);
      //sub(0,0)会是空字符串，所以直接返回false，因此要在set里面添加空字符串
      if (!set.contains(sub)) {
        return false;
      }
    }
    return true;
  }
}
/*
下面的例子是很多长度是1的字符串，这些都要排除，不能用substring否则sub(0,-1)溢出，但这里build word函数中可直接
跳过长度是1的单词
["b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"]
["yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"]

       P0720LongestWordInDictionaryHashSet p720 = new P0720LongestWordInDictionaryHashSet();
        System.out.println(p720.longestWord(new String[]{"w","wo","wor","worl","world"}));
        System.out.println(p720.longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"}));
        System.out.println(p720.longestWord(new String[]{"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"}));
        System.out.println(p720.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}));
*/