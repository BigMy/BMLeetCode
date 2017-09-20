public class No_26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2)
            return nums.length;

        int replacingPos = 1;
        int scanPos = 1;
        int newLen = 1;
        while (scanPos < nums.length) {
            // 如果扫描的值跟 替换目标位的前一位不一样，就用新值替换目标位的值
            // 替换后目标位后移
            // 不管替换与否，扫描位都继续向前
            if (nums[replacingPos - 1] != nums[scanPos]) {
                nums[replacingPos] = nums[scanPos];
                replacingPos ++;
                newLen ++;
            }
            scanPos ++;
        }

        return newLen;
    }
}
