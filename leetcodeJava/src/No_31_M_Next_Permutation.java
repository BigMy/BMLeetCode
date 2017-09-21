import java.util.Arrays;

/**
 * 全排列 字典序的下一位排列组合
 * 如果没有下一位 给出起始位排列组合
 */
public class No_31_M_Next_Permutation {

    public static void main(String[] args) {


        int[] input = new int[]{1, 3, 2};

        System.out.println("input: " + Arrays.toString(input));
        nextPermutation(input);
        System.out.println("output: " + Arrays.toString(input));

    }

    public static void nextPermutation(int[] nums) {

        if (nums.length < 2)
            return;

        int nextPermutationPos = nums.length - 1;

        int swappingPos = -1;
        // 从尾向头扫描，找到第一个 "小于它后边idx数字"的数字位置swappingPos
        for (int idx = nums.length - 1; idx > 0; idx --) {


            if (nums[idx - 1] < nums[idx]) {
                // 找到后记录这个位置swappingPos
                swappingPos = idx - 1;
                // 再剩余的右侧找一个第一个大于这个数字的数字
                for (int innerIdx = nums.length - 1; innerIdx > 0; innerIdx --) {
                    // 找到后互换位置
                    if (nums[innerIdx] > nums[swappingPos]) {
                       nextPermutationPos = innerIdx;
                       break;
                    }
                }

                int tempNum = nums[swappingPos];

                nums[swappingPos] = nums[nextPermutationPos];

                nums[nextPermutationPos] = tempNum;

                break;
            }
        }

        // 这里应该是 反转 swappingPos + 1 到末尾的数字就行了
        // 为了省事用sort代替
        Arrays.sort(nums, swappingPos + 1, nums.length);
        return;
    }

}
