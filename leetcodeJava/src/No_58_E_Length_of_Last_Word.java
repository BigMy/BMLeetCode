public class No_58_E_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        String s1 = s.replace(" ", "");
        if (s1.length() == 0) {
            return 0;
        }
        String[] strs = s.split(" ");
        if (strs.length == 0) {
            return 0;
        }

        for (int idx = strs.length - 1; idx >=0; idx --) {
            if (strs[idx].length() > 0) {
                return strs[idx].length();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new No_58_E_Length_of_Last_Word().lengthOfLastWord("hello word   "));
    }
}
