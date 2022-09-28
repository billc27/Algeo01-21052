import Primitif.Matrix;
import Primitif.MatrixOp;

/**
13521052 Melvin Kent
13521064 Bill Clinton
13521100 Alexander Jason
*/
public class driver {
    public static void main(String[] args) {
        Matrix mnew = new Matrix(4, 4);
        mnew.readMatrix(mnew.getRow(), mnew.getCol());
        // SolveSPL.inverseMethod(mnew);
        Bicubic.inverseXmat().displayMatrix();
        // System.out.println(mnew.isSegitigaAtas());
        double val;
        val = Bicubic.bicubic(mnew, 0.5, 0.5);
        System.out.println(val);
    }
}
