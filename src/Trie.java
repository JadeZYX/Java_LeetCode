//P208Leetcode
public class Trie {
  TrieNode root;
  public void Trie() {//initialize constructure构造函数
    root = new TrieNode();
  }

  // TrieNode root = new TrieNode();或者直接写成这样，则不需要构造函数第四行
  public void insert(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();//如果不存在就new出来一个节点
      }
      cur = cur.children[c - 'a'];//更新指针
    }
    cur.isWord = true;//update boolean value
  }

  public boolean search(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        return false;
      }
      cur = cur.children[c - 'a'];
    }
    return cur.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for (char c : prefix.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        return false;
      }
      cur = cur.children[c - 'a'];
    }
    return true;
  }
}
/*
 * class 最好写成平级形式，不要写成包裹形式。Trie里其实并没有用到value，所以不需要val这个成员变量
 * root 的调用要在Trie class里，其实就是Trie Node的实力化，让root里有两个成分，第一个是children，第二是个布尔值
 */
