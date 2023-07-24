public class P0048RotateImage {
  public void rotate(int[][]matrix){
    if(matrix.length == 0 )return;
    int len = matrix.length;
    //we need to retate the image by clockwise 90 degrees,we can transpose（转置）it into 2 steps: flip the matrix diagonal, and then flip it horizontally
    for(int i = 0;i<len;i++){//N*N matrix
      for(int j = i;j<len;j++){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
      }
    }
    for(int i = 0;i<len;i++){
      for(int j = 0;j<len/2;j++){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[i][len-1-j];
        matrix[i][len-1-j]=temp;
      }
    }
  }
}
/*
 旋转问题可以通过对角线，横向或者纵向轴翻转来获取结果。这道题目第一步是按照对角线翻转，第二步是水平翻转
 1 2 3               1 4 7              7 4 1
 4 5 6 ->对角线翻转    2 5 8 ->纵轴反转    8 5 2
 7 8 9               3 6 9              9 6 3
 例子2
 5   1  9  11             5  2  13  15            15  13  2  5
 2   4  8  10             1  4   3  14            14  3  4  1
 13  3  6   7             9  8   6  12            12  6  8  9
 15 14 12 16             11  10  7  16            16 7  10 11
 */