// package com.logsystem.chain;

import com.logsystem.model.LogMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WarningHandler implements LogHandler {
    private LogHandler next;
    private static final String FILE_PATH = "logs/warnings.log";

    public WarningHandler() {
        // Garante que o diretório "logs" exista
        new File("logs").mkdirs();
    }

    @Override
    public void setNext(LogHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void processarLog(LogMessage log) {
        if ("WARNING".equals(log.getNivel())) {
            // Escreve no arquivo de log
            try (FileWriter fw = new FileWriter(FILE_PATH, true);
                    PrintWriter pw = new PrintWriter(fw)) {

                pw.println(log.toString());
                System.out.println("ARQUIVO (WARNING): Log escrito em " + FILE_PATH);

            } catch (IOException e) {
                System.err.println("Falha ao escrever log de WARNING: " + e.getMessage());
            }
        } else if (next != null) {
            next.processarLog(log);
        }
    }
}