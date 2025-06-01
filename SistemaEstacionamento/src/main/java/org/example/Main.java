package org.example;

import java.time.LocalDateTime;

import org.example.controllers.EstacionamentoController;
import org.example.model.Carro;
import org.example.model.Moto;
import org.example.model.Vaga;

public class Main {

    public static void main(String[] args) {
        try {
            // Inicializar estacionamento
            EstacionamentoController controller = new EstacionamentoController();
            controller.cadastrarEstacionamento("Estacionamento Central", 10,
                    "Rua A, 123", "1234-5678", "contato@estacionamento.com");

            // Verificar vagas disponíveis inicialmente
            System.out.println("Vagas disponíveis inicialmente: "
                    + controller.estacionamento.getVagas().stream()
                            .filter(Vaga::estaDisponivel)
                            .count());

            // Criar veículos
            Carro carro = new Carro("ABC-1234", "Gol", "Prata", LocalDateTime.now());
            Moto moto1 = new Moto("XYZ-9876", "Honda", "Vermelha", LocalDateTime.now());
            Moto moto2 = new Moto("DEF-5678", "Yamaha", "Preta", LocalDateTime.now());

            // Alocar veículos
            System.out.println(controller.alocarCarro(carro));
            System.out.println(controller.alocarMoto(moto1));

            // Verificar vagas disponíveis para carros após alocação
            System.out.println("Vagas disponíveis para carros após alocação: "
                    + controller.estacionamento.getVagas().stream()
                            .filter(Vaga::estaDisponivel)
                            .count());

            // Verificar vagas disponíveis para motos após alocação
            System.out.println("Vagas disponíveis para motos após alocação: "
                    + controller.estacionamento.getVagas().stream()
                            .filter(Vaga::estaDisponivelParaMoto)
                            .count());

            // Tentar alocar mais uma moto
            System.out.println(controller.alocarMoto(moto2));

            // Liberar uma vaga ocupada
            Vaga vagaOcupada = controller.estacionamento.getVagas().get(0);
            vagaOcupada.alterarDisponibilidade(true);
            System.out.println("Vaga " + vagaOcupada.getNumero() + " liberada para qualquer veículo.");

            // Verificar novamente as vagas disponíveis
            System.out.println("Vagas disponíveis após liberação: "
                    + controller.estacionamento.getVagas().stream()
                            .filter(Vaga::estaDisponivel)
                            .count());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
