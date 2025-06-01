package org.example.model;

import java.time.LocalDateTime;

public class Carro extends Veiculo {

    private static final double VALOR_HORA = 10.0;

    public Carro(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) {
        super(placa, modelo, cor);
    }

    @Override
    public double getValorPorHoras() {
        return VALOR_HORA;
    }

    @Override
    public String toString() {
        return "Carro{"
                + "placa='" + getPlaca() + '\''
                + ", modelo='" + getModelo() + '\''
                + ", cor='" + getCor() + '\''
                + ", dataHoraEntrada=" + getDataHoraEntrada()
                + '}';
    }
}
