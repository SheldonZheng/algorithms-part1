import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
/**
 * Created by Baiye on 30/08/2017.
 */
public class PercolationStats {

    private final double[] opens;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        opens = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation p = new Percolation(N);
            opens[i] = 0;
            while (!p.percolates()) {
                while (true) {
                    int j = StdRandom.uniform(1, N+1);
                    int k = StdRandom.uniform(1, N+1);
                    if (!p.isOpen(j, k)) {
                        p.open(j, k);
                        opens[i]++;
                        break;
                    }
                }
            }
            opens[i] /= N * N;
        }
        System.out.println("mean                    = " + mean());
        System.out.println("stddev                  = " + stddev());
        System.out.println("95% confidence interval = " + confidenceLo() + ", " + confidenceHi());
    }

    public double mean() {
        return StdStats.mean(opens);
    }
    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(opens);
    }

    public double confidenceLo() {
        return mean() - stddev();
    }                  // low  endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + stddev();
    }

 /*   public static void main(String[] args) {
        // test client, described below
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        new PercolationStats(N, T);
    }*/

    public static void main(String args[]) {
     /*   3
        1 3
        2 3
        3 3
        3 1
        2 1
        1 1*/
        Percolation p = new Percolation(3);
        p.open(1,3);
        System.out.println(p.isFull(1,3));
        p.open(2,3);
        System.out.println(p.isFull(2,3));
        p.open(3,3);
        System.out.println(p.isFull(3,3));
        p.open(3,1);
    }

}
