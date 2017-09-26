import java.util.Arrays;

public class No_48_M_Rotate_Image {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];

        matrix[0] = new int[] {1, 2, 3, 4};
        matrix[1] = new int[] {5, 6, 7, 8};
        matrix[2] = new int[] {9, 10, 11, 12};
        matrix[3] = new int[] {13, 14, 15, 16};


        rotate(matrix);


        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rotate(int[][] matrix) {

        int radius = matrix.length / 2;

        for (int idx = 0; idx < radius; idx ++) {
            rotateCycle(matrix, idx);
        }
    }


    public static void rotateCycle(int[][] matrix, int depth) {

        int edgeLen = matrix.length - 2 * depth - 1;
        int numCount = edgeLen * 4;

        for (int moveStep = 0; moveStep < edgeLen; moveStep ++) {
            int tempNum = matrix[depth][depth];
            int moveDirection = 0; // 0 下 1 右 2 上 3 左
            int x = depth;
            int y = depth;
            for (int idx = 0; idx < numCount; idx ++) {
                switch (moveDirection) {
                    case 0: {
                        if (y + 1 > matrix.length - depth - 1) {
                            // 转向
                            matrix[y][x] = matrix[y][x + 1];
                            x = x + 1;
                            moveDirection = 1;
                        } else {
                            matrix[y][x] = matrix[y + 1][x];
                            y = y + 1;
                        }
                    }
                    break;
                    case 1: {
                        if (x + 1 > matrix.length - depth - 1) {
                            // 转向
                            matrix[y][x] = matrix[y - 1][x];
                            y = y - 1;
                            moveDirection = 2;
                        } else {
                            matrix[y][x] = matrix[y][x + 1];
                            x = x + 1;
                        }
                    }
                    break;
                    case 2: {
                        if (y - 1 < depth) {
                            // 转向
                            matrix[y][x] = matrix[y][x - 1];
                            x = x - 1;
                            moveDirection = 3;
                        } else {
                            matrix[y][x] = matrix[y - 1][x];
                            y = y - 1;
                        }

                    }
                    break;
                    case 3: {
                        if (x - 1 < depth) {
                            // 转向
                            matrix[y][x] = matrix[y + 1][x];
                            y = y + 1;
                            moveDirection = 1;
                        } else {
                            matrix[y][x] = matrix[y][x - 1];
                            x = x - 1;
                        }
                    }
                    break;
                    default:
                        break;
                }
            }
            matrix[depth][depth + 1] = tempNum;
        }
    }

}
