package top.itweixiang;

import java.util.ArrayList;
import java.util.List;

/**
 * 《在二叉树中找到两个节点的最近公共祖先》
 * <p>
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，
 * 请找到 o1 和 o2 的最近公共祖先节点。
 * 注：本题保证二叉树中每个节点的val值均不相同。
 */
public class NC102 {
    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    /*
    思路：
    1、先找到两个节点
    2、在找到节点的过程中，记录寻找的路径
    3、两条路径从根节点开始遍历，若路径出现分叉，则分叉点为最近的祖先
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        backTrace(root, l1, o1);
        backTrace(root, l2, o2);
        int length = Math.min(l1.size(), l2.size());
        TreeNode ancestor = null;
        for (int i = 1; i < length; i++) {
            if (l1.get(l1.size() - i).equals(l2.get(l2.size() - i))) {
                ancestor = l1.get(l1.size() - i);
            } else {
                break;
            }
        }
        return ancestor.val;
    }

    private boolean backTrace(TreeNode root, List<TreeNode> l1, int o1) {
        if (root != null) {
            if (root.val == o1) {
                l1.add(root);
                return true;
            }
            if (backTrace(root.left, l1, o1) || backTrace(root.right, l1, o1)) {
                l1.add(root);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
