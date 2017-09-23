import java.util.Arrays;

public class No_34_M_Search_for_a_Range {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 6, 7, 7, 8, 8, 9, 10};

        int[] result = searchRange(nums, 7);

        System.out.println(Arrays.toString(result));
    }

    public static  int[] searchRange(int[] nums, int target) {


        int[] result = new int[]{-1, -1};

        if (nums.length == 0) {
            return result;
        }

        int searchRangeLeft = 0;

        int searchRangeRight = nums.length;

        int searchPos = (searchRangeRight + searchRangeLeft) / 2;

        for (int i = 0; i < nums.length; i ++) {

            if (target == nums[searchPos]) {
                result[0] = searchPos;
                result[1] = searchPos;
                int rangeLeft = searchPos;
                while (rangeLeft > 0) {
                    rangeLeft --;
                    if (nums[rangeLeft] == target)
                        result[0] = rangeLeft;
                    else
                        break;
                }
                int rangeRight = searchPos;
                while (rangeRight < nums.length - 1) {
                    rangeRight ++;
                    if (nums[rangeRight] == target)
                        result[1] = rangeRight;
                    else
                        break;
                }

                break;
            } else if (nums[searchPos] > target) {
                searchRangeRight = searchPos;
            } else {
                searchRangeLeft = searchPos;
            }

            searchPos = Math.min((searchRangeRight + searchRangeLeft) / 2, nums.length - 1);

        }
        return result;
    }
}
