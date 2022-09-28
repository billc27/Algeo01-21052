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
        return mOut;
    }
    public static void toEchelon(Matrix m){ //mengubah matriks m ke dalam bentuk eselon
        // Matrix m1;
        // m1 = m.copyMatrix();
        // gauss(m, m1);
        int i, j, k, l, p;
        double pembagi, pengali;
        // m1 = m.copyMatrix();
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

        // m = m1.copyMatrix();
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
        // // SORT
        // int x, y;
        // int rowNow, colNow;
        // // double max; 
        // // for (x=0; x<m1.cols; x++){
        // //     max = m1.getElmt();
        // //     for (y=x; y<m1.rows; y++){
        // //         // holder = m1.getElmt(y, x);
        // //         // w = y-1;
        // //         // while(w>=0 && m1.getElmt(y,x)<holder){
        // //         //     m1.swapRow(w+1, w);
        // //         //     w--;
        // //         // }
        // //         max = m1.getElmt(x, y);
        // //     }
        // // }
        // rowNow = 0;
        // colNow = 0;

        // while(rowNow<m1.getRow()){
        //     for(y=colNow; y<m1.cols; y++){
        //         for(x=rowNow; x<m1.rows; x++){
        //             if(m1.getElmt(x, y)!= 0){
        //                 m1.swapRow(rowNow, x);
        //                 break;
        //             }
        //         }
        //         if(m1.getElmt(x, y)!= 0){
        //             rowNow++;
        //             colNow=y;
        //             break;
        //         }
                
        //     }
        // }
        

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
        // // SORT
        // int x, y;
        // int rowNow, colNow;
        // // double max; 
        // // for (x=0; x<m1.cols; x++){
        // //     max = m1.getElmt();
        // //     for (y=x; y<m1.rows; y++){
        // //         // holder = m1.getElmt(y, x);
        // //         // w = y-1;
        // //         // while(w>=0 && m1.getElmt(y,x)<holder){
        // //         //     m1.swapRow(w+1, w);
        // //         //     w--;
        // //         // }
        // //         max = m1.getElmt(x, y);
        // //     }
        // // }
        // rowNow = 0;
        // colNow = 0;

        // while(rowNow<m1.getRow()){
        //     for(y=colNow; y<m1.cols; y++){
        //         for(x=rowNow; x<m1.rows; x++){
        //             if(m1.getElmt(x, y)!= 0){
        //                 m1.swapRow(rowNow, x);
        //                 break;
        //             }
        //         }
        //         if(m1.getElmt(x, y)!= 0){
        //             rowNow++;
        //             colNow=y;
        //             break;
        //         }
                
        //     }
        // }

    }
}