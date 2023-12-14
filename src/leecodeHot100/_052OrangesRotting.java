package leecodeHot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 示例 1：
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class _052OrangesRotting {

    /**
     * 这道题是要计算腐烂橘子需要多少分钟才能使得所有新鲜橘子都腐烂。
     * 为了解决这个问题，我们可以使用广度优先搜索（BFS）的方法。
     * 具体步骤如下：
     * 1. 创建一个队列，用于存储当前腐烂的橘子的位置。
     * 2. 遍历整个网格，将所有腐烂的橘子的位置加入到队列中。
     * 3. 初始化分钟数为0。
     * 4. 使用BFS进行搜索，直到队列为空。
     * - 在每一分钟内，先记录当前队列中的橘子数量，用于判断是否还有新鲜橘子。
     * - 遍历当前队列中的橘子，将其周围的新鲜橘子变为腐烂状态，并加入到队列中。
     * - 每遍历一个橘子，将其从队列中移除。
     * - 如果在遍历过程中有新鲜橘子被腐烂，分钟数加1。
     * 5. 最后，检查网格中是否还有新鲜橘子，如果有，则返回-1；否则返回分钟数。
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> rotting = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rotting.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int minutes = 0;
        while (!rotting.isEmpty()) {
            int size = rotting.size();
            boolean hasRotting = false;
            for (int i = 0; i < size; i++) {
                int[] curr = rotting.poll();
                int row = curr[0];
                int col = curr[1];
                int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
                for (int[] dir : direction) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        rotting.offer(new int[]{newRow, newCol});
                        hasRotting = true;
                        fresh--;
                    }
                }
            }
            if (hasRotting) {
                minutes++;
            }
        }
        if (fresh > 0) {
            return -1;
        }
        return minutes;
    }

    public static void main(String[] args) {
        _052OrangesRotting solution = new _052OrangesRotting();

        // 创建二维网格
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int result1 = solution.orangesRotting(grid1);
        System.out.println(result1);  // 输出：4

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        int result2 = solution.orangesRotting(grid2);
        System.out.println(result2);  // 输出：-1

        int[][] grid3 = {
                {0, 2}
        };
        int result3 = solution.orangesRotting(grid3);
        System.out.println(result3);  // 输出：0
    }
}
