package top.itweixiang.study.tree;

public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    /**
     * 当前节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        return left == null ? 0 : left.height();
    }

    public int rightHeight() {
        return right == null ? 0 : right.height();
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public Boolean isLeaf() {
        return left == null && right == null;
    }
}
