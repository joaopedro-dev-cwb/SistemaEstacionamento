package org.example.interfaces;

public interface Disponibilidade {

    boolean estaDisponivel();

    boolean estaDisponivelParaMoto();

    void alterarDisponibilidade(boolean disponivel);

    void alterarDisponibilidadeMoto(boolean disponivel);
}
