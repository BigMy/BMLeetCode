public class No_43_M_Multiply_Strings {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] intResult = new int[222];

        // for循环，数组有低位到高位 一次对应结果的低位和高位
        // 比如 intResult[0]代表结果中 个位数存的值  intResult[1]代表十位数存的值
        // 每次循环计算不进位，只存结果
        for (int idx = 0; idx < num2.length(); idx ++) {

            char num2Char = num2.charAt(num2.length() - 1 - idx);

            int num2num = num2Char - '0';

            for (int idx2 = 0; idx2 < num1.length(); idx2 ++) {

                int num1num = num1.charAt(num1.length() - 1 -idx2) - '0';

                int currMulti = num1num * num2num;

                intResult[idx + idx2] = intResult[idx + idx2] + currMulti;
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        // 循环结果数组 从低位向高位遍历  把当前位存的数值 除以10的结果加到数组后一位的值上，当前值留mod 10后的结果
        for (int idx = 0; idx < num1.length() + num2.length() + 1; idx ++) {
            int mod = intResult[idx] % 10;
            int divide = intResult[idx] / 10;
            intResult[idx + 1] = intResult[idx + 1] + divide;
            intResult[idx] = mod;
        }
        boolean okFlag = false;
        // 转化成字符串
        for (int idx = num1.length() + num2.length(); idx >= 0; idx --) {
            if (intResult[idx] != 0)
                okFlag = true;

            if (okFlag) {
                resultBuilder.append(intResult[idx]);
            }

        }
        return resultBuilder.toString();
    }


    public static void main(String[] args) {

        System.out.println(new No_43_M_Multiply_Strings().multiply("999", "999"));
    }

}
