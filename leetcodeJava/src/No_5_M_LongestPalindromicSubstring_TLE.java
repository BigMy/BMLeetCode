/**
 * Created by BigMy on 2017/9/7.
 */
public class No_5_M_LongestPalindromicSubstring_TLE {


    /*
       O(n​3)
     */

    public static void main(String[] args) {


        String inputString1 = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";

        String inputString2 = "ababa";

        String inputString3 = "abc";

        String inputString4 = "abababvddadfqqqfbbbabbbfqqqfda";




        System.out.println("Longest Palindromic Substring");
        System.out.println();
        System.out.println("input:" + inputString1);
        System.out.println("output:" + longestPalindrome(inputString1));
        System.out.println();
        System.out.println("input:" + inputString2);
        System.out.println("output:" + longestPalindrome(inputString2));
        System.out.println();
        System.out.println("input:" + inputString3);
        System.out.println("output:" + longestPalindrome(inputString3));
        System.out.println();
        System.out.println("input:" + inputString4);
        System.out.println("output:" + longestPalindrome(inputString4));
    }


    public static String longestPalindrome(String s) {

        String longestPalindrome =  null;
        int lengthOfSubstring = 0;
        for (int idx = 0; idx < s.length(); idx ++) {
            for (int innerIdx = s.length(); innerIdx > idx; innerIdx --) {
                if ((innerIdx - idx) <= lengthOfSubstring) {
                    break;
                }

                String substring = s.substring(idx, innerIdx);
                if (isPalindrome(substring)) {
                    if (substring.length() > lengthOfSubstring) {
                        longestPalindrome = substring;
                        lengthOfSubstring = substring.length();
                    }
                    break;
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int idx = 0; idx < length / 2; idx ++) {
            char lChar = s.charAt(idx);
            char rChar = s.charAt(length - idx - 1);
            if (lChar != rChar)
                return false;
        }
        return true;
    }
}
