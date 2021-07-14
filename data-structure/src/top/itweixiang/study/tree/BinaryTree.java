package top.itweixiang.study.tree;

/**
 * 如果二叉树的所有叶子节点，都在最后一层，并且节点综述为2^n-1，称为满二叉树
 * 如果二叉树的所有叶子节点，都在最后一层或者倒数第二层，而最后一层的叶子节点在左边连续，
 * 倒数第二层的叶子节点在右边连续，称之为完全二叉树
 */
public class BinaryTree {

    Node root;

    /**
     * 如果是叶子节点，则直接删除，如果是非叶子节点，则删除整个子树
     *
     * @param delete
     */
    public void delete(Node delete) {
        if (delete == root) {
            root = null;
        } else {
            del(root, delete);
        }
    }

    private Boolean del(Node node, Node del) {
        if (node == null) {
            return false;
        }
        if (node.left == del) {
            node.left = null;
            return true;
        } else if (node.right == del) {
            node.right = null;
            return true;
        } else {
            Boolean flag = del(node.left, del);
            if (flag) {
                return true;
            } else {
                return del(node.right, del);
            }
        }
    }


    public void pre(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            pre(node.left);
            pre(node.right);
        }
    }

    public void infix(Node node) {
        if (node != null) {
            infix(node.left);
            System.out.print(node.data + " ");
            infix(node.right);
        }
    }

    public void post(Node node) {
        if (node != null) {
            post(node.left);
            post(node.right);
            System.out.print(node.data + " ");
        }
    }

}
