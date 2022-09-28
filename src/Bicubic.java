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

        for (i = 0; i < m.getRow(); i++) {
            for (j = 0; j < m.getCol(); j++) {
                func.setElmt(sRow, 0, m.getElmt(i, j));
                sRow++;
            }
        }

        return func;
    }

    public static Matrix xMat() {
        Matrix koef = new Matrix(16, 16); //matrix variable dari tiap fungsi
        int i, j,row=0,col=0;
        double x, y;

        for (x = -1; x < 3;x++){
            for (y = -1; y < 3; y++) {
                col = 0;
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 4; j++) {
                        koef.setElmt(row, col, Math.pow(x, i) * Math.pow(y, j));
                        col++;
                    }
                }
                row++;
            }
        }
        return koef;
    }
    
    public static Matrix inverseXmat() {
        return MatrixOp.inversId(xMat());
    }

    public static Matrix bicubKoef(Matrix m, Matrix x) {
        return MatrixOp.multiplyMatrix(inverseXmat(), toFuncMat(m));
    }
    
    public static double bicubic(Matrix m, double x, double y) {
        Matrix xMatrix = xMat();
        Matrix koef = bicubKoef(m, xMatrix);
        double val = 0;
        int i, j, row=0;
        
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                val += Math.pow(x, i) * Math.pow(y, j) * koef.getElmt(row, 0);
                row++;
            }
        }
        return val;
    }

}
