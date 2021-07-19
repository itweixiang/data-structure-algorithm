package top.itweixiang;

import java.util.ArrayList;

/**
 * 《输出二叉树的右视图》
 * <p>
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 */
public class NC136 {
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
        int startPre = 0;
        int startInfix = 0;

        while (startPre < xianxu.length && startInfix < zhongxu.length) {
            if (xianxu[startPre] == zhongxu[startInfix]) {
                list.add(xianxu[startPre]);

            }
        }

        return null;
    }

    public int[] getPost(int[] pre, int[] infix) {
        TreeNode root = new TreeNode();
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < infix.length; j++) {
                if (infix[j] == pre[i]) {
                    if (root.val == 0) {
                        root.val = infix[j];
                    }

                }
            }
        }
        return null;
    }
}
