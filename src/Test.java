import edu.princeton.cs.algs4.In;

/**
 * Created by Baiye on 20/09/2017.
 */
public class Test {

    public static void main(String args[]) {
        Point[] points = getPointsFromTestFile("input40.txt");
        FastCollinearPoints collinearPoints = new FastCollinearPoints(points);
    }

    public static Point[] getPointsFromTestFile(String fileName) {
        In in = new In("/Users/zhenghang/Downloads/collinear/" + fileName);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        return points;
    }
}
