package elimination;

import java.util.*;

/**
 * <h1>Prioritas Proyek Dawala</h1>
 * <hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * Diberikan dua buah titik sembarang di sebuah peta. Titik-titik itu menggambarkan jarak yang
 * harus ditempuh dari setiap pusat wilayah desa satu dan lainnya. Dawala perlu mengetahui jarak
 * antara desa-desa itu dan membuat proyek penghubung desa yang paling jauh. Desa-desa itu
 * dianggap memiliki wilayah yang berbentuk sebuah lingkaran. Buatlah prioritas penyelesaian dari
 * jarak-jarak desa itu (jarak antara pusat dua buah lingkaran). Nama dari setiap desa dianggap
 * tidak mengandung spasi. Tidak ada jarak desa yang sama.
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan terdiri dari beberapa baris. Baris pertama adalah bilangan bulat 𝑝 dengan batasan
 * 1 < 𝑝 < 101 yang menyatakan banyaknya pasangan data desa. Masukan berikutnya adalah
 * sebanyak 𝑝 baris pasangan data desa. Data desa berisi nama desa, koordinat 𝑥 dan 𝑦 dari pusat
 * desa itu, dan jari-jari (𝑟) wilayah desa itu. Batasan-batasan untuk nilai 𝑥, 𝑦, dan 𝑟 adalah
 * 0 < 𝑥 < 100 000, 0 < 𝑦 < 100 000, dan 0 < 𝑟 < 100 000.
 * Keluaran terdiri dari 𝑝 baris urutan prioritas dari jarak desa yang terjauh yang telah dibulatkan ke
 * bawah (bukan desimal).
 * <p>
 * <h2>Masukkan</h2>
 * <code>
 * 3<br/>
 * Sari 10 10 60 Wangi 120 150 30<br/>
 * Mekar 10 100 70 Jeungjirigil 30 200 40<br/>
 * Cihanjuang 1000 210 70 Cisaranten 1230 2045 80<br/>
 * </code>
 * </p>
 * <p>
 * <h2>Keluaran</h2>
 * <code>
 * Cihanjuang Cisaranten 1849<br/>
 * Sari Wangi 178<br/>
 * Mekar Jeungjirigil 101<br/>
 * </code>
 * </p>
 * <p>
 * <h2>Solution</h2>
 * Worst case time & space complexity:<code><b> O(n log n)</b></code>
 * </p>
 */

public class FirstChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // total testcase
        int n = Integer.parseInt(in.nextLine());

        // result map
        HashMap<String, Integer> result = new HashMap<>();
        LinkedHashMap<String, Integer> sortedResult = new LinkedHashMap<>();

        while (n-- > 0) { // O(n)
            String[] data = in.nextLine().split(" ");
            Region a = new Region(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Region b = new Region(data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]));

            // distance = sqrt((x_a - x_b)^2 + (y_a - y_b)^2)
            result.put(String.format("%s %s", a.getName(), b.getName()), (int) Math.floor(Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)))); // O(1)
        }

        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(i -> sortedResult.put(i.getKey(), i.getValue())); // if merge sort then O(n log n)

        sortedResult.forEach((key, value) -> System.out.format("%s %d%n", key, value)); // O(n)

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
    }
}
