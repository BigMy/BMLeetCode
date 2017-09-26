import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class No_47_M_Permutations_II {


    public static void main(String[] args) {

        int[] input = new int[]{1,1,2, 3};
        System.out.println("input:" + Arrays.toString(input));

        List<List<Integer>> result = new No_47_M_Permutations_II().permuteUnique(input);

        for (List<Integer> combination : result) {
            System.out.println(combination.toString());
        }


    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int idx = 0; idx < nums.length; idx ++) {

            if (numCountMap.containsKey(nums[idx])) {
                int val = numCountMap.get(nums[idx]);
                numCountMap.put(nums[idx], val + 1);
            } else {
                numCountMap.put(nums[idx], 1);
            }
        }

        List<Integer> keyList = new ArrayList<>(numCountMap.keySet());

        for (Integer num : keyList) {
            List<Integer> combination = new ArrayList<>();
            combination.add(num);
            Map<Integer, Integer> currMap = new HashMap<>(numCountMap);
            int val = currMap.get(num);
            if (val == 1) {
                currMap.remove(num);
            } else {
                currMap.put(num, val - 1);
            }

            generateNextStep(result, combination, nums, currMap);

        }

        return result;
    }

    public void generateNextStep(List<List<Integer>> result,
                                 List<Integer> combination,
                                 int[] nums,
                                 Map<Integer, Integer> countMap) {
        if (combination.size() == nums.length) {
            result.add(combination);
            return;
        }

        List<Integer> keyList = new ArrayList<>(countMap.keySet());

        for (Integer num : keyList) {
            List<Integer> nextCombination = new ArrayList<>(combination);
            nextCombination.add(num);
            Map<Integer, Integer> currMap = new HashMap<>(countMap);
            int val = currMap.get(num);
            if (val == 1) {
                currMap.remove(num);
            } else {
                currMap.put(num, val - 1);
            }

            generateNextStep(result, nextCombination, nums, currMap);
        }

    }
}
