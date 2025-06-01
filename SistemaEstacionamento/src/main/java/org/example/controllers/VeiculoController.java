package org.example.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.example.factory.VeiculoFactory;
import org.example.model.Veiculo;

public class VeiculoController {

    List<Veiculo> veiculos;

    public VeiculoController() {
        veiculos = new ArrayList<>();
    }

    public void criarCarro(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) throws Exception {
        veiculos.add(VeiculoFactory.criarCarro(placa, modelo, cor, dataHoraEntrada));
    }

    public void criarMoto(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) {
        veiculos.add(VeiculoFactory.criarMoto(placa, modelo, cor, dataHoraEntrada));
    }

}
