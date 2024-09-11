package sort.answer;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsAnswer {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {
            List<List<String>> result;

            public List<String> get(int index) {
                if (result == null) {
                    solve();
                }
                return result.get(index);
            }

            public int size() {
                if (result == null) {
                    solve();
                }
                return result.size();
            }

            // logic function to group the anagrams together
            private void solve() {
                int n = strs.length;
                Map<String, List<String>> hmap = new HashMap<>();
                // Instead of making the sortedWord as a key we can make as keys count
                // TC = O(n*wordLen) instead of O(n*wordLen*log(wordLen))

                for (int i = 0; i < n; i++) {
                    char[] keys = new char[26];
                    int len = strs[i].length();
                    for (int j = 0; j < len; j++) {
                        keys[strs[i].charAt(j) - 'a']++;
                    }

                    String key = new String(keys);
                    if (!hmap.containsKey(key)) {
                        hmap.put(key, new ArrayList<>());
                    }
                    hmap.get(key).add(strs[i]);
                }
                result = new ArrayList<>(hmap.values());
            }
        };

    }
}
