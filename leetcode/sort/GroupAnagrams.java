package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);

            String afterStr = String.copyValueOf(temp);
            if (map.containsKey(afterStr)) {
                map.get(afterStr).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(afterStr, indexList);
            }
        }

        map.forEach((key, value) -> {
            List<String> group = new ArrayList<>();
            for (Integer i : value) {
                group.add(strs[i]);
            }
            result.add(group);
        });
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(g.groupAnagrams(strs));
    }

}
