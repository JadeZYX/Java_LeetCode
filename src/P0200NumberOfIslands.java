import java.util.LinkedList;
import java.util.Queue;

public class P0200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    setZero1(i, j, grid);
                  //  setZero(i, j, grid);//用一个即可
                }
            }
        }
        return count;
    }

   private void setZero(int m, int n, char[][] grid) {
        if (m >= grid.length || m < 0)
            return;
        if (n >= grid[m].length || n < 0)
            return;
        if (grid[m][n] != '1')
            return;
        grid[m][n] = '0';
        setZero(m, n + 1, grid);
        setZero(m, n - 1, grid);
        setZero(m + 1, n, grid);
        setZero(m - 1, n, grid);
    }

    private void setZero1(int m, int n, char[][] grid) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(m, n));
        while (!queue.isEmpty()) {
            Point top = queue.poll();
            int x = top.x;//新的变量
            int y = top.y;
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
                continue;
            }
            grid[x][y] = '0';
            queue.offer(new Point(x + 1, y));
            queue.offer(new Point(x - 1, y));
            queue.offer(new Point(x, y + 1));
            queue.offer(new Point(x, y - 1));
        }
    }

    public class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
/*
 * //深度优先：当遇到岛屿时候，count++，为了防止count重复duplicate计算，可以向四周扩散，把周边都是1的位置全置换成0，
 * 这个操作可以用递归来实现。递归三要素：结束条件，中间操作，最后的递归传递。 递归函数的部分：要先考虑结束条件
 * 1）当超出矩阵范围的时候，是二维矩阵，所以要考虑column和row的取值范围；2）当所在值不为1的时候结束。 递归中间操作就是把1改成0；
 */
