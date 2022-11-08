public class LC1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allows = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            allows[allowed.charAt(i) - 'a'] = true;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int j = 0;
            for (; j < word.length(); j++) {
                if (!allows[word.charAt(j) - 'a']) {
                    break;
                }
            }
            if (j == word.length()) {
                res++;
            }
        }
        return res;
    }
}
