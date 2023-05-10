public class LC50 {
    // public static double myPow(double x, int n) {
    //     long N = (long)Math.abs((long)n);
    //     return n >= 0 ? pow_iter(x, N) : 1.0 / pow_iter(x, N);
    // }

    // private static double pow_iter(double x, long n) {
    //     double res = 1.0;
    //     while (n > 0) {
    //         if ((n & 1) == 1) {
    //             res *= x;
    //         }
    //         x *= x;
    //         n = n >> 1;
    //     }
    //     return res;
    // }

    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }


    public static void main(String[] args) {
        double x = 1.0;
        int n = -2147483648;
        double res = myPow(x, n);
        System.out.println(res);
    }
}
