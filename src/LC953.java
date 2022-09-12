public class LC953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ch2order = new int[26];
        for (int i = 0; i < order.length(); i++) {
            ch2order[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], ch2order)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String str1, String str2, int[] ch2order) {
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if (ch2order[ch1 - 'a'] < ch2order[ch2 - 'a']) {
                return true;
            } else if (ch2order[ch1 - 'a'] > ch2order[ch2 - 'a']) {
                return false;
            }
            i++;
            j++;
        }
        if (i < str1.length()) {
            return false;
        }
        return true;
    }
}
