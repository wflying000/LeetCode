public class Offer33 {
    public static boolean verifyPostorder(int[] postorder) {
        return judge(postorder, 0, postorder.length - 1);
    }

    private static boolean judge(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = postorder[right];
        int i = left;
        while (i < right && postorder[i] < root) {
            i++;
        }
        int j = i;
        while (j < right && postorder[j] > root) {
            j++;
        }
        // 先判断postoder[left .. right]是否满足左右中的结构，(左 < 中，右 > 中)
        // 如果满足左右中的结构，则可以确定左子树和右子树的边界，然后递归判断左子树和右子树是否为后序遍历
        return (j == right) && judge(postorder, left, i - 1) && judge(postorder, i, j - 1);
    }

    public static void main(String[] args) {
        int[] postorder = {4, 8, 6, 12, 16, 14, 10};
        boolean res = verifyPostorder(postorder);
        System.out.println(res);
    }
}
