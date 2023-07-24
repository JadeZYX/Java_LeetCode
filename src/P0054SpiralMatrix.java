import java.util.ArrayList;
import java.util.List;
public class P0054SpiralMatrix {
  public List<Integer>spiralOrder(int[][]matrix){
    List<Integer> res = new ArrayList<>();
    if(matrix.length==0)return res;
    int rowStart = 0, rowEnd = matrix.length-1;
    int columnStart = 0, columnEnd = matrix[0].length-1;
    while(rowStart<=rowEnd && columnStart <= columnEnd){
      //行不变，变列号,且列号是逐渐变大的
      for(int i = columnStart;i<=columnEnd;i++){
        res.add(matrix[rowStart][i]);
      }
      rowStart++;
      //列号不改变，行号改变且行号是逐渐变大
      for(int i = rowStart;i<=rowEnd;i++){
        res.add(matrix[i][columnEnd]);
      }
      columnEnd--;
      //行号不变(因为我们上面改变了行数，所以要判定行号)，变列号，且列号逐渐变小
      if(rowStart<=rowEnd){
        for(int i = columnEnd;i>=columnStart;i--){
          res.add(matrix[rowEnd][i]);
        }
      }
      rowEnd--;
      //行号改变，列号不变,但我们之前改变了列数，所以要加判断
      if(columnStart<=columnEnd){
        for(int i = rowEnd;i>=rowStart;i--){
          res.add(matrix[i][columnStart]);
        }
     }
      columnStart++;
    }
    return res;
  }
}
// P0054SpiralMatrix p54 = new P0054SpiralMatrix();
// System.out.println(p54.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));