package nobility;

public class NobleTree {
    private NobleHierarchy root; // bangsawan utama (akar tree)

    // constructor: buat tree baru dengan bangsawan utama
    public NobleTree(String rootName, String rootTitle) {
        this.root = new NobleHierarchy(rootName, rootTitle);
    }

    // getter untuk akses root (jika dibutuhkan dari luar)
    public NobleHierarchy getRoot() {
        return root;
    }

    // tambah bangsawan ke bawah atasan tertentu
    public void addNoble(String superiorName, String newName, String newTitle) {
        // cari bangsawan yang jadi atasan
        NobleHierarchy superior = root.findNoble(superiorName);
        if (superior != null) {
            // kalau ketemu, tambahkan sebagai bawahannya
            superior.addSubordinate(new NobleHierarchy(newName, newTitle));
        } else {
            // kalau atasan gak ketemu
            System.out.println("Atasan dengan nama '" + superiorName + "' tidak ditemukan.");
        }
    }

    // hapus bangsawan dari tree berdasarkan nama
    public void removeNoble(String name) {
        // tidak boleh hapus bangsawan utama
        if (root.getName().equalsIgnoreCase(name)) {
            System.out.println("Tidak bisa menghapus bangsawan utama!");
            return;
        }

        // panggil fungsi remove secara rekursif dari root
        boolean removed = root.removeSubordinateByName(name);
        if (removed) {
            System.out.println("Bangsawan '" + name + "' berhasil dihapus.");
        } else {
            System.out.println("Bangsawan '" + name + "' tidak ditemukan.");
        }
    }

    // tampilkan seluruh hierarki secara preorder
    public void printPreorder() {
        System.out.println("=== Hierarki (Preorder) ===");
        root.printPreorder("");
    }

    // tampilkan seluruh hierarki secara postorder
    public void printPostorder() {
        System.out.println("=== Hierarki (Postorder) ===");
        root.printPostorder("");
    }
}
