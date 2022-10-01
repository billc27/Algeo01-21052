import java.io.*;
import java.util.*;
import java.lang.Math;
import IO.*;
import Primitif.*;

public class Main {
    static Matrix mUtama = new Matrix(20, 20); // BIAR MAX SIZE NYA 20 SEMENTARA

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
        System.out.println("============= SUB MENU DET =============");
        System.out.println("1. Metode Adjoint");
        System.out.println("2. Metode Identitas/Gauss");
    }
    // ***************************** TAMPILAN PER MENU *****************************

    public static void SPLmenu() {
        subMenuSPL();
        int input;
        boolean run = true;
        Matrix m = new Matrix(20, 20);
        while (run) {
            System.out.print("Masukkan angka menu(1-4): ");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    run = false;
                    break;
                case 2:
                    run = false;
                    break;
                case 3:
                    run = false;
                    m = Parser.inputMatrix();
                    SolveSPL.inverseMethod(m);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Input " + input + " tidak valid. Silahkan masukan input yang valid.");
            }
        }
    }
    public static void main(String[] args) {
        SPLmenu();
    }
    
}
