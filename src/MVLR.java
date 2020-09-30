package src;

public class MVLR {
    
    matriks M;  // Matrix contained all equations
    int k;      // Number of variable
    int n;      // Number of data
    double[] xk;
    
    public MVLR(int k, int n, double[] x, double y, double[]xk) {
        this.M = new matriks(k+1, k+2);
        this.k = k;
        this.n = n;
        this.xk = xk;

        insertFirstRow(x);
        insertRestRow();

        insertLastCol(y);
    }

    private void insertFirstRow(double[] x) {
        this.M.mat[0][0] = this.n;
        for (int j = 1; j < this.M.n_kol - 1; j++) {
            this.M.mat[0][j] = x[j-1];
        }
    }

    private void insertRestRow() {
        for (int i = 1; i < this.M.m_brs; i++) {
            for (int j = 0; j < this.M.n_kol - 1; j++) {
                if (j == 0) {
                    this.M.mat[i][j] = this.M.mat[0][i];
                }

                this.M.mat[i][j] = this.M.mat[i][0] * this.M.mat[0][j];
            }
        }
    }

    private void insertLastCol(double y) {
        for (int i = 0; i < this.M.m_brs; i++) {
            if (i == 0) {
                this.M.mat[i][this.M.n_kol - 1] = y;
            }
            this.M.mat[i][this.M.n_kol - 1] = y * this.M.mat[i][0];
        }
    }

    public double[] resolve() {
        double[] solution;

        this.M.convertToMEB();
        solution = this.M.backwardSubs();

        return solution;
    }

    public double predict() {

        double[] solution;
        double[] resultArray = new double[this.k+1];
        double sum;

        solution = resolve();
        
        resultArray[0] = solution[0];
        for (int i = 1; i < solution.length; i++) {
            resultArray[i] = solution[i] * this.xk[i-1];
        }

        sum = 0;
        for (double d : resultArray) {
            sum += d;
        }

        return sum;
    }
}
