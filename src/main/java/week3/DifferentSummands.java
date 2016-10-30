package week3;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        int k = n;
        int l = 1;
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        while (k > 0) {
            if (k <= 2 * l) {
                summands.add(k);
                k -= k;
            } else {
                summands.add(l);
                k -= l;
                l += 1;
            }

        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

