import java.util.Arrays;

public class No_45_H_Jump_Game_II {


    public static void main(String[] args) {

        int[] nums = new int[] {2,0,1,1,4,2};

        System.out.println("input: " + Arrays.toString(nums));

        System.out.println("output:" + jump(nums));
    }


    public static int jump(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int jumpStep = 0;
        int idx = 0;
        for (;;) {

            int maxStep = nums[idx];
            if (maxStep + idx >= nums.length - 1) {
                jumpStep ++;
                break;
            }

            int nextStep = chooseBestStep(nums, idx);
            jumpStep ++;

            idx += nextStep;
        }

        return jumpStep;
    }

    static int chooseBestStep(int[] nums, int currIdx) {
        int maxStep = nums[currIdx];
        int longestLen = 0;
        int step = 0;
        int scanCount = 0;
        int idx = currIdx;
        while (idx < currIdx + maxStep){
            idx ++;
            int maxLen = nums[idx];
            scanCount ++;

            if (maxLen == 0)
                continue;

            if (maxLen + currIdx >= nums.length - 1)
                return scanCount;

            if (maxLen + (idx - currIdx - 1) >= longestLen) {
                longestLen = maxLen + (idx - currIdx - 1);
                step = scanCount;
            }
        }
        return step;
    }
}
