import java.util.ArrayList;
import java.util.List;
public class P0417PacificAtlanticWaterFlow {
  public List<List<Integer>> pacificAtlantic(int[][]heights){
    List<List<Integer>>res = new ArrayList<>();
        int m = heights.length;
        if(m ==0)return res;
        int n = heights[0].length;
        //这两个boolean二维数组分别记录能汇入大西洋和太平洋的点。最后返回二者都为true的点
        boolean[][]pacific = new boolean[m][n];//初始值是false；
        boolean[][]atlantic = new boolean[m][n];
        //top and bottom最上面一行和下面一行 行号不改变，只改变列号
        for(int col = 0;col<n;col++){
            dfs(heights,0,col,0,pacific);//pacific 设置preheight为0,也可以设置成当前高度
            dfs(heights,m-1,col,0,atlantic);//atlantic;
        }
        //left and right 此时列号不变，行号改变
        for(int row = 0;row<m;row++){
            dfs(heights,row,0,0,pacific);
            dfs(heights,row,n-1,0,atlantic);
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(pacific[i][j]==true && atlantic[i][j]==true){
                    res.add(new ArrayList<>(List.of(i,j)));
                    //List.of()或者 Arrays.asList()
                }
            }
        }
        return res;
    }
    void dfs(int[][]matrix, int row, int column, int preheight, boolean[][]ocean){
        if(row<0 || row >= matrix.length || column<0 || column >= matrix[0].length){//out of boundary
            return;
        }
        if(matrix[row][column]<preheight){
            //如果这个点的高度比前一个点要高，则返回，因为ocean初始值是false，所以没必要改
            return;
        }
        if(ocean[row][column]==true){//already visited
            return;
        }
        ocean[row][column]=true;
        dfs(matrix,row-1,column,matrix[row][column],ocean);
        dfs(matrix,row+1,column,matrix[row][column],ocean);
        dfs(matrix,row,column-1,matrix[row][column],ocean);
        dfs(matrix,row,column+1,matrix[row][column],ocean);
    }
  }
/*
        P0417PacificAtlanticWaterFlow p417 = new P0417PacificAtlanticWaterFlow();
        System.out.println(p417.pacificAtlantic(new int[][]{new int[]{1,2,2,3,5},new int[]{3,2,3,4,4},new int[]{2,4,5,3,1},new int[]{6,7,1,4,5},new int[]{5,1,1,2,4}}));
我们需要找的是既能够汇流到大西洋，又能够汇流到太平洋的点。
从边上开始，因为边上的点是能够连接海洋的。水从高处往低处流，所以从边上往中间汇，找比它高或者等于它的点。
如果不比那个cell高，则返回。否则继续DFS
find cells that can both flow to both pacific and atlantic oceans
solution:
1 table for pacific:boolean true can flow, false can not.
1 table for atlantic ocean: boolean
get the intersection of both true.
How to generate the tables? DFS. From the edges(oceans) to higher or equal height places
是否需要visited array? No need. Once the cell is true, indicate we have visited before.
*/