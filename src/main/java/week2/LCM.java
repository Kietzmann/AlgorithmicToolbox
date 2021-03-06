package week2;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long gcd = 0;
        if (a == 0 || b == 0) {
            System.out.println(0);
        } else {
            gcd = getDivisor(a, b);
        }
        System.out.println((a * b) / gcd);
    }

    private static long getDivisor(long a, long b) {
        if (b == 0) {
            return (long) a;
        }

        return getDivisor((long) b, (long) a % b);

    }
}
