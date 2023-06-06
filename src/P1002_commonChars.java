import java.util.ArrayList;
import java.util.List;

public class P1002_commonChars {
    public List<String> commonChars(String[] words) {
        // P0007 p7 = new P0007();
        // p7.reverse(123);//调用其他类下函数，与此题无关
        List<String> list = new ArrayList<>();// java里不管是啥都要注名类型
        int[] count = new int[26];
        if (words.length <= 1) { // 数组的长度不需要括号
            return list;
        }
        for (int i = 0; i < words[0].length(); i++) { // string的长度需要括号
            count[words[0].charAt(i) - 'a']++; //计数 将char转成int并记录其对应字母出现的次数
        }
        for (int i = 1; i < words.length; i++) {
            int[] countcur = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                countcur[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) { // 取两个集合的较小值，更新计数数组
                count[k] = Math.min(count[k], countcur[k]);
            }
        }
        for (int m = 0; m < 26; m++) { // 26个字母
            for (int n = 0; n < count[m]; n++) { // 查看计数里的每个元素对应的个数
                list.add(Character.toString((char) ('a' + m))); //
            }
        }
        return list;
    }
}

