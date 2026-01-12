package br.com.alura.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {

    public static Properties getProperties() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            props.load(file);
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de configuração: " + e.getMessage());
        }
        return props;
    }
}