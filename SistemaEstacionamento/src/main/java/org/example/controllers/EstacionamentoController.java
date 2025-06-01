package org.example.controllers;

import org.example.Enum.StatusVaga;
import org.example.factory.EstacionamentoFactory;
import org.example.model.Carro;
import org.example.model.Estacionamento;
import org.example.model.Moto;
import org.example.model.Vaga;

import java.io.IOException;
import java.util.Optional;


public class EstacionamentoController {
    public Estacionamento estacionamento;

    public void cadastrarEstacionamento(String nome, int numeroDeVagas, String endereco, String telefone, String email) {
        estacionamento = EstacionamentoFactory.criarEstacionamento(nome, numeroDeVagas, endereco, telefone, email);
    }

    public String alocarCarro(Carro carro) throws Exception {
        Vaga vaga = estacionamento.getVagas().stream()
                .filter(v -> v.getStatus() == StatusVaga.LIVRE).findFirst().orElse(null);

        if (vaga != null) {
            vaga.setStatus(StatusVaga.OCUPADA);
            return "Carro alocado com sucesso!";
        } else {
            throw new Exception("Sem vagas disponiveis");
        }
    }

    public String alocarMoto(Moto moto) throws Exception {
        Vaga vaga = estacionamento.getVagas().stream()
                .filter(v -> v.getStatus() == StatusVaga.LIVREMOTO)
                .findFirst()
                .orElseGet(() -> estacionamento.getVagas().stream()
                        .filter(v -> v.getStatus() == StatusVaga.LIVRE)
                        .findFirst()
                        .orElse(null));

        if (vaga != null) {
            if (vaga.getStatus() == StatusVaga.LIVREMOTO) {
                vaga.setStatus(StatusVaga.OCUPADA);
            }
            if (vaga.getStatus() == StatusVaga.LIVRE) {
                vaga.setStatus(StatusVaga.LIVREMOTO);
            }
            return "Moto alocada com sucesso!";
        } else {
            throw new Exception("Sem vagas disponíveis.");
        }
    }
}
