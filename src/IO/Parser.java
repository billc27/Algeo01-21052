package IO;

import Primitif.Matrix;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
// import java.util.logging.Level;
// import java.util.logging.Logger;

public class Parser {
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
        try{
            PrintWriter writer =  new PrintWriter(folder);
            String[] textlines = text.split("\n");
            for (String textline : textlines){
                writer.println(textline);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak dapat disimpan");
        }
    }
}
