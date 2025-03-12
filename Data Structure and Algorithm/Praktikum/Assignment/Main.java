package Assignment;

public class Asp_01 {
    import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Daftar buah-buahan awal
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList(
                "Rambutan", "Jambu", "Jeruk", "Melon", "Semangka", "Durian"));

        // Menampilkan seluruh list
        System.out.println("Seluruh List:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Membagi list menjadi dua bagian
        ArrayList<String> list1 = new ArrayList<>(fruits.subList(0, 3));
        ArrayList<String> list2 = new ArrayList<>(fruits.subList(3, 6));

        // Menghapus "Jambu" dari list1 dan "Durian" dari list2
        list1.remove("Jambu");
        list2.remove("Durian");

        // Menampilkan hasil akhir dari kedua list
        System.out.println("\nList 1:");
        for (String fruit : list1) {
            System.out.println(fruit);
        }

        System.out.println("\nList 2:");
        for (String fruit : list2) {
            System.out.println(fruit);
        }
    }
}

}
