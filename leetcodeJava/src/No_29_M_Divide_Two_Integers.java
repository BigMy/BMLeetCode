public class No_29_M_Divide_Two_Integers {


    public static void main(String[] args) {



        System.out.println("input: " + 8 + " " + 3);
        long start = System.currentTimeMillis();

        int result = divide(2147483647, 2);
        long end = System.currentTimeMillis();

        System.out.println("output: " + divide(2147483647, 2));

        System.out.println(end - start);

    }


    public static int divide(int dividend, int divisor) {

        if (dividend == 0)
            return 0;

        if (divisor == 0) {
            throw new ArithmeticException();
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        if (divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE)
            return 1;

        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }


        boolean isPositive = true;

        int result = 0;

        if (dividend < 0)
            isPositive = !isPositive;

        if (divisor < 0)
            isPositive = !isPositive;


        if (dividend < 0)
            dividend = 0 - dividend;

        if (divisor < 0)
            divisor = 0 - divisor;

        for (int idx = divisor; idx <= dividend; idx += divisor) {
            result++;
            if (dividend - idx < divisor)
                break;
        }

        if (isPositive)
            return result;
        else
            return 0 - result;

    }

}
