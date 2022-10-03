import java.io.IOException;
import java.util.Scanner;
import Primitif.Matrix;
import Primitif.OBE;

public class Polinom {

    public static Matrix matrixGenerator(Matrix mData){
        int i, j;
        double a,b, val;
        int n; // jumlah data

        n = mData.getRow();
        Matrix m = new Matrix(n, n+1);
        for(i=0; i<n; i++){
            a = mData.getElmt(i, 0);
            b = mData.getElmt(i, 1);
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
        return m;
    }

    public static double polinomInterpolation(Matrix m) throws IOException{
        int i;
        double x;
        double hasil, xPangkat;
        final StringBuffer str = new StringBuffer();
        
        OBE.toReducedEchelon(m);
        
        System.out.print("f(x) = ");
        str.append("f(x) = ");
        for(i=0; i<m.getRow(); i++){  
            if(i==0){
                System.out.print(m.getElmt(i, m.getCol()-1));
            } else if (m.getElmt(i, m.getCol()-1)>=0){
                System.out.print(" + " + m.getElmt(i, m.getCol()-1) + "x^" + i);
            } else {
                System.out.print(" - " + -1*m.getElmt(i, m.getCol()-1) + "x^" + i);
            }
        }
        System.out.println();
        
        System.out.println("Taksir nilai fungsi");
        System.out.print("Masukkan nilai x: ");
        
        Scanner scanElmt = new Scanner(System.in);
        x = scanElmt.nextDouble();
        hasil = 0;
        xPangkat=1;
        for(i=0; i<m.getRow(); i++){  
            hasil = hasil + m.getElmt(i, m.getCol()-1)*xPangkat;
            xPangkat = xPangkat*x;
        }
        return hasil;
    }
}
