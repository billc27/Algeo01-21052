import Primitif.Matrix;
import java.io.IOException;
import java.util.Scanner;

import IO.Parser;

public class Regresi {
    public static Matrix matRegression() throws IOException {
        int var, titik;
        Scanner scanreg = new Scanner(System.in);

        // Input banyak variabel peubah
        System.out.print("Masukkan jumlah variable peubah: ");
        var = scanreg.nextInt();

        // Input jumlah titik
        System.out.print("Masukkan jumlah titik yang ingin dimasukkan: ");
        titik = scanreg.nextInt();

        // Isi matrix
        Matrix mawal;
        mawal = new Matrix(titik, var + 1);
        int i, j;

        // Inisialisasi Matrix
        for (j = 0; j < mawal.getRow(); j++) {
            for (i = 0; i < mawal.getCol(); i++) {
                mawal.matrix[j][i] = 1;
            }
        }

        int pilihan;
        System.out.println("Pilihan: ");
        System.out.println("1. Read File ");
        System.out.println("2. Input Manual ");
        System.out.print("Masukkan pilihan: ");
        pilihan = scanreg.nextInt();

        while ((pilihan != 1) && (pilihan != 2)) {
            System.out.println("Input tidak valid. Silakan ulangi. ");
            System.out.println("Pilihan: ");
            System.out.println("1. Read File ");
            System.out.println("2. Input Manual ");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanreg.nextInt();
        }

        if (pilihan == 1) {
            mawal = Parser.readFiletoMatrix();
        } else {
            mawal = mawal.inputManualReg(mawal);
        }

        mawal = mawal.Transpose();
        Matrix mreg;
        mreg = new Matrix(var + 1, var + 2);
        
        for (i = 0; i < mreg.getRow(); i++) {
            for (j = 0; j < mreg.getCol(); j++) {
                if (i == 0) {
                    if (j == 0) {
                        mreg.matrix[i][j] = titik;
                    } else {
                        mreg.matrix[i][j] = mreg.countRow(mawal, titik, i, j);
                    }
                } else {
                    if (j == 0) {
                        mreg.matrix[i][j] = mreg.matrix[j][i];
                    } else {
                        mreg.matrix[i][j] = mreg.countRow(mawal, titik, i, j);
                    }
                }

            }
        }
        return mreg;
    }
}
