class Node {
    int value;
    Node right;
    Node left;

    Node(int value) {
        this.value = value;
    }
}

public class BinarySearchTree {
    Node root;

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        // if (root == null) {
        //   return false;
        // }
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        System.out.println("Root = " + myBST.root);

        myBST.insert(10); // jadi root
        myBST.insert(5); // masuk ke kiri 10
        myBST.insert(15); // masuk ke kanan 10
        myBST.insert(3); // masuk ke kiri 5
        myBST.insert(7); // masuk ke kanan 5

        System.out.println("Root = " + myBST.root.value); // 10
        System.out.println("Root Left = " + myBST.root.left.value); // 5
        System.out.println("Root Right = " + myBST.root.right.value); // 15
        System.out.println("Root Left Left = " + myBST.root.left.left.value); // 3
        System.out.println("Root Left Right = " + myBST.root.left.right.value); 

    }

}