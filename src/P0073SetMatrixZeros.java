public class P0073SetMatrixZeros {
  public void setZeroes(int[][] matrix) {
    // 用两个数组来存储哪些行列需要改变
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[] row = new boolean[m];
    boolean[] column = new boolean[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          column[j] = true;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row[i] == true || column[j] == true) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public void setZeroes1(int[][] matrix) {//O（1）空间+ O（mn)时间
    int m = matrix.length;//行
    int n = matrix[0].length;//列
    boolean row0Flag = false;
    boolean column0Flag = false;
    for(int i =0;i<n;i++){//查询第一行是否有0
      if(matrix[0][i]==0){
        row0Flag = true;
        break;//一旦发现第一行有一个0，则终止，没必要继续下去
      }
    }
    for(int j = 0;j<m;j++){
      if(matrix[j][0]==0){
        column0Flag = true;
        break;
      }
    }
//去除第一行第一列，所以遍历的坐标从[1,1]开始
//一旦遍历到0元素，则把它在的[i,0]和[0,j]都变成0，也就是第一行第一列的对应位置
    for(int i = 1;i<m;i++){
      for(int j = 1;j<n;j++){
        if(matrix[i][j]==0){
          matrix[i][0]=0;
          matrix[0][j]=0;
        }
      }
    }
    //再次遍历矩阵，从[1,1]开始,如果所在的行列是0，则当前数变成0
    for(int i = 1;i<m;i++){
      for(int j = 1;j<n;j++){
        if(matrix[i][0]==0 || matrix[0][j]==0){
          matrix[i][j]=0;
        }
      }
    }
    //若原第一行第一列有0，则要把第一行第一列的元素变成0
    if(row0Flag){
      for(int i = 0;i<n;i++){
        matrix[0][i]=0;//只改变第一行上的列
      }
    }
    if(column0Flag){
        for(int j =0;j<m;j++){
          matrix[j][0]=0;
        }
    }
  }
}
/*
 * 可以用两个标记数组分别记录每一行和每一列是否有零出现
 * 具体地，首先遍历该矩阵一次，如果某个元素为 00，那么就将该元素所在的行和列所对应标记数组的位置置为
 * \text{true}true。最后再次遍历该矩阵，用标记数组更新原数组即可。
 * 时间复杂度：O(mn)O(mn)，其中 mm 是矩阵的行数，nn 是矩阵的列数。至多只需要遍历该矩阵两次。
 * 空间复杂度：O(m+n)O(m+n)，其中 mm 是矩阵的行数，nn 是矩阵的列数。需要分别记录每一行或每一列是否有零出现。
 *
 */