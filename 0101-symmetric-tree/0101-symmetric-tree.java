class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return symmetry(root.left, root.right);
    }

    private boolean symmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // Both nodes are null, so symmetric
        }

        if (left == null || right == null) {
            return false; // One of the nodes is null, so not symmetric
        }

        if (left.val != right.val) {
            return false; // The values of the nodes do not match, so not symmetric
        }

        // Recursively check the children of the nodes
        return symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }
}