import java.util.Scanner;

public class BankMini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rekening rekening = new Rekening("001", "Ani", 100000);

        // Percobaan enkapsulasi: baris di bawah ini error saat di-compile.
        // Pesan error: 'saldo' has private access in 'Rekening'
        // rekening.saldo = 1000000;

        System.out.println("============ BANK MINI ============");
        System.out.println("Rekening 001 a.n. Ani");

        int pilihan;
        do {
            System.out.print("Menu (1 setor, 2 tarik, 3 info, 0 keluar): ");
            pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.print("Jumlah: ");
                int jumlah = input.nextInt();
                System.out.println(rekening.setor(jumlah) ? "  Berhasil" : "  Ditolak");
            } else if (pilihan == 2) {
                System.out.print("Jumlah: ");
                int jumlah = input.nextInt();
                System.out.println(rekening.tarik(jumlah) ? "  Berhasil" : "  Ditolak");
            } else if (pilihan == 3) {
                rekening.cetakInfo();
            } else if (pilihan != 0) {
                System.out.println("Menu tidak dikenal");
            }
        } while (pilihan != 0);

        System.out.println();
        System.out.println("=========== SALDO AKHIR ===========");
        rekening.cetakInfo();
        input.close();
    }
}