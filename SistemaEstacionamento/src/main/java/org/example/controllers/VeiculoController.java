package org.example.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.example.dal.VeiculoDAO;
import org.example.factory.VeiculoFactory;
import org.example.model.Veiculo;

public class VeiculoController {

    static List<Veiculo> veiculos;

    public VeiculoController() {
        veiculos = new ArrayList<>();
    }

    public void criarCarro(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) throws Exception {
        veiculos.add(VeiculoFactory.criarCarro(placa, modelo, cor, dataHoraEntrada));
    }

    public void criarMoto(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada) {
        veiculos.add(VeiculoFactory.criarMoto(placa, modelo, cor, dataHoraEntrada));
    }

    public List<String> listarVeiculos(){
        return veiculos.stream().map(Veiculo::toString).toList();
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public static Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void removerVeiculo(String placa) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
        }
    }

    public Veiculo atualizarVeiculo(String placa, String modelo, String cor) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculo.setModelo(modelo);
            veiculo.setCor(cor);
        }
        return veiculo;
    }

    public void salvar() throws IOException, ClassNotFoundException {
        VeiculoDAO.salvar(veiculos);
    }

}
