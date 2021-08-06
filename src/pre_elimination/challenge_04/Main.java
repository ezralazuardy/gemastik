package pre_elimination.challenge_04;

import library.Reader;

/**
 * <h1>Menghitung Banyaknya Produk Unik</h1>
 * <small>
 * Time limit: 0.2 second / test case<br/>
 * Memory limit: 64 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Tahukah kamu siapa nama dari maskot GemasTIK XIII 2020? Nama dari maskot tersebut adalah
 * Galih. Pada tahun 2120, ketika para harimau di Kerajaan Dayeuhkolot memiliki kemampuan
 * membuat algoritma dan program, Galih, bersama dua saudaranya yang lain, yaitu Galuh dan
 * Gilang, membuat sebuah perusahaan perangkat lunak yang dinamai PT DayeuhCoder.
 * </p>
 * <p>
 * Setiap perangkat lunak yang dibuat oleh PT DayeuhCoder diberi nomor seri yang setiap digitnya
 * merupakan bilangan bulat antara 0 hingga 9 (inklusif). Nomor seri ini merepresentasikan suatu
 * bilangan bulat antara 0 hingga 1019 − 1 = 9 999 999 999 999 999 999 (inklusif, termasuk 0
 * dan 1019 − 1.
 * </p>
 * <p>
 * Galih, Galuh, dan Gilang memiliki kebiasaan yang tidak biasa pada perangkat lunak yang dibuat
 * perusahaan mereka. Beberapa perangkat lunak yang dirilis untuk pengguna bisa jadi memiliki
 * fitur tambahan yang unik. Pemberian fitur unik ini dijelaskan sebagai berikut. Galih, Galuh, dan
 * Gilang memilih tiga bilangan berbeda, sebutlah 𝐴, 𝐵, dan 𝐶 dengan sifat 2 ≤ 𝐴,𝐵, 𝐶 ≤ 1019 −
 * 1. Galih memberikan fitur tambahan unik pada produk yang nomor serinya habis dibagi 𝐴 saja
 * (namun tidak habis dibagi oleh 𝐵 maupun 𝐶), Galuh memberikan fitur tambahan unik pada
 * produk yang nomor serinya habis dibagi 𝐵 saja (namun tidak habis dibagi oleh 𝐴 maupun 𝐶),
 * dan Gilang memberikan fitur tambahan unik pada produk yang nomor serinya habis dibagi oleh
 * 𝐶 saja (namun tidak habis dibagi oleh 𝐴 maupun 𝐵).
 * </p>
 * <p>
 * Suatu ketika, seekor harimau bernama Galang yang tinggal di kerajaan tetangga ingin
 * mengetahui ada berapa banyak maksimal produk dengan fitur tambahan unik untuk sekumpulan
 * perangkat lunak yang nomor serinya di antara 𝑀𝑖𝑛 dan 𝑀𝑎𝑥 (inklusif, termasuk 𝑀𝑖𝑛 dan 𝑀𝑎𝑥
 * itu sendiri, dengan 𝑀𝑖𝑛 ≤ 𝑀𝑎𝑥) apabila dia juga mengetahui bilangan berbeda 𝐴, 𝐵, dan 𝐶
 * yang dipilih oleh Galih, Galuh, dan Gilang. Tugas Anda adalah membantu Galang untuk
 * menyelesaikan masalah ini.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan terdiri dua baris, baris pertama adalah dua bilangan 𝑀𝑖𝑛 dan 𝑀𝑎𝑥 dengan 0 ≤ 𝑀𝑖𝑛 ≤
 * 𝑀𝑎𝑥 ≤ 1019 − 1 yang dipisahkan dengan spasi. Baris kedua adalah tiga bilangan berbeda 𝐴,
 * 𝐵, dan 𝐶 dengan 2 ≤ 𝐴,𝐵, 𝐶 ≤ 1019 − 1 dengan 𝐴 ≠ 𝐵 ≠ 𝐶 yang dipisahkan dengan spasi.
 * </p>
 * <p>
 * Keluaran adalah banyaknya produk dengan fitur tambahan unik berdasarkan nomor serinya yang
 * berada di antara 𝑀𝑖𝑛 dan 𝑀𝑎𝑥 (inklusif, termasuk 𝑀𝑖𝑛 dan 𝑀𝑎𝑥), sebagaimana dijelaskan pada
 * deskripsi soal.
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
 * 1 20<br/>
 * 9 4 6<br/>
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
 * 6<br/>
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
 * 20 40<br/>
 * 8 9 6<br/>
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
 * 4<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <h2>Penjelasan Masukan/Keluaran</h2>
 * Pada contoh masukan dan keluaran pertama, kita memiliki nilai 𝑀𝑖𝑛 = 1 dan 𝑀𝑎𝑥 = 20. Di
 * antara dua bilangan ini, ada 6 bilangan yang merepresentasikan nomor seri produk dengan fitur
 * tambahan unik sesuai dengan nilai 𝐴 = 9, 𝐵 = 4, dan 𝐶 = 6 sebagaimana kriteria pada soal,
 * yaitu: 4, 6, 8, 9, 16, dan 20.
 * </p>
 * <p>
 * Pada contoh masukan dan keluaran kedua, kita memiliki nilai 𝑀𝑖𝑛 =20 dan 𝑀𝑎𝑥 = 40. Di
 * antara dua bilangan ini, ada 4 bilangan yang merepresentasikan nomor seri produk dengan fitur
 * tambahan unik sesuai dengan nilai 𝐴 = 8, 𝐵 = 9, dan 𝐶 = 6 sebagaimana kriteria pada soal,
 * yaitu: 27, 30, 32, dan 40.
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
        final Reader in = new Reader();

        final int min = in.nextInt(), max = in.nextInt(),
                a = in.nextInt(), b = in.nextInt(), c = in.nextInt();

        in.close();

        int ca = 0, cb = 0, cc = 0;

        for (int i = min; i <= max; i++) {
            if (i % a == 0 && i % b != 0 && i % c != 0) ca++;
            else if (i % a != 0 && i % b == 0 && i % c != 0) cb++;
            else if (i % a != 0 && i % b != 0 && i % c == 0) cc++;
        }

        System.out.println(ca + cb + cc);
    }
}
