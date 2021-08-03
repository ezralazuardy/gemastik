package elimination.challenge_09;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Pembatasan Sosial Berbasis Blokade</h1>
 * <small>
 * Time limit: 3 second / test case<br/>
 * Memory limit: 256 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Di tengah-tengah pandemi COVID-19, pemerintah di provinsi tempat Pak Andi tinggal sedang
 * merencanakan langkah-langkah untuk mengurangi persebaran virus ini melalui serangkaian upaya
 * pembatasan sosial. Salah satu bentuk upaya yang akan dilakukan adalah dengan melakukan
 * serangkaian blokade (penutupan) terhadap ruas-ruas jalan tertentu dengan tujuan untuk
 * mengurangi mobilitas (pergerakan orang) dan mengurangi risiko penularan virus dari satu kota ke
 * kota lainnya. Namun, dalam melakukan pembatasan ini juga diinginkan agar jangan sampai
 * pembatasan sosial tersebut terlalu melemahkan kegiatan perekonomian sehari-hari masyarakat di
 * provinsi itu, yang dapat disebabkan oleh blokade yang tidak perlu.
 * </p>
 * <p>
 * Provinsi tempat tinggal Pak Andi terdiri dari beberapa kota dan beberapa ruas jalan. Satu ruas jalan
 * menghubungkan antara dua buah kota berbeda, dan selalu dapat dilalui pada kedua arah. Dalam
 * kondisi saat ini, untuk setiap pasang kota, selalu ada rute (serangkaian ruas jalan) yang
 * menghubungkan antar kedua kota tersebut. Pada setiap ruas jalan, juga telah disediakan data
 * berapa besaran mobilitas yang diamati melalui ruas jalan tersebut. Di antara kota-kota tersebut,
 * telah diidentifikasi juga ada beberapa kota di mana telah ditemukan kasus positif COVID-19, yang
 * akan memerlukan penanganan khusus pada saat melakukan blokade. Setelah melalui serangkaian
 * rapat, gugus penanganan COVID-19 di provinsi tersebut memutuskan bahwa proses blokade yang
 * akan dilakukan harus memenuhi aturan-aturan sebagai berikut:
 * </p>
 * <p>
 * <ul>
 * <ol>Tidak boleh boleh ada rute/jalur yang menghubungkan antara sebuah kota yang belum
 * memiliki kasus positif dan kota yang sudah memiliki kasus positif.</ol>
 * <ol>Untuk setiap pasang kota yang sama-sama belum memiliki kasus positif COVID-19,
 * apabila di awal sudah ada rute/jalur yang menghubungkan kedua kota tersebut tanpa
 * melewati kota yang sudah memiliki kasus positif, maka setelah dilakukan blokade, harus
 * tetap ada rute/jalur yang menghubungkan keduanya tanpa melewati kota dengan kasus
 * positif.</ol>
 * <ol>Untuk setiap pasang kota yang sama-sama sudah memiliki kasus positif COVID-19,
 * apabila di awal sudah ada rute/jalur yang menghubungkan kedua kota tersebut tanpa
 * melewati kota yang belum memiliki kasus positif, maka setelah dilakukan blokade, harus
 * tetap ada rute/jalur yang menghubungkan keduanya tanpa melewati kota yang belum
 * memiliki kasus positif.</ol>
 * <ol>Jumlah total nilai mobilitas pada ruas jalan yang tidak diblokade haruslah sekecil mungkin,
 * dengan tetap memenuhi aturan a) - c) di atas.</ol>
 * </ul>
 * </p>
 * <p>
 * Pak Andi yang merupakan salah satu anggota gugus penanganan COVID-19, diminta untuk
 * melakukan analisis dan melakukan perhitungan untuk menentukan ruas jalan mana saja yang perlu
 * diblokade sehingga memenuhi semua kriteria di atas, serta menghitung berapa nilai total mobilitas
 * jika blokade telah dilaksanakan berdasarkan data-data yang telah dikumpulkan. Bisakah Anda
 * membantu Pak Andi?
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan dimulai dengan tiga buah nilai, 𝑛, 𝑚, dan 𝑘 yang masing -masing menunjukkan:
 * </p>
 * <p>
 * <ul>
 * <li>𝑛 : banyaknya kota tanpa kasus positif</li>
 * <li>𝑚 : banyaknya kota dengan kasus positif</li>
 * <li>𝑘 : banyaknya ruas jalan pada provinsi tersebut</li>
 * </ul>
 * </p>
 * <p>
 * Kemudian 𝑛 baris selanjutnya berisi 𝑛 buah bilangan bulat non-negatif yang menunjukkan nomor
 * kota-kota tanpa kasus positif, 𝑚 baris berikutnya berisi 𝑚 buah bilangan bulat non-negatif yang
 * menunjukkan nomor kota-kota dengan kasus positif, 𝑘 baris berikutnya masing-masing berisi tiga
 * buah bilangan bulat 𝑎, 𝑏 dan 𝑤, yang menunjukkan bahwa ada ruas jalan antara kota 𝑎 dan 𝑏
 * dengan nilai mobilitas sebesar 𝑤.<br/>Batasan untuk variabel masukan adalah:
 * </p>
 * <p>
 * <ul>
 * <li>0 ≤ 𝑛, 0 ≤ 𝑚, 0 < 𝑛 + 𝑚 ≤ 10 000</li>
 * <li>0 < 𝑘 ≤ 50 000</li>
 * <li>0 ≤ 𝑤 ≤ 100</li>
 * </ul>
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
 * 3 1 5<br/>
 * 0<br/>
 * 1<br/>
 * 2<br/>
 * 3<br/>
 * 0 1 2<br/>
 * 1 2 5<br/>
 * 0 2 3<br/>
 * 0 3 4<br/>
 * 2 3 2<br/>
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
 * 5<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <h2>Solution</h2>
 * This solution uses an Kruskal's Algorithm that has a
 * worst case time & space complexity:<code><b> O(E log V)</b></code><br/>
 * where <b>E</b> equals to the total edges and <b>V</b> equals to the total vertices.
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
        final Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        final int[] negative = new int[m];
        final ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) in.nextInt();

        for (int i = 0; i < m; i++) negative[i] = in.nextInt();

        while (k-- > 0) {

            final int x = in.nextInt(), y = in.nextInt(), w = in.nextInt();

            boolean positive = true;

            // ensure no negative city is added
            for (int entry : negative) {
                if (x == entry || y == entry) {
                    positive = false;
                    break;
                }
            }

            // if positive city is detected, add current path
            if (positive) edges.add(new Edge(x, y, w));
        }

        final ArrayList<Edge> result = new Graph(n, edges).kruskal();

        int weight = 0;

        for (Edge edge : result) weight += edge.getWeight();

        System.out.println(weight);

        in.close();
    }
}
