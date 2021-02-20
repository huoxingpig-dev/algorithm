package leetcode;

import leetcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by langji on 16/01/2020.
 */
public class N236_LongestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        TreeNode base = root;

        LinkedList<TreeNode> list = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode tmp = list.pop();
            if (root.val == p.val) {
                if (lowestCommonAncestor(root, null, q) == null) {
                    //if (root.val == list.peek().val) return findParent(base, p);
                    //else return null;
                }
                return p;
            }
            if (root.val == q.val) {
                if (lowestCommonAncestor(root, null, p) == null) {
                    //if (root.val == list.peek().val) return findParent(base, q);
                    //else return null;
                }
                return q;
            }
            if (tmp.left != null) {
                list.add(tmp.left);
            }
            if (tmp.right != null) {
                list.add(tmp.right);
            }

        }

        return null;
    }

    private TreeNode way1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null || root.val == p.val || root.val == q.val) return null;

        TreeNode left = way1(root.left, p, q);
        TreeNode right = way1(root.right, p ,q);

        return left == null ? right : right == null ? left : root;
    }

}
