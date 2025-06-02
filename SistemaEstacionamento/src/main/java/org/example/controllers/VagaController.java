package org.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.example.Enum.StatusVaga;
import org.example.factory.VagaFactory;
import org.example.model.Vaga;

public class VagaController {

    private List<Vaga> vagas = new ArrayList<>();



    public  List<Vaga> criarVagas(int numeroDeVagas) {
        for (int i = 1; i <= numeroDeVagas; i++) {
            vagas.add(VagaFactory.criarVaga(i, StatusVaga.LIVRE));
        }
        return vagas;
    }

    public List<String> listarVagas() {
        return vagas.stream().map(Vaga::toString).toList();
    }

    public List<Vaga> getVagas(){
        return vagas;
    }


    public  Vaga buscarVagaPorNumero(int numeroVaga) {
        for (Vaga vaga : vagas) {
            if (vaga.getNumero() == numeroVaga) {
                return vaga;
            }
        }
        return null;
    }

    public void removerVaga(int numeroVaga) {
        Vaga vaga = buscarVagaPorNumero(numeroVaga);
        if (vaga != null) {
            vagas.remove(vaga);
        }
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

}
