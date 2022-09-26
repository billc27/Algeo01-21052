import Primitif.Matrix;
import Primitif.MatrixOp;
/**
13521052 Melvin Kent
13521064 Bill Clinton
13521100 Alexander Jason
*/
public class SolveSPL {
    static MatrixOp op = new MatrixOp();
    
    public static void inverseMethod(Matrix m){
        Matrix mOri = MatrixOp.MatrixOriginal(m);
        Matrix mHasil = MatrixOp.MatrixHasil(m);
        // Matrix inv = Matrix.inversAdj();
        int i;
        Matrix mOut = new Matrix(m.getRow(), 1);
        mOri.displayMatrix();
        mHasil.displayMatrix();
        mOut = MatrixOp.multiplyMatrix(MatrixOp.inversAdj(mOri), mHasil);
        mOut.displayMatrix();
        for (i = 0; i < mOut.getRow(); i++) {
            System.out.println("x"+(i+1)+" = " +(mOut.getElmt(i,0)));
        }
    }
}
