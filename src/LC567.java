import java.util.Arrays;

public class LC567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < m; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            count2[s2.charAt(i - m) - 'a']--;
            count2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean res = new LC567().checkInclusion(s1, s2);
        System.out.println(res);
    }
}
