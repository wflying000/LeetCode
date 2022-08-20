import java.util.ArrayDeque;
import java.util.Deque;

public class LC654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                node.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return stack.peekLast();
    }
    
    public TreeNode constructMaximumBinaryTreeRecursive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int idx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(nums, left, idx - 1);
        root.right = construct(nums, idx + 1, right);
        return root;
    }

    public static void main(String[] args) {
        LC654 sln = new LC654();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = sln.constructMaximumBinaryTreeRecursive(nums);
        TreeNode root2 = sln.constructMaximumBinaryTree(nums);
        TreeNode.print(root);
        TreeNode.print(root2);
    }
}
