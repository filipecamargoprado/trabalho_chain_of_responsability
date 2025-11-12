// package com.logsystem.chain;

import com.logsystem.model.LogMessage;

public interface LogHandler {
    /**
     * Define o próximo handler na cadeia.
     * 
     * @param nextHandler O próximo handler.
     */
    void setNext(LogHandler nextHandler);

    /**
     * Processa ou passa o log para o próximo handler.
     * 
     * @param log A mensagem de log a ser processada.
     */
    void processarLog(LogMessage log);
}