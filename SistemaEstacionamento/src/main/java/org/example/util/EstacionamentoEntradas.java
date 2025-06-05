package org.example.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EstacionamentoEntradas {

    private static final String LOG_DIR = "EstacionamentoEntradas";
    private static final String LOG_FILE = LOG_DIR + "/entradas.txt";
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void registrarEntrada(String placa) {
        try {
            // Criar diretório se não existir
            File logDir = new File(LOG_DIR);
            if (!logDir.exists()) {
                logDir.mkdir();
            }

            // Escrever entrada no arquivo
            try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
                String registro = "[" + LocalDateTime.now().format(DTF) + "] Veículo: " + placa;
                writer.write(registro + System.lineSeparator());
                System.out.println("Entrada registrada: " + registro);
            }
        } catch (IOException e) {
            System.err.println("Erro ao registrar entrada: " + e.getMessage());
        }
    }
}

