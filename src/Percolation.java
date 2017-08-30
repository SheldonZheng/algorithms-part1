
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Baiye on 30/08/2017.
 */
public class Percolation {

    private boolean[][] field;

    private int[][] intfield;

    private final int size;

    private int openCount;

    private final WeightedQuickUnionUF operator;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = n;
        this.operator = new WeightedQuickUnionUF(size * size + 2);
        this.field = new boolean[n][n];
        this.intfield = new int[n][n];
        this.openCount = 0;
        initFileld();
    }

    private void initFileld() {
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = false;
                this.intfield[i][j] = index++;
            }
        }
        createVirtualRoots();
    }

    private void createVirtualRoots() {
        int temp = size * size;
        for (int i = 0; i < size; i++) {
            operator.union(intfield[0][i], temp);
            operator.union(intfield[size - 1][i], temp + 1);

        }
    }

    public void open(int row, int col) {
        if (row <= 0 || col <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int k = row - 1;
        int j = col - 1;
        field[k][j] = true;
        openCount++;
        if (k - 1 >= 0 && field[k - 1][j]) {
            operator.union(intfield[k - 1][j], intfield[k][j]);
        }
        if (k + 1 < size && field[k + 1][j]) {
            operator.union(intfield[k + 1][j], intfield[k][j]);
        }
        if (j - 1 >= 0 && field[k][j - 1]) {
            operator.union(intfield[k][j - 1], intfield[k][j]);
        }
        if (j + 1 < size && field[k][j + 1]) {
            operator.union(intfield[k][j + 1], intfield[k][j]);
        }

    }    // open site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0) {
            throw new IndexOutOfBoundsException();
        }
        return field[row - 1][col - 1];
    }  // is site (row, col) open?

    public boolean isFull(int row, int col) {
        if (row <= 0 || col <= 0) {
            throw new IndexOutOfBoundsException();
        }
        return (operator.connected(intfield[row - 1][col - 1], size * size) && isOpen(row, col));
    }  // is site (row, col) full?

    public int numberOfOpenSites() {
        return openCount;
    }       // number of open sites

    public boolean percolates() {
        if (size == 1) {
            return isOpen(1, 1);
        }
        return operator.connected(size * size, size * size + 1);
    }             // does the system percolate?
}
