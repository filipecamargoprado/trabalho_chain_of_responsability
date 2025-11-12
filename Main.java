// package com.logsystem;

import com.logsystem.chain.*;
import com.logsystem.model.LogMessage;

public class Main {

    /* * MÉTODO MAIN CORRIGIDO (Melhor Prática):
     * Mantém as referências para não depender da estrutura da cadeia.
     */
    public static void main(String[] args) {
        // 1. Criar os handlers
        LogHandler debug = new DebugHandler();
        InfoHandler info = new InfoHandler(); // Mantemos o tipo concreto aqui
        LogHandler warning = new WarningHandler();
        LogHandler error = new ErrorHandler();

        // 2. Configurar a cadeia: Debug -> Info -> Warning -> Error
        debug.setNext(info);
        info.setNext(warning);
        warning.setNext(error);

        LogHandler chain = debug; // O início da cadeia

        System.out.println("--- Enviando Lote de Logs ---");
        
        chain.processarLog(new LogMessage("DEBUG", "Conexão com banco de dados iniciada."));
        chain.processarLog(new LogMessage("INFO", "Usuário 'filipe' logado com sucesso."));
        chain.processarLog(new LogMessage("WARNING", "Uso de API obsoleta detectado."));
        chain.processarLog(new LogMessage("ERROR", "Falha crítica! O servidor não responde."));
        chain.processarLog(new LogMessage("INFO", "Pedido #12345 processado."));
        chain.processarLog(new LogMessage("FATAL", "Sistema sem memória."));

        System.out.println("\n--- Verificando Logs de INFO Armazenados ---");
        
        // Agora temos a referência direta!
        info.getInfoLogs().forEach(System.out::println);
    }
}