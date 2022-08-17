import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，
// 并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。

public class LC318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int n = words.length;
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                bits[i] = bits[i] | (1 << (word.charAt(j) - 'a'));
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public int maxProduct2(String[] words) {
        int n = words.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int bits = 0;
            for (int j = 0; j < word.length(); j++) {
                bits = bits | (1 << (word.charAt(j) - 'a'));
            }
            if (word.length() > map.getOrDefault(bits, 0)) {
                map.put(bits, word.length());
            }
        }
        int res = 0;
        Set<Integer> keySet = map.keySet();
        for (int k1 : keySet) {
            for (int k2 : keySet) {
                if ((k1 & k2) == 0) {
                    res = Math.max(res, map.get(k1) * map.get(k2));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC318 solution = new LC318();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int res = solution.maxProduct(words);
        int res2 = solution.maxProduct2(words);
        System.out.println(res);
        System.out.println(res2);
    }
}
