public class No_64_Minimum_Path_Sum {

    /**
     * 动态规划思路与矩阵方格唯一路径总数类似
     *
     * 通过归纳 可得出转移方程式如下：
     *
     * 1.到达每一点的最小和 = Math.min(当前数值 + 上测点的值， 当前述职 + 左侧点的值)
     *
     * 2. 与起点x轴或y轴相同的点的最小值只能是当前轴的数一直累加
     *
     * 所以递推公式分3中情况处理，坐标x=0的和y=0的（公式2） x与y均不为0的 （公式1）
     *
     * 加到最后，就是最小和 yes!!!
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int gridX = grid.length;
        int gridY = grid[0].length;

        int[][] sumGrid = new int[gridX][gridY];

        int xSum = 0;

        int ySum = 0;

        for (int x = 0; x < gridX; x ++) {
            for (int y = 0; y < gridY; y ++) {
                if (x == 0 || y == 0) {
                    if (x == 0) {
                        ySum += grid[x][y];
                        sumGrid[x][y] = ySum;
                    }
                    if (y == 0) {
                        xSum += grid[x][y];
                        sumGrid[x][y] = xSum;
                    }
                } else {
                    int sum = grid[x][y];
                    sum = Math.min(sumGrid[x -1][y] + sum, sumGrid[x][y - 1] + sum);
                    sumGrid[x][y] = sum;
                }
            }
        }

        return sumGrid[gridX - 1][gridY - 1];
    }

    public static void main(String[] args) {

        int[][] grid = new int[][] {{1, 2,},{1, 1}};

        System.out.println(new No_64_Minimum_Path_Sum().minPathSum(grid));
    }
}
