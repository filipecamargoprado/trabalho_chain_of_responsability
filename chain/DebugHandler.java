// package com.logsystem.chain;

import com.logsystem.model.LogMessage;

public class DebugHandler implements LogHandler {
    private LogHandler next;

    @Override
    public void setNext(LogHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void processarLog(LogMessage log) {
        if ("DEBUG".equals(log.getNivel())) {
            // 1. Processa o log DEBUG
            System.out.println("CONSOLE (DEBUG): " + log);
        } else if (next != null) {
            // 2. Passa para o próximo
            next.processarLog(log);
        }
    }
}