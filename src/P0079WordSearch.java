public class P0079WordSearch {
  public boolean exist(char[][]board,String word){
    for(int i = 0;i<board.length;i++){
      for(int j = 0;j<board[0].length;j++){
        //这里不能写成if(condition){return helper()}必须是if(condition && true){return true} 因为如果写成这种形式，第一次找到第一个字母的位置就决定了最后的结果。可其实是如果这个位置找到了第一个字母，但也许不能找到其他字母，所以要继续找board的其他位置。所以说是在整个board里只要找到一条满足的条件即可
        if(board[i][j] == word.charAt(0) && dfsHelper(board,word,i,j,0) ){//这里要传入index0岁人已经确定了board[i][j]就是第一个字母。因为在DFS里还要判断board[i][j]是否等于word.charAt(index)如果这里传入index1，则i,j也需要做相应调整了
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
