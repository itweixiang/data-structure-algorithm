package top.itweixiang;

import java.util.ArrayList;
import java.util.List;

/**
 * 《实现二叉树先序，中序和后序遍历》
 * <p>
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 */
public class NC45 {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> infix = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        pre(pre, root);
        infix(infix, root);
        post(post, root);
        int[][] ints = new int[3][];
        ints[0] = new int[pre.size()];
        ints[1] = new int[infix.size()];
        ints[2] = new int[post.size()];
        for (int i = 0; i < pre.size(); i++) {
            ints[0][i] = pre.get(i);
        }
        for (int i = 0; i < pre.size(); i++) {
            ints[1][i] = infix.get(i);
        }
        for (int i = 0; i < pre.size(); i++) {
            ints[2][i] = post.get(i);
        }
        return ints;
    }

    private void post(List<Integer> post, TreeNode root) {
        if (root != null) {
            post(post,root.left);
            post(post,root.right);
            post.add(root.val);
        }
    }

    private void infix(List<Integer> infix, TreeNode root) {
        if (root != null) {
            infix(infix,root.left);
            infix.add(root.val);
            infix(infix,root.right);
        }
    }

    private void pre(List<Integer> pre, TreeNode root) {
        if (root != null) {
            pre.add(root.val);
            pre(pre,root.left);
            pre(pre,root.right);
        }
    }
}
