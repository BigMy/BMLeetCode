package review;

import java.util.Stack;

public class No_85_H_Maximal_Rectangle {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;

        // 转换成 no 84的直方图数组
        int[] heights =  new int[rows];

        int maxArea = 0;
        // 每一行
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                if (matrix[i][j] == '1')
                    heights[i] ++;
                else
                    heights[i] = 0;
            }
            maxArea = Math.max(maxArea, maxHistogramArea(heights));
        }
        return maxArea;
    }

    private int maxHistogramArea(int[] h) {

        int n = h.length, i = 0, max = 0;


        Stack<Integer> stack = new Stack<>();



        return max;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        System.out.println(new No_85_H_Maximal_Rectangle().maximalRectangle(matrix));

    }
}
