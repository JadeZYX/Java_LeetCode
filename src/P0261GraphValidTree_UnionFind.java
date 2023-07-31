public class P0261GraphValidTree_UnionFind {
  class UnionFind {
    int[]parent;
    public UnionFind(int n){
      this.parent = new int[n];
      for(int i=0;i<n;i++){
        this.parent[i]=i;
      }
    }
    public int find(int x){
      while(this.parent[x]!=x){
        x = this.parent[x];
      }
      return x;
    }
    public void union(int x, int y){
      int rootX = this.find(x);
      int rootY = this.find(y);
      if(rootX == rootY) return;
      this.parent[rootX]=rootY;
    }
  }
  public boolean validTree(int n, int[][]edges){
    if(n == 0 || edges.length == 0 || edges[0].length==0){
      return false;
    }
    //quick check
    if(n-1 != edges.length){//树有N个节点，就有N-1条边
      return false;
    }
    UnionFind uf = new UnionFind(n);
    for(int i = 0;i<edges.length;i++){
      int root1 = uf.find(edges[i][0]);
      int root2 = uf.find(edges[i][1]);
      if(root1 == root2) return false;//如果它们本身就有同一个祖宗且又相邻，则成了环，所以false
      uf.union(root1, root2);
    }
    return false;
  }
}
