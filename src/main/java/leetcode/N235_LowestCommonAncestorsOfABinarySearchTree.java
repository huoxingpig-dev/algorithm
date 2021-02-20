package leetcode;

import leetcode.helper.TreeNode;

import java.util.Stack;

/**
 * Created by langji on 15/01/2020.
 */
public class N235_LowestCommonAncestorsOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode p1 = root;
        while (p1 != null) {
            stack1.push(p1);
            if (p.val < p1.val) p1 = p1.left;
            else if (p.val > p1.val) p1 = p1.right;
            else
                break;
        }

        p1 = root;
        while (p1 != null) {
            stack2.push(p1);
            if (q.val < p1.val) p1 = p1.left;
            else if (q.val > p1.val) p1 = p1.right;
            else
                break;
        }

        while (!stack1.empty()) {
            TreeNode tmp = stack1.pop();
            if (stack2.contains(tmp)) return tmp;
        }
        return null;
    }

    private TreeNode anotherWay(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        int min = p.val < q.val ? p.val : q.val;
        int max = p.val >= q.val ? p.val : q.val;

        TreeNode x = root;
        while (x != null) {
            if (x.val < min) x = x.right;
            else if (x.val > max) x = x.left;
            else if (x.val == p.val) return ifContains(x, q) ? x : null;
            else if (x.val == q.val) return ifContains(x, p) ? x : null;
            else return x;
        }

        return null;
    }

    private TreeNode getCommon(TreeNode root, TreeNode small, TreeNode big) {
        if (root.val < small.val) {
            return getCommon(root.right, small, big);
        } else if (root.val > big.val) {
            return getCommon(root.left, small, big);
        } else if (root.val == small.val) {
            return ifContains(root, big) ? small : null;
        } else if (root.val == big.val) {
            return ifContains(root, small) ? big : null;
        }
        return null;
    }

    private boolean ifContains(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (p.val == root.val) return true;
        if (p.val < root.val) return ifContains(root.left, p);
        if (p.val > root.val) return ifContains(root.right, p);

        return false;
    }
}
