import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_51_H_N_Queens {


    public static void main(String[] args) {

        int n = 8;
        System.out.println("input: " + n);

        List<List<String>> result = solveNQueens(n);

        for (List<String> checkboard : result) {

            for (String row : checkboard) {
                System.out.println(row);
            }
            System.out.println("--------------");
        }

    }


    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();


        for (int idx = 0; idx < n; idx ++) {

            List<String> checkerBoardList = new ArrayList<>();
            int[][] checkerboard = new int[2][n];
            checkerBoardList.add(generateString(n, idx));
            checkerboard[0][idx] = 1;
            appendCheckerboard(result, checkerBoardList, n,1, checkerboard);
        }
        return result;
    }


    /**
     * 递推下棋盘下一行
     */
    public static void appendCheckerboard(List<List<String>> result,
                                          List<String> checkerboardList,
                                          int n,
                                          int rowNum,
                                          int[][] checkerboard) {
        if (rowNum == n) {
            result.add(checkerboardList);
            return;
        }

        int[] currRow = checkerboard[rowNum];
        for (int idx = 0; idx < n; idx ++) {
            if (currRow[idx] == 0) {
                boolean isValid = checkQueenKill(checkerboard, rowNum, idx, n);
                if (isValid) {
                    List<String> currCheckerboard = new ArrayList<>(checkerboardList);
                    currCheckerboard.add(generateString(n, idx));
                    int[][] nextCheckerboard = copyAndAppendCheckerboard(checkerboard, rowNum + 1, n);
                    nextCheckerboard[rowNum][idx] = 1;
                    appendCheckerboard(result, currCheckerboard, n, rowNum + 1, nextCheckerboard);
                }

            }
        }
    }


    public static String generateString(int width, int qIdx) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < width; idx ++) {
            if (idx == qIdx)
                sb.append("Q");
            else
                sb.append(".");
        }
        return sb.toString();
    }


    /**
     * 检查与当前其旁上的皇后是否冲突
     */
    public static boolean checkQueenKill(int[][] checkerboard, int currRow, int qIdx, int n) {

        // 检查垂直
        for (int scanningRow = 0; scanningRow < currRow; scanningRow ++) {
            if (checkerboard[scanningRow][qIdx] == 1)
                return false;
        }
        // 检查左斜角
        int lefDiagonalRow = currRow - 1;
        for (int colIdx = qIdx - 1; colIdx >= 0; colIdx --) {
            if (lefDiagonalRow < 0)
                break;
            if (checkerboard[lefDiagonalRow][colIdx] == 1)
                return false;
            lefDiagonalRow --;
        }
        // 检查右斜角
        int rightDiagonalRow = currRow - 1;
        for (int colIdx = qIdx + 1; colIdx < n; colIdx ++) {
            if (rightDiagonalRow < 0) {
                break;
            }
            if (checkerboard[rightDiagonalRow][colIdx] == 1)
                return false;
            rightDiagonalRow --;
        }
        return true;
    }

    /**
     * 复制一个新的棋盘 并扩展一行
     */
    public static int[][] copyAndAppendCheckerboard(int[][] src, int rowCount, int n) {
        int[][] dst = new int[rowCount + 1][n];
        for (int i = 0; i < rowCount; i++) {
            dst[i] = Arrays.copyOf(src[i], src[i].length);
        }
        return dst;
    }


}
