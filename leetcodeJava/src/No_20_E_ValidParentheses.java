import java.util.Stack;

/**
 * Created by BigMy on 2017/9/18.
 */
public class No_20_E_ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int idx = 0; idx < s.length(); idx ++) {
            char parentheseChar = s.charAt(idx);
            if (parentheseChar == '(' || parentheseChar == '[' || parentheseChar == '{') {
                stack.push(parentheseChar);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char popedchar = stack.pop();

                if (popedchar == '(' && parentheseChar != ')')
                    return false;
                if (popedchar == '[' && parentheseChar != ']')
                    return false;
                if (popedchar == '{' && parentheseChar != '}')
                    return false;
            }
        }

        if (stack.size() > 0) {
            return false;
        }

        return true;
    }
}
