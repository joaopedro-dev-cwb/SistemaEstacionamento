package org.example.controllers;

import org.example.Enum.StatusVaga;
import org.example.factory.VagaFactory;
import org.example.model.Vaga;

import java.util.ArrayList;
import java.util.List;

public class VagaController {
    private static List<Vaga> vagas = new ArrayList<>();

    public static List<Vaga> criarVagas(int numeroDeVagas){
        for(int i = 1; i < numeroDeVagas; i++){
            vagas.add(VagaFactory.criarVaga(i, StatusVaga.LIVRE));
        }
        return vagas;
    }

}
