import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给一个s串，有多个等长单词组成，给一组单词words，求得在串s中，出现words词组连结情况的起始未知
 * 连结顺序无所谓
 * 例：
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * return [0, 9];
 */
public class No_30_H_Substring_with_Concatenation_of_All_Words {

    public static void main(String[] args) {

        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
        List<Integer> result = findSubstring(s, words);
        System.out.println("output:" + result.toString());
    }


    public static List<Integer> findSubstring(String s, String[] words) {

        if (words.length == 0) {
            return new ArrayList<>();
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int idx = 0; idx < words.length; idx ++) {
            if (wordMap.containsKey(words[idx])) {
                wordMap.put(words[idx], wordMap.get(words[idx]) + 1);
            } else {
                wordMap.put(words[idx], 1);
            }
        }

        for (int idx = 0; idx <= s.length() - (wordLen * wordCount); idx ++) {
            String startWord = s.substring(idx, idx + wordLen);
            if (wordMap.containsKey(startWord)) {
                Map<String, Integer> checkingMap = new HashMap<>();
                checkingMap.putAll(wordMap);
                handleCheckingMap(checkingMap, startWord);
                int nextWordIdx = idx + wordLen;
                while (nextWordIdx < idx + wordLen * wordCount) {

                    String curString = s.substring(nextWordIdx, nextWordIdx + wordLen);
                    handleCheckingMap(checkingMap, curString);
                    nextWordIdx += wordLen;
                }

                if (checkingMap.isEmpty())
                    result.add(idx);
            }
         }
        return result;
    }

    private static void handleCheckingMap(Map<String, Integer> checkingMap, String key) {
        if (!checkingMap.containsKey(key))
            return;
        int val = checkingMap.get(key);
        if (val > 1) {
            checkingMap.put(key, val - 1);
        } else {
            checkingMap.remove(key);
        }

    }
}
