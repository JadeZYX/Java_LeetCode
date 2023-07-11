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

  public boolean searchHelper(String word,TrieNode node, int index){
    if (node == null) return false;
    if(index == word.length()){
      return node.isWord;//因为此时index就是单词的长度，而node还保留在length-1的位置上
    }
    char c = word.charAt(index);
    if(c == '.'){
      for(int i = 0;i<26;i++){
        if(searchHelper(word, node.children[i], index+1)){
          return true;
        }
      }
      return false;//for循环25次后
    }
    else{
      return searchHelper(word, node.children[c-'a'], index+1);
    }
  }

  public boolean searchHelper1(String word,TrieNode node, int index){
    if(index == word.length()){
      return node.isWord;//因为此时index就是单词的长度，而node还保留在length-1的位置上
    }
    char c = word.charAt(index);
    if(c == '.'){
      for(int i = 0;i<26;i++){
        if(node.children[i]!=null && searchHelper(word, node.children[i], index+1)){
          return true;
        }
      }
      return false;//for循环25次后
    }
   else{
      if(node.children[c-'a']==null){
        return false;
      }
      else{
        return searchHelper(word, node.children[c-'a'], index+1);
      }
   }
 }
}
