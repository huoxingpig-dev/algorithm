package leetcode;

import leetcode.helper.TreeNode;

/**
 * Created by langji on 12/01/2020.
 */
public class N98_ValidateBinarySearchTree {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        //pre = null;
        //return inOrder(root);
        return isValidSubTree(root, null, null);
    }

    private boolean isValidSubTree(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValidSubTree(root.left, min, root.val) && isValidSubTree(root.right, root.val, max);

    }

    private boolean inOrder(TreeNode root) {
        if (root == null) return true;

        if (!inOrder(root.left)) return false;

        if (pre != null && pre.val >= root.val) return false;

        pre = root;

        return inOrder(root.right);

    }
}
