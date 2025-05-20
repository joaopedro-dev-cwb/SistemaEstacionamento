package org.example.model;

import java.time.LocalDateTime;

public class Carro extends Veiculo{
    public Carro(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) {
        super(placa, modelo, cor, dataHoraEntrada);

    }
}
