/**
 * Created by BigMy on 2017/9/8.
 */
public class No_7_E_Reverse_Integer {


    public static void main(String[] args) {



        System.out.println("reverse int");
        System.out.println("input:" + 1534236469);
        System.out.println("output:" + reverse(1534236469));

    }


    public static int reverse(int x) {

        int divisor = 10;

        int reversedInt = 0;

        while (true) {
            int remainder = x % divisor;
            int divideInt = x / divisor;

            if (Math.abs(reversedInt) > (Integer.MAX_VALUE / 10)) {
                return 0;
            }

            if (Math.abs(remainder) > (Integer.MAX_VALUE - Math.abs(reversedInt * 10))) {
                return 0;
            }

            reversedInt = reversedInt * 10 + remainder;

            if (divideInt == 0) {
                break;
            }
            x = divideInt;
        }
        return reversedInt;
    }
}
