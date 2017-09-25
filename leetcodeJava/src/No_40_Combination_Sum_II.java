import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_40_Combination_Sum_II {

    public static void main(String[] args) {

        int[] canidates = new int[] {1, 2, 3, 4, 5, 3, 2, 11, 6};
        int target = 9;
        System.out.println("input:" + Arrays.toString(canidates) + " target:" + target);
        List<List<Integer>> result = combinationSum2(canidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination.toString());
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();


        Arrays.sort(candidates);

        for (int idx = 0; idx < candidates.length; idx ++) {
            if (candidates[idx] <= target) {
                List<Integer> combinationList = new ArrayList<>();
                combinationList.add(candidates[idx]);
                appendCombination(result, combinationList, candidates[idx], candidates, target, idx + 1);
            }
        }

        return new ArrayList<>(result);
    }

    static void  appendCombination(Set<List<Integer>> result,
                                   List<Integer> combination,
                                   int sum,
                                   int[] candidates,
                                   int target,
                                   int candidatesIdx) {

        if (sum == target) {
            result.add(combination);
            return;
        }


        for (int idx = candidatesIdx; idx < candidates.length; idx ++) {
            if (candidates[idx] <= target - sum) {
                List<Integer> nextCombination = new ArrayList<>(combination);
                nextCombination.add(candidates[idx]);
                int currSum = sum;
                currSum += candidates[idx];
                appendCombination(result, nextCombination, currSum, candidates, target, idx + 1);
            }
        }
    }
}
