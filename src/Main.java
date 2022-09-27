import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
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
}
