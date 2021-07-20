package top.itweixiang;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 《输出二叉树的右视图》
 * <p>
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 * <p>
 * TODO 使用二叉树的层序遍历的方法，先还原二叉树，然后层序遍历，添加其右节点
 * TODO 二叉树的右视图，不是指二叉树的所有右节点，而是每一层最右边的元素
 */
public class NC136 {
    public static void main(String[] args) {
        NC136 nc136 = new NC136();
        int[] pre = {1, 2, 4, 5, 6, 3};
        int[] infix = {5, 4, 6, 2, 1, 3};
        nc136.solve(pre, infix);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * <p>
     * 二叉树每个节点的值在区间[1,10000]内，且保证每个节点的值互不相同
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode root = rebuild(xianxu, zhongxu);
        right(0, list, root);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void right(int deep, ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;

        if (list.size() == deep) {
            list.add(root.val);
        } else {
            list.set(deep, root.val);
        }

        right(deep + 1, list, root.left);
        right(deep + 1, list, root.right);
    }


    public TreeNode rebuild(int[] pre, int[] infix) {
        if (pre.length == 0 || infix.length == 0) return null;
        int val = pre[0];
        TreeNode root = new TreeNode(val);
        if (pre.length == 1) return root;
        for (int i = 0; i < infix.length; i++) {
            if (infix[i] == val) {
                root.left = rebuild(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(infix, 0, i));
                root.right = rebuild(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(infix, i + 1, infix.length));
                break;
            }
        }
        return root;
    }
}
