// package com.logsystem.chain;

import com.logsystem.model.LogMessage;
import java.util.ArrayList;
import java.util.List;

public class InfoHandler implements LogHandler {
    private LogHandler next;
    private final List<LogMessage> infoLogs = new ArrayList<>();

    @Override
    public void setNext(LogHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void processarLog(LogMessage log) {
        if ("INFO".equals(log.getNivel())) {
            System.out.println("MEMÓRIA (INFO): Log armazenado.");
            infoLogs.add(log);
        } else if (next != null) {
            next.processarLog(log);
        }
    }

    // Método para cumprir o requisito de visualizar os logs
    public List<LogMessage> getInfoLogs() {
        return new ArrayList<>(infoLogs); // Retorna uma cópia
    }
}