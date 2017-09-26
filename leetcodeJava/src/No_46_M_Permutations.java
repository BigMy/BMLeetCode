import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_46_M_Permutations {


    public static void main(String[] args) {

        int[] input = new int[]{1,2,3};

        System.out.println("input:" + Arrays.toString(input));

        List<List<Integer>> result = new No_46_M_Permutations().permute(input);

        for (List<Integer> combination : result) {
            System.out.println(combination.toString());
        }

    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int idx = 0; idx < nums.length; idx ++) {
            List<Integer> combination = new ArrayList<>();
            combination.add(nums[idx]);
            Set<Integer> set = new HashSet<>();
            set.add(nums[idx]);
            generateNextStep(result, combination, nums, set);
        }
        return result;
    }

    public void generateNextStep(List<List<Integer>> result,
                                 List<Integer> combination,
                                 int[] nums,
                                 Set<Integer> pickedSet) {
        if (combination.size() == nums.length) {
            result.add(combination);
            return;
        }

        for (int idx = 0; idx < nums.length; idx ++) {
            if (!pickedSet.contains(nums[idx])) {
                Set<Integer> nextPickedSet = new HashSet<>(pickedSet);
                nextPickedSet.add(nums[idx]);
                List<Integer> nextCombination = new ArrayList<>(combination);
                nextCombination.add(nums[idx]);
                generateNextStep(result, nextCombination, nums, nextPickedSet);
            }
        }
    }
}
