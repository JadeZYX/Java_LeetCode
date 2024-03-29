import java.util.HashSet;

public class P0200NumberOfIslands_unionFind {
    public int numIslands(char[][]grid){
        int m=grid.length,n=grid[0].length;
        UnionFind uf=new UnionFind(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0'){
                    continue;
                }
                if(i-1>=0&&grid[i-1][j]=='1'){
                    uf.union(mapPos(i,j,n), mapPos(i-1,j,n));
                }
                if(j-1>=0&&grid[i][j-1]=='1'){
                    uf.union(mapPos(i,j,n), mapPos(i,j-1,n));
                }
            }
        }
        HashSet<Integer>sets=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){//把二维矩阵中等于1的地方的所有parent添加到set里。set自动去重
                    sets.add(uf.find(mapPos(i,j,n)));
                }
            }
        }
        return sets.size();
    }
    private int mapPos(int x,int y,int n){//把二维的位置转换成一维对应的位置
        return x*n+y;//n是列
        //x是当前行号，y是当前列号，n是一行应该有几个。所以如果第一行就是0*5+y的位置

    }
    private class UnionFind{
        int[]parent;
        public UnionFind(int N){
            this.parent=new int[N];
            for(int i=0;i<N;i++){
                parent[i]=i;
            }
        }
        public int find(int x){
            while(this.parent[x]!=x){
                x=this.parent[x];
            }
            return x;
        }
        public void union(int x,int y){
            this.parent[this.find(x)]=this.find(y);
        }
    }


    int sumIslands;
    public int numIslandsDFS(char[][] grid) {//O(n*m)
        sumIslands = 0;
        if(grid.length == 0)return sumIslands;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){//如果遇到1，则说明当前是岛屿，所以岛屿+1
                    sumIslands+=1;
                    setSurroundingIslandsZero(grid,i,j);//并把与此岛屿设置成‘0’
                }
            }
        }
        return sumIslands;
    }
    private void setSurroundingIslandsZero(char[][]grid,int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length) return;
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        //把此岛屿的周边岛屿设置成‘0’
        setSurroundingIslandsZero(grid,i-1,j);
        setSurroundingIslandsZero(grid,i+1,j);
        setSurroundingIslandsZero(grid,i,j-1);
        setSurroundingIslandsZero(grid,i,j+1);
    }

}
/*
P0200NumberOfIslands p200 = new P0200NumberOfIslands();
System.out.println(p200.numIslands0(new char[][]{{'1','1','1'},
                                                 {'0','1','0'},
                                                 {'1','1','1'}}));
 */

//深度优先：当遇到岛屿时候，count++，为了防止count重复duplicate计算，可以向四周扩散，把周边都是1的位置全置换成0，这个操作可以用递归来实现。递归三要素：结束条件，中间操作，最后的递归传递。 递归函数的部分：要先考虑结束条件 1）当超出矩阵范围的时候，是二维矩阵，所以要考虑column和row的取值范围；2）当所在值不为1的时候结束。  递归中间操作就是把1改成0；