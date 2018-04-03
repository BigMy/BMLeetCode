import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 给定一个字符串 S 和一个字符串 T，找到 S 中的最小窗口，它将包含复杂度为 O(n) 的 T 中的所有字符。
 * <p>
 * 示例：
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * <p>
 * 最小窗口是 "BANC".
 * <p>
 * 注意事项:
 * 如果 S 中没有覆盖 T 中所有字符的窗口，则返回空字符串 ""。
 * <p>
 * 如果有多个这样的窗口，你将会被保证在 S 中总是只有一个唯一的最小窗口。
 */
public class No_76_H_Minimum_Window_Substring {


    /**
     * 解题思路
     *
     * 1.讲t转化成为包含char的字串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        if (t.length() > s.length())
            return "";

        Map<Character, Integer> targetCharMap = new HashMap<>();

        for (int idx = 0; idx < t.length(); idx ++) {
            if (targetCharMap.containsKey(t.charAt(idx))) {
                targetCharMap.put(t.charAt(idx), targetCharMap.get(t.charAt(idx)) + 1);
            } else {
                targetCharMap.put(t.charAt(idx), 1);
            }
        }


        Map<Character, Integer> searchingTargetMap = new HashMap<>();

        TreeMap<Integer, Character> charPosMap = new TreeMap<>();

        int minWindowLen = Integer.MAX_VALUE;

        String window = "";

        for (int idx = 0; idx < s.length(); idx ++) {
            Character currChar = s.charAt(idx);
            if (targetCharMap.containsKey(currChar)) {
                if (searchingTargetMap.containsKey(currChar)) {
                    if (searchingTargetMap.get(currChar) >= targetCharMap.get(currChar) && charPosMap.firstEntry().getValue().equals(currChar)) {
                        charPosMap.remove(charPosMap.firstKey());
                    } else {
                        searchingTargetMap.put(s.charAt(idx), searchingTargetMap.get(s.charAt(idx)) + 1);
                    }
                } else {
                    searchingTargetMap.put(currChar, 1);
                }
                charPosMap.put(idx, currChar);


                reserveCheckPosMap(charPosMap, searchingTargetMap, targetCharMap);
            }


            if (canSubstringWindow(targetCharMap, searchingTargetMap)) {

                Character minKey = charPosMap.firstEntry().getValue();

                int minValue = charPosMap.firstKey();
                int maxValue = charPosMap.lastKey();
                if (maxValue - minValue < minWindowLen) {
                    minWindowLen = maxValue - minValue;
                    window = s.substring(minValue, maxValue + 1);
                }

                if (searchingTargetMap.get(minKey) == 1) {
                    searchingTargetMap.remove(minKey);
                } else {
                    searchingTargetMap.put(minKey, searchingTargetMap.get(minKey) - 1);
                }

                charPosMap.remove(charPosMap.firstKey());
            }
        }

        return window;
    }

    private boolean canSubstringWindow(Map<Character, Integer> target, Map<Character, Integer> searching) {

        if (target.size() != searching.size())
            return false;

        for (Character ch : target.keySet()) {
            if (target.get(ch) > searching.get(ch))
                return false;

        }
        return true;
    }

    private void reserveCheckPosMap(TreeMap<Integer, Character> charPosMap,
                                    Map<Character, Integer> searchingTargetMap,
                                    Map<Character, Integer> targetCharMap) {

        if (searchingTargetMap.get(charPosMap.firstEntry().getValue()) > targetCharMap.get(charPosMap.firstEntry().getValue())) {

            searchingTargetMap.put(charPosMap.firstEntry().getValue(), searchingTargetMap.get(charPosMap.firstEntry().getValue()) - 1);

            charPosMap.remove(charPosMap.firstKey());
            reserveCheckPosMap(charPosMap, searchingTargetMap, targetCharMap);
        }

    }

    public static void main(String[] args) {

        String s = "acbbaca";

        String t = "aba";

        System.out.println(new No_76_H_Minimum_Window_Substring().minWindow(s, t));

    }
}
