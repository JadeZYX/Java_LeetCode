public class P0079WordSearch {
  public boolean exist(char[][]board,String word){
    for(int i = 0;i<board.length;i++){
      for(int j = 0;j<board[0].length;j++){
        if(board[i][j] == word.charAt(0) && dfsHelper(board,word,i,j,0) ){
          return true;//index 表示当前找到哪个字母
        }
      }
    }
    return false;
  }

  private boolean dfsHelper(char[][]board, String word, int i, int j,int index){
    //递归结束条件 1)如果当前要找的索引位置大于单词长度了，说明已经找到了单词中的所有字母，返回true
    if(index == word.length()){
      return true;
    }
    //2)越界
    if(i<0 || i>=board.length || j<0 || j>=board[i].length){
      return false;
    }
    // 3) 没找到
    if(board[i][j]!= word.charAt(index)) return false;
    // same letter can not be used multiple times so we set it to be empty string
    char temp = board[i][j];//先存储在修改，这样最后再借助temp变量修改过来
    board[i][j] = '*';
    //上下左右四个方向扫射查询后面的字母
    boolean found = dfsHelper(board, word, i-1, j, index+1) || dfsHelper(board, word, i+1, j, index+1) ||
                    dfsHelper(board, word, i, j-1, index+1) || dfsHelper(board, word, i, j+1, index+1);
    board[i][j] = temp;//assign the value back here
    return found;
  }
}
/*
 * P0079WordSearch p79 = new P0079WordSearch();
        System.out.println(p79.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
 */
