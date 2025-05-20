package org.example.model;

import java.time.LocalDateTime;

public class Moto extends Veiculo{
    public Moto(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) {
        super(placa, modelo, cor, dataHoraEntrada);
    }
}
