package org.example.factory;

import org.example.Enum.StatusVaga;
import org.example.model.Vaga;

public abstract class VagaFactory {

    public static Vaga criarVaga(int numero, StatusVaga status)throws Exception {
        try{
            return new Vaga(numero, status);
        } catch (Exception e) {
            System.err.println("[Factory] Erro ao criar vaga: " + e.getMessage());
            throw new Exception("Erro ao criar vaga: " + e.getMessage(), e);
        }
    }
}
