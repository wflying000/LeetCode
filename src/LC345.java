import java.util.HashSet;
import java.util.Set;

public class LC345 {
    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] chs = s.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i < j) {
            while (i < j && !set.contains(chs[i])) {
                i++;
            }
            while (i < j && !set.contains(chs[j])) {
                j--;
            }
            if (i < j) {
                char ch = chs[i];
                chs[i] = chs[j];
                chs[j] = ch;
                i++;
                j--;
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String res = reverseVowels(s);
        System.out.println(res);
    }

}