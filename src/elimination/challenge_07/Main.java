package elimination.challenge_07;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * <h1>Kumpulan Kartu Keren</h1>
 * <small>
 * Time limit: 1 second / test case<br/>
 * Memory limit: 256 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Diberikan 𝑁 buah kartu yang diberi nomor 1 sampai 𝑁. Masing-masing kartu bernilai sebuah
 * bilangan bulat positif 𝐴. Sekumpulan kartu ini dinyatakan sebagai Kumpulan Kartu Keren jika
 * nilai-nilainya dari kartu nomor 1 sampai 𝑁 membentuk sebuah palindrom. Sebagai contoh
 * sekumpulan kartu di bawah ini merupakan Kumpulan Kartu Keren.
 * </p>
 * <p>
 * <code>
 * Nomor Kartu 1 2 3 4 5 6<br/>
 * Nilai Kartu 10 20 30 30 20 10
 * </code>
 * </p>
 * <p>
 * Sedangkan sekumpulan kartu di bawah ini bukan merupakan Kumpulan Kartu Keren.
 * </p>
 * <p>
 * <code>
 * Nomor Kartu 1 2 3 4 5 6<br/>
 * Nilai Kartu 10 20 30 50 20 10
 * </code>
 * </p>
 * <p>
 * Namun, meski sekumpulan kartu kedua bukan merupakan Kumpulan Kartu Keren, kita bisa
 * menyisipkan kartu bernilai 30 di antara kartu nomor 4 dan 5 sehingga sekumpulan kartu tersebut
 * menjadi Kumpulan Kartu Keren. Diberikan sebuah sekumpulan kartu, Anda diminta untuk
 * menentukan banyaknya proses penyisipan kartu minimum sehingga sekumpulan kartu tersebut
 * menjadi Kumpulan Kartu Keren.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Baris pertama masukan adalah bilangan bulat 𝑁 (1 ≤ 𝑁 ≤ 10 000) yang menyatakan
 * banyaknya kartu sekumpulan kartu yang harus dijadikan Kumpulan Kartu Keren. Baris kedua
 * berisi 𝑁 buah bilangan bulat 𝐴 (1 ≤ 𝐴 ≤ 100) yang menyatakan nilai kartu nomor 1 sampai
 * kartu nomor 𝑁. Anda harus mencetak banyaknya operasi penyisipan minimal sehingga
 * sekumpulan kartu ini menjadi Kumpulan Kartu Keren.
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
 * 6<br/>
 * 10 20 30 30 20 10<br/>
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
 * 0<br/>
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
 * 6<br/>
 * 10 20 30 50 20 10<br/>
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
 * 1<br/>
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
 * 4<br/>
 * 10 20 30 40<br/>
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

        final int n = Integer.parseInt(in.nextLine());
        final String[] data = in.nextLine().split(" ");

        in.close();

        final ArrayList<Integer> a = new ArrayList<>();
        for (String entry : data) a.add(Integer.parseInt(entry));

        System.out.println(palindrome(a));
    }

    /**
     * Get a different integer digit elements
     *
     * @param a ArrayList(Integer)
     * @return int
     */
    private static int palindrome(ArrayList<Integer> a) {
        int s = 0, maxRight = -1, maxRightIndex = -1;

        for (int i = 0; i < a.size() / 2; i++) {
            if (!Objects.equals(a.get(i), a.get(a.size() - i - 1))) {
                maxRight = a.get(a.size() - i - 1);
                maxRightIndex = a.size() - i - 1;
                break;
            }
        }

        if (maxRight != -1 && maxRightIndex != -1) {
            if (a.get(maxRightIndex) == maxRight && maxRightIndex == a.size() - 1) { // last element
                s = maxRightIndex;
            } else if (a.get(maxRightIndex) == maxRight) { // center element
                for (int i = 0; i < a.size() / 2; i++) {
                    if (!Objects.equals(a.get(i), a.get(a.size() - i - 1))) {
                        s++;
                    }
                }
            }
        }

        return s;
    }
}
