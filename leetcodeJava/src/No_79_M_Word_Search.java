import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_79_M_Word_Search {

    public List<String> findWords(char[][] board, String[] words) {



        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < words.length; i ++) {
            if (exist(board, words[i]))
                stringSet.add(words[i]);
        }

        List<String> list = new ArrayList<>();
        list.addAll(stringSet);
        return list;
    }

    public boolean exist(char[][] board, String word) {

        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        int w = board.length;
        int h = board[0].length;
        int matchLen = word.length();
        boolean[] resultRef = new boolean[] {false};
        boolean[][] cellTagBoard = new boolean[w][h];
        for (int x = 0; x < w; x ++) {
            for (int y = 0; y < h; y ++)
                backTracking(board, word, copyBoard(cellTagBoard), x, y, 1, matchLen, resultRef);
        }
        return resultRef[0];
    }

    private void backTracking(char[][] board,
                              String word,
                              boolean[][] cellTagBoard,
                              int posX,
                              int posY,
                              int step,
                              int matchLen,
                              boolean[] resultRef) {
        if (resultRef[0])
            return;

        if (board[posX][posY] != word.charAt(step - 1))
            return;
        cellTagBoard[posX][posY] = true;
        if (matchLen == step) {
            resultRef[0] = true;
            return;
        }

        // 看左边
        if (posX > 0 && !cellTagBoard[posX - 1][posY])
            backTracking(
                    board,
                    word,
                    copyBoard(cellTagBoard),
                    posX - 1,
                    posY,
                    step + 1,
                    matchLen,
                    resultRef);

        // 看右
        if (posX < cellTagBoard.length - 1 && !cellTagBoard[posX + 1][posY])
            backTracking(
                    board,
                    word,
                    copyBoard(cellTagBoard),
                    posX + 1,
                    posY,
                    step + 1,
                    matchLen,
                    resultRef);

        // 看上
        if (posY > 0 && !cellTagBoard[posX][posY - 1])
            backTracking(
                    board,
                    word,
                    copyBoard(cellTagBoard),
                    posX,
                    posY - 1,
                    step + 1,
                    matchLen,
                    resultRef);

        // 看下
        if (posY < cellTagBoard[0].length - 1 && !cellTagBoard[posX][posY + 1])
            backTracking(
                    board,
                    word,
                    copyBoard(cellTagBoard),
                    posX,
                    posY + 1,
                    step + 1,
                    matchLen,
                    resultRef);
    }

    private boolean[][] copyBoard(boolean[][] board) {
        boolean[][] rets = new boolean[board.length][board[0].length];
        for (int idx = 0; idx < rets.length; idx ++) {
            rets[idx] = Arrays.copyOf(board[idx], board[idx].length);
        }
        return rets;
    }

    public static void main(String[] args) {

        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        char[][] board2 = new char[][] {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word1 = "SEE";
        String word2 = "ABCCED";
        String word3 = "ABCB";

        String word4 = "AAB";

        long start = System.currentTimeMillis();
        System.out.println(new No_79_M_Word_Search().exist(board, word1));
        System.out.println(new No_79_M_Word_Search().exist(board, word2));
        System.out.println(new No_79_M_Word_Search().exist(board, word3));
        System.out.println(new No_79_M_Word_Search().exist(board2, word4));

        long end = System.currentTimeMillis();

        System.out.println(end - start + "ms");

    }
}
