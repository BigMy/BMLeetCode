import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigMy on 2017/9/19.
 */
public class No_22_M_GenerateParentheses {

    public static void main(String[] args) {

        int input = 10;
        System.out.println("input:" + input);
        System.out.println("output:" + generateParenthesis(input));
    }



    public static List<String> generateParenthesis(int n) {

        List<String> resultList = new ArrayList<>();
        traversalTree(resultList, "(", 1, 1, '(', n * 2);
        traversalTree(resultList, "(", 1, 1, ')', n * 2);


        // back trace
//        List<String> list = new ArrayList<String>();
//        backtrack(list, "", 0, 0, n);

        return resultList;
    }


    public static void traversalTree(List<String> resultList,
                              String result,
                              int leftParenthesisCount,
                              int depth,
                              char parenthesis,
                              int targetLen) {
        // 没有大括号了 退出


        if (leftParenthesisCount == 0 && parenthesis == ')') {
            return;
        }
        // 深度大于剩余左括号了 还来左括号 就退出
        if (leftParenthesisCount >= targetLen / 2 && parenthesis == '(') {
            return;
        }

        if (depth >= targetLen) {
            return;
        }

        result = String.format("%s%c", result, parenthesis);


        if (parenthesis == ')') {
            // 右括号 消减一个左括号
            leftParenthesisCount --;

        } else {
            leftParenthesisCount ++;
        }


        if (result.length() == targetLen && leftParenthesisCount == 0) {
            resultList.add(result);
        }


        traversalTree(resultList, result, leftParenthesisCount, depth + 1, '(', targetLen);
        traversalTree(resultList, result, leftParenthesisCount, depth + 1, ')', targetLen);

    }



    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
