import java.util.Stack;

/**
 * Created by BigMy on 2017/9/18.
 */
public class No_32_H_LongestValidParentheses {


    public static void main(String[] args) {

        String input1 = "())(())";

        String input2 = "()))))))";

        String input3 = "()()()";

        String input4 = ")()(()()()()())";


        System.out.println("Longest Valid Parentheses");

        System.out.println("input1: " + input1);

        System.out.println("output1: " + longestValidParentheses(input1));

        System.out.println("input2: " + input2);

        System.out.println("output2: " + longestValidParentheses(input2));

        System.out.println("input3: " + input3);

        System.out.println("output3: " + longestValidParentheses(input3));

        System.out.println("input4: " + input4);

        System.out.println("output4: " + longestValidParentheses(input4));


    }

    public static int longestValidParentheses(String s) {

        int length = 0;
        int startIdx = 0;
        boolean isCleared = false;
        Stack<Integer> stack = new Stack<>();
        for (int idx = 0; idx < s.length(); idx ++) {
            if (s.charAt(idx) == '(') {
                stack.push(idx);
                if (isCleared) {
                    startIdx = idx;
                    isCleared = false;
                }
            } else {
                // 为空 单独处理
                if (stack.isEmpty()) {
                    isCleared = true;
                } else {
                    int currLen;
                    Integer poppedElement =  stack.pop();
                    if (stack.isEmpty()) {
                        currLen = (idx - startIdx) + 1;
                    } else {
                        currLen = (idx - stack.peek());
                    }
                    if (currLen > length)
                        length = currLen;
                }
            }
        }

        return length;
    }

}
