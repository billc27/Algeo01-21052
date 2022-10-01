import Primitif.*;
import IO.*;
import java.io.*;
import java.util.*;
import java.lang.Math;
/**
13521052 Melvin Kent
13521064 Bill Clinton
13521100 Alexander Jason
*/
public class SolveSPL {
    static Scanner sc = new Scanner(System.in);
    
    public static void inverseMethod(Matrix m){
        Matrix mOri = MatrixOp.MatrixOriginal(m);
        Matrix mHasil = MatrixOp.MatrixHasil(m);
        // Matrix inv = Matrix.inversAdj();
        int i;
        Matrix mOut = new Matrix(m.getRow(), 1);

        if (MatrixOp.inversAdj(mOri) == null) {
            System.out.println("Matriks tidak memiliki balikan");
        } else {
            boolean out = Parser.printMethod();
            mOut = MatrixOp.multiplyMatrix(MatrixOp.inversAdj(mOri), mHasil);
            if (out = true) {
                for (i = 0; i < mOut.getRow(); i++) {
                    System.out.println("x" + (i + 1) + " = " + (mOut.getElmt(i, 0)));
                }
            } else {
                System.out.print("Masukkan nama file hasil, lengkap dgn .txt = ");
                String temp = Parser.matToStr(mOut);
                String fileName, filePath;
                fileName = sc.nextLine();
                filePath = Parser.getPathOutput(fileName);
                Parser.strToFile(temp, filePath);
            }
        }
    }
}
