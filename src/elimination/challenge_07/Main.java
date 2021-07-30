package elimination.challenge_07;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = Integer.parseInt(in.nextLine());
        final String[] data = in.nextLine().split(" ");

        in.close();

        final ArrayList<Integer> a = new ArrayList<>();
        for (String entry : data) a.add(Integer.parseInt(entry));

        System.out.println(palindrome(a));
    }

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
