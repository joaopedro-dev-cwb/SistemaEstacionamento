package org.example.factory;

import org.example.controllers.VagaController;
import org.example.model.Estacionamento;
import org.example.model.Vaga;

import java.util.List;

public abstract class EstacionamentoFactory {

    public static Estacionamento criarEstacionamento(String nome, int numeroDeVagas, String endereco, String telefone, String email) {
        VagaController vagaController = new VagaController();
        vagaController.criarVagas(numeroDeVagas);
        List<Vaga> vagas = vagaController.getVagas();
        Estacionamento estacionamento = new Estacionamento(nome, endereco, numeroDeVagas, telefone, email, vagas, vagaController);
        return estacionamento;
    }

}
