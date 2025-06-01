package org.example.model;

import java.time.LocalDateTime;

public class Moto extends Veiculo {

    private static final double VALOR_HORA = 5.0;

    public Moto(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) {
        super(placa, modelo, cor, dataHoraEntrada);
    }

    @Override
    public double getValorPorHoras() {
        return VALOR_HORA;
    }

    @Override
    public String toString() {
        return "Moto{"
                + "placa='" + getPlaca() + '\''
                + ", modelo='" + getModelo() + '\''
                + ", cor='" + getCor() + '\''
                + ", dataHoraEntrada=" + getDataHoraEntrada()
                + '}';
    }
}
