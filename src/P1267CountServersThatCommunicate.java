import java.util.HashMap;

public class P1267CountServersThatCommunicate {
    public int countServers(int[][]grid){
        int m = grid.length, n = grid[0].length;
        UnionFind uf=new UnionFind(m * n);
        for(int i=0;i<m;i++){
            int lastI=-1,lastJ=-1;
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    continue;
                }
                if(lastI==-1&&lastJ==-1){
                    lastI = i;
                    lastJ = j;
                    continue;
                }

                uf.union(mapPos_1D(i, j, n), mapPos_1D(lastI, lastJ, n));
            }
        }
        for(int j=0;j<n;j++){
            int lastI=-1,lastJ=-1;
            for(int i=0;i<m;i++){
                if(grid[i][j]==0){
                    continue;
                }
                if(lastI==-1&&lastJ==-1){
                    lastI = i;
                    lastJ = j;
                    continue;
                }

                uf.union(mapPos_1D(i, j, n), mapPos_1D(lastI, lastJ, n));
            }
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int k=uf.find(mapPos_1D(i, j, n));
                    map.put(k, map.getOrDefault(k, 0)+1);
                }  
            }
        }
        int count=0;
        for(int num:map.values()){
            if(num>1){
                count+=num;
            }
        }
        return count;
    }
    private int mapPos_1D(int x,int y,int n){
        return x*n+y;
    }
    private class UnionFind{
       int[]parent;
       private UnionFind(int N){
           this.parent=new int[N];
          for(int i=0;i<N;i++){
              parent[i]=i;
          }
       }
       private int find(int x){
           assert(x>=0&&x<parent.length);
           while(x!=parent[x]){
               x=parent[x];
           }
           return x;
       }
       private void union(int x, int y){
           int xRoot=find(x);
           int yRoot=find(y);
           if(xRoot==yRoot){
               return;
           }
           parent[xRoot]=yRoot;
       }
    }
}
