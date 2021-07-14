package top.itweixiang.study.tree;

/**
 * 二叉排序树可能退化成链表
 * 二叉平衡树实现有红黑树、AVL、替罪羊树、伸展树、Treap等
 */
public class BinaryBalancedTree extends BinarySortTree {


    public void add(Node node) {
        super.add(node);
        if (root.rightHeight() - root.leftHeight() > 1) {
            leftRotate();
        }
        if (root.leftHeight()- root.rightHeight()>1){
            rightRotate();
        }
    }



    /**
     * 当右节点高度-左节点高度>1时， 左旋转
     */
    private void leftRotate() {
        //创建一个新节点，值为根节点
        Node temp = new Node(root.data);
        //新节点的左子树为根节点的左子树
        temp.left = root.left;
        //新节点的右子树为根节点的右子树的左子树
        temp.right = root.right.left;
        //根节点的值为根节点右子树的值
        root.data = root.right.data;
        //根节点的右子树为根节点右子树的右子树
        root.right = root.right.right;
        //根节点的左子树设置为新节点
        root.left = temp;
    }
    private void rightRotate() {
        Node temp = new Node(root.data);
        temp.right = root.right;
        temp.left = root.left.right;
        root.left = root.left.left;
        root.data = root.left.data;
        root.right = temp;
    }
}
