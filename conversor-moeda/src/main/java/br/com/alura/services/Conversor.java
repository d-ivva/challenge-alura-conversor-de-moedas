package br.com.alura.services;

import br.com.alura.models.Moeda;

public class Conversor {

    public double converteMoeda(double valor, Moeda moeda) {
        return valor * moeda.conversion_rate();
}
}
