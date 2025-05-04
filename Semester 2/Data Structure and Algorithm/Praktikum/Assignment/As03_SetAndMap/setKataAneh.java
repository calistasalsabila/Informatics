import java.util.*;

public class setKataAneh {
    public static void main(String[] args) {
        // Array kata yang akan diperiksa
        String[] kata = { "halo", "dunia", "haha", "halo", "abcd", "abcde", "abcc", "abcde" };
        
        //Set untuk menyimpan kata yang sudah di cek agar tidak dihitung dua kali
        Set<String> kataYangSudahDiCek = new HashSet<>();

        // Deklarasi variabel untuk set huruf dan jumlah kata aneh
        Set<Character> huruf;
        int jumlah = 0;

        // Periksa setiap kata dalam array
        for (String currentWord : kata) {
            // Jika kata sudah pernah dicek sebelumnya, skip (lanjut ke kata berikutnya)
            if (kataYangSudahDiCek.contains(currentWord)) {
                continue;
            }

            // Cek apakah semua huruf dalam kata unik (tidak ada huruf yang sama)
            huruf = new HashSet<>();
            boolean isUnique = true;
            for (char currentChar : currentWord.toCharArray()) {
                // Jika huruf sudah ada dalam set, berarti tidak unik
                if (!huruf.add(currentChar)) {
                    isUnique = false;
                    break; // keluar dari loop karena sudah tidak unik
                }
            }

            // Jika semua huruf dalam kata ini unik, tambahkan sebagai "kata aneh"
            if (isUnique) {
                kataYangSudahDiCek.add(currentWord); 
                jumlah++; 
            }
        }

        // Output
        System.out.println("Jumlah kata aneh: " + jumlah);
    }
}
