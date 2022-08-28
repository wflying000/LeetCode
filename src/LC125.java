public class LC125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                char lch = s.charAt(left);
                char rch = s.charAt(right);
                if (lch != rch) {
                    boolean flag = false;
                    if (Character.isLetter(lch) && Character.isLetter(rch)) {
                        if (Character.toLowerCase(lch) == Character.toLowerCase(rch)) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        return false;
                    }
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC125 sln = new LC125();
        String s = "A man, a plan, a canal: Panama";
        boolean res = sln.isPalindrome(s);
        System.out.println(res);
    }
}
