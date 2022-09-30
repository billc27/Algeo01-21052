import java.util.Scanner;

import Primitif.Matrix;
import Primitif.OBE;


public class Polinom {

    public static void polinomInterpolation(){
        int i, j;
        double a,b, val;
        double x;
        double hasil, xPangkat;
        Scanner scanElmt = new Scanner(System.in);
        

        int n; // jumlah data

        n = scanElmt.nextInt();
        Matrix m = new Matrix(n, n+1);
        for(i=0; i<n; i++){
            a = scanElmt.nextDouble();
            b = scanElmt.nextDouble();
            val = 1;
            for(j=0; j<m.getCol(); j++){
                if(j==m.getCol()-1){
                    m.setElmt(i, j, b);
                } else {
                    m.setElmt(i, j, val);
                    val = val*a;
                }
            }
        }

        // m.readMatrix(m.getRow(), m.getCol());
        m.displayMatrix();
        OBE.toReducedEchelon(m);
        
        
        x = scanElmt.nextDouble();
        scanElmt.close();
        hasil = 0;
        xPangkat=1;
        for(i=0; i<m.getRow(); i++){  
            hasil = hasil + m.getElmt(i, m.getCol()-1)*xPangkat;
            xPangkat = xPangkat*x;
        }
        System.out.printf("%.3f",hasil);
    }



}
