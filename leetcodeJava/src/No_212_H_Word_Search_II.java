import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_212_H_Word_Search_II {

    public static void main(String[] args) {

        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] word = new String[] {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};

        System.out.println(new No_212_H_Word_Search_II().findWords(board, word));
    }

    public List<String> findWords(char[][] board, String[] words) {

        if (words.length == 0)
            return new ArrayList<>();

        if (board.length == 0 || board[0].length == 0)
            return new ArrayList<>();

        List<String> list = new ArrayList<>();

        int w = board.length;
        int h = board[0].length;

        boolean[][] taggingBoard = new boolean[w][h];

        TrieNode root = buildTrieRoot(words);

        for (int x = 0; x < w; x ++) {
            for (int y = 0; y < h; y ++) {
                backTrack(board, root, list, x, y, copyBoard(taggingBoard));
            }
        }
        return list;
    }


    void backTrack(char[][] board, TrieNode trieNode, List<String> retRef, int posX, int posY, boolean[][] taggingBoard) {

        char ch = board[posX][posY];

        if (trieNode.nodes[ch - 'a'] == null || taggingBoard[posX][posY])
            return;

        taggingBoard[posX][posY] = true;

        if (trieNode.nodes[ch - 'a'].word != null) {
            retRef.add(trieNode.nodes[ch - 'a'].word);
            trieNode.nodes[ch - 'a'].word = null;
        }
        // left
        if (posX > 0 && !taggingBoard[posX - 1][posY])
            backTrack(board, trieNode.nodes[ch - 'a'], retRef, posX - 1, posY, copyBoard(taggingBoard));
        // right
        if (posX < taggingBoard.length - 1 && !taggingBoard[posX + 1][posY])
            backTrack(board, trieNode.nodes[ch - 'a'], retRef, posX + 1, posY, copyBoard(taggingBoard));
        // up
        if (posY > 0 && !taggingBoard[posX][posY - 1])
            backTrack(board, trieNode.nodes[ch - 'a'], retRef, posX, posY - 1, copyBoard(taggingBoard));
        // down
        if (posY < taggingBoard[0].length - 1 && !taggingBoard[posX][posY + 1])
            backTrack(board, trieNode.nodes[ch - 'a'], retRef, posX, posY + 1, copyBoard(taggingBoard));
    }


    TrieNode buildTrieRoot(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int idx = 0; idx < word.length(); idx ++) {
                int i = word.charAt(idx) - 'a';
                if (cur.nodes[i] == null)
                    cur.nodes[i] = new TrieNode();
                cur = cur.nodes[i];
            }
            cur.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String word = null;
    }

    private boolean[][] copyBoard(boolean[][] board) {
        boolean[][] rets = new boolean[board.length][board[0].length];
        for (int idx = 0; idx < rets.length; idx ++) {
            rets[idx] = Arrays.copyOf(board[idx], board[idx].length);
        }
        return rets;
    }
}
