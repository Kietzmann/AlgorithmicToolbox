package week2;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a == 0 || b == 0) {
            System.out.println(0);
        } else {
            System.out.println(getDivisor(a, b));
        }
    }

    private static int getDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getDivisor(b, a % b);
    }
}
