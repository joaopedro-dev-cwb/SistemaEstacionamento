package org.example.model;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private Veiculo veiculo;
    private Vaga vaga;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private double valor;

    Ticket(int id, Veiculo veiculo, Vaga vaga, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, double valor) {
        this.id = id;
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nTicket=" +
                "\ndataHoraEntrada:" + dataHoraEntrada +
                "\nid:" + id +
                "\nveiculo:" + veiculo +
                "\nvaga:" + vaga +
                "\ndataHoraSaida:" + dataHoraSaida +
                "\nvalor:" + valor;
    }
}
