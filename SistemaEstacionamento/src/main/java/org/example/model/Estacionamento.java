package org.example.model;

import java.util.List;

import org.example.controllers.VagaController;

public class Estacionamento {

    private String nome;
    private int numeroDeVagas;
    private List<Vaga> vagas;
    private String endereco;
    private String telefone;
    private String email;
    private VagaController vagaController;

    public Estacionamento(String nome, String endereco, int numeroDeVagas, String telefone, String email, List<Vaga> vagas, VagaController vagaController) {
        this.nome = nome;
        this.numeroDeVagas = numeroDeVagas;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.vagas = vagas;
        this.vagaController = vagaController;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }

    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public VagaController getVagaController() {
        return vagaController;
    }

    public void setVagaController(VagaController vagaController) {
        this.vagaController = vagaController;
    }

    @Override
    public String toString() {
        return "\nEstacionamento="
                + "\nemail:" + email
                + "\nnome:'" + nome
                + "\nnumeroDeVagas:" + numeroDeVagas
                + "\nendereco:" + endereco
                + "\ntelefone:" + telefone;
    }
}
