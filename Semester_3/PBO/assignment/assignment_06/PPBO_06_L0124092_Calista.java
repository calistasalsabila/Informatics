package PBO.assignment.assignment_06;

// Nama : Calista
// NIM  : L0124092

import java.util.*;

public class PPBO_06_L0124092_Calista {

    static class Mahasiswa {
        String nim;
        String nama;
        int nilai;

        Mahasiswa(String nim, String nama, int nilai) {
            this.nim = nim;
            this.nama = nama;
            this.nilai = nilai;
        }

        public String toString() {
            return nim + " - " + nama + " - " + nilai;
        }
    }

    public static void main(String[] args) {
        // array
        String[] nimArr = {"231001", "231002", "231003"};
        String[] namaArr = {"Dokja", "Shirone", "Cale"};
        int[] nilaiArr = {85, 90, 78};

        for (int i = 0; i < nimArr.length; i++) {
            System.out.println(nimArr[i] + " - " + namaArr[i] + " - " + nilaiArr[i]);
        }

        // array list
        ArrayList<Mahasiswa> listMhs = new ArrayList<>();
        listMhs.add(new Mahasiswa("231004", "Jeha", 88));
        listMhs.add(new Mahasiswa("231005", "Eruki", 92));
        listMhs.add(new Mahasiswa("231006", "Neid", 75));

        System.out.println("\nData awal:");
        for (Mahasiswa m : listMhs) System.out.println(m);

        // hapus data berdasarkan nim
        String nimHapus = "231005";
        listMhs.removeIf(m -> m.nim.equals(nimHapus));

        System.out.println("\nSetelah menghapus NIM " + nimHapus + ":");
        for (Mahasiswa m : listMhs) System.out.println(m);

        // hashset
        HashSet<String> namaUnik = new HashSet<>();
        for (Mahasiswa m : listMhs) namaUnik.add(m.nama);

        System.out.println("\nNama unik:");
        for (String nama : namaUnik) System.out.println(nama);

        // hashmap
        HashMap<String, Integer> mapNilai = new HashMap<>();
        mapNilai.put("231004", 88);
        mapNilai.put("231006", 75);
        mapNilai.put("231007", 95);

        System.out.println("\nNIM dan Nilai:");
        for (String nim : mapNilai.keySet()) {
            System.out.println(nim + " : " + mapNilai.get(nim));
        }

        // rata rata
        double total = 0;
        for (int nilai : mapNilai.values()) total += nilai;
        double rata = total / mapNilai.size();
        System.out.println("Rata-rata nilai = " + rata);

        // sorting, ascending
        System.out.println("\nUrutkan berdasarkan nilai:");
        Collections.sort(listMhs, Comparator.comparingInt(m -> m.nilai));
        for (Mahasiswa m : listMhs) System.out.println(m);

        System.out.println("\nUrutkan berdasarkan nama:");
        Collections.sort(listMhs, Comparator.comparing(m -> m.nama));
        for (Mahasiswa m : listMhs) System.out.println(m);
    }
}
