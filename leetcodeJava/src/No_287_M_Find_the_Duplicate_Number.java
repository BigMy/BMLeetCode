/**
 * 此题请深入理解 检测链表有环 且找到环的入口
 * 满指针每次走1步 快指针每次走n步
 * 慢指针走过的路程S1 = 非环部分长度 + 弧A长
 *
 * 快指针走过的路程S2 = 非环部分长度 + n * 环长 + 弧A长

 * S1 * 2 = S2，可得 非环部分长度 = n * 环长 - 弧A长

 * 让指针A回到起始点后，走过一个非环部分长度，指针B走过了相等的长度，也就是n * 环长 - 弧A长，正好回到环的开头。
 */
public class No_287_M_Find_the_Duplicate_Number {



    public int findDuplicate(int[] nums) {

        int fast = 0;
        int slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = 0;

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
