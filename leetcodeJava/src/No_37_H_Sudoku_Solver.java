import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class No_37_H_Sudoku_Solver {


    public void solveSudoku(char[][] board) {

        for (int rowIdx = 0; rowIdx < 9; rowIdx ++) {

            Map<Integer, Set<Integer>> alternativeNumMap = new TreeMap<>();

            for (int colIdx = 0; colIdx < 9; colIdx ++) {
                char numChar = board[rowIdx][colIdx];
                if (numChar == '.') {
                    alternativeNumMap.put(colIdx, getAlternativeNum(board, rowIdx, colIdx));
                }
            }
        }
    }


    Set<Integer> getAlternativeNum(char[][] board, int row, int col) {

        Set<Integer> rowSet = availableNumInRow(board, row);
        Set<Integer> colSet = availableNumInColumn(board, col);
        Set<Integer> blockSet = availableNumInBlock(board, row, col);
        rowSet.retainAll(colSet);
        rowSet.retainAll(blockSet);
        return rowSet;
    }


    Set<Integer> availableNumInRow(char[][] board, int row) {

        Set<Integer> set = fullSet();

        for (int idx = 0; idx < 9; idx ++) {
            if (board[row][idx] != '.') {
                set.remove(Character.getNumericValue(board[row][idx]));
            }
        }
        return set;
    }

    Set<Integer> availableNumInColumn(char[][] board, int col) {

        Set<Integer> set = fullSet();
        for (int idx = 0; idx < 9; idx ++) {
            if (board[idx][col] != '.') {
                set.remove(Character.getNumericValue(board[idx][col]));
            }
        }
        return set;
    }

    Set<Integer> availableNumInBlock(char[][] board, int row, int col) {

        int blockStartRow = (row / 3) * 3;
        int blockStartCol = (col / 3) * 3;
        Set<Integer> set = fullSet();

        for (int r =  blockStartRow; r < blockStartRow + 3; r ++) {
            for (int c = blockStartCol; c < blockStartCol + 3; c ++) {
                if (board[r][c] != '.') {
                    set.remove(Character.getNumericValue(board[r][c]));
                }
            }
        }
        return set;
    }

    Set<Integer> fullSet() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        return set;
    }

    void getUniqueueCombine(List<List<Integer>> combinelist, List<Integer> currentCombine, List<Set> alternativeSet, int depth, int target) {
        if (target == depth) {
            combinelist.add(currentCombine);
        }
    }

}
