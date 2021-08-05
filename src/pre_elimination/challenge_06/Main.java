package pre_elimination.challenge_06;

/**
 * <h1>Dadu Multisisi</h1>
 * <small>
 * Time limit: 0.2 second / test case<br/>
 * Memory limit: 16 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Di Kerajaan Bojongsoang, Adhi dan Vijay adalah dua orang sahabat yang gemar bermain dadu.
 * Alih-alih bermain dengan dadu konvensional yang memiliki enam sisi, mereka suka
 * bereksperimen dengan dadu yang memiliki 𝑛 sisi dengan 3 ≤ 𝑛 ≤ 100. Setiap sisi dapat memuat
 * label bilangan bulat 𝑚 dengan 1 ≤ 𝑚 ≤ 100. Angka yang terdapat pada sisi-sisi sebuah dadu
 * dapat sama (baik pada dadu yang sama maupun dadu yang berbeda), namun Adhi dan Vijay
 * menjamin bahwa peluang sebuah sisi muncul (menghadap ke atas) pada satu lemparan untuk dadu
 * dengan 𝑛 sisi selalu sama, yaitu 1/𝑛. Sebagai contoh, peluang sebuah sisi muncul pada satu
 * lemparan untuk sebuah dadu konvensional dengan enam sisi adalah 1/6. Beberapa bentuk dadu
 * unik ini dapat dilihat pada Gambar 1.
 * </p>
 * <p>
 * Mahen adalah teman baik dari Adhi dan Vijay. Suatu ketika ia ingin mengetahui siapa di antara
 * mereka berdua yang memiliki peluang lebih besar dalam sebuah permainan dadu multisisi. Kedua
 * pemain memainkan dua buah dadu dengan banyak sisi yang sama. Pemenang dari permainan
 * adalah orang yang memiliki angka lebih besar daripada lawannya pada sisi dadu yang menghadap
 * ke atas.
 * </p>
 * <p>
 * Sebagai ilustrasi, misalkan Adhi dan Vijay bermain dadu dengan enam sisi. Dadu milik Adhi
 * memiliki tiga buah angka 3 dan tiga buah angka 4, sedangkan dadu milik Vijay memiliki tiga buah
 * angka 2 dan tiga buah angka 5. Adhi memenangkan permainan apabila dadunya memberikan
 * angka yang lebih besar daripada dadu milik Vijay, dan sebaliknya. Contohnya, bila dadu milik
 * Adhi memberikan angka 3 dan dadu milik Vijay menunjukkan angka 2, maka Adhi memenangkan
 * permainan ini. Sedangkan apabila dadu milik Adhi memberikan angka 3 dan dadu milik Vijay
 * menunjukkan angka 5, maka Vijay memenangkan permainan ini.
 * </p>
 * <p>
 * Mahen ingin mengetahui siapakah di antara Adhi dan Vijay yang memiliki peluang yang lebih
 * besar untuk memenangkan permainan dadu ini (atau mungkin saja keduanya memiliki peluang
 * yang sama, dengan perkataan lain, permainan berakhir imbang). Pada contoh ilustrasi sebelumnya,
 * kedua pemain memiliki peluang kemenangan yang sama (peluang kemenangan Adhi maupun
 * Vijay masing-masing adalah 50%).
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan terdiri dari dua baris yang masing-masing memuat 𝑛 bilangan dengan 3 ≤ 𝑛 ≤ 100.
 * Bilangan pada masing-masing baris merepresentasikan angka pada sebuah sisi dari dadu yang
 * bersesuaian dan setiap bilangan berada pada rentang [1,100]. Informasi mengenai 𝑛 harus dibaca
 * dari masukan. Bilangan-bilangan pada baris pertama merepresentasikan angka-angka yang
 * terdapat pada sisi-sisi dadu milik Adhi, sedangkan bilangan-bilangan pada baris kedua menyatakan
 * angka-angka yang terdapat pada sisi-sisi dadu miliki Vijay. Pada masing-masing dadu, peluang
 * suatu sisi menghadap ke atas adalah sama (uniform), yaitu 1/𝑛 untuk dadu dengan 𝑛 sisi.
 * </p>
 * <p>
 * Keluaran dapat berupa salah satu dari kondisi berikut:
 * </p>
 * <p>
 * <ol>
 * <li>String “Adhi menang dengan peluang x/y” tanpa tanda kutip apabila secara teori
 * Adhi dapat memenangkan permainan dadu dengan peluang 𝑥/𝑦 dengan 0 ≤ 𝑥/𝑦 ≤ 1 dan
 * 𝑥/𝑦 dinyatakan dalam pecahan paling sederhana.</li>
 * <li>String “Vijay menang dengan peluang x/y” tanpa tanda kutip apabila secara
 * teori Vijay dapat memenangkan permainan dadu dengan peluang 𝑥/𝑦 dengan 0 ≤ 𝑥/𝑦 ≤
 * 1 dan 𝑥/𝑦 dinyatakan dalam pecahan paling sederhana.</li>
 * <li>String “Imbang” tanpa tanda kutip apabila secara teori setiap pemain memiliki peluang
 * 50% untuk memenangkan permainan dadu.</li>
 * </ol>
 * </p>
 * <p>
 * Catatan: pecahan paling sederhana adalah pecahan yang tidak dapat disederhanakan lagi.
 * </p>
 * <p>
 * <table style="width: 100%;">
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 1</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 1 2 3 4 5 6<br/>
 * 6 2 4 3 1 5<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran 1</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * Imbang<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <table style="width: 100%;">
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 2</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 3 3 4 4 3 4<br/>
 * 2 5 5 5 2 2<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran 2</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * Imbang<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <table style="width: 100%;">
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 3</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 2 2 2 5 6 7<br/>
 * 1 1 3 8 8 9<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran 3</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * Vijay menang dengan peluang 7/12<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <table style="width: 100%;">
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 4</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 3 5 7 9 8 1<br/>
 * 3 4 1 2 1 4<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran 4</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * Adhi menang dengan peluang 3/4<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <h2>Penjelasan Masukan/Keluaran</h2>
 * Pada contoh masukan dan keluaran pertama, dadu yang digunakan adalah dadu konvensional 6
 * sisi yang setiap sisinya memiliki peluang 1/6 untuk menghadap ke atas. Dalam kasus ini baik
 * Adhi maupun Vijay memiliki peluang yang sama untuk menang.
 * </p>
 * <p>
 * Pada contoh masukan dan keluaran kedua, kita dapat menghitung bahwa baik Adhi maupun Vijay
 * memiliki peluang kemenangan yang sama, yaitu 50%. Pada dadu milik Adhi, peluang masing-masing
 * angka 3 atau angka 4 muncul adalah 1/2, sedangkan pada dadu milik Vijay, peluang
 * masing-masing angka 2 atau 5 muncul adalah 1/2.
 * </p>
 * <p>
 * Pada contoh masukan dan keluaran ketiga, pada dadu milik Adhi peluang angka 2 muncul adalah
 * 3 ⋅ 1/6 = 1/2, sedangkan peluang masing-masing angka 5, 6, atau 7 muncul adalah 1/6. Pada
 * dadu milik Vijay peluang masing-masing angka 1 atau 8 muncul adalah 2 ⋅ 1/6 = 1/3, sedangkan
 * peluang masing-masing angka 3 atau 9 muncul adalah 1/6. Dengan formulasi statistika (yang
 * harus Anda cari sendiri), kita dapat mengetahui bahwa Adhi berpeluang memenangkan permainan
 * ini dengan peluang 7/12.
 * </p>
 * <p>
 * <h2>Solution</h2>
 * Worst case time & space complexity:<code><b> ?</b></code>
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

    }
}
