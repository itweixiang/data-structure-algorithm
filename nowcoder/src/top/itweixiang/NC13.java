package top.itweixiang;

/**
 * 《二叉树的最大深度》
 * <p>
 * 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 */
public class NC13 {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        return Math.max(deep(root.left, 1), deep(root.right, 1));
    }

    private int deep(TreeNode root, int deep) {
        if (root == null) return deep;
        return Math.max(deep(root.left, deep + 1), deep(root.right, deep + 1));
    }
}
