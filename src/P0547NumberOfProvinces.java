import java.util.HashSet;

public class P0547NumberOfProvinces {
    public int findCircleNum(int[][]isConnected){
        unionFind uf=new unionFind(isConnected.length);

        for(int i=0;i<isConnected.length;i++){
             for(int j=0;j<isConnected[0].length;j++){//for(int j=i+1;j<isConnected[0].length;j++)优化
                 if(isConnected[i][j]==1){
                    uf.union(i, j);
                 }
             }
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<isConnected.length;i++){
            set.add(uf.find(i));
       }
       return set.size();
    }
    private class unionFind{
        private int[]parent;
        private unionFind(int N){
            parent=new int[N];
            for(int i=0;i<N;i++){
                parent[i]=i;
            }
        }
        private int find(int n){
            assert(n>=0&&n<parent.length);
            while(n!=parent[n]){
                n=parent[n];
            }
            return n;
        }
        /*
        private boolean isValidConnected(int p,int q){
            return find(p)==find(q);
        }
        */
        private void union(int p,int q){
            int pParent=find(p);
            int qParent=find(q);
            if(pParent==qParent){
                return;
            }
            parent[pParent]=qParent;
        }
    }
}
//for(int j=i+1;j<isConnected[0].length;j++) 因为将city i和city j union和将city j和 city i union
//是一样的，所以只需要查看矩阵对角线的右上角即可。右上角j>i的，左下角i>j的
