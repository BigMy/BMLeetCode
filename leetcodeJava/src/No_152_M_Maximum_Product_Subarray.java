public class No_152_M_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {

        if (nums.length == 0) return 0;
        int maxEndHere = nums[0];
        int minEndHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 0) {
                maxEndHere = Math.max(maxEndHere * num, num);
                minEndHere = Math.min(minEndHere * num, num);
            } else {
                int temp = maxEndHere;
                maxEndHere = Math.max(minEndHere * num, num);
                minEndHere = Math.min(temp * num, num);
            }
            maxSoFar = Math.max(maxEndHere, maxSoFar);
        }
        return maxSoFar;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 0, 2, -3, 0};

        System.out.println(new No_152_M_Maximum_Product_Subarray().maxProduct(arr));

    }
}
