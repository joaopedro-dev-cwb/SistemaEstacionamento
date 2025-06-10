package org.example.factory;

import java.time.LocalDateTime;

import org.example.model.Carro;
import org.example.model.Moto;
import org.example.model.Veiculo;

public abstract class VeiculoFactory {
    public static Veiculo criarCarro(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada)throws Exception {
        try{
            return new Carro(placa, modelo, cor, dataHoraEntrada);
        } catch (Exception e) {
            System.err.println("[Factory] Erro ao criar carro: " + e.getMessage());
            throw new Exception("Erro ao criar carro: " + e.getMessage(), e);
        }
    }

    public static Moto criarMoto(String placa, String modelo, String cor, LocalDateTime dataHoraEntrada)throws Exception {
        try{
            return new Moto(placa, modelo, cor, dataHoraEntrada);
        } catch (Exception e) {
            System.err.println("[Factory] Erro ao criar moto: " + e.getMessage());
            throw new Exception("Erro ao criar moto: " + e.getMessage(), e);
        }
    }
}
