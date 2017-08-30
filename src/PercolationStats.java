import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
/**
 * Created by Baiye on 30/08/2017.
 */
public class PercolationStats {

    private double[] opens;

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
        double low = mean() - stddev();
        double high = mean() + stddev();
        System.out.println("95% confidence interval = " + low + ", " + high);
    }

    private double mean() {
        return StdStats.mean(opens);
    }
    // sample standard deviation of percolation threshold
    private double stddev() {
        return StdStats.stddev(opens);
    }

    public static void main(String[] args) {
        // test client, described below
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        new PercolationStats(N, T);
    }

}
