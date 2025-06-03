package org.example;

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
        // Inicializar log de erros
        Log.setError();
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Inicializar controllers
            EstacionamentoController estacionamentoController = new EstacionamentoController();
            VeiculoController veiculoController = new VeiculoController();
            TicketController ticketController = new TicketController();
            VagaController vagaController = new VagaController();
            PagamentoController pagamentoController = new PagamentoController();
            
            // Configurar relacionamentos entre controllers
            vagaController.setVagas(estacionamentoController.estacionamento != null ? 
                                   estacionamentoController.estacionamento.getVagas() : null);

            // Inicializar views
            VeiculoView veiculoView = new VeiculoView(veiculoController);
            VagaView vagaView = new VagaView(vagaController);
            EstacionamentoView estacionamentoView = new EstacionamentoView(estacionamentoController, veiculoController);
            TicketView ticketView = new TicketView(ticketController, veiculoController, vagaController);
            PagamentoView pagamentoView = new PagamentoView(pagamentoController, ticketController);
            
            // Menu principal
            int opcao;
            do {
                System.out.println("\n=== SISTEMA DE ESTACIONAMENTO ===");
                System.out.println("1. Gerenciar Estacionamento");
                System.out.println("2. Gerenciar Veículos");
                System.out.println("3. Gerenciar Vagas");
                System.out.println("4. Gerenciar Tickets");
                System.out.println("5. Gerenciar Pagamentos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                
                switch (opcao) {
                    case 1:
                        estacionamentoView.menuEstacionamento();
                        // Atualizar as vagas no controller após possíveis mudanças
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
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
            
        } catch (Exception e) {
            System.out.println("Erro no sistema: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
