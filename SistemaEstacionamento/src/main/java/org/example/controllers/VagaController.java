package org.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.example.Enum.StatusVaga;
import org.example.factory.VagaFactory;
import org.example.model.Vaga;

public class VagaController {

    private static List<Vaga> vagas = new ArrayList<>();

    public static List<Vaga> criarVagas(int numeroDeVagas) {
        for (int i = 1; i < numeroDeVagas; i++) {
            vagas.add(VagaFactory.criarVaga(i, StatusVaga.LIVRE));
        }
        return vagas;
    }

    public static List<Vaga> listarVagas() {
        return vagas;
    }

    public static Vaga buscarVagaPorNumero(int numeroVaga) {
        for (Vaga vaga : vagas) {
            if (vaga.getNumero() == numeroVaga) {
                return vaga;
            }
        }
        return null;
    }

    public static void removerVaga(int numeroVaga) {
        Vaga vaga = buscarVagaPorNumero(numeroVaga);
        if (vaga != null) {
            vagas.remove(vaga);
        }
    }

}
