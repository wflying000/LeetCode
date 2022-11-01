public class LC1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int sp1 = 0;
        int sp2 = 0;
        int cp1 = 0;
        int cp2 = 0;
        while (sp1 < word1.length && sp2 < word2.length) {
            while (cp1 < word1[sp1].length() && cp2 < word2[sp2].length()) {
                if (word1[sp1].charAt(cp1) != word2[sp2].charAt(cp2)) {
                    return false;
                }
                cp1++;
                cp2++;
            }
            if (cp1 >= word1[sp1].length()) {
                sp1++;
                cp1 = 0;
            }
            if (cp2 >= word2[sp2].length()) {
                sp2++;
                cp2 = 0;
            }
        }
        return sp1 == word1.length && sp2 == word2.length;
    }
}