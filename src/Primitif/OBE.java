package Primitif;

public class OBE {
    public static Matrix gauss(Matrix mIn){ //menghasilkan matriks baru m1 berupa matriks eselon dari matriks m
        int i, j, k, l, p;
        double pembagi, pengali;
        Matrix mOut;
        mOut = mIn.copyMatrix();
        for (i=0; i<mOut.rows; i++){
    
            // Mencari elemen bukan 0 pertama pada baris 1
            pembagi = 1;
            for (j=0; j<mOut.cols; j++){
                if(mOut.getElmt(i, j)!= 0){
                    pembagi = mOut.getElmt(i, j);
                    break;
                }
            }
            if(j>=mOut.cols){ //menghandle kasus baris 0
                j = 0;
            }
            // Membuat leading 1 pada baris;
            for (k=0; k<mIn.cols; k++){
                mOut.setElmt(i, k, mOut.getElmt(i, k)/pembagi);
            }

            // Membuat elemen di bawah leading 1 menjadi 0
            for (l = i + 1; l < mOut.rows; l++) {

                pengali = mOut.getElmt(l, j);
                for(p=0; p<mOut.cols; p++){
                    mOut.setElmt(l, p, mOut.getElmt(l, p) - pengali*mOut.getElmt(i, p));
                }
            }      
        }
        // swap row
        int left;
        int row = 0;
        int iterate;

        for(iterate=0; iterate<mOut.getRow(); iterate++){
            left = mOut.getCol()-1;
            row = iterate;
            for(i=iterate; i<mOut.getRow(); i++){
                // finding most left leading one in the matrix
                j = 0;
                while(mOut.getElmt(i, j)==0 && j<mOut.getCol()-1){
                    j++;
                }
                
                if(left>j){
                    left = j;
                    row = i;
                }
            }
            mOut.swapRow(row, iterate);
        }
        return mOut;
    }
    public static void toEchelon(Matrix m){ //mengubah matriks m ke dalam bentuk eselon
        int i, j, k, l, p;
        double pembagi, pengali;
        for (i=0; i<m.rows; i++){
    
            // Mencari elemen bukan 0 pertama pada baris 1
            pembagi = 1;
            for (j=0; j<m.cols; j++){
                if(m.getElmt(i, j)!= 0){
                    pembagi = m.getElmt(i, j);
                    break;
                }
            }
            if(j>=m.cols){ //menghandle kasus baris 0
                j = 0;
            }
            // Membuat leading 1 pada baris;
            for (k=0; k<m.cols; k++){
                m.setElmt(i, k, m.getElmt(i, k)/pembagi);
            }

            // Membuat elemen di bawah leading 1 menjadi 0
            for (l = i + 1; l < m.rows; l++) {

                pengali = m.getElmt(l, j);
                for(p=0; p<m.cols; p++){
                    m.setElmt(l, p, m.getElmt(l, p) - pengali*m.getElmt(i, p));
                }
            }      
        }

        // swap row
        int left;
        int row = 0;
        int iterate;

        for(iterate=0; iterate<m.getRow(); iterate++){
            left = m.getCol()-1;
            row = iterate;
            for(i=iterate; i<m.getRow(); i++){
                // finding most left leading one in the matrix
                j = 0;
                while(m.getElmt(i, j)==0 && j<m.getCol()-1){
                    j++;
                }
                
                if(left>j){
                    left = j;
                    row = i;
                }
            }
            m.swapRow(row, iterate);
        }
    }
    public static Matrix gaussJordan(Matrix m) { //menghasilkan matriks baru m1 berupa matriks eselon tereduksi dari matriks m
        // Gauss
        int a, b, c, d;
        double pengali;
        Matrix m1;
        m1 = OBE.gauss(m);
        // Gauss Jordan
        // Membuat elemen di atas leading 1 menjadi 0
        for (a=m1.rows-1; a>0; a--){
            // Mencari leading 1 pada baris terakhir

            for (b = 0; b < m1.cols; b++) {
                if (m1.getElmt(a, b) != 0) {
                    break;
                }
            }

            if(b>=m1.cols){ //menghandle kasus baris 0
                b = 0;
            }

            // Membuat elemen di atas leading 1 menjadi 0
            for (c=a-1; c>=0; c--){
                pengali = m1.getElmt(c, b);
                for (d=0; d<m1.cols; d++){
                    m1.setElmt(c, d, m1.getElmt(c,d)-pengali*m1.getElmt(a, d));
                }
            }
        }
        return m1;
    }
    public static void toReducedEchelon(Matrix m) { ////mengubah matriks m ke dalam bentuk eselon tereduksi
        // Gauss
        int a, b, c, d;
        double pengali;
        toEchelon(m);
        // Gauss Jordan
        // Membuat elemen di atas leading 1 menjadi 0
        for (a=m.rows-1; a>0; a--){
            // Mencari leading 1 pada baris terakhir

            for (b = 0; b < m.cols; b++) {
                if (m.getElmt(a, b) != 0) {
                    break;
                }
            }

            if(b>=m.cols){ //menghandle kasus baris 0
                b = 0;
            }

            // Membuat elemen di atas leading 1 menjadi 0
            for (c=a-1; c>=0; c--){
                pengali = m.getElmt(c, b);
                for (d=0; d<m.cols; d++){
                    m.setElmt(c, d, m.getElmt(c,d)-pengali*m.getElmt(a, d));
                }
            }
        }
    }
    public static double detOBE(Matrix mIn){
        int i, j, k, l, p;
        double det; // berbeda dari gauss
        double pembagi, pengali;
        double peubah; // berbeda dari gauss
        Matrix mOut;
        mOut = mIn.copyMatrix();
        peubah = 1; // berbeda dari gauss
        for (i=0; i<mOut.rows; i++){
    
            // Mencari elemen bukan 0 pertama pada baris 1
            pembagi = 1;
            for (j=0; j<mOut.cols; j++){
                if(mOut.getElmt(i, j)!= 0){
                    pembagi = mOut.getElmt(i, j);
                    peubah = peubah * pembagi ; // berbeda dari gauss
                    break;
                }
            }
            if(j>=mOut.cols){ //menghandle kasus baris 0
                j = 0;
            }
            // Membuat leading 1 pada baris;
            for (k=0; k<mIn.cols; k++){
                mOut.setElmt(i, k, mOut.getElmt(i, k)/pembagi);
            }

            // Membuat elemen di bawah leading 1 menjadi 0
            for (l = i + 1; l < mOut.rows; l++) {

                pengali = mOut.getElmt(l, j);
                for(p=0; p<mOut.cols; p++){
                    mOut.setElmt(l, p, mOut.getElmt(l, p) - pengali*mOut.getElmt(i, p));
                }
            }      
        }
        // swap row
        int left;
        int row = 0;
        int iterate;

        for(iterate=0; iterate<mOut.getRow(); iterate++){
            left = mOut.getCol()-1;
            row = iterate;
            for(i=iterate; i<mOut.getRow(); i++){
                // finding most left leading one in the matrix
                j = 0;
                while(mOut.getElmt(i, j)==0 && j<mOut.getCol()-1){
                    j++;
                }
                
                if(left>j){
                    left = j;
                    row = i;
                }
            }
            mOut.swapRow(row, iterate);

            if(row != iterate){
                peubah = peubah*-1;
            }
        }

        det = 1;
        for(i=0; i < mOut.getRow(); i++){
            det = det * mOut.getElmt(i, i);
        }
        det = det * peubah;
        return det;
    }
}