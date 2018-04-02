import java.util.ArrayList;
import java.util.List;

public class No_60_M_Permutation_Sequence {

    /**
     * 总数是n!个
     * 序列的第一位有 n! / n种可能
     * 比如 n= 3是   第一位是1的 有3!/3 = 2种可能 [1,2,3] [1,3,2]
     * 第k个序列的第一位是  (k - 1） / 可能性 + 1
     * 比如n=3时， 第3个序列的最高位是   (3 -1) / 2 + 1  = 2
     * 所以可以按照此规律，从高位到到低位依次求得当前位置
     * 迭代过程中不断的修正 n 和k， 由于数字是排列组合，所以把可以用的数字放在一个list里面，每次推断完一位后，就把对应数字移除，
     * 下一位推断时选择数组里对应的idx的数字即可
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {

        if (n == 1) {
            return "1";
        }

        int permuationCount = getFactorial(n);

        if (k > permuationCount)
            return "";

        StringBuilder permutationBuilder = new StringBuilder();

        List<Integer> list = getList(n);

        int n2 = n;
        int k2 = k - 1;

        for (int idx = 0; idx < n; idx ++) {

            int numIndex = k2 / (permuationCount / n2);
            permutationBuilder.append(list.get(numIndex));
            list.remove(numIndex);
            k2 = k2 % (permuationCount / n2);
            permuationCount /= n2;
            n2 --;
        }

        return permutationBuilder.toString();
    }

    private int getFactorial(int n) {
        int result = 1;

        for (int idx = 1; idx <= n; idx ++) {
            result *= idx;
        }

        return result;
    }

    private List<Integer> getList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int idx = 0; idx < n; idx ++) {
            list.add(idx + 1);
        }
        return list;
    }

    public static void main(String args[]) {
        System.out.println(new No_60_M_Permutation_Sequence().getPermutation(5, 9));
    }
}
