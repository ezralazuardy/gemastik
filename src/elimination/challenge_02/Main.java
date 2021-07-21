package elimination.challenge_02;

import java.util.*;

/**
 * <h1>Lumpat (Kabur)</h1>
 * Time limit: 1 second / test case<br/>
 * Memory limit: 64 MB
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Cepot memiliki hutang pada Dawala. Dawala sedang membutuhkan uang, maka pergilah Dawala
 * ke rumah Cepot di daerah Gedung Sate. Dawala masuk ke rumah Cepot, namun Cepot berusaha
 * untuk kabur. Bantulah Dawala apakah dia bisa bertemu Cepot, dan apakah untuk Cepot ada jalan
 * untuk kabur. Tanda bahwa Dawala dapat bertemu bertemu Cepot adalah ketika ada jalan antara
 * ruangan Dawala dengan ruangan Cepot. Sebagai pembatas ruangan digunakan simbol | dan - .
 * Di dalam ruangan simbol yang digunakan adalah spasi dan x sebagai tanda adanya penghalang.
 * Dawala dilambangkan dengan D dan Cepot dilambangkan dengan C. Jalan keluar ditandai
 * dengan adanya dinding yang terbuka yang dapat dilalui Cepot untuk keluar dari ruangan. Arah
 * pergerakan yang diizinkan adalah atas, bawah, kiri, dan kanan.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan terdiri dari beberapa baris. Baris pertama adalah bilangan bulat 𝑝 dengan batasan
 * 5 < 𝑝 < 70 yang menyatakan panjang dari peta (arah ke bawah). Baris kedua adalah bilangan
 * bulat 𝑙 dengan batasan 5 < 𝑙 < 50 yang menyatakan lebar dari peta (arah ke samping).
 * Selanjutnya adalah 𝑝 baris yang menyatakan gambaran ruangan peta.
 * Keluaran terdiri dari dua baris, pertama menyatakan Dawala bertemu Cepot atau Dawala tidak
 * bertemu Cepot, baris kedua menyatakan ada jalan bagi Cepot untuk lumpat (kabur) atau tidak
 * ada jalan bagi Cepot untuk lumpat.
 * </p>
 *
 * <p>
 * <table style="width: 100%;">
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 1</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 10<br/>
 * 8<br/>
 * |------|<br/>
 * |xxxx&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |------|<br/>
 * |xx&nbsp;&nbsp;&nbsp;x|<br/>
 * |&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;|<br/>
 * |------|<br/>
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
 * Dawala tidak bertemu Cepot<br/>
 * ada jalan Cepot lumpat
 * </code>
 * </td>
 * </tr>
 * </table>
 * </p>
 *
 * <p>
 * <table style="width: 100%;">
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 2</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 10<br/>
 * 8<br/>
 * |------|<br/>
 * |xxxx&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |--&nbsp;---|<br/>
 * |xx&nbsp;&nbsp;&nbsp;x|<br/>
 * |&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;|<br/>
 * |------|<br/>
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
 * Dawala bertemu Cepot<br/>
 * tidak ada jalan Cepot lumpat
 * </code>
 * </td>
 * </tr>
 * </table>
 * </p>
 *
 * <p>
 * <table style="width: 100%;">
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 3</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 10<br/>
 * 8<br/>
 * |------|<br/>
 * |xxxx&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|<br/>
 * |--&nbsp;---|<br/>
 * |xx&nbsp;&nbsp;&nbsp;x|<br/>
 * |&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;|<br/>
 * |---&nbsp;--|<br/>
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
 * Dawala bertemu Cepot<br/>
 * ada jalan Cepot lumpat
 * </code>
 * </td>
 * </tr>
 * </table>
 * </p>
 *
 * <p>
 * <h2>Solution</h2>
 * Worst case time & space complexity:<code><b> ?</b></code>
 * </p>
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /// solve!

        in.close();
    }
}