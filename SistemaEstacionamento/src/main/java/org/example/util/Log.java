package org.example.util;

import java.io.File;
import java.io.PrintStream;

public abstract class Log {
    public static void setError(){
        try {
            File logDir = new File("logs");
            logDir.mkdir();

            PrintStream logErro = new PrintStream("logs/erro.txt");
            System.setErr(logErro);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
