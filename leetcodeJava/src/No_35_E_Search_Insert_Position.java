public class No_35_E_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (target > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        if (nums[nums.length -1] < target) {
            return nums.length;
        } else if (nums[0] > target) {
            return 0;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int lPos, int rPos) {

        int currPos = (lPos + rPos) / 2;

        //
        if (target == nums[currPos]) {
            return currPos;
        } else if (target == nums[currPos + 1]) {
            return currPos + 1;
        } else if (target < nums[currPos]) {
            return binarySearch(nums, target, lPos, currPos);
        } else if (target > nums[currPos + 1]) {
            return binarySearch(nums, target, currPos, rPos);
        } else {
            return currPos + 1;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new No_35_E_Search_Insert_Position().searchInsert(nums, 2));
    }
}
