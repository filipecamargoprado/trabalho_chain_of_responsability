// package com.logsystem.chain;

import com.logsystem.model.LogMessage;

public class ErrorHandler implements LogHandler {
    private LogHandler next; // Será null, mas implementamos por consistência

    @Override
    public void setNext(LogHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void processarLog(LogMessage log) {
        if ("ERROR".equals(log.getNivel())) {
            // Simula o envio de e-mail
            System.out.println("E-MAIL (ERROR): Notificação de erro enviada!");
            System.out.println("-> Assunto: ERRO CRÍTICO no Sistema");
            System.out.println("-> Mensagem: " + log.getMensagem());
        } else if (next != null) {
            // Passa adiante (embora seja o fim da cadeia)
            next.processarLog(log);
        } else {
            System.out.println("LOG NÃO TRATADO: " + log);
        }
    }
}