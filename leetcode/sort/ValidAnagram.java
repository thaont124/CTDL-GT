package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }
        Map<Character, Integer> countCharInT = new HashMap<>();
        Map<Character, Integer> countCharInS = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            countCharInT.put(t.charAt(i), countCharInT.getOrDefault(t.charAt(i), 0) + 1);
            countCharInS.put(s.charAt(i), countCharInS.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countCharInT.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if (!countCharInS.containsKey(key)) {
                return false;
            }

            if (countCharInS.get(key) < value) {
                return false;
            }
        }

        return true;

    }

    public boolean isAnagramAnswer1(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();

        Arrays.sort(s_array);
        Arrays.sort(t_array);

        return Arrays.equals(s_array, t_array);
    }

    public boolean isAnagramAnswer2(String s, String t) {
        int[] count = new int[26];
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;

    }

}
