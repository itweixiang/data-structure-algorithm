package top.itweixiang.study.tree;


/**
 * 只考虑完全二叉树
 * 线性结构还原二叉树，左节点=2*n+1，有节点=2*n+2，父节点为(n-1)/2，n为元素顺序
 */
public class ArrayBinaryTree {
    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    /**
     * 前序遍历
     *
     * @param index
     */
    public void pre(int index) {
        System.out.print(array[index] + " ");
        if ((index * 2 + 1) < array.length) {
            pre(index * 2 + 1);
        }
        if ((index * 2 + 2) < array.length) {
            pre(index * 2 + 2);
        }
    }

    public void infix(int index) {
        if ((index * 2 + 1) < array.length) {
            pre(index * 2 + 1);
        }
        System.out.print(array[index] + " ");
        if ((index * 2 + 2) < array.length) {
            pre(index * 2 + 2);
        }
    }

    public void post(int index) {
        if ((index * 2 + 1) < array.length) {
            pre(index * 2 + 1);
        }
        if ((index * 2 + 2) < array.length) {
            pre(index * 2 + 2);
        }
        System.out.print(array[index] + " ");
    }
}
