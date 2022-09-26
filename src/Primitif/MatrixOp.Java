package Primitif;

public class MatrixOp {
// ********************************** INVERSE ************************************************
    public static Matrix minorMatrix(Matrix m1, int i, int j) { // Mengembalikan matriks minor
        Matrix mOut = new Matrix(m1.rows - 1, m1.cols - 1);
        int m, n;
        mOut.rows = m1.rows - 1;
        mOut.cols = m1.cols - 1;
        for (m = 0; m <= mOut.rows; m++) {
            for (n = 0; n <= mOut.cols; n++) {
                if (m < i) {
                    if (n > j) {
                        mOut.matrix[m][n-1] = m1.matrix[m][n];
                    } else if (n < j) {
                        mOut.matrix[m][n] = m1.matrix[m][n];
                    }
                }
                if (m > i) {
                    if (n > j) {
                        mOut.matrix[m-1][n-1] = m1.matrix[m][n];
                    } else if (n < j) {
                        mOut.matrix[m-1][n] = m1.matrix[m][n];
                    }
                }
            }
        }
        return mOut;
    }

    public static double detCofactor(Matrix M) { // Mengembalikan nilai determinan dengan metode kofaktor
        int sign;
        int m;
        double det;
        Matrix mTemp = new Matrix(M.rows - 1, M.cols - 1);

        sign = 1;
        det = 0;
        if (M.rows != 1) {
            for (m = 0; m < M.rows; m++) {
                mTemp = minorMatrix(M,0, m);
                det += (detCofactor(mTemp) * M.matrix[0][m] * sign);
                sign *= (-1);
            }
        } else {
            det = M.matrix[0][0];
        }
        return det;
    }
 
    public static double valCofactor(Matrix M,int i, int j) { // Mengembalikan nilai kofaktor
        if ((M.rows == 1) && (M.cols == 1)) {
            return 1;
        } else {
            Matrix mOut = new Matrix(M.rows - 1, M.cols - 1);
            mOut = minorMatrix(M,i, j);
            if ((i + j) % 2 == 1) {
                return detCofactor(mOut) * (-1);
            } else {
                return detCofactor(mOut);
            }
        }
    }
    
    
    //Menghasilkan hasil matrix dari kofaktor
    public static Matrix Cofactor(Matrix m) {
        Matrix mOut = new Matrix(m.rows, m.cols);
        int i, j;

        for (i = 0; i < mOut.rows; i++) {
            for (j = 0; j < mOut.cols; j++) {
                mOut.matrix[i][j] = valCofactor(m, i, j);
            }
        }
        return mOut;
    }

    public static Matrix inversAdj(Matrix M) {
        int i, j;
        Matrix kof = Cofactor(M);
        Matrix mOut = kof.Transpose();
        double det = detCofactor(M);

        if (det == 0) {
            return null;
        }
 
        for (i = 0; i < mOut.rows; i++) {
            for (j = 0; j < mOut.cols; j++) {
                mOut.matrix[i][j] = mOut.matrix[i][j] / det;
            }
        }
        return mOut;
    }
// ****************************** Augmented Matrix *******************************
    public static Matrix MatrixOriginal(Matrix m){
        Matrix mOut = new Matrix(m.rows,m.cols-1);
        int i,j;
        for (i=0;i<mOut.rows;i++){
            for (j=0; j<mOut.cols;j++){
                mOut.setElmt(i,j, m.getElmt(i,j));
            }
        }
        return mOut;
    }

    public static Matrix MatrixHasil(Matrix m){
        Matrix mOut = new Matrix(m.rows, 1);
        int i;
        for (i=0;i<mOut.rows;i++){
            mOut.setElmt(i,0, m.getElmt(i,m.getCol()-1));
        }
        return mOut;
    }
}