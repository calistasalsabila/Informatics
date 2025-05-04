package nobility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NobleHierarchy {
    private String name; // nama bangsawan
    private String title; // gelar bangsawan
    private List<NobleHierarchy> subordinates; // daftar bawahan langsung

    // constructor: buat bangsawan baru
    public NobleHierarchy(String name, String title) {
        this.name = name;
        this.title = title;
        this.subordinates = new ArrayList<>();
    }

    // tambah bawahan ke bangsawan ini
    public void addSubordinate(NobleHierarchy subordinate) {
        if (subordinate != null && subordinate.name != null && !subordinate.name.isBlank()) {
            subordinates.add(subordinate);
        }
    }

    // hapus bawahan berdasarkan nama (rekursif)
    public boolean removeSubordinateByName(String name) {
        for (int i = 0; i < subordinates.size(); i++) {
            if (subordinates.get(i).name.equalsIgnoreCase(name)) {
                subordinates.remove(i);
                return true;
            }
        }
        // cari ke anak-anaknya kalau belum ketemu
        for (NobleHierarchy sub : subordinates) {
            if (sub.removeSubordinateByName(name))
                return true;
        }
        return false;
    }

    // cari bangsawan berdasarkan nama with rekursif
    public NobleHierarchy findNoble(String name) {
        if (this.name.equalsIgnoreCase(name))
            return this;

        for (NobleHierarchy sub : subordinates) {
            NobleHierarchy found = sub.findNoble(name);
            if (found != null)
                return found;
        }
        return null;
    }

    // cari semua bangsawan dengan title tertentu
    public List<NobleHierarchy> findByTitle(String title) {
        List<NobleHierarchy> result = new ArrayList<>();
        if (this.title.equalsIgnoreCase(title)) {
            result.add(this);
        }
        for (NobleHierarchy sub : subordinates) {
            result.addAll(sub.findByTitle(title));
        }
        return result;
    }

    // cetak hierarki level per level (BFS / level-order traversal)
    public void printLevelOrder() {
        Queue<NobleHierarchy> queue = new LinkedList<>();
        queue.add(this);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Level " + level + ":");
            for (int i = 0; i < size; i++) {
                NobleHierarchy current = queue.poll();
                System.out.println("  " + current.title + " " + current.name);
                queue.addAll(current.subordinates);
            }
            level++;
     }
    }

    // hitung total bangsawan (termasuk diri sendiri)
    public int countAll() {
        int count = 1; // hitung diri sendiri
        for (NobleHierarchy sub : subordinates) {
            count += sub.countAll();
        }
        return count;
    }


    // print hierarki preorder 
    public void printPreorder(String indent) {
        System.out.println(indent + title + " " + name);
        for (NobleHierarchy sub : subordinates) {
            sub.printPreorder(indent + "  ");
        }
    }

    // print hierarki postorder 
    public void printPostorder(String indent) {
        for (NobleHierarchy sub : subordinates) {
            sub.printPostorder(indent + "  ");
        }
        System.out.println(indent + title + " " + name);
    }

    // getter buat ambil nama
    public String getName() {
        return name;
    }

    // getter buat ambil gelar
    public String getTitle() {
        return title;
    }

    // getter buat ambil daftar bawahannya
    public List<NobleHierarchy> getSubordinates() {
        return subordinates;
    }
}
