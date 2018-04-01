import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class No_62_M_Unique_Paths {

    public int uniquePaths(int m, int n) {

        /**
         * grid的每个点代表到达该点的路径数
         * 通过归纳法可知
         * 1.如果跟起点在一条水平线上，则路径是1
         * 2.否则是 左点路径数+右点路径数
         *
         * 通过2x2 往3x3扩展画一画，会比较形象
         */
        int[][] grid = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0||j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }



    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(new No_62_M_Unique_Paths().uniquePaths(23, 12));
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
