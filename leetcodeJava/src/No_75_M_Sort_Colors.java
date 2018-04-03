import java.util.Arrays;

public class No_75_M_Sort_Colors {

    public void sortColors(int[] nums) {

        int leftP = 0;
        int rightP = nums.length - 1;

        int index = 0;

        while (index <= rightP) {

            if (nums[index] == 0) {
                nums[index] = nums[leftP];
                nums[leftP] = 0;
                leftP ++;
                index ++;

            } else if (nums[index] == 2) {

                nums[index] = nums[rightP];
                nums[rightP] = 2;
                rightP --;

            } else {
                index ++;

            }

        }

    }

    public static void main(String[] args) {

        int[] colors = new int[] {0, 1, 2, 0, 1, 0, 2, 0, 1};

        new No_75_M_Sort_Colors().sortColors(colors);

        System.out.println(Arrays.toString(colors));
    }
}
