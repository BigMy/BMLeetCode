import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_49_M_Group_Anagrams {


    public static void main(String args[]) {

        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("input:" + Arrays.toString(strs));
        List<List<String>> result = groupAnagrams(strs);

        for (List<String> stringList : result) {
            System.out.println(stringList.toString());
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }



}
