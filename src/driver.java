import Primitif.*;

import java.io.*;
import java.util.*;
import IO.*;

/**
13521052 Melvin Kent
13521064 Bill Clinton
13521100 Alexander Jason
*/
public class driver {
    static Scanner scanObj = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Matrix mnew = new Matrix(4, 4);
        mnew = Parser.readFiletoMatrix();
        mnew.displayMatrix();
        String temp = Parser.matToStr(mnew);
        String fileName, filePath;
        fileName = scanObj.nextLine();
        filePath = Parser.getPathOutput(fileName);
        Parser.strToFile(temp, filePath);
        System.out.println(temp);
        // File file = new File(filePath);
        
        // SolveSPL.inverseMethod(mnew);
        // Bicubic.inverseXmat().displayMatrix();
        // // System.out.println(mnew.isSegitigaAtas());
        // double val;
        // val = Bicubic.bicubic(mnew, 0.5, 0.5);
        // System.out.println(val);
    }
}
