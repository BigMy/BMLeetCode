package dp;

/**
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * <p>
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 */
public class No_746_E_Min_Cost_Climbing_Stairs {

    /**
     *
     * 简单的动态规划
     *
     * 通过归纳分析，每次只能跳一步或者跳两步， 那么i点只可能由i-1和i-2跳过来
     *
     * 则可得到i点最小费用的 dp转移方程式  dp[i] = min( dp[i-1] + cost[i], dp[i-2] + cost[i]);
     *
     * 依次递推，在最后两步中选一个便宜的就行
     */
    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] pay = new int[cost.length];

        pay[0] = cost[0];

        pay[1] = cost[1];

        for (int idx = 2; idx < cost.length; idx ++) {
            pay[idx] = Math.min(pay[idx - 1] + cost[idx], pay[idx - 2] + cost[idx]);
        }
        return Math.min(pay[cost.length - 1], pay[cost.length - 2]);
    }


    public static void main(String[] args) {

        int[] cost = new int[] {10, 15, 20};  // {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(new No_746_E_Min_Cost_Climbing_Stairs().minCostClimbingStairs(cost));

    }
}
