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
            if (out == true) {
                for (i = 0; i < mOut.getRow(); i++) {
                    System.out.printf("x%d = %.2f\n", (i + 1),(mOut.getElmt(i, 0)));
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


    // Fungsi untuk mendapatkan matriks berisi solusi
    public static Matrix solInverseMethod(Matrix m) {
        Matrix mOri = MatrixOp.MatrixOriginal(m);
        Matrix mHasil = MatrixOp.MatrixHasil(m);
        Matrix mOut = new Matrix(m.getRow(), 1);
        if (MatrixOp.inversAdj(mOri) == null) {
            System.out.println("Matriks tidak memiliki balikan");
        } else {
            mOut = MatrixOp.multiplyMatrix(MatrixOp.inversAdj(mOri), mHasil);
        }
        return mOut;
    }
    
    public static void SPLGaussJordanMethod(Matrix m){
        Matrix m1 = OBE.gaussJordan(m);
        int i, j;
        int row, col, selisih;
        boolean nosolution;

        nosolution = false;

        row = 0;
        col = 0;
        

        for(i=0; i<m1.getRow();i++){
            if(!m1.isRowZeroAugmented(i)){
                row++;
            } else{
                if(m1.getElmt(i, m1.getCol()-1)!=0){
                    nosolution = true;
                }
            }
        } 
        for(j=0; j<m1.getCol()-1;j++){
            if(!m1.isColZero(j)){
                col++;
            }
        }

        selisih = col - row;

        if (nosolution){
            System.out.println("Tidak ada solusi.");
        } else { // solusi unik atau solusi banyak
            if(selisih == 0){ // solusi unik
                for (i = 0; i < row-1; i++) {
                    System.out.println("x" + (i + 1) + " = " + (m1.getElmt(i, m1.getCol()-1)));
                }
            } else {
                
            }
        }


   }
}
