public class P0720LongestWordInDictionaryTrie {
  String res = "";

  class TrieNode {
    TrieNode[] children;
    boolean isWord;
    String str;

    public TrieNode() {
      this.children = new TrieNode[26];
      this.isWord = false;
      this.str = "";
    }
  }

  class Trie {
    TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode();
        }
        cur = cur.children[c - 'a'];
      }
      cur.isWord = true;
      cur.str = word;
    }
//遍历整棵字典树的时候从跟节点开始，不断查看它的children节点是否为空且是否是已经添加到字典树的单词，
//如果是，则更新结果。 因为是字典树，按照字母顺序来的，所以不需要考虑按照字母顺序排序
    public void traverseTree(TrieNode node) {
      if (node.isWord && node.str.length() > res.length()) {
        res = node.str;
      }
      for (int i = 0; i < 26; i++) {
        if (node.children[i] != null && node.children[i].isWord) {
          traverseTree(node.children[i]);
        }
      }
    }
  }

  public String longestWord(String[] words) { // O(n+m*k) + O(n)
    // create trie tree
    Trie tree = new Trie();
    for (String word : words) {
      tree.addWord(word);
    }
    // traverse trie tree and update res with longest length
    tree.traverseTree(tree.root);
    return res;
  }
}
