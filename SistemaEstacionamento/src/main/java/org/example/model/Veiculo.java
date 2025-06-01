package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Veiculo {

    private String placa;
    private String modelo;
    private String cor;
    private LocalDateTime dataHoraEntrada;

    public Veiculo(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    public void registrarEntrada() {
        this.dataHoraEntrada = LocalDateTime.now();
    }

    //no main lançar essa exeção
    public void registrarEntrada(String dataHoraTexto) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataHoraEntrada = LocalDateTime.parse(dataHoraTexto, formatter);
    }

    public abstract double getValorPorHoras();

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    @Override
    public String toString() {
        return "Veiculo="
                + "\ncor:'" + cor + '\''
                + "\nplaca='" + placa + '\''
                + "\nmodelo='" + modelo + '\''
                + "\ndataHoraEntrada=" + dataHoraEntrada;
    }
}
