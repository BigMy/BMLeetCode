import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_17_M_Letter_Combinations_of_a_Phone_Number {


    public static void main(String[] args) {

        String input = "23";
        Integer.valueOf(input);
        System.out.println("input:" + input);
        List<String> result = letterCombinations(input);
        for (String s : result)
            System.out.println(s);
    }

    public static List<String> letterCombinations(String digits) {


        Map<Character, List<String>> numberCharMap = new HashMap<>();

        if (digits.length() == 0)
            return new ArrayList<>();

        numberCharMap.put('2', new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        });

        numberCharMap.put('3', new ArrayList<String>(){
            {
                add("d");
                add("e");
                add("f");
            }
        });

        numberCharMap.put('4', new ArrayList<String>(){
            {
                add("g");
                add("h");
                add("i");
            }
        });

        numberCharMap.put('5', new ArrayList<String>(){
            {
                add("j");
                add("k");
                add("l");
            }
        });

        numberCharMap.put('6', new ArrayList<String>(){
            {
                add("m");
                add("n");
                add("o");
            }
        });

        numberCharMap.put('7', new ArrayList<String>(){
            {
                add("p");
                add("q");
                add("r");
                add("s");
            }
        });

        numberCharMap.put('8', new ArrayList<String>(){
            {
                add("t");
                add("u");
                add("v");
            }
        });

        numberCharMap.put('9', new ArrayList<String>(){
            {
                add("w");
                add("x");
                add("y");
                add("z");
            }
        });

        List<String> result = new ArrayList<>();


        List<String> charList = numberCharMap.get(digits.charAt(0));

        for (String s : charList) {

            appendCombination(result, "", s, digits, numberCharMap);
        }
        return result;
    }

    private static void appendCombination(List<String> result,
                                   String combination,
                                   String appendChar,
                                   String digits,
                                   Map<Character, List<String>> numberCharMap) {

        combination = combination + appendChar;
        if (combination.length() == digits.length()) {
            result.add(combination);
            return;
        }
        List<String> charList = numberCharMap.get(digits.charAt(combination.length()));
        if (charList == null) {
            return;
        }

        for (String s : charList) {
            appendCombination(result, combination, s, digits, numberCharMap);
        }

    }

}
