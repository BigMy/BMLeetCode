public class No_63_M_Unique_Paths_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[][] pathCountGrid = new int[m][n];

        int xObstaclesPos = m;

        int yObstaclesPos = n;

        for (int  idx = 0; idx < m; idx ++) {
            if (obstacleGrid[idx][0] == 1) {
                xObstaclesPos = idx;
                break;
            }
        }

        for (int  idx = 0; idx < n; idx ++) {
            if (obstacleGrid[0][idx] == 1) {
                yObstaclesPos = idx;
                break;
            }
        }

        for (int x = 0; x < m; x ++) {

            for (int y = 0; y < n; y ++) {

                if (x == 0 || y == 0) {
                    // 如果是与起始点在一条轴上
                    if (x >= xObstaclesPos || y >= yObstaclesPos) {
                        // 如果x 或y坐标大等于于有障碍物的位置 填0
                        pathCountGrid[x][y] = 0;
                    } else {
                        pathCountGrid[x][y] = 1;
                    }

                } else {
                    // 如果当前点的上一点和左一点不是障碍物，就把他们的路径总数加上
                    int count = 0;
                    if (obstacleGrid[x -1][y] == 0)
                        count += pathCountGrid[x - 1][y];
                    if (obstacleGrid[x][y - 1] == 0)
                        count += pathCountGrid[x][y - 1];
                    pathCountGrid[x][y] = count;
                }

            }
        }

        return pathCountGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] grid = new int[][] {{0, 0, 0}, {0, 0, 0}, {1, 0, 0}};

        System.out.println(new No_63_M_Unique_Paths_II().uniquePathsWithObstacles(grid));
    }
}
