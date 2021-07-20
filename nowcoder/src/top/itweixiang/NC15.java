package top.itweixiang;

import java.util.ArrayList;

/**
 * 《二叉树层序遍历》
 *
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 */
public class NC15 {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> col = new ArrayList<>(32);
        pre(root, col, 0);
        return col;
    }

    public void pre(TreeNode root, ArrayList<ArrayList<Integer>> col, int deep) {
        if (root != null) {
            if (col.size() <= deep) {
                col.add(new ArrayList<>());
            }
            ArrayList<Integer> row = col.get(deep);
            row.add(root.val);
            pre(root.left, col, deep + 1);
            pre(root.right, col, deep + 1);
        }
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
