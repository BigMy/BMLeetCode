import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class No_39_M_Combination_Sum {


    public static void main(String[] args) {

        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target  = 8;

        System.out.println("input: candidates " + Arrays.toString(candidates) + " target " + target);
        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println("output:");
        for (List<Integer> combination : result) {
            System.out.println(combination.toString());
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {



        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> treeSet = new TreeSet<>();
        for (int idx = 0; idx < candidates.length; idx ++) {
            treeSet.add(candidates[idx]);
        }

        int[] newCandidates = new int[treeSet.size()];

        Iterator<Integer> iterator = treeSet.iterator();
        for (int idx = 0; idx < treeSet.size(); idx ++) {
            newCandidates[idx] = iterator.next();
        }

        for (int idx = 0; idx < newCandidates.length; idx ++) {
            if (newCandidates[idx] > target)
                continue;

            List<Integer> combinationList = new ArrayList<>();
            combinationList.add(newCandidates[idx]);
            appendCombination(result, combinationList, newCandidates[idx], newCandidates, target, idx);
        }
        return result;
    }

    static void  appendCombination(List<List<Integer>> result,
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
                appendCombination(result, nextCombination, currSum, candidates, target, idx);
            }
        }
    }
}
