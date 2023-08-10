//P211 design add and search words data structure
public class classWordDictionary {
  class TrieNode {
    TrieNode[] children;
    boolean isWord;
   //下面是构造函数，实力化变量成员
    public TrieNode() {
      children = new TrieNode[26];//null
      isWord = false;
    }
  }

  TrieNode root;// 定义

public void WordDictionary() {
    root = new TrieNode();//初始化
}

  public void addWord(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }
      cur = cur.children[c - 'a'];
    }
    cur.isWord = true;
  }


  public boolean search(String word){
    return searchHelper1(word,root,0);
  }

  public boolean searchHelper1(String word,TrieNode node, int index){
    if(index == word.length()){
      return node.isWord;//因为此时index就是单词的长度，而node还保留在length-1的位置上
    }
    char c = word.charAt(index);//dot或者是char类型
    if(c == '.'){
      for(int i = 0;i<26;i++){//找到任意一条非null节点然后递归下去
        if(node.children[i]!=null && searchHelper1(word, node.children[i], index+1)){
          return true;
        }
      }
      return false;//for循环25次后全是null节点
    }
   else{
      if(node.children[c-'a']==null){
        return false;
      }
      else{
        return searchHelper1(word, node.children[c-'a'], index+1);
      }
   }
 }
}
/*逐个字母的用递归去查找。每个字母存在两种可能，
第一是dot，第二就是小写字母。所以如果是dot，我们要找到某个非Null的节点，然后调用递归继续往下查找，所以索引+1，同时把当前的trieNode节点传递下去。
如果不是dot,则判断是否为Null，如果不是，继续递归查找下一个字母
*/