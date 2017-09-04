package week1;

import edu.princeton.cs.algs4.StdOut;
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

        Percolation[] ps = new Percolation[T];
        for (int i = 0; i < T; i++) {
            ps[i] = new Percolation(N);
            opens[i] = 0;
            while (!ps[i].percolates()) {
                int j = StdRandom.uniform(1, N + 1);
                int k = StdRandom.uniform(1, N + 1);
                ps[i].open(j, k);

            }
            opens[i] = 1.0 * ps[i].numberOfOpenSites() / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(opens);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(opens);
    }

    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(opens.length);
    }                  // low  endpoint of 95% confidence interval

    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(opens.length);
    }

 /*   public static void main(String[] args) {
        // test client, described below
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        new week1.PercolationStats(N, T);
    }*/

    public static void main(String args[]) {
     /*   3
        1 3
        2 3
        3 3
        3 1
        2 1
        1 1*/

        /**
         * 4
         4 1
         3 1
         2 1
         1 1
         1 4
         2 4
         4 4
         3 4

         */

        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats p = new PercolationStats(n, t);

        StdOut.printf("mean                    = %f\n", p.mean());
        StdOut.printf("stddev                  = %f\n", p.stddev());
        StdOut.println("95% confidence interval = " + p.confidenceLo() + ", " + p.confidenceHi());

        //week1.Percolation p = new week1.Percolation(3);
        //week1.PercolationVisualizer.draw(p, 3);
        // StdDraw.show(0);          // turn on animation mode

        //p.open(1,3);
        //p.open(2,3);
        //p.open(3,3);
        // p.open(3,1);
        //week1.PercolationVisualizer.draw(p,3);
        // StdDraw.show(100);        // pause for 100 miliseconds

        //   System.out.println( p.isFull(3,1));

     /*   List<String> strs = readTxtFileIntoStringArrList("/Users/zhenghang/Downloads/percolation/input20.txt");
        week1.Percolation p = new week1.Percolation(Integer.valueOf(strs.get(0)));
        for (int i = 1; i < strs.size(); i++) {
            String[] strL = strs.get(i).split(" ");
            System.out.println(i);
            p.open(Integer.valueOf(strL[0]),Integer.valueOf(strL[1]));
        }*/

    }

  /*  public static List<String> readTxtFileIntoStringArrList(String filePath)
    {
        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }*/

}
