import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        int m = s.length();
        int n = p.length();
        int[] countp = new int[26];
        int[] counts = new int[26];

        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
            countp[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(counts, countp)) {
            res.add(0);
        }
        for (int i = n; i < m; i++) {
            counts[s.charAt(i - n) - 'a']--;
            counts[s.charAt(i) - 'a']++;
            if (Arrays.equals(counts, countp)) {
                res.add(i - n + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = new LC438().findAnagrams(s, p);
        System.out.println(res);
    }
}
