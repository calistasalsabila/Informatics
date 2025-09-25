// Nama : Calista Salsabila
// NIM  : L0124092

// package
package PPBO_01_L0124092_CalistaSalsabila;

// class
public class Laptop {

    // constructor
    String brand, dgpu;
    int ram, storage;

    Laptop(String brand, String dgpu, int ram, int storage){
        this.brand = brand;
        this.dgpu = dgpu;
        this.ram = ram;
        this.storage = storage;
    }

    public void displayInfo(){
        System.out.println("Nama laptop: " +brand);
        System.out.println("GPU Laptop: " +dgpu);
        System.out.println("RAM laptop: " +ram);
        System.out.println("Storage: " +storage);
    }
}


