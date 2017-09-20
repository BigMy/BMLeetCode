public class No_27_RemoveElement {

    public int removeElement(int[] nums, int val) {




        int newArrayIdx = 0;

        for (int idx = 0; idx < nums.length; idx ++) {
            if (nums[idx] != val) {
                nums[newArrayIdx] = nums[idx];
                newArrayIdx ++;
            }
        }

        return newArrayIdx;
    }
}
