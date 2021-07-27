package top.itweixiang;

import java.util.ArrayList;

/**
 * 《二叉树根节点到叶子节点和为指定值的路径》
 * 给定一个二叉树和一个值  sum，请找出所有的根节点到叶子节点的节点值之和等于  sum 的路径
 */
public class NC8 {
    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root==null) return list;
        backtracking(list, root, sum, new ArrayList<>());
        return list;
    }

    private void backtracking(ArrayList<ArrayList<Integer>> list, TreeNode root,
                              int sum, ArrayList<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.val == sum && root.left== null&& root.right== null) {
            list.add(tmp);
        } else {
            backtracking(list, root.left, sum - root.val, new ArrayList<>(tmp));
            backtracking(list, root.right, sum - root.val, new ArrayList<>(tmp));
        }
    }
}

