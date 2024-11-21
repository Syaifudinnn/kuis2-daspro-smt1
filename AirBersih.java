import java.util.Scanner;

public class AirBersih {

    public static void main(String[] args) {

        // deklarasi inputan
        Scanner input = new Scanner(System.in);

        // judul
        System.out.println("=============================================");
        System.out.println("=========== Pemantau Konsumsi Air ===========");
        System.out.println("=============================================\n");

        // input jumlah wilayah
        System.out.print("Masukkan jumlah wilayah : ");
        int jumlahWilayah = input.nextInt();
        input.nextLine();

        // deklarasi array
        int[][] konsumsiAir = new int[jumlahWilayah][7]; // 7 hari seminggu
        String[] namaWilayah = new String[jumlahWilayah];

        // input nama wilayah
        for (int i = 0; i < jumlahWilayah; i++) {
            System.out.print("Masukkan nama untuk wilayah ke-" + (i + 1) + " : ");
            namaWilayah[i] = input.nextLine();
        }

        // input konsumsi air
        for (int i = 0; i < jumlahWilayah; i++) { // loop untuk per wilayah
            System.out.println("\n" + namaWilayah[i] + ":");
            for (int j = 0; j < 7; j++) { // loop untuk input konsumsi air tiap hari
                System.out.print("Konsumsi air pada hari ke-" + (j + 1) + " (m3) : ");
                konsumsiAir[i][j] = input.nextInt();
            }
        }

        System.out.println("\n-----------------------------------------\n");

        // tabel konsumsi air per hari
        System.out.println("Tabel Konsumsi Air :");
        // nama wilayah
        System.out.print("         ");
        for (String wilayah : namaWilayah) {
            System.out.printf("%-10s", wilayah);
        }
        System.out.println();

        // konsumsi air per hari
        for (int i = 0; i < 7; i++) { // loop untuk setiap hari
            System.out.print("Hari " + (i + 1) + " : ");
            for (int j = 0; j < jumlahWilayah; j++) { // loop untuk setiap wilayah
                System.out.printf("%-10d", konsumsiAir[j][i]);
            }
            System.out.println();
        }

        System.out.println("\n-----------------------------------------\n");

        // hitung total konsumsi per wilayah
        for (int i = 0; i < jumlahWilayah; i++) {
            int totalKonsumsi = 0; // deklarasi total konsumsi sebagai 0 untuk setiap loop
            for (int j = 0; j < 7; j++) {
                totalKonsumsi += konsumsiAir[i][j]; // penambahan nilai ke total konsumsi
            }
            System.out.println("Total konsumsi air wilayah " + namaWilayah[i] + " selama 1 minggu : " + totalKonsumsi + " m3");
        }

        System.out.println("\n-----------------------------------------\n");

        // deklarasi array konsumsiHarian untuk menghitung rata-rata harian dan mencari hari dgn konsumsi tertinggi
        int[] konsumsiHarian = new int[7]; // 7 hari seminggu

        for (int i = 0; i < jumlahWilayah; i++) {
            for (int j = 0; j < 7; j++) { // loop untuk menambah konsumsi air tiap hari ke array konsumsi harian
                konsumsiHarian[j] += konsumsiAir[i][j]; // tambah nilai ke array konsumsi harian
            }
        }

        // cari hari dengan konsumsi air tertinggi
        int hariTertinggi = 0; // untuk menyimpan nilai konsumsi tertinggi
        int konsumsiTertinggi = 0; // untuk menyimpan hari dgn konsumsi terbesar

        for (int j = 0; j < 7; j++) {
            double rataRata = (double) konsumsiHarian[j] / jumlahWilayah; // hitung rata-rata
            System.out.println("Rata-rata konsumsi air pada hari ke-" + (j+1) + " : " + rataRata + " meter kubik");

            if (konsumsiHarian[j] > konsumsiTertinggi) {
                konsumsiTertinggi = konsumsiHarian[j];
                hariTertinggi = j + 1;
            }
        }

        // cari wilayah dengan konsumsi air tertinggi
        int totalTertinggi = 0; // untuk menyimpan konsumsi tertinggi
        String wilayahTerbesar = " "; // untuk menyimpan nama wilayah dgn konsumsi terbesar

        for (int i = 0; i < jumlahWilayah; i++) {
            int totalKonsumsi = 0; // deklarasi total konsumsi sebagai 0 untuk setiap loop
            for (int j = 0; j < 7; j++) {
                totalKonsumsi += konsumsiAir[i][j]; // penambahan nilai ke total konsumsi
            }

            // periksa apakah total konsumsi ini yang tertinggi
            if (totalKonsumsi > totalTertinggi) {
                totalTertinggi = totalKonsumsi;
                wilayahTerbesar = namaWilayah[i]; // simpan nama wilayah dengan konsumsi tertinggi
            }  
        }

        System.out.println("\n-----------------------------------------\n");

        // hari dengan konsumsi tertinggi
        System.out.println("Hari dengan konsumsi air tertinggi : Hari ke-" + hariTertinggi + " dengan total konsumsi " + konsumsiTertinggi + " liter.");

        // wilayah dengan total konsumsi tertinggi
        System.out.println("Wilayah dengan konsumsi air tertinggi selama seminggu : Wilayah " + wilayahTerbesar + " dengan total konsumsi " + totalTertinggi + " liter.");

    }

}