public class No_74_M_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0  || matrix[0].length == 0) {
            return false;
        }

        int matrixWidth = matrix[0].length;
        int matrixHeight = matrix.length;

        if (target < matrix[0][0] || target > matrix[matrixHeight - 1][matrixWidth - 1]) {
            return false;
        }

        int row = findRow(matrix, target);

        if (row == -1) {
            return false;
        }

        return findTarget(matrix[row], target);

    }

    private int findRow(int[][] matrix, int target) {

        if (matrix.length == 1) {
            return 0;
        }

        int width = matrix[0].length;

        int leftSide = 0;
        int rightSide = matrix.length - 1;

        int searchMid = (leftSide + rightSide) / 2;

        while (true) {

            if (matrix[searchMid][0] <= target && matrix[searchMid][width -1] >= target) {
                return searchMid;
            }
            if (leftSide == rightSide) {
                return -1;
            }

            if (matrix[searchMid][0] > target) {
                rightSide = Math.max(leftSide, searchMid - 1);

            } else {
                leftSide = Math.min(rightSide ,searchMid + 1);
            }
            searchMid = (leftSide + rightSide) / 2;
        }
    }

    private boolean findTarget(int[] searchingRow, int target) {

        int leftSide = 0;
        int rightSide = searchingRow.length - 1;

        int searchMid = (leftSide + rightSide) / 2;

        while (true) {

            if (searchingRow[searchMid] == target) {
                return true;
            }

            if (leftSide == rightSide) {
                return false;
            }

            if (searchingRow[searchMid] > target) {
                rightSide = Math.max(leftSide, searchMid - 1);

                searchMid = (leftSide + rightSide) / 2;
            } else {
                leftSide = Math.min(rightSide ,searchMid + 1);
                searchMid = (leftSide + rightSide) / 2;

            }

        }

    }


    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};


        System.out.println(new No_74_M_Search_a_2D_Matrix().searchMatrix(matrix, 13));
    }

}
