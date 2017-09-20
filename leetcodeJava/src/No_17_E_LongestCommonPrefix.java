/**
 * Created by BigMy on 2017/9/8.
 */
public class No_17_E_LongestCommonPrefix {


    public static void main(String[] args) {

        String[] strings = new String[]{"abcc","abcddd","abcbbbb"};

        System.out.println("LongestCommonPrefix");
        System.out.println("input:" + strings);
        System.out.println("output:" + longestCommonPrefix(strings));

    }


    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return null;
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int charIdx = 0;
        out: while (true) {
            char ch = 0;
            for (int idx = 0; idx < strs.length; idx ++) {
                if (charIdx >= strs[idx].length()) {
                    break out;
                }

                if (idx == 0) {
                    ch = strs[idx].charAt(charIdx);
                } else {
                    if (ch != strs[idx].charAt(charIdx)) {
                        break out;
                    }

                }

            }
            charIdx ++;
        }

        return strs[0].substring(0, charIdx);
    }
}
