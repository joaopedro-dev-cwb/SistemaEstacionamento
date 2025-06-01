package org.example.factory;

import org.example.Enum.StatusVaga;
import org.example.model.Vaga;

public abstract class VagaFactory {

    public static Vaga criarVaga(int numero, StatusVaga status) {
        return new Vaga(numero, status);
    }
}
