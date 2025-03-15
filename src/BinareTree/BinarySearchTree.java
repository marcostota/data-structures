package BinareTree;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insertNode(int key) {
        root = insertHelper(root, key);
    }

    Node insertHelper(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertHelper(root.left, key);
        else if (key > root.key)
            root.right = insertHelper(root.right, key);
        return root;
    }

    void preOrder() {
        preOrderHelper(root);
    }

    void preOrderHelper(Node root) {
        if (root != null) {
            System.out.print(root.key);
            preOrderHelper(root.left);
            preOrderHelper(root.right);
        }
    }

    void inOrder() {
        inOrderHelper(root);
    }

    void inOrderHelper(Node root) {
        if (root != null) {
            inOrderHelper(root.left);
            System.out.println(root.key);
            inOrderHelper(root.right);
        }
    }

    void postOrder() {
        postOrderHelper(root);
    }

    void postOrderHelper(Node root) {
        if (root != null) {
            postOrderHelper(root.left);
            System.out.println(root.key);
            postOrderHelper(root.right);
        }
    }

    void deleteKey(int key) {
        root = deleteNode(root, key);
    }

    Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            //node  wit no leaf nodes
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
//                nodes with two nodes;
//                search for min number in right sub tree
                int minValue = minValue(root.right);
                root.key = minValue;
                root.right = deleteNode(root.right, minValue);
            }
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(8);
        tree.insertNode(4);
        tree.insertNode(1);
        tree.insertNode(7);
        tree.insertNode(12);
        tree.insertNode(9);
        tree.insertNode(14);

        System.out.println("Data you are looking for :: " + tree.search(tree.root, 1).key);

        tree.inOrder();
        System.out.println("------------------------------");

        tree.deleteKey(12);
        tree.inOrder();
    }


}