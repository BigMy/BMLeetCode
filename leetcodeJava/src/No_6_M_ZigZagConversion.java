/**
 * Created by BigMy on 2017/9/8.
 */
public class No_6_M_ZigZagConversion {


    public static void main(String[] args) {

        String input = "A";
        System.out.println("ZigZag Conversion");
        System.out.println("input: 3rows " + input);
        System.out.println("output:" + convert(input, 2));

        Integer.parseInt(input);

    }


    public static String convert(String s, int numRows) {

        int length = s.length();
        if (length == 0 || numRows == 1) {
            return s;
        }
        int charGroupNum = 2 * numRows - 2;
        int colGropNum = numRows - 2 + 1;

        int numcolumns = length / charGroupNum;

        numcolumns *= colGropNum;

        if (length % charGroupNum > 0) {
            numcolumns += 1;

            if (length % charGroupNum > numRows) {
                numcolumns += ((length % charGroupNum) - numRows);
            }
        }


        char[][] charMatrix =  new char[numcolumns][numRows];

        int charIdx = 0;
        out: for (int col = 0; col < numcolumns; col ++) {
            for (int row = 0; row < numRows; row ++) {
                if (col % colGropNum == 0) {
                    charMatrix[col][row] = s.charAt(charIdx);
                    charIdx ++;
                } else {
                    if ( (numRows - 1 - (col % colGropNum)) == row) {
                        charMatrix[col][row] = s.charAt(charIdx);
                        charIdx ++;
                    }
                }
                if (charIdx >= length) {
                    break out;
                }
            }
        }

        char[] newChars = new char[length];

        int newCharIdx = 0;
        out2: for (int row = 0; row < numRows; row ++) {
            for (int col = 0; col < numcolumns; col ++) {
                char ch = charMatrix[col][row];

                if (ch != 0) {
                    newChars[newCharIdx] = ch;
                    newCharIdx ++;
                }

                if (newCharIdx >= length) {
                    break out2;
                }
            }
        }

        return String.valueOf(newChars);
    }
}
