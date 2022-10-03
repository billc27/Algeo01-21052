import Primitif.*;

import java.io.IOException;

import IO.*;

/**
13521052 Melvin Kent
13521064 Bill Clinton
13521100 Alexander Jason
*/
public class SolveSPL {
    
    public static void inverseMethod(Matrix m){
        Matrix mOri = MatrixOp.MatrixOriginal(m);
        Matrix mHasil = MatrixOp.MatrixHasil(m);
        // Matrix inv = Matrix.inversAdj();
        int i;
        Matrix mOut = new Matrix(m.getRow(), 1);
        mOri.displayMatrix();
        mHasil.displayMatrix();
        if (MatrixOp.inversAdj(mOri) == null) {
            System.out.println("Matriks tidak memiliki balikan");
        }else{
        mOut = MatrixOp.multiplyMatrix(MatrixOp.inversAdj(mOri), mHasil);
        for (i = 0; i < mOut.getRow(); i++) {
            System.out.println("x" + (i + 1) + " = " + (mOut.getElmt(i, 0)));
        }
        }
    }

    public static void SPLGaussJordanMethod(Matrix m) throws IOException{
        Matrix m1 = OBE.gaussJordan(m);

        int i, j, a, b;
        int row, col, selisih;
        boolean nosolution;
        final StringBuffer str = new StringBuffer();

        nosolution = false;

        row = 0;
        col = m1.getCol() - 1;
        

        for(i=0; i<m1.getRow();i++){
            if(!m1.isRowZeroAugmented(i)){
                row++;
            } else{
                if(m1.getElmt(i, m1.getCol()-1)!=0){
                    nosolution = true;
                }
            }
        }

        selisih = col - row;

        if (nosolution){
            System.out.println("Tidak ada solusi.");
        } else { // solusi unik atau solusi banyak
            if(selisih == 0){ // solusi unik
                for (i = 0; i < col; i++) {
                    System.out.printf("x%d = %.2f\n", (i + 1),m1.getElmt(i, m1.getCol()-1));
                    // System.out.print("x" + (i + 1) + " = " );
                    // System.out.printf(".2f",(m1.getElmt(i, m1.getCol()-1)));
                    // System.out.println();
                    str.append("x" + (i + 1) + " = " + String.format("%.2f",m1.getElmt(i, m1.getCol()-1)) + "\n");
                }
                Parser.printMatrixtoFile(str.toString());
            } else {  
                for (j = 0; j < m1.getCol()-1; j++){
                    System.out.print("x" + (j + 1) + " = ");
                    str.append("x" + (j + 1) + " = ");
                    //cek apakah variabel tidak memengaruhi variabel lainnya
                    if(m1.isColZero(j)){
                        System.out.println((char)(j+65));
                        str.append((char)(j+65));
                        str.append("\n");
                    } else {
                        // cek apakah leading one
                        for(i=0; i<m1.getRow(); i++){
                            if(m1.getElmt(i, j)!=0 ){
                                // mendapatkan index leading one pada baris i
                                for(b=0; b<m1.getCol()-1; b++){
                                    if(m1.getElmt(i, b)!=0){
                                        break;
                                    }
                                }
                                if(j!=b){ // apabila bukan leading one
                                    System.out.println((char)(j+65));
                                    str.append((char)(j+65));
                                    str.append("\n");
                                } else { // apabila leading one
                                    if(m1.getElmt(i, m1.getCol()-1)!=0){
                                        System.out.print(m1.getElmt(i, m1.getCol()-1));
                                        str.append(m1.getElmt(i, m1.getCol()-1));
                                    }
                                     // iterasi untuk mencari variabel lainnya di baris i
                                    for(a = b+1; a < m1.getCol()-1; a++){
                                        if(m1.getElmt(i, a)>0){
                                            System.out.print(" - " + m1.getElmt(i, a)+(char)(a+65));
                                            str.append(" - " + m1.getElmt(i, a)+(char)(a+65));

                                        } else if (m1.getElmt(i, a)<0 && m1.getElmt(i, m1.getCol()-1)!=0){
                                            System.out.print(" + " + -1*m1.getElmt(i, a) + (char)(a+65));
                                            str.append(" + " + -1*m1.getElmt(i, a) + (char)(a+65));
                                        } else if(m1.getElmt(i, a)<0 && m1.getElmt(i, m1.getCol()-1)==0){
                                            System.out.print(""+ -1*m1.getElmt(i, a) + (char)(a+65));
                                            str.append(""+ -1*m1.getElmt(i, a) + (char)(a+65));
                                        }
                                    }
                                    System.out.println();
                                    str.append("\n");
                                }
                                break; 
                            }
                        }
                    }
                }
                Parser.printMatrixtoFile(str.toString());
            }
        }
    }
    public static void cramerMethod(Matrix m) throws IOException{
        Matrix m1;
        int i, row, col, selisih;
        double det, det1;
        final StringBuffer str = new StringBuffer();
        boolean nosolution;

        m1 = m.copyMatrix();

        row = 0;
        col = m1.getCol() - 1;
        nosolution = false;
        
        for(i=0; i<m1.getRow();i++){
            if(!m1.isRowZeroAugmented(i)){
                row++;
            } else{
                if(m1.getElmt(i, m1.getCol()-1)!=0){
                    nosolution = true;
                }
            }
        } 
            selisih = col - row;
        if(selisih!=0){
            System.out.println("Persamaan tidak membentuk matriks persegi sehingga tidak dapat menggunakan kaidah Cramer.");
        } else if(nosolution){
            System.out.println("Tidak ada solusi.");
        } else {
            det = OBE.detOBE(m);
            det1 = 1;
            if(det==0){
            System.out.println("Determinan matriks bernilai 0 sehingga tidak dapat menggunakan kaidah Cramer.");
            } else{ //solusi unik
                    for(i=0; i<m.getCol()-1; i++){
                        m1.swapCol(i, m.getCol()-1);
                        det1 = OBE.detOBE(m1);
                        System.out.print("x"+ (i+1) + " = ");
                        System.err.printf("%.2f", det1/det);
                        System.out.println();
                        str.append("x"+ (i+1) + " = " + String.format("%.2f",det1/det)+"\n");                
                        m1 = m.copyMatrix();
                    }
                    Parser.printMatrixtoFile(str.toString());
            }
        }
    }
}
