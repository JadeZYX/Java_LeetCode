import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P0692TopKFrequentWordsTrie {
  class TrieNode {
    TrieNode[]children;
    boolean isWord;
    String str;
    int count;
    //constructor
    public TrieNode(){
      this.children = new TrieNode[26];//初始值全是null
      this.isWord = false;
      this.str = "";
      this.count = 0;
    }
  }
  class Trie {
    TrieNode root;
    public Trie(){
      this.root = new TrieNode();
    }
    public void addWord(String word){
      TrieNode cur = root;
      for(char c: word.toCharArray()){
        if(cur.children[c-'a']==null){
          cur.children[c-'a']=new TrieNode();
        }
        cur = cur.children[c-'a'];
      }
      cur.isWord = true;
      cur.str = word;
      cur.count+=1;
    }
    public void traverseTrieTree(TrieNode curNode, PriorityQueue<TrieNode>queue){
      //从字典数头节点开始，然后遍历头节点的每个children节点，一共26个，递归每条路径
      //如果当前的node是个单词则把单词添加入对
      if(curNode.isWord){
        queue.offer(curNode);
      }
      for(int i = 0;i<26;i++){
        if(curNode.children[i]!=null){//必须判定节点不为null
          traverseTrieTree(curNode.children[i], queue);
        }
      }
    }
  }

  /*using trienode to solve problem: create trienode -> add all words in array into
    trienode tree -> traverse trienode tree and add all words into priority queue
    priority queue should be sort by each word's length or alphabet order
  */
  public List<String> topKFrequent(String[] words, int k){
    List<String> res = new ArrayList<>();
    Trie tree = new Trie();
    //create trie tree
    for(int i = 0;i<words.length;i++){
      tree.addWord(words[i]);
    }
    //define minheap and how to order the elements in minheap
    PriorityQueue<TrieNode>queue = new PriorityQueue<>((a,b)->{
      if(a.count != b.count){//by count number, so pass in trienode type
        return b.count - a.count;//from largest to smallest
      }
      else{
        return a.str.compareTo(b.str);//by alphabetical order
      }
    });
    //add each word in words array into minheap through traversing the whole trie tree
    tree.traverseTrieTree(tree.root,queue);
    //get the most k words
    int num = 0;
    while(!queue.isEmpty() && num < k){
      res.add(queue.poll().str);
      num++;
    }
    return res;

  }
}
