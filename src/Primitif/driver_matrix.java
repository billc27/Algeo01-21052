package Primitif;


public class driver_matrix {
    public static void main(String[] args) {

        Matrix mnew = new Matrix(3, 3);
        // mnew.readMatrix(3, 3);
        // mnew.displayMatrix();
        /*
        mnew.getRow(2);
        mnew.getCol(1);
        number = mnew.getElmt(1, 1);
        System.out.println(number);
        mnew.swapRow(1, 2);
        mnew.displayMatrix();
        mnew.swapCol(0, 3);
        mnew.displayMatrix();
        
        Matrix mnew2 = new Matrix(2,2);
        mnew2 = mnew.minorMatrix(1, 1);
        mnew2.displayMatrix();
        System.out.println(mnew.valCofactor(2, 2));
        System.out.println(mnew.detCofactor());
        Matrix mnew3 = new Matrix(3,3);
        mnew3 = mnew.multiplyMatrix(mnew, mnew);
        mnew3.displayMatrix(); 
        */
        //Matrix mnew3 = new Matrix(3,3);
        //mnew3 = mnew.plusminusMatrix(mnew, mnew, false);
        //mnew3.displayMatrix();
        System.out.println(mnew.isRowZero());
        System.out.println(mnew.isColZero());
        Matrix m = new Matrix(3,3);
        m.displayMatrix();
        m.readMatrix(3, 3);
        Matrix m1 = new Matrix(3, 3);
        m1 = m.copyMatrix();
        MatrixOp.MatrixHasil(m1).displayMatrix();
        MatrixOp.MatrixOriginal(m1).displayMatrix();
        m1 = MatrixOp.inversAdj(m1);
        m1.Transpose().displayMatrix();

    }

}
