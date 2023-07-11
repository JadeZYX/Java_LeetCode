public class TrieNode {
  //成员变量
  TrieNode[] children;//26个字母 类型是trie node
  boolean isWord;//判断是否是个单词
 //constructure
 public void TrieNode(){
  children = new TrieNode[26];
  isWord = false;
 }
}
/* 也可以写成这样
class 里要有成员变量和constructure。如果简单，对成员变量的assign value 可以直接写在成员变量的声明里。
class TrieNode {
  TrieNode[]children= new TrieNode[26];
  boolean isWord = false;
}
 */

//Trie里不需要定义value
