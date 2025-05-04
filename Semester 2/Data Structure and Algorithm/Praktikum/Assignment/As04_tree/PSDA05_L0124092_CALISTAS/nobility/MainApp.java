package nobility;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Membuat tree dengan bangsawan utama "Arvis" yang berjudul "Emperor"
        NobleTree tree = new NobleTree("Arvis", "Emperor");

        // Tambah bangsawan
        tree.addNoble("Arvis", "Bjorn", "King");
        tree.addNoble("Arvis", "Matthias", "King");
        tree.addNoble("Bjorn", "Felix", "Prince");
        tree.addNoble("Felix", "Layla", "Duchess");

        // Cetak hierarki dengan preorder dan postorder
        tree.printPreorder();
        System.out.println();
        tree.printPostorder();

        // Coba hapus bangsawan
        System.out.println("\n--- Menghapus Layla ---");
        tree.removeNoble("Layla");
        tree.printPreorder();

        // Coba cari bangsawan tertentu
        System.out.println("\n--- Mencari Felix ---");
        NobleHierarchy found = tree.getRoot().findNoble("Felix");
        if (found != null) {
            System.out.println("Ditemukan: " + found.getTitle() + " " + found.getName());
        } else {
            System.out.println("Felix tidak ditemukan.");
        }
        // Menampilkan level
        System.out.println("\n--- Menampilkan seluruh bangsawan berdasarkan level ---");
        tree.getRoot().printLevelOrder();

        // Menampilkan total
        System.out.println("\n--- Jumlah total bangsawan dalam pohon ---");
        System.out.println("Total: " + tree.getRoot().countAll());

        // Search by title
        System.out.println("\n--- Mencari semua bangsawan dengan gelar 'King' ---");
        List<NobleHierarchy> kings = tree.getRoot().findByTitle("King");
        for (NobleHierarchy k : kings) {
            System.out.println(k.getTitle() + " " + k.getName());
        }

    }
}
