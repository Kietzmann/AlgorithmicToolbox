package week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[][] compares = new double[values.length][2];
        for (int i = 0; i < compares.length; i++) {
            compares[i][0] = (double) values[i] / weights[i];
            compares[i][1] = i;
        }

        Arrays.sort(compares, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[0], o1[0]);
            }
        });

        for (int i = 0; i < compares.length; i++) {

            if (capacity == 0) {
                break;
            }

            if (capacity <= weights[(int) compares[i][1]]) {
                value += compares[i][0] * capacity;
                break;
            }

            value += values[(int) compares[i][1]];
            capacity -= weights[(int) compares[i][1]];

        }

        return value;

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
