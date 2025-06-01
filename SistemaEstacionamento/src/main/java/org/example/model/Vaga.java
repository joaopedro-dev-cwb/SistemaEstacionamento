package org.example.model;

import org.example.Enum.StatusVaga;
import org.example.interfaces.Disponibilidade;

public class Vaga implements Disponibilidade {

    private int numero;
    private StatusVaga status;

    public Vaga(int numero, StatusVaga status) {
        this.numero = numero;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public void setStatus(StatusVaga status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nVaga="
                + "\nnumero:" + numero
                + "\nstatus:" + status;
    }

    @Override
    public boolean estaDisponivel() {
        return status == StatusVaga.LIVRE;
    }

    @Override
    public boolean estaDisponivelParaMoto() {
        return status == StatusVaga.LIVRE || status == StatusVaga.LIVREMOTO;
    }

    @Override
    public void alterarDisponibilidade(boolean disponivel) {
        this.status = disponivel ? StatusVaga.LIVRE : StatusVaga.OCUPADA;
    }

    @Override
    public void alterarDisponibilidadeMoto(boolean disponivel) {
        if (disponivel) {
            // Se está sendo liberado para moto
            if (this.status == StatusVaga.OCUPADA) {
                this.status = StatusVaga.LIVREMOTO;
            } else {
                this.status = StatusVaga.LIVRE;
            }
        } else {
            // Se está sendo ocupado por moto
            if (this.status == StatusVaga.LIVRE) {
                this.status = StatusVaga.LIVREMOTO;
            } else {
                this.status = StatusVaga.OCUPADA;
            }
        }
    }
}
