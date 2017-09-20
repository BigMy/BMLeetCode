import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by BigMy on 2017/8/22.
 */
public class No_1_E_TwoSum {

    public static void main(String[] args) {

        int[] input = new int[]{1, 8, 17, 2 , 23, 24, 4};
        int[] testResult = twoSum(input, 18);
        System.out.println("two sum");
        System.out.println("input:" + Arrays.toString(input));
        System.out.println("output:" + Arrays.toString(testResult));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx ++) {
            if (hashMap.containsKey(Integer.valueOf(target - nums[idx]))) {
                result[0] = hashMap.get(Integer.valueOf(target - nums[idx]));
                result[1] = idx;
                return result;
            }
            hashMap.put(Integer.valueOf(nums[idx]), idx);
        }
        return result;
    }
}
