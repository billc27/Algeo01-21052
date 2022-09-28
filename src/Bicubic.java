import Primitif.Matrix;
import Primitif.MatrixOp;
/**
13521100 Alexander Jason
*/
public class Bicubic {
    public static Matrix toFuncMat(Matrix m) {
        // pre kondisi: matrix input berupa 4x4
        int i, j, sRow = 0;
        Matrix func = new Matrix(16, 1); //matrix konversi fungsi dari matrix m
        Matrix var = new Matrix(16, 16); //matrix variable dari tiap fungsi
        Matrix a = new Matrix(16, 1); // matrix hasil variable 
        for (i = 0; i < m.getRow(); i++) {
            for (j = 0; j < m.getCol(); j++) {
                func.setElmt(sRow, 0, m.getElmt(i, j));
                sRow++;
            }
        }

        for(){

        }
        return func;

    }

    public static Matrix mat()
}
