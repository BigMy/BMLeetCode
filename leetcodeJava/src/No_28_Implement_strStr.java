public class No_28_Implement_strStr {

    public int strStr(String haystack, String needle) {

        int pos = -1;

        for (int idx = 0; idx < haystack.length() - needle.length(); idx ++) {
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
            idx += subIdx;

        }

        return pos;
    }
}
