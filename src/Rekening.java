public class Rekening {
    // Semua field private: tidak bisa diakses langsung dari luar class
    private String nomor;
    private String pemilik;
    private int saldo;

    // Constructor: nama parameter sama dengan nama field, dibedakan dengan this
    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Saldo read-only: hanya ada getter, tidak ada setSaldo
    public int getSaldo() {
        return saldo;
    }

    // Menolak jumlah <= 0
    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    // Menolak jumlah <= 0 dan jumlah yang melebihi saldo
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    // Contoh hasil: 001 | Ani    |    Rp120.000
    public void cetakInfo() {
        System.out.printf("%s | %-6s | %12s%n", nomor, pemilik, formatRupiah(saldo));
    }

    // Memberi titik pemisah ribuan, mis. 120000 -> Rp120.000
    private String formatRupiah(int uang) {
        String angka = String.valueOf(Math.abs(uang));
        StringBuilder hasil = new StringBuilder();
        int hitung = 0;
        for (int i = angka.length() - 1; i >= 0; i--) {
            if (hitung > 0 && hitung % 3 == 0) {
                hasil.insert(0, '.');
            }
            hasil.insert(0, angka.charAt(i));
            hitung++;
        }
        String tanda = uang < 0 ? "-" : "";
        return tanda + "Rp" + hasil;
    }
}