package Primitif;

public class Cramer {
    
    // membaca matriks augmented
    public static void splCrammer(Matrix m){
        //I.S m berupa matriks augmented
        Matrix m1;
        int i;
        double det, det1;

        det = OBE.detOBE(m);
        det1 = 1;
        m1 = m.copyMatrix();

        for(i=0; i<m.getCol()-1; i++){
            m1.swapCol(i, m.getCol()-1);
            det1 = OBE.detOBE(m1);
            System.out.println(det1/det);
            m1 = m.copyMatrix();
        }
    } 



    
}
