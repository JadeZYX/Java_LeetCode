import java.util.HashMap;

public class P0695maxAreaOfIslands {
    public int maxAreaOfIsland(int[][]grid){
         unionFind uf=new unionFind(grid.length*grid[0].length);
         for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j]==0){
                    continue;
                 }
                 if(i-1>=0&&grid[i-1][j]==1){
                    uf.union(mapPos1D(i, j, grid), mapPos1D(i-1, j, grid)); 
               //check 上+左；
                 }
                 if(j-1>=0&&grid[i][j-1]==1){
                    uf.union(mapPos1D(i, j, grid), mapPos1D(i, j-1, grid));
                 }
             }
         }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int k=uf.find(mapPos1D(i, j, grid));
                    map.put(k, map.getOrDefault(k, 0)+1);
                    //max=Math.max(max,map.get(k));
                } 
            }
        }
        int max=0;
        for(int num:map.values()){//二维转成一维
            max=Math.max(max, num);
        }
        return max;
    }
    private int mapPos1D(int x,int y,int[][]nums){
        int pos=x*nums[0].length+y;
        return pos;
    }
    private class unionFind{
        private int[]parents;
        private  unionFind(int n){
            parents=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
            }
        }
        private int find(int n){
            assert(n>=0&&n<parents.length);
            while(n!=parents[n]){
                n=parents[n];
            }
            return n;
        }
        private void union(int p,int q){
            int pRoot=find(p);
            int qRoot=find(q);
            if(pRoot==qRoot){
                return;
            }
            parents[pRoot]=qRoot;
        }
    }
}
