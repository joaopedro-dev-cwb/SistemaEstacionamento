package org.example.controllers;

import org.example.factory.EstacionamentoFactory;
import org.example.model.Carro;
import org.example.model.Estacionamento;
import org.example.model.Moto;
import org.example.model.Vaga;

public class EstacionamentoController {

    public Estacionamento estacionamento;

    public void cadastrarEstacionamento(String nome, int numeroDeVagas, String endereco, String telefone, String email) throws Exception, IllegalStateException {
        if (estacionamento != null) {
            throw new IllegalStateException("Estacionamento já cadastrado.");
        }
        
        try {
            estacionamento = EstacionamentoFactory.criarEstacionamento(nome, numeroDeVagas, endereco, telefone, email);
        } catch (Exception e) {
            System.err.println("[Controller] Erro inesperado ao cadastrar estacionamento: " + e.getMessage());
            throw new Exception("Erro ao cadastrar estacionamento: " + e.getMessage(), e);
        }
        
    }

    public String alocarCarro(Carro carro) throws Exception {
        Vaga vaga = estacionamento.getVagas().stream()
                .filter(Vaga::estaDisponivel).findFirst().orElse(null);

        if (vaga != null) {
            vaga.alterarDisponibilidade(false);
            carro.setIdVaga(vaga.getNumero());
            return "Carro alocado com sucesso!";

        } else {
            System.err.println("[Controller] Erro inesperado sem vagas: ");
            throw new Exception("Sem vagas disponiveis");
        }
    }

    public String alocarMoto(Moto moto) throws Exception {
        Vaga vaga = estacionamento.getVagas().stream()
                .filter(Vaga::estaDisponivelParaMoto)
                .findFirst()
                .orElse(null);
        if (vaga != null) {
            vaga.alterarDisponibilidadeMoto(false);
        }
        if (vaga == null) {
            vaga = estacionamento.getVagas().stream()
                    .filter(Vaga::estaDisponivel).findFirst().orElse(null);
            vaga.alterarDisponibilidadeMoto(true);
            vaga.alterarDisponibilidade(false);
        }
        if (vaga != null) {
            return "Moto alocada com sucesso!";
        } else {
            System.err.println("[Controller] Erro inesperado sem vagas disponiveis: ");
            throw new Exception("Sem vagas disponíveis.");
        }
    }
}


