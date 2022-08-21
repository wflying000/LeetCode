public class LC1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int res = 1;
        int i = 0;
        while (i < sentence.length()) {
            int j = 0;
            while (i < sentence.length() && sentence.charAt(i) != ' '
                    && j < searchWord.length()) {
                if (sentence.charAt(i) != searchWord.charAt(j)) {
                    break;
                }
                i++;
                j++;
            }
            if (j == searchWord.length()) {
                return res;
            }
            while (i < sentence.length() && sentence.charAt(i) != ' ') {
                i++;
            }
            if (i < sentence.length()) {
                i++;
                res++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC1455 sln = new LC1455();
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int res = sln.isPrefixOfWord(sentence, searchWord);
        System.out.println(res);
    }
}