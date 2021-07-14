package top.itweixiang.study.tree;

/**
 * 利用二叉排序树进行排序
 */
public class HeapSort {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        int[] array = {1, 2, 4, 1, 67, 99, 0, -1};
        for (int i = 0; i < array.length; i++) {
            tree.add(new Node(array[i]));
        }
        tree.infix(tree.root);
    }
}
