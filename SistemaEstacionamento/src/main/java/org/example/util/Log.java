package org.example.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Log {

    public static void setError() {
        try {
            // Cria diretório de logs se não existir
            File logDir = new File("logs");
            logDir.mkdir();

            // Cria PrintWriter que adiciona data/hora no início de cada log
            PrintStream logErro = new PrintStream(new FileOutputStream("logs/erro.txt", true)) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                @Override
                public void println(String x) {
                    super.println("[" + LocalDateTime.now().format(dtf) + "] " + x);
                }
            };

            // Define o stream de erro do sistema
            System.setErr(logErro);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
