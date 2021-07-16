package top.itweixiang;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 《二叉树的之字形层序遍历》
 * <p>
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 */
public class NC14 {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        pre(list, root, 0);
        for (int i = 1; i < list.size(); i += 2) {
            ArrayList<Integer> arrayList = list.get(i);
            Collections.reverse(arrayList);
        }
        return list;
    }

    private void pre(ArrayList<ArrayList<Integer>> list, TreeNode root, int deep) {
        if (root == null) return;
        if (list.size() <= deep) {
            list.add(new ArrayList<>());
        }
        ArrayList<Integer> arrayList = list.get(deep);
        arrayList.add(root.val);
        pre(list, root.left, deep + 1);
        pre(list, root.right, deep + 1);
    }
}
