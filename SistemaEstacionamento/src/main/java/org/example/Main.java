package org.example;

import java.util.InputMismatchException; // Importar esta classe
import java.util.Scanner;

import org.example.controllers.EstacionamentoController;
import org.example.controllers.PagamentoController;
import org.example.controllers.TicketController;
import org.example.controllers.VagaController;
import org.example.controllers.VeiculoController;
import org.example.util.Log;
import org.example.view.EstacionamentoView;
import org.example.view.PagamentoView;
import org.example.view.TicketView;
import org.example.view.VagaView;
import org.example.view.VeiculoView;

public class Main {

    public static void main(String[] args) {
        Log.setError();

        Scanner scanner = new Scanner(System.in);

        try {
            EstacionamentoController estacionamentoController = new EstacionamentoController();
            VeiculoController veiculoController = new VeiculoController();
            TicketController ticketController = new TicketController();
            VagaController vagaController = new VagaController();
            PagamentoController pagamentoController = new PagamentoController();

            vagaController.setVagas(estacionamentoController.estacionamento != null ?
                                    estacionamentoController.estacionamento.getVagas() : null);

                                    VeiculoView veiculoView = new VeiculoView(veiculoController);
            VagaView vagaView = new VagaView(vagaController);
            EstacionamentoView estacionamentoView = new EstacionamentoView(estacionamentoController, veiculoController);
            TicketView ticketView = new TicketView(ticketController, veiculoController, vagaController);
            PagamentoView pagamentoView = new PagamentoView(pagamentoController, ticketController);

            int opcao = -1;
            do {
                System.out.println("\n=== SISTEMA DE ESTACIONAMENTO ===");
                System.out.println("1. Gerenciar Estacionamento");
                System.out.println("2. Gerenciar Veículos");
                System.out.println("3. Gerenciar Vagas");
                System.out.println("4. Gerenciar Tickets");
                System.out.println("5. Gerenciar Pagamentos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                try {
                    opcao = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, digite um número.");
                    System.err.println("Erro de entrada de usuário: " + e.getMessage()); // Loga a mensagem específica para o usuário
                    e.printStackTrace(); // Garante que o stack trace vá para o log
                    scanner.nextLine(); // CONSUMIR A ENTRADA INVÁLIDA para evitar loop infinito
                    opcao = -1; // Define a opção como inválida para continuar o loop
                    continue; // Pula para a próxima iteração do loop do-while
                } finally {
                    scanner.nextLine();
                }


                switch (opcao) {
                    case 1:
                        estacionamentoView.menuEstacionamento();
                        if (estacionamentoController.estacionamento != null) {
                            vagaController.setVagas(estacionamentoController.estacionamento.getVagas());
                        }
                        break;
                    case 2:
                        veiculoView.menuVeiculo();
                        break;
                    case 3:
                        vagaView.menuVaga();
                        break;
                    case 4:
                        ticketView.menuTicket();
                        break;
                    case 5:
                        pagamentoView.menuPagamento();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida! Escolha um número entre 0 e 5.");
                }
            } while (opcao != 0);

        } catch (Exception e) { // Este catch pega qualquer outra exceção não tratada especificamente acima
            System.err.println("Um erro inesperado ocorreu no sistema principal: " + e.getMessage());
            System.err.println("Por favor, verifique o log de erros para mais detalhes.");
            e.printStackTrace(); // O stack trace completo irá para logs/erro.txt
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}