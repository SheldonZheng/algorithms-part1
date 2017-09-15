/**
 * Created by Baiye on 15/09/2017.
 */
public class FastCollinearPoints {

    private int nums;

    private LineSegment[] segments;

    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new java.lang.IllegalArgumentException();
        for (Point point : points) {
            if (point == null)
                throw new java.lang.IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            for (int i1 = 0; i1 < points.length; i1++) {
                if (points[i].compareTo(points[i1]) == 0)
                    throw new java.lang.IllegalArgumentException();
            }
        }

        segments = (LineSegment[]) new Object[10];
        nums = 0;

        for (int i = 0;i < points.length - 3;i++) {
            for (int j = i + 1;j < points.length - 2;j++) {
                for (int y = j + 1;y < points.length - 1;y++){
                    for (int z = y + 1;z < points.length;z++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[y]) &&
                                points[i].slopeTo(points[j]) == points[i].slopeTo(points[z])) {
                            segments[nums++] = new LineSegment(points[i],points[z]);
                        }
                    }
                }
            }
        }

    }   // finds all line segments containing 4 points
    public           int numberOfSegments() {
        return nums;
    }       // the number of line segments
    public LineSegment[] segments() {
        return segments;
    }
}
