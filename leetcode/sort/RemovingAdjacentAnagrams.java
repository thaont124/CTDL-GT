package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemovingAdjacentAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String comp = "";
        for (int i = 0; i < words.length; i++) {
            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);

            String afterStr = String.copyValueOf(temp);
            // System.out.println(afterStr);
            if (!comp.equals(afterStr)) {
                result.add(words[i]);
                comp = afterStr;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RemovingAdjacentAnagrams g = new RemovingAdjacentAnagrams();
        String[] strs = { "a", "b", "c", "d", "e" };
        System.out.println(g.removeAnagrams(strs));
    }
}
