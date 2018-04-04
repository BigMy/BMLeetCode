package review;

import java.util.Stack;

/**
 *
 * 给出 n 个非负整数来表示柱状图的各个柱子的高度，每个柱子紧挨彼此，且宽度为 1 。
 *  您的函数要能够求出该柱状图中，能勾勒出来的最大矩形的面积。
 */
public class No_84_H_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] h) {


        int n = h.length, i = 0, max = 0;

        Stack<Integer> s = new Stack<>();

        while (i < n) {
            // as long as the current bar is shorter than the last one in the stack
            // we keep popping out the stack and calculate the area based on
            // the popped bar
            while (!s.isEmpty() && h[i] < h[s.peek()]) {
                // tricky part is how to handle the index of the left bound
                max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
            }
            // put current bar's index to the stack
            s.push(i++);
        }

        // finally pop out any bar left in the stack and calculate the area based on it
        while (!s.isEmpty()) {
            max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
        }

        return max;
    }
}
