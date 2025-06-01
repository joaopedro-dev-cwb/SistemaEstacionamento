package org.example;

import java.util.Scanner;

import org.example.controllers.EstacionamentoController;
import org.example.controllers.TicketController;
import org.example.controllers.VagaController;
import org.example.controllers.VeiculoController;
import org.example.util.Log;
import org.example.view.TicketView;
import org.example.view.VagaView;
import org.example.view.VeiculoView;

public class Main {

    public static void main(String[] args) {
        // Inicializar log de erros
        Log.setError();
        
        try {
            // Inicializar controllers
            EstacionamentoController estacionamentoController = new EstacionamentoController();
            VeiculoController veiculoController = new VeiculoController();
            TicketController ticketController = new TicketController();
            VagaController vagaController = new VagaController();

            // Inicializar views
            VeiculoView veiculoView = new VeiculoView(veiculoController);
            VagaView vagaView = new VagaView(vagaController); // Sem parâmetros
            TicketView ticketView = new TicketView(ticketController);

            // Criar estacionamento padrão se não existir
            if (estacionamentoController.estacionamento == null) {
                estacionamentoController.cadastrarEstacionamento(
                        "Estacionamento Central",
                        20,
                        "Av. Principal, 123",
                        "(11) 9876-5432",
                        "contato@estacionamento.com.br"
                );
                System.out.println("Estacionamento padrão criado com sucesso!");
            }

            // Inicializar scanner para input do usuário
            Scanner scanner = new Scanner(System.in);

            // Loop principal do menu
            int opcao;
            do {
                try {
                    exibirMenuPrincipal();
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha

                    switch (opcao) {
                        case 1:
                            gerenciarEstacionamento(estacionamentoController, scanner);
                            break;
                        case 2:
                            veiculoView.menu();
                            break;
                        case 3:
                            vagaView.menu();
                            break;
                        case 4:
                            ticketView.menu();
                            break;
                        case 5:
                            gerenciarPagamentos(scanner);
                            break;
                        case 0:
                            System.out.println("Saindo do sistema...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } catch (Exception e) {
                    System.err.println("Erro no menu principal: " + e.getMessage());
                    scanner.nextLine(); // Limpar buffer em caso de erro
                    opcao = -1; // Continuar no loop
                }
            } while (opcao != 0);

            scanner.close();
        } catch (Exception e) {
            System.err.println("Erro crítico na inicialização do sistema: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    private static void gerenciarEstacionamento(EstacionamentoController controller, Scanner scanner) {
        try {
            System.out.println("\n--- Gerenciamento de Estacionamento ---");
            System.out.println("1. Ver informações do estacionamento");
            System.out.println("2. Atualizar informações do estacionamento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (controller.estacionamento != null) {
                        System.out.println(controller.estacionamento);
                    } else {
                        System.out.println("Estacionamento não configurado!");
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Número de vagas: ");
                    int vagas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    controller.cadastrarEstacionamento(nome, vagas, endereco, telefone, email);
                    System.out.println("Informações atualizadas com sucesso!");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Erro ao gerenciar estacionamento: " + e.getMessage());
            scanner.nextLine(); // Limpar buffer em caso de erro
        }
    }

    private static void gerenciarPagamentos(Scanner scanner) {
        try {
            System.out.println("\n--- Gerenciamento de Pagamentos ---");
            System.out.println("Funcionalidade em desenvolvimento...");
            System.out.println("Pressione ENTER para continuar");
            scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Erro ao gerenciar pagamentos: " + e.getMessage());
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=================================");
        System.out.println("  SISTEMA DE ESTACIONAMENTO");
        System.out.println("=================================");
        System.out.println("1. Gerenciar Estacionamento");
        System.out.println("2. Gerenciar Veículos");
        System.out.println("3. Gerenciar Vagas");
        System.out.println("4. Gerenciar Tickets");
        System.out.println("5. Gerenciar Pagamentos");
        System.out.println("0. Sair");
        System.out.println("=================================");
        System.out.print("Escolha uma opção: ");
    }
}
