public class No_28_E_Implement_strStr {


    public static void main(String[] args) {


        System.out.println(strStr("abbabababac", "bac"));
    }


    /**
     * 暴力算法
     *
     * 优解1. KMP 线性
     * 优解2. rolling  hash，每次前进以为就算一下 haystack的前5位char的hash与needle是否一致
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        int pos = -1;

        int idx = 0;

        while (idx < haystack.length() - needle.length() + 1) {

            char haystackChar =  haystack.charAt(idx);
            char needleChar = needle.charAt(0);

            pos = idx;
            int subIdx = 0;
            while (haystackChar == needleChar) {
                if (subIdx < needle.length() - 1)
                    subIdx ++;
                else {
                    return pos;
                }
                haystackChar = haystack.charAt(pos + subIdx);
                needleChar = needle.charAt(subIdx);
            }
            pos = -1;
            idx = idx + Math.max(subIdx - 1, 1);
        }

        return pos;
    }
}
