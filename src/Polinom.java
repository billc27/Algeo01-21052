import java.util.Scanner;

import Primitif.Matrix;
import Primitif.OBE;


public class Polinom {

    public static void polinomInterpolation(){
        int i;
        double x;
        double hasil, xPangkat;
       
        Matrix m = new Matrix(3,4);

        m.readMatrix(m.getRow(), m.getCol());
        OBE.toReducedEchelon(m);
        Scanner scanElmt = new Scanner(System.in);
        
        x = scanElmt.nextDouble();
        hasil = 0;
        xPangkat=1;
        for(i=0; i<m.getRow(); i++){  
            hasil = hasil + m.getElmt(i, m.getCol()-1)*xPangkat;
            xPangkat = xPangkat*x;
        }
        System.out.println(hasil);
    }



}
