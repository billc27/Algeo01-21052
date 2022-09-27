package Primitif;

public class OBE {
    public static Matrix gaussJordan(Matrix m) {
        //Gauss
        Matrix m1;
        int i, j, k, l, p;
        double pembagi, pengali;
        m1 = m.copyMatrix();
        for (i=0; i<m1.rows; i++){
    
            // Mencari elemen bukan 0 pertama pada baris 1
            pembagi = 1;
            for (j=0; j<m1.cols; j++){
                if(m1.getElmt(i, j)!= 0){
                    pembagi = m1.getElmt(i, j);
                    break;
                }
            }
            if(j>=m1.cols){ //menghandle kasus baris 0
                j = 0;
            }
            // Membuat leading 1 pada baris;
            for (k=0; k<m.cols; k++){
                m1.setElmt(i, k, m1.getElmt(i, k)/pembagi);
            }

            // Membuat elemen di bawah leading 1 menjadi 0
            for (l = i + 1; l < m1.rows; l++) {

                pengali = m1.getElmt(l, j);
                for(p=0; p<m1.cols; p++){
                    m1.setElmt(l, p, m1.getElmt(l, p) - pengali*m1.getElmt(i, p));
                }
            }
            
            
        }
        // Gauss Jordan
        int a, b, c, d;
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
}
