package ru.ezhik;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Files {

    public static List<String> readFile(String vFileName) {
        List<String> arrayStr = new ArrayList();

        FileReader fr = null;
        try {
            fr = new FileReader(vFileName);
            Scanner scan = new Scanner(fr);

            while (scan.hasNextLine()) {
                arrayStr.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return arrayStr;
    }

    public static void writeFile(String vFileName, String vStr) {
        FileWriter nFile = null;
        try {
            nFile = new FileWriter(vFileName,true);
            nFile.write(vStr+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                nFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void cleanFile(String vFileName) {
        FileWriter nFile = null;
        try {
            nFile = new FileWriter(vFileName);
            nFile.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                nFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
