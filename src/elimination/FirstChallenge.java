package elimination;

import java.util.*;

/**
 * <h1>Prioritas Proyek Dawala</h1>
 * <small>
 * Time limit: 1 second / test case<br/>
 * Memory limit: 64 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Diberikan dua buah titik sembarang di sebuah peta. Titik-titik itu menggambarkan jarak yang
 * harus ditempuh dari setiap pusat wilayah desa satu dan lainnya. Dawala perlu mengetahui jarak
 * antara desa-desa itu dan membuat proyek penghubung desa yang paling jauh. Desa-desa itu
 * dianggap memiliki wilayah yang berbentuk sebuah lingkaran. Buatlah prioritas penyelesaian dari
 * jarak-jarak desa itu (jarak antara pusat dua buah lingkaran). Nama dari setiap desa dianggap
 * tidak mengandung spasi. Tidak ada jarak desa yang sama.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan terdiri dari beberapa baris. Baris pertama adalah bilangan bulat 𝑝 dengan batasan
 * 1 < 𝑝 < 101 yang menyatakan banyaknya pasangan data desa. Masukan berikutnya adalah
 * sebanyak 𝑝 baris pasangan data desa. Data desa berisi nama desa, koordinat 𝑥 dan 𝑦 dari pusat
 * desa itu, dan jari-jari (𝑟) wilayah desa itu. Batasan-batasan untuk nilai 𝑥, 𝑦, dan 𝑟 adalah
 * 0 < 𝑥 < 100 000, 0 < 𝑦 < 100 000, dan 0 < 𝑟 < 100 000.
 * Keluaran terdiri dari 𝑝 baris urutan prioritas dari jarak desa yang terjauh yang telah dibulatkan ke
 * bawah (bukan desimal).
 * </p>
 * <p>
 * <table style="width: 100%;">
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 3<br/>
 * Sari 10 10 60 Wangi 120 150 30<br/>
 * Mekar 10 100 70 Jeungjirigil 30 200 40<br/>
 * Cihanjuang 1000 210 70 Cisaranten 1230 2045 80<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * Cihanjuang Cisaranten 1849<br/>
 * Sari Wangi 178<br/>
 * Mekar Jeungjirigil 101<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <h2>Solution</h2>
 * Worst case time & space complexity:<code><b> O(n log n)</b></code>
 * </p>
 */

public class FirstChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // total test cases
        int n = Integer.parseInt(in.nextLine());

        // result data
        HashMap<String, Integer> result = new HashMap<>();
        LinkedHashMap<String, Integer> sortedResult = new LinkedHashMap<>();

        while (n-- > 0) { // time & space complexity: O(n)
            String[] data = in.nextLine().split(" ");
            Region a = new Region(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Region b = new Region(data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]));
            result.put(String.format("%s %s", a.getName(), b.getName()), a.calculateDistanceFrom(b));
        }

        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(i -> sortedResult.put(i.getKey(), i.getValue())); // if merge sort then time & space complexity: O(n log n)

        sortedResult.forEach((key, value) -> System.out.format("%s %d%n", key, value)); // time & space complexity: O(n)

        in.close();
    }

    public static class Region {

        private final String name;
        private final int x;
        private final int y;

        public Region(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        public String getName() {
            return this.name;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        // calculate circle a and circle b based on x y coordinates
        // distance: sqrt((x_a - x_b)^2 + (y_a - y_b)^2)
        // time & space complexity: O(1)
        public int calculateDistanceFrom(Region b) {
            return (int) Math.floor(Math.sqrt(Math.pow(this.getX() - b.getX(), 2) + Math.pow(this.getY() - b.getY(), 2)));
        }
    }
}
