import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by BigMy on 2017/8/22.
 */
public class No_15_M_3Sum {


    public static void main(String[] args) {

        int[] input = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        // int[] input = new int[]{1,1,-2};

        List<List<Integer>> testResult = threeSum(input);
        System.out.println("3 sum");
        System.out.println("input:" + Arrays.toString(input));
        System.out.println("output:" + testResult.toString());

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        // sort for detect duplicates
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx ++) {
            hashMap.put(nums[idx], idx);
        }

        for (int idx = 0; idx < nums.length; idx ++) {
            if (idx > 0 && nums[idx] == nums[idx - 1] && nums[idx] != 0) {
                continue;
            }
            int target = nums[idx];
            for (int innerIdx = idx + 1; innerIdx < nums.length; innerIdx ++) {
                if (hashMap.containsKey(0 - (nums[innerIdx] + target))) {
                    int key = hashMap.get(0 - (nums[innerIdx] + target));
                    if (key > innerIdx) {
                        if (result.size() > 0) {
                            List<Integer> preSubList = result.get(result.size() - 1);
                            if (preSubList.get(0) == target && preSubList.get(1) == nums[innerIdx]) {
                                continue;
                            }
                        }
                        List<Integer> subList = new ArrayList<>();
                        subList.add(target);
                        subList.add(nums[innerIdx]);
                        subList.add(0 - (nums[innerIdx] + target));
                        result.add(subList);
                    }
                }
            }
        }
        return result;
    }
}
