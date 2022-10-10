public class LC801 {
    public static int minSwap(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 1;
        int n = nums1.length;
        for (int i = 1; i < n; i++) {
            int pa = a;
            int pb = b;
            a = n;
            b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = Math.min(a, pa);
                b = Math.min(b, pb + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, pb);
                b = Math.min(b, pa + 1);
            }
            
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 4};
        int[] nums2 = {1, 2, 3, 7};
        int res =  minSwap(nums1, nums2);
        System.out.println(res);
    }
}
