public class BinaryTree {
    private Node root;

    private static class Node {
        String isbn;
        Node left, right;

        Node(String isbn) {
            this.isbn = isbn;
        }
    }

    // Menambahkan ISBN ke tree
    public void insert(String isbn) {
        root = insertRec(root, isbn);
        System.out.println("ISBN " + isbn + " berhasil dimasukkan ke dalam binary Tree.");
    }

    private Node insertRec(Node current, String isbn) {
        if (current == null) {
            return new Node(isbn);
        }

        int cmp = isbn.compareTo(current.isbn);
        if (cmp < 0) {
            current.left = insertRec(current.left, isbn);
        } else if (cmp > 0) {
            current.right = insertRec(current.right, isbn);
        } // else do nothing kalau duplikat
        return current;
    }

    // Mencari ISBN di tree
    public boolean search(String isbn) {
        boolean found = searchRec(root, isbn);
        System.out.println(found ? "ISBN ditemukan di binary tree." : "ISBN tidak ditemukan di binary tree.");
        return found;
    }

    private boolean searchRec(Node current, String isbn) {
        if (current == null)
            return false;
        int cmp = isbn.compareTo(current.isbn);
        if (cmp == 0)
            return true;
        return cmp < 0 ? searchRec(current.left, isbn) : searchRec(current.right, isbn);
    }

    // remove
    // Menghapus ISBN dari BinaryTree
    public void delete(String isbn) {
        root = deleteRec(root, isbn);
        System.out.println("ISBN " + isbn + " telah dihapus dari binary tree.");
    }

    private Node deleteRec(Node node, String isbn) {
        if (node == null)
            return null;

        int cmp = isbn.compareTo(node.isbn);
        if (cmp < 0) {
            node.left = deleteRec(node.left, isbn);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, isbn);
        } else {
            // Node ditemukan
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            Node min = findMin(node.right);
            node.isbn = min.isbn;
            node.right = deleteRec(node.right, min.isbn);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void printInOrder() {
        System.out.println("Daftar ISBN dalam binary tree (in-order):");
        printInOrderRec(root);
    }

    private void printInOrderRec(Node node) {
        if (node != null) {
            printInOrderRec(node.left);
            System.out.println(" - " + node.isbn);
            printInOrderRec(node.right);
        }
    }
}
