import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int i = 0;

        while (i < s.length()) {
            char index = s.charAt(i);
            if (i + 1 < s.length()) {
                char nextIndex = s.charAt(i + 1);

                if (index == 'I' && (nextIndex == 'V' || nextIndex == 'X')) {
                    result += (romanMap.get(nextIndex) - romanMap.get(index));
                    i += 2;
                } else if (index == 'X' && (nextIndex == 'L' || nextIndex == 'C')) {
                    result += (romanMap.get(nextIndex) - romanMap.get(index));
                    i += 2;
                } else if (index == 'C' && (nextIndex == 'D' || nextIndex == 'M')) {
                    result += (romanMap.get(nextIndex) - romanMap.get(index));
                    i += 2;
                } else {
                    result += romanMap.get(index);
                    i++;
                }
            } else {
                result += romanMap.get(index);
                i++;
            }
        }

        return result;
    }

    // vidu
    // public int romanToInt(String s) {
    // int n = 0;
    // int r = 0;
    // char l = 'a';
    // for (char c : s.toCharArray()){
    // if(c == 'I'){
    // n += 1;
    // l = 'I';
    // } else if (c == 'L'){
    // if(l == 'X'){
    // n += 30;
    // } else {
    // n += 50;
    // }
    // l = 'L';
    // } else if (c == 'V'){
    // if(l == 'I'){
    // n+=3;
    // } else {
    // n += 5;
    // };
    // l = 'V';
    // } else if (c == 'M'){
    // if(l == 'C'){
    // n+=800;
    // } else {
    // n += 1000;
    // }; l = 'M';
    // } else if (c == 'C'){
    // if(l == 'X'){
    // n+=80;
    // } else {
    // n += 100;
    // }; l = 'C';
    // } else if (c == 'X'){
    // if(l == 'I'){
    // n+=8;
    // } else {
    // n += 10;
    // }; l = 'X';
    // } else if (c == 'D'){
    // if(l == 'C'){
    // n += 300;
    // } else {
    // n += 500;
    // }
    // l = 'D';
    // }
    // };
    // r += n;
    // return r;
    // }

    public static void main(String[] args) {
        RomanNumerals rn = new RomanNumerals();
        String x = "MCMXCIV";
        System.out.println(rn.romanToInt(x));
    }
}
