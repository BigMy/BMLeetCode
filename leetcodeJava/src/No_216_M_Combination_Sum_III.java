import java.util.ArrayList;
import java.util.List;

public class No_216_M_Combination_Sum_III {


    public static void main(String[] args) {
        int k = 3;
        int n = 50;
        System.out.println("input: k=" + k + " n=" + n);
        List<List<Integer>> result = combinationSum3(k, n);

        for (List<Integer> combination : result) {
            System.out.println(combination.toString());
        }
    }


    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int idx = 0; idx < candidates.length - 2; idx ++) {

            if (candidates[idx] < n) {
                List<Integer> combinationList = new ArrayList<>();
                combinationList.add(candidates[idx]);
                appendCombination(result, combinationList, candidates, idx + 1, candidates[idx] , n, 1, k);
            }

        }
        return result;
    }

    static void appendCombination(List<List<Integer>> result,
                                  List<Integer> combinationList,
                                  int[] candidates,
                                  int candidateIdx,
                                  int sum,
                                  int n,
                                  int depth,
                                  int k) {

        if (depth == k) {
            if (sum == n) {
                result.add(combinationList);
            }
            return;
        }
        for (int idx = candidateIdx; idx < candidates.length; idx ++) {
            int currSum = sum;
            if (candidates[idx] <= n - currSum) {
                List<Integer> nextCombination = new ArrayList<>(combinationList);
                nextCombination.add(candidates[idx]);
                currSum += candidates[idx];
                appendCombination(
                        result, nextCombination, candidates, idx + 1, currSum, n, depth + 1, k);
            }
        }
    }

}
