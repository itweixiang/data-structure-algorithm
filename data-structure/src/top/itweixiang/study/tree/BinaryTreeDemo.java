package top.itweixiang.study.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        /*
                           node1
                node2               node3
                                         node4
           pre = 1 2 3 4
           infix = 2 1 3 4
           post = 2 4 3 1
         */
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        tree.pre(node1);
        System.out.println();
        tree.infix(node1);
        System.out.println();
        tree.post(node1);
        System.out.println();

        tree.root = node1;
        tree.delete(node4);
        tree.pre(tree.root);
    }
}
