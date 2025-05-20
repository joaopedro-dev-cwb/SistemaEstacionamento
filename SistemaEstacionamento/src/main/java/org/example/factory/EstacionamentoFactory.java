package org.example.factory;

import org.example.Enum.StatusVaga;
import org.example.Enum.TipoVaga;
import org.example.model.Estacionamento;

public abstract class EstacionamentoFactory {

    public static Estacionamento criarEstacionamento(String nome, int numeroDeVagas, String endereco, String telefone, String email){
        Estacionamento estacionamento = new Estacionamento(nome, endereco, numeroDeVagas, telefone, email);
        return estacionamento;
    }

}
