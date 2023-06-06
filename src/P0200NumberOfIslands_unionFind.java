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
                if(i-1>=0&&grid[i-1][j]=='1'){//将左和上union
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
                if(grid[i][j]=='1'){
                    sets.add(uf.find(mapPos(i,j,n)));
                }
            }
        }
        return sets.size();
    }
    private int mapPos(int x,int y,int n){
        return x*n+y;//n是列
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
}
