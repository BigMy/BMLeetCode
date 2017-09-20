import java.util.Arrays;

/**
 * Created by BigMy on 2017/8/23.
 */
public class No_16_M_3Sum_Closest {


    public static void main(String[] args) {

        int[] input = new int[]{-10, 0, -2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
        // int[] input = new int[]{1,1,-2};

        int result = threeSumClosest(input, 18);
        System.out.println("3 sum closest");
        System.out.println("input:" + Arrays.toString(input));
        System.out.println("output:" + Integer.toString(result));

    }

    public static int threeSumClosest(int[] nums, int target) {

        // 先排序，第一个元素for循环
        // 第二个 第三个元素在第一个元素后面的index范围内夹逼
        // 算法目前击败75%的java提交
        // 还有优化空间是每次夹逼的时候判断diff，根据具体情况，夹逼只需要移动一端
        Arrays.sort(nums);
        int diff = 0;
        int tempSum = target;
        for (int idx = 0; idx < nums.length - 2; idx ++) {
            int left = nums[idx];
            int midPos = idx + 1;
            int rightPos = nums.length - 1;
            while (midPos < rightPos) {

                int currentSum = left + nums[midPos] + nums[rightPos];
                if (currentSum > target) {
                    rightPos = rightPos - 1;
                } else if (currentSum < target){
                    midPos = midPos + 1;
                } else {
                    return target;
                }

                if (diff == 0) {
                    tempSum = currentSum;
                    diff = Math.abs(target - currentSum);
                } else {
                    if (Math.abs(target - currentSum) < diff) {
                        tempSum = currentSum;
                        diff = Math.abs(target - currentSum);
                    }
                }
            }
        }
        return tempSum;
    }
}
