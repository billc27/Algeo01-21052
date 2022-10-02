import java.io.*;
import java.util.*;
import java.lang.Math;
import IO.*;
import Primitif.*;

public class Main {
    static Matrix m = new Matrix(20, 20); // BIAR MAX SIZE NYA 20 SEMENTARA

    static Scanner sc = new Scanner(System.in);
// ********************* TAMPILAN MENU UTAMA BIAR CAKEP ***********************
    public static void mainMenu() {
        System.out.println("============== MAIN MENU ===============");
        System.out.println("1. Sistem Persamaan Linear");
        System.out.println("2. Determinan Matriks");
        System.out.println("3. Matrix Balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic");
        System.out.println("6. Regresi Linear Berganda");
        System.out.println("7. Exit Program");
    }

    public static void subMenuSPL() {
        System.out.println("============= SUB MENU SPL =============");
        System.out.println("1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Eliminasi Gauss-Jordan");
        System.out.println("3. Metode Matriks Balikan");
        System.out.println("4. Kaidah Cramer");
    }

    public static void subMenuDet() {
        System.out.println("============= SUB MENU DET =============");
        System.out.println("1. Metode Ekspansi Kofaktor");
        System.out.println("2. Metode OBE");
    }

    public static void subMenuInv() {
        System.out.println("============= SUB MENU INV =============");
        System.out.println("1. Metode Adjoint");
        System.out.println("2. Metode Identitas/Gauss");
    }
    // ***************************** TAMPILAN PER MENU *****************************

    public static void SPLmenu() throws IOException {
        subMenuSPL();
        int input;
        boolean run = true;
        Matrix m = new Matrix(20, 20);
        while (run) {
            System.out.print("Masukkan angka menu(1-4): ");
            input = sc.nextInt();
            System.out.println();
            switch (input) {
                case 1:
                    run = false;
                    m = Parser.input(false);
                    break;
                case 2:
                    run = false;
                    m = Parser.input(false);
                    break;
                case 3:
                    run = false;
                    m = Parser.input(false);
                    SolveSPL.inverseMethod(m);
                    break;
                case 4:
                    run = false;
                    m = Parser.input(false);
                    break;
                default:
                    System.out.println("Input " + input + " tidak valid. Silahkan masukan input yang valid.");
            }
        }
    }

    public static void invMenu() throws IOException {
        subMenuInv();
        int input, i, j;
        boolean run = true;
        Matrix m = new Matrix(20, 20), mOut = new Matrix(20, 20);
        while (run) {
            System.out.print("Masukkan angka menu(1-2): ");
            input = sc.nextInt();
            System.out.println();
            switch (input) {
                case 1:
                    m = Parser.input(true);
                    mOut = MatrixOp.inversAdj(m);
                    if (mOut == null) {
                        System.out.println("Matriks tidak memiliki balikan");
                    } else {
                        boolean out = Parser.printMethod();
                        if (out == true) {
                            System.out.println("Matrix Invers:");
                            mOut.displayMatrix();
                        } else {
                            String temp = Parser.matToStr(mOut);
                            Parser.printMatrixtoFile(temp);
                        }
                    }
                    run = false;
                    break;
                case 2:
                    m = Parser.input(true);
                    mOut = MatrixOp.inversId(m);
                    if (mOut == null) {
                        System.out.println("Matriks tidak memiliki balikan");
                    } else {
                        boolean out = Parser.printMethod();
                        if (out == true) {
                            System.out.println("Matrix Invers:");
                            mOut.displayMatrix();
                        } else {
                            String temp = Parser.matToStr(mOut);
                            Parser.printMatrixtoFile(temp);
                        }
                    }
                    run = false;
                    break;
                default:
                    System.out.println("Input " + input + " tidak valid. Silahkan masukan input yang valid.");
            }
        }
    }
    
    public static void detMenu() throws IOException {
        subMenuDet();
        int input, i, j;
        boolean run = true;
        Matrix m = new Matrix(20, 20), mOut = new Matrix(20, 20);
        while (run) {
            System.out.print("Masukkan angka menu(1-2): ");
            input = sc.nextInt();
            System.out.println();
            switch (input) {
                case 1:
                    m = Parser.input(true);
                    // pake fungsi det ekspansi
                    run = false;
                    break;
                case 2:
                    m = Parser.input(true);
                    // pake fungsi det obe
                    run = false;
                    break;
                default:
                    System.out.println("Input " + input + " tidak valid. Silahkan masukan input yang valid.");
            }
        }
    }

    public static void interpolasiMenu() {

    }
    
    public static void bicubicMenu() throws IOException {
        System.out.println("============= BICUBIC MENU =============");
        m = Parser.input(true);
        int input;
        double hasil, x, y;
        boolean run = true;
        System.out.println("Taksir nilai Fungsi");
        while (run){
            System.out.print("Masukkan titik x: ");
            x = sc.nextDouble();
            System.out.print("Masukkan titik y: ");
            y = sc.nextDouble();

            hasil = Bicubic.bicubic(m, x, y);
            System.out.printf("Hasil f(%.2f ,%.2f) = %.2f\n",x,y,hasil);
            System.out.println("Apakah ingin mengecek hasil taksiran fungsi lain?");
            System.out.println("1. Ya");
            System.out.println("2. Tidak");
            System.out.print("Masukkan angka menu(1-2): ");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    continue;
                case 2:
                    run = false;
                    break;
                default:
                    System.out.println("Input " + input + " tidak valid. Silahkan masukan input yang valid.");
            }
        }
    }
    
    public static void regresiMenu() throws IOException {
        Regresi.matRegression();
    }
    public static void main(String[] args) throws IOException {
        invMenu();
    }   
}
