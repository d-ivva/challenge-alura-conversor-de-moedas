package br.com.alura.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracao {

    public static Properties getProperties() {
        Properties props = new Properties();
        try {
            InputStream input = Configuracao.class.getResourceAsStream("/config.properties");
            
            if (input == null) {
                System.out.println("Desculpe, não consegui achar o arquivo config.properties!");
                return props;
            }

            props.load(input);
            input.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return props;
    }
}