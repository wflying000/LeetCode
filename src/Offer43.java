public class Offer43 {
    public static int countDigitOne(int n) {
        int res = 0;
        long m = 1;
        while (m <= n) {
            long nextm = m * 10;
            long rest = n % nextm;
            res += n / nextm * m + Math.min(Math.max(rest - m + 1, 0), m);
            m = nextm;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 857;
        int res = countDigitOne(n);
        System.out.println(res);
    }
}
