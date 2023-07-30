public class P323NumberOfConnectedComponentsInAnUndirectedGraph_UnionFind {
  class UnionFind {
    int[]parent;
    public UnionFind(int n){
      this.parent = new int[n];
      for(int i = 0;i<n;i++){
        parent[i]=i;
      }
    }
    public int find(int x){
      while(parent[x]!=x){
        x = parent[x];
      }
      return x;
    }
    public void union(int x, int y){
      int rootX = find(x);
      int rootY = find(y);
      if(rootX == rootY) return;
      parent[rootX] = rootY;
    }
    public int countComponents(int n, int[][]edges){
      UnionFind uf = new UnionFind(n);//此时N个nodes，每个node的父亲节点就是自己
      int count = n;//既然初始状态每个node自成一家，则目前就有N个components
      for(int i = 0;i<edges.length;i++){
        //因为edges里给出的就是相邻节点，所以可以通过并查集更改成为同一个parent，且count数量要减少
        int root1 = uf.find(edges[i][0]);
        int root2 = uf.find(edges[i][1]);
        if(root1 != root2){
          uf.union(root1, root2);
          count--;
        }
      }
      return count;
    }
  }
}
