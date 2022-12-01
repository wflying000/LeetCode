import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC131 {
    public static String[][] partition(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isPalindrome[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
            }
        }
        List<String> list = new ArrayList<>();
        List<List<String>> list2 = new ArrayList<>();
        backtrack(s, 0, list, list2, isPalindrome);
        String[][] res = new String[list2.size()][];
        for (int i = 0; i < list2.size(); i++) {
            list = list2.get(i);
            res[i] = new String[list.size()];
            for (int j = 0; j < list.size(); j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;
    }

    private static void backtrack(String s, int i, List<String> list, List<List<String>> list2,
                     boolean[][] isPalindrome) {
        if (i == s.length()) {
            list2.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome[i][j]) {
                list.add(s.substring(i, j + 1));
                backtrack(s, j + 1, list, list2, isPalindrome);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[][] res = partition("google");
        System.out.println(Arrays.deepToString(res));
    }
}
