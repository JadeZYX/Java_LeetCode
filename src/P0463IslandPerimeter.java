public class P0463IslandPerimeter {
    int res = 0;
    boolean[][] visted;
    int[][] grid;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        visted = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    VisitGrid(i, j);
                    return res;
                }
            }
        }
        return 0;
    }

    void VisitGrid(int m, int n) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == 0) { // 结束条件
            return;
        }

        // Process
        visted[m][n] = true;

        // this point is land
        res += getYellowSides(m, n);

        // Go next
        VisitGrid(m+1, n);
        VisitGrid(m-1, n);
        VisitGrid(m, n+1);
        VisitGrid(m, n-1);
    }

    int getYellowSides(int m, int n) {
        int count = 4;
        if(isLand(m+1, n)) {
            count--;
        }

        if(isLand(m-1, n)) {
            count--;
        }

        if(isLand(m, n+1)) {
            count--;
        }

        if(isLand(m, n-1)) {
            count--;
        }

        return count;
    }

    boolean isLand(int m, int n) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length) {
            return false;
        }

        return grid[m][n] == 1;
    }

    public int islandPerimeter1(int[][] grid) {
        int area=0;
        int connect=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){//找到了陆地，再查看它的上下左右是否数陆地，如果是，链接边++
                    area++;
                    if(i-1>=0 && grid[i-1][j]==1) connect++;
                    if(i+1<m && grid[i+1][j]==1) connect++;
                    if(j-1>=0 && grid[i][j-1]==1) connect++;
                    if(j+1<n && grid[i][j+1]==1) connect++;
                }
            }
        }
        return area*4-connect;//陆地个数*4条边-重合部分的边就是周长
    }
}
