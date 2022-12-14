public class LC1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int a = -1;
        int b = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                } else {
                    return false;
                }
            } 
        }
        if ((a == -1) ^ (b == -1)) {
            return false;
        }
        return (a == -1 && b == -1) || (s1.charAt(a) == s2.charAt(b) && s2.charAt(a) == s1.charAt(b));
    }
}