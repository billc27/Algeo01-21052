package IO;

import Primitif.*;
import java.util.*;
import java.io.*;
// import java.util.logging.Level;
// import java.util.logging.Logger;

public class Parser {
    static Scanner sc = new Scanner(System.in);
    public int input;

    public static Matrix readFiletoMatrix() throws IOException{
        String fileName, filePath;
        boolean run = true;
        int row, col;
        Matrix m = new Matrix(0,0);

        while (run) {
            System.out.println("============== READ FILE ===============");
            System.out.print("Masukkan nama file lengkap dgn .txt = ");
            // sc.nextLine();
            fileName = sc.nextLine();
            filePath = getPathInput(fileName);
            File file = new File(filePath);
            if (file.exists()) {
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader buffReader = new BufferedReader(reader);

                    String line;
                    // int countRow;
                    row = 0;
                    col = 0;
                    while ((line = buffReader.readLine()) != null) {
                        if (row == 0) {
                            col = countCol(line);
                        }
                        row++;
                    }
                    m = new Matrix(row, col);
                    m = fileToMat(file);
                    reader.close();
                    run = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("File '"+ fileName+ "' tidak ada!");
            }
        }
        return m;
    }

    public static Integer countCol(String line){
        // Menghitung banyaknya kolom dapat menggunakan dengan menghitung banyaknya spasi
        // Setiap elemen berakhir maka terdapat spasi. Maka 1 spasi merepresentasikan 1 elemen.
        int len = line.length();
        int count = 0;
        int i;
        for (i = 0; i < len; i++){
            if (Character.isWhitespace(line.charAt(i))){
                count++;
            }
        }
        //(elemen terakhir belum terhitung).
        count++;

        return count;
    }
    public static String getPathInput(String fileName) {
        String filePath;
        String currentPath;

        currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);
        if (currentPath.contains("src")) {
            // jika currentPath user.dir berhenti hingga directory src
            currentPath = currentPath.replaceAll("src", "");
            // Menggabungkan currentPath dengan lokasi file
            filePath = currentPath + "test\\" + fileName;
        } else {
            filePath = currentPath + "\\test\\" + fileName;
        }

        return filePath;
    }
    public static String getPathOutput(String fileName){
        String filePath;
        String currentPath;

        currentPath = System.getProperty("user.dir");
        if (currentPath.contains("src")){
            currentPath = currentPath.replaceAll("src","");
            filePath = currentPath+"test\\"+ fileName;
        } else {
            filePath = currentPath+"\\test\\"+ fileName;
        }

        return filePath;
    }
    public static Matrix strToMat(String text) {
        String[] textline = text.split("\n");
        double[][] elmtMatrix = new double[textline.length][textline[0].split(" ").length];
        int i, j;
        for (i = 0; i < textline.length; i++) {
            String[] tempElmt = textline[i].split(" ");
            for (j = 0; j < tempElmt.length; j++) {
                elmtMatrix[i][j] = Double.parseDouble(tempElmt[j]);
            }
        }

        Matrix mOut = new Matrix(elmtMatrix.length, elmtMatrix[0].length);
        for (i = 0; i < elmtMatrix.length; i++) {
            for (j = 0; j < elmtMatrix[0].length; j++) {
                mOut.setElmt(i, j, elmtMatrix[i][j]);
            }
        }

        return mOut;
    }
    
    public static Matrix fileToMat(File text) {
        String temp = "";
        try {
            Scanner sc = new Scanner(text);
            while (sc.hasNextLine()) {
                temp = temp + sc.nextLine() + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        }
        return strToMat(temp);
    }
    
    public static void strToFile(String text, String folder) {
        try {
            PrintWriter writer = new PrintWriter(folder);
            String[] textlines = text.split("\n");
            for (String textline : textlines) {
                writer.println(textline);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak dapat disimpan");
        }
    }

    public static String matToStr(Matrix m) {
        final StringBuffer str = new StringBuffer();
        int i = 0, j = 0;
        for (i = 0; i < m.getRow(); i++) {
            for (j = 0; j < m.getCol(); j++) {
                str.append(" " + m.getElmt(i, j));
            }
            str.append("\n");
        }
        return str.toString();    
    }

     // PROCEDURE
    // Melakukan print matriks
    public void printMatrix(Matrix m){
        for (int i = 0; i < m.getRow(); i++){
            System.out.print("[");
            for (int j = 0; j < m.getCol(); j++){
                if ( j == m.getCol()-1) {
                    System.out.printf("%.2f", m.getElmt(i, j));
                } else {
                    System.out.printf("%.2f", m.getElmt(i, j));
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }

    // FUNCTION 
    // Menanyakan kepada user apakah ingin di print pada terminal atau pada text
    public boolean reqPrint() {
        boolean run = true;
        boolean text = false;
        int input;
        System.out.println("============== PRINT RESULT ===============");
        System.out.println("Pilih cara untuk menampilkan Output:");
        System.out.println("1. Print pada terminal ");
        System.out.println("2. Print pada file .txt ");
        while (run) {
            System.out.print("Masukkan angka saja (1-2): ");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    text = false;
                    run = false;
                case 2:
                    text = true;
                    run = false;
                default:
                System.out.println("Input " + input + " tidak valid. Silahkan masukan input yang valid.");
            }

        }

        return text;
    }

}
