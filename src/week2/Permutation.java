package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Baiye on 07/09/2017.
 */
public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        while(!StdIn.isEmpty())
        {
            rq.enqueue(StdIn.readString());
        }
        for(int i=1;i<=k;i++)
        {
            StdOut.println(rq.dequeue());
        }
    }
}
