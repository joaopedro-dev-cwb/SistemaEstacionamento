package org.example.factory;

import org.example.controllers.VagaController;
import org.example.model.Estacionamento;
import org.example.model.Vaga;

import java.util.List;

public abstract class EstacionamentoFactory {

    public static Estacionamento criarEstacionamento(String nome, int numeroDeVagas, String endereco, String telefone, String email) {
        List<Vaga> vagas = fazerVagas(numeroDeVagas);
        Estacionamento estacionamento = new Estacionamento(nome, endereco, numeroDeVagas, telefone, email, vagas);
        return estacionamento;
    }

    public static List<Vaga> fazerVagas(int numeroDeVagas) {
        VagaController  vagaController = new VagaController();
        List<Vaga> vagasProntas = vagaController.criarVagas(numeroDeVagas);
        return vagasProntas;

    }

}
