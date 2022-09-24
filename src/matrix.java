import java.util.Scanner;

class Matrix {
    int row;
    int col;
    double[][] matrix;

    // Matrix Constructor
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix = new double[row][col];
    }

    // Read Matrix
    public void readMatrix(int row, int col) {
        double elmt;
        int i, j;

        Scanner scanElmt = new Scanner(System.in);
        this.row = row;
        this.col = col;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.print("Masukkan nilai pada baris ke-" + (i+1) + " dan kolom ke-" + (j+1) + ": ");
                elmt = scanElmt.nextDouble();
                this.matrix[i][j] = elmt;
            }
        }
    }
        
    // Display Matrix
    public void displayMatrix() {
        int i, j;
        for (i = 0; i < this.row; i++) {
            for (j = 0; j < this.col; j++) {
                if (j < (this.col-1)) {
                    System.out.print(this.matrix[i][j] + " ");
                } else {
                    System.out.print(this.matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    double getElmt(int i, int j) {
        return this.matrix[i][j];
    }

    public void getCol(int i) {
        int j;
        for (j = 0; j < this.col; j++) {
            if (j < (this.col-1)) {
                System.out.print(getElmt(i, j) + " ");
            } else {
                System.out.print(getElmt(i, j));
            }
            
        }
        System.out.println();
    }
    
    public void getRow(int j) {
        int i;
        for (i = 0; i < this.row; i++) {
            System.out.println(getElmt(i, j));
        }
    }

    public void swapRow(int i1, int i2) { // Swap baris index i1 dan i2
        int j;
        double temp;
        for (j = 0; j < this.col; j++) {
            temp = this.matrix[i1][j];
            this.matrix[i1][j] = this.matrix[i2][j];
            this.matrix[i2][j] = temp;
        }
    }

    public void swapCol(int j1, int j2) { // Swap kolom index j1 dan j2
        int i;
        double temp;
        for (i = 0; i < this.row; i++) {
            temp =this.matrix[i][j1];
            this.matrix[i][j1] = this.matrix[i][j2];
            this.matrix[i][j2] = temp;
        }
    }

    public Matrix plusminusMatrix(Matrix m1, Matrix m2, boolean value) {
        int i, j;
        Matrix mOut = new Matrix(m1.row, m1.col);
        if (value) {
            for (i = 0; i < mOut.row; i++) {
                for(j = 0; j < mOut.col; j++) {
                    mOut.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
                }
            }
        } else {
            for (i = 0; i < mOut.row; i++) {
                for(j = 0; j < mOut.col; j++) {
                    mOut.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
                }
            }
        }
        return mOut;
    }

    public Matrix multiplyMatrix(Matrix m1, Matrix m2) {
        Matrix mOut = new Matrix(m1.row, m2.col);
        if (m1.col == m2.row) {
            int i, j, k;
            double result;
            for (i = 0; i < m1.row; i++) {
                for (j = 0; j < m2.col; j++) {
                    result = 0;
                    for (k = 0; k < m1.col; k++) {
                        result += m1.matrix[i][k]*m2.matrix[k][j];
                    }
                    mOut.matrix[i][j] = result;
                }
            }
        }
        return mOut;
    }

    public Matrix minorMatrix(int i, int j) { // Mengembalikan matriks minor
        Matrix mOut = new Matrix(this.row - 1, this.col - 1);
        int m, n;
        mOut.row = this.row - 1;
        mOut.col = this.col - 1;
        for (m = 0; m <= mOut.row; m++) {
            for (n = 0; n <= mOut.col; n++) {
                if (m < i) {
                    if (n > j) {
                        mOut.matrix[m][n-1] = this.matrix[m][n];
                    } else if (n < j) {
                        mOut.matrix[m][n] = this.matrix[m][n];
                    }
                }
                if (m > i) {
                    if (n > j) {
                        mOut.matrix[m-1][n-1] = this.matrix[m][n];
                    } else if (n < j) {
                        mOut.matrix[m-1][n] = this.matrix[m][n];
                    }
                }
            }
        }
        return mOut;
    }

    public double detCofactor() { // Mengembalikan nilai determinan dengan metode kofaktor
        int sign;
        int m;
        double det;
        Matrix mTemp = new Matrix(this.row - 1, this.col - 1);

        sign = 1;
        det = 0;
        if (this.row != 1) {
            for (m = 0; m < this.row; m++) {
                mTemp = this.minorMatrix(0, m);
                det += (mTemp.detCofactor()*this.matrix[0][m]*sign);
                sign *= (-1);
            }
        } else {
            det = this.matrix[0][0];
        }
        return det;
    }

    public double valCofactor(int i, int j) { // Mengembalikan nilai kofaktor
        if ((this.row == 1) && (this.col == 1)) {
            return 1;
        } else {
            Matrix mOut = new Matrix(this.row - 1, this.col - 1);
            mOut = this.minorMatrix(i, j);
            if ((i+j)%2 == 1) {
                return mOut.detCofactor()*(-1);
            } else {
                return mOut.detCofactor();
            }
        }
    }

    public boolean isRowZero() {
        int i, j;
        boolean row_val, val;
        i = 0;
        j = 0;
        row_val = true;
        val = false;
        for (i = 0; i < this.row; i++) {
            for (j = 0; j < this.col; j++) {
                if (getElmt(i, j) != 0) {
                    row_val = false;
                }
            }
            if (row_val) {
                val = true;
            }
            row_val = true;
        }
        return val;
    }

    public boolean isColZero() {
        int i, j;
        boolean col_val, val;
        i = 0;
        j = 0;
        col_val = true;
        val = false;
        for (j = 0; j < this.col; j++) {
            for (i = 0; i < this.row; i++) {
                if (getElmt(i, j) != 0) {
                    col_val = false;
                }
            }
            if (col_val) {
                val = true;
            }
            col_val = true;
        }
        return val;
    }
}
