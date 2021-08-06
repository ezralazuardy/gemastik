package pre_elimination.challenge_07;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;
import library.Reader;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */

public class Main {

    /**
     * Main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        final Reader in = new Reader();

        int n = Integer.parseInt(in.nextLine());

        HashMap<String, Integer> result = new HashMap<>();
        LinkedHashMap<String, Integer> sortedResult = new LinkedHashMap<>();

        // time & space complexity: O(n)
        while (n-- > 0) {
            String[] data = in.nextLine().split(" ");
            Region a = new Region(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Region b = new Region(data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]));
            result.put(String.format("%s %s", a.getName(), b.getName()), a.calculateDistanceFrom(b));
        }

        in.close();

        // record the execution start time
        long startTime = System.nanoTime();

        // if merge sort then time & space complexity: O(n log n)
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(i -> sortedResult.put(i.getKey(), i.getValue()));

        // time & space complexity: O(n)
        System.out.println();
        sortedResult.forEach((key, value) -> System.out.format("%s %d%n", key, value));

        // print the runtime information
        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }
}
