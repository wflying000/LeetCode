import java.util.LinkedList;
import java.util.Queue;


public class LC662 {
    private static class Pair {
        TreeNode key;
        Integer value;

        public Pair(TreeNode key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public TreeNode getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }
    }
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Pair p = queue.poll();
            TreeNode node = p.getKey();
            int left = p.getValue();
            int right = left;
            if (node.left != null) {
                queue.offer(new Pair(node.left, 2 * left));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, 2 * left + 1));
            }
            for (int i = 1; i < size; i++) {
                p = queue.poll();
                node = p.getKey();
                right = p.getValue();
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * right));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * right + 1));
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"1", "3", "2", "5", "null", "null", "9", "6", "null", "7"};
        TreeNode root = TreeNode.buildTree(strs);
        int res = widthOfBinaryTree(root);
        System.out.println(res);
    }
    
}
