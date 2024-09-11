
import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;

        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) == last.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return first.substring(0, index);
    }

    public static void main(String[] args) {
        LongestCommonPrefix rn = new LongestCommonPrefix();
        String[] strs = new String[] { "flower", "flow", "flight" };
        System.out.println(rn.longestCommonPrefix(strs));
    }
}
