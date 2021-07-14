package top.itweixiang.study.tree;

/**
 * 二叉排序树也叫二叉查找树
 * 左节点比父节点小，右节点比父节点大
 * <p>
 * 中序遍历二叉排序树时，数据从小排到大
 */
public class BinarySortTree extends BinaryTree {

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            add1(root, node);
        }
    }

    /**
     * 删除的情况比较复杂，有：
     * 1、删除叶子节点，直接删
     * 2、删除只有一颗子树的节点，父节点原先指向删除节点的指针，重新指向到删除节点的子节点
     * 3、删除有两颗子树的节点，找到目标节点右子树的最小节点，将其删掉，并替换目标节点
     *
     * @param delete
     */
    @Override
    public void delete(Node delete) {
        if (root == delete) {
            if (root.isLeaf()) {
                root = null;
            } else {
                Node delMin = delMin(root, root.left);
                delMin.left = root.left;
                delMin.right = root.right;
                root = delMin;
            }
        }
        else{
            del(root, delete);
        }
    }

    private void del(Node father, Node del) {
        if (father.left == del) {
            if (del.isLeaf()) {
                father.left = null;
                return;
            }
            //如果有删除的目标节点，有两颗子树
            if (del.left != null && del.right != null) {
                Node delMin = delMin(del, del.left);
                delMin.left = del.left;
                delMin.right = del.right;
                father.left = delMin;
            } else if (del.left == null) {
                father.left = del.right;
            } else {
                father.left = del.left;
            }
        } else if (father.right == del) {
            if (del.isLeaf()) {
                father.right = null;
                return;
            }
            if (del.left != null && del.right != null) {
                Node delMin = delMin(del, del.left);
                delMin.left = del.left;
                delMin.right = del.right;
                father.right = delMin;
            } else if (del.left == null) {
                father.right = del.right;
            } else {
                father.right = del.left;
            }
        } else if (father.data >= del.data) {
            del(father.left, del);
        } else if (father.data < del.data) {
            del(father.right, del);
        }
    }

    private Node delMin(Node father, Node node) {
        if (node.right == null) {
            //如果删除的节点，不是叶子节点
            father.right = null;
            return node;
        } else {
            return delMin(node, node.right);
        }
    }


    private void add1(Node father, Node son) {
        if (father.data <= son.data) {
            if (father.right == null) {
                father.right = son;
            } else {
                add1(father.right, son);
            }
        } else {
            //if (father.data > son.data)
            if (father.left == null) {
                father.left = son;
            } else {
                add1(father.left, son);
            }
        }
    }
}
