import java.io.*;
import java.util.*;

public class Trees {
    TreeNode invertTree(TreeNode root) {
        //https://neetcode.io/problems/invert-a-binary-tree?list=blind75
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public int maxDepth(TreeNode root) {
        //https://neetcode.io/problems/depth-of-binary-tree?list=blind75
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //https://neetcode.io/problems/same-binary-tree?list=blind75
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else {
            return false;
        }
    }

    boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //https://neetcode.io/problems/subtree-of-a-binary-tree?list=blind75
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left,  subRoot) || isSubtree(root.right, subRoot);
    }

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //https://neetcode.io/problems/lowest-common-ancestor-in-binary-search-tree?list=blind75
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    //{
    //https://neetcode.io/problems/level-order-traversal-of-binary-tree?list=blind75
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        dfs(root, 0, levels);
        return levels;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null) return;

        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        dfs(node.left,  level + 1, levels);
        dfs(node.right, level + 1, levels);
    }
    //}

    //{
    //https://neetcode.io/problems/valid-binary-search-tree?list=blind75
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if (low != null && node.val <= low) return false;
        if (high != null && node.val >= high) return false;
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
    //}

    //{
    //https://neetcode.io/problems/kth-smallest-integer-in-bst?list=blind75
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        collect(root, values);
        Collections.sort(values);
        return values.get(k - 1);  // zero-based index
    }

    public List<Integer> collect(TreeNode root, List<Integer> col) {
        if (root == null) return col;
        col.add(root.val);
        collect(root.left, col);
        collect(root.right, col);
        return col;
    }
    //}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}