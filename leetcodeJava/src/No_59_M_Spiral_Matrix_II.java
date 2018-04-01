import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_59_M_Spiral_Matrix_II {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];


        int R = n, C = n;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            matrix[r][c] = i + 1;
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

        int[][] martix = new No_59_M_Spiral_Matrix_II().generateMatrix(3);

        for (int idx = 0; idx < 3; idx ++) {
            System.out.println(Arrays.toString(martix[idx]));
        }
    }

}
