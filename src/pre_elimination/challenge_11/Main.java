package pre_elimination.challenge_11;

import java.util.Scanner;

/**
 * <h1>Sultan yang Dermawan</h1>
 * <small>
 * Time limit: 0.2 second / test case<br/>
 * Memory limit: 32 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Sultan Said merupakan pemimpin Kesultanan Dayeuh Kolot yang dermawan. Selain suka
 * membagikan barang-barang tertentu secara cuma-cuma kepada warganya (yang juga disebut
 * sebagai kegiatan giveaway), Sultan Said suka membagikan hadiah tertentu kepada pegawai
 * kesultanan yang berprestasi.
 * </p>
 * <p>
 * Berbeda dengan giveaway yang dilakukan oleh pegawai kesultanan, pembagian hadiah untuk
 * pegawai kesultanan dilakukan langsung oleh Sang Sultan. Sebulan sekali, setiap hari Jumat
 * terakhir di bulan tersebut, Sang Sultan suka memberikan hadiah secara langsung kepada para
 * pegawainya yang berprestasi, yang banyaknya tidak lebih dari 15 000 orang.
 * </p>
 * <p>
 * Pegawai yang berprestasi akan memperoleh keping emas yang banyaknya bervariasi, bergantung
 * pada prestasi pegawai tersebut. Sebagai contoh, apabila pada suatu waktu terdapat 𝑛 pegawai
 * kesultanan dengan 1 ≤ 𝑛 ≤ 15 000, maka setiap pegawai 𝑝𝑖 dapat memperoleh koin emas
 * sebanyak 𝑎𝑖 dengan nilai 𝑎𝑖 yang dapat sama atau berbeda-beda. Setiap pegawai setidaknya
 * memperoleh satu koin emas dan paling banyak memperoleh 1000 koin emas.
 * </p>
 * <p>
 * Ketika pembagian koin emas dilakukan, Sultan Said terkadang tidak membagikan langsung 𝑎𝑖
 * koin emas kepada pegawai 𝑝𝑖. Bukan itu saja, ketika pemberian hadiah dilakukan, tidak seorang
 * pegawai pun yang mengetahui berapa banyak koin emas yang akan diperolehnya. Sering kali
 * pembagian koin emas dilakukan bergiliran di mana setiap pegawai hanya memperoleh satu koin
 * emas dalam satu gilirannya. Hal ini dilakukan dengan tujuan agar setiap pegawai mengikuti
 * rangkaian acara pembagian hadiah dari awal hingga akhir.
 * </p>
 * <p>
 * Sebagai contoh, misalkan pada suatu waktu hanya ada dua pegawai kesultanan yang berprestasi,
 * sebutlah Dody dan Qori yang masing-masing akan memperoleh sebanyak dua koin emas.
 * Pembagian hadiah yang dilakukan oleh Sultan Said dapat dilakukan dengan salah satu dari enam
 * cara berikut:
 * </p>
 * <p>
 * <ol>
 * <li>Cara pertama: giliran 1: Dody, giliran 2: Qori, giliran 3: Dody, giliran 4: Qori.</li>
 * <li>Cara kedua: giliran 1: Dody, giliran 2: Qori, giliran 3: Qori, giliran 4: Dody.</li>
 * <li>Cara ketiga: giliran 1: Dody, giliran: 2: Dody, giliran 3: Qori, giliran 4: Qori.</li>
 * <li>Cara keempat: giliran 1: Qori, giliran 2: Dody, giliran 3: Qori, giliran 4: Dody.</li>
 * <li>Cara kelima: giliran 1: Qori, giliran 2: Dody, giliran 3: Dody, giliran 4: Qori.</li>
 * <li>Cara keenam: giliran 1: Qori, giliran 2: Qori, giliran 3: Dody, giliran 4: Dody.</li>
 * </ol>
 * </p>
 * <p>
 * Sebagaimana yang mungkin Anda ketahui sebelumnya, Sultan Said juga suka melakukan
 * sayembara. Siapa pun yang dapat menjawab teka-teki ini akan memperoleh hadiah tambahan
 * darinya. Misalkan terdapat 𝑛 pegawai kesultanan dengan 1 ≤ 𝑛 ≤ 15 000 di mana setiap
 * pengawai 𝑝𝑖 memperoleh sebanyak 𝑎𝑖 koin emas dengan 1 ≤ 𝑎𝑖 ≤ 1000 untuk setiap nilai 𝑖
 * (1 ≤ 𝑖 ≤ 𝑛). Anda diminta untuk menentukan banyaknya cara pembagian koin emas berbeda yang
 * dapat dilakukan oleh Sultan Said sebagaimana dijelaskan sebelumnya. Karena nilai jawaban yang
 * diberikan bisa sangat besar, Sang Sultan meminta Anda mereduksi jawaban yang diperoleh dalam
 * modulo 1000 000 007.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan hanya terdiri dari sebuah baris yang memuat 𝑛 bilangan bulat 𝑎𝑖
 * (dengan 1 ≤ 𝑖 ≤ 𝑛 dan 1 ≤ 𝑛 ≤ 15 000) yang dipisahkan dengan spasi. Informasi mengenai 𝑛 harus dibaca dari
 * masukan. Setiap bilangan 𝑎𝑖 untuk 1 ≤ 𝑖 ≤ 𝑛 memenuhi 1 ≤ 𝑎𝑖 ≤ 1000.
 * </p>
 * <p>
 * Keluaran program adalah sebuah bilangan yang menyatakan banyaknya cara pembagian hadiah
 * yang dapat dilakukan Sultan Said sebagaimana ketentuan pada deskripsi soal. Jawaban yang
 * diperoleh direduksi dalam modulo 1000 000 007.
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
 * 2 2<br/>
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
 * 1 1 1<br/>
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
 * <h3>Masukkan 3</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 1 2<br/>
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
 * 3<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Penjelasan untuk contoh masukan/keluaran pertama dapat dibaca pada deskripsi soal. Untuk
 * contoh masukan/keluaran kedua, perhatikan bahwa Sultan Said akan membagikan hadiah kepada
 * tiga pegawai kesultanan yang masing-masing memperoleh sebanyak satu koin emas. Dalam hal
 * ini ada enam cara pembagian hadiah yang dapat dilakukan Sultan Said.
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
        final Scanner in = new Scanner(System.in);

        in.close();
    }
}
