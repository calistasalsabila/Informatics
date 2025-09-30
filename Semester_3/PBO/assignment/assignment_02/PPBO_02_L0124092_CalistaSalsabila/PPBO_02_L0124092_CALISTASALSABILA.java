package Semester_3.PBO.assignment.assignment_02.PPBO_02_L0124092_CalistaSalsabila;

public class PPBO_02_L0124092_CALISTASALSABILA {
    public static void main(String[] args) {
        Inventaris inv = new Inventaris();

        inv.tambahBarang("Penggaris", "Alat Tulis", 10, 2000);
        inv.tambahBarang("Kertas A4", "Alat Tulis", 5, 50000);
        inv.tambahBarang("Mouse", "Elektronik", 3, 100000);

        inv.tampilkanInventaris();

        inv.pakaiBarang("Penggaris", 3);
        inv.pakaiBarang("Mouse", 2);

        inv.tambahStok("Kertas A4", 10);

        inv.pakaiBarang("Mouse", 5);

        inv.tampilkanInventaris();
    }
}
