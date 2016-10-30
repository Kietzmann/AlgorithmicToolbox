package week3;

import java.util.*;

public class CoveringSegments {

    private static Integer[] optimalPoints(Segment[] segments) {
        //write your code here
        List<Segment> segmentList = Arrays.asList(segments);
        Collections.sort(segmentList, new Comparator<Segment>() {
            @Override
            public int compare(Segment p1, Segment p2) {
                return p1.end - p2.end; // Ascending
            }
        });

        // Really ugly solution, go around the array O(n) times and add points in
        List<Integer> points = new ArrayList<>();
        points.add(segmentList.get(0).end);
        for (int i = 0; i <= segmentList.size(); ) {

            Segment point = segmentList.get(i);

            int spot = 0;

            for (int j = i; j < segmentList.size(); j++) {
                Segment t = segmentList.get(j);
                spot = j;

                if (point.end < t.start) {
                    points.add(t.end);
                    break;
                }
            }

            i = spot;

            if (i == segmentList.size() - 1) {
                break;
            }

        }

        Integer [] result = new Integer[points.size()];
        result = points.toArray(result);
        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        Integer[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
