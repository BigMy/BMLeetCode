import java.util.Arrays;


/**
 * 求数组内没有出现过的最小正数
 *
 * 长度是n的数组，答案就在1到n+1之间，思路是调整数组把符合范围内的数字调整到它对应的idx上
 *
 * 遍历数组，把遇见的数字与他对应的位置交换，加入遇到了5 把它换到idx=4的位置，知道换正确位置
 * 遍历需要n，交换加一起不超过n，再从头遍历到第一个位置与自己位置不相同的idx就是结果，它度 所以复杂度是O(3n)=O(n)
 *
 *
 */
public class No_41_H_First_Missing_Positive {

    public static void main(String[] args) {

        int[] input = new int[]{1, 2, 3, 4, 4, -1, 0, 5, 7};
        System.out.println("input:" + Arrays.toString(input));
        System.out.println("output:" + firstMissingPositive(input));
    }

    public static int firstMissingPositive(int[] nums) {

        for (int idx = 0; idx < nums.length; idx ++) {
            int currPosNum = nums[idx];
            while (currPosNum > 0 && currPosNum <= nums.length && nums[currPosNum - 1] != currPosNum) {
                swap(nums, idx, currPosNum - 1);
                currPosNum = nums[idx];
            }
        }

        for (int idx = 0; idx < nums.length; idx ++) {
            if (nums[idx] != idx + 1) {
                return idx + 1;
            }
        }
        return nums.length + 1;
    }


    private static void swap(int[] nums, int idx0, int idx1) {
        int temp = nums[idx0];
        nums[idx0] = nums[idx1];
        nums[idx1] = temp;
    }
}
