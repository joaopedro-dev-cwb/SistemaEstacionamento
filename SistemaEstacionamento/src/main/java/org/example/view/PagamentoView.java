package org.example.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.example.controllers.PagamentoController;
import org.example.controllers.TicketController;
import org.example.dal.PagamentoDAO;
import org.example.model.Pagamento;
import org.example.model.Ticket;

public class PagamentoView {

    private PagamentoController pagamentoController;
    private TicketController ticketController;
    private Scanner scanner;

    public PagamentoView(PagamentoController pagamentoController, TicketController ticketController) {
        this.pagamentoController = pagamentoController;
        this.ticketController = ticketController;
        this.scanner = new Scanner(System.in);
    }

    public void menuPagamento() {
        int opcao;

        List<Pagamento> lista = new ArrayList<>();
        try {
            lista = PagamentoDAO.carregar();
        } catch (Exception e){
            System.err.println("Erro ao carregar a lista " + e.getMessage());
        }

        do {
            exibirMenuPagamento();
            opcao = lerOpcao();
            
            try {
                executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    // Novo método para exibir o menu (similar ao VeiculoView)
    private void exibirMenuPagamento() {
        System.out.println("\n--- Menu de Pagamentos ---");
        System.out.println("1. Realizar Pagamento");
        System.out.println("2. Listar Pagamentos");
        System.out.println("3. Editar Pagamento");
        System.out.println("4. Remover Pagamento");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    // Novo método para ler a opção com tratamento de InputMismatchException (similar ao VeiculoView)
    private int lerOpcao() {
        int opcao;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, digite um número para a opção.");
            System.err.println("[PagamentoView] Erro de entrada de usuário em lerOpcao: " + e.getMessage());
            e.printStackTrace(); // Envia para o log
            return -1; // Retorna um valor inválido para manter o loop
        } finally {
            scanner.nextLine(); // Limpar buffer sempre, seja sucesso ou falha
        }
        return opcao;
    }

    // Novo método para executar a opção (similar ao VeiculoView)
    private void executarOpcao(int opcao) throws Exception { // Mantém 'throws Exception' para que o try-catch em menuPagamento possa pegar
        switch (opcao) {
            case 1 -> realizarPagamento();
            case 2 -> listarPagamentos();
            case 3 -> editarPagamento();
            case 4 -> removerPagamento();
            case 0 -> {
                try {
                    pagamentoController.salvar();
                } catch (Exception e) {
                    System.err.println("[PagamentoView] Erro ao salvar lista de pagamentos ao sair: " + e.getMessage());
                    e.printStackTrace(); // Envia para o log
                } finally {
                    System.out.println("Voltando ao menu principal...");
                }
            }
            default -> System.out.println("Opção inválida! Escolha um número entre 0 e 4.");
        }
    }

    private void realizarPagamento() {
        System.out.println("\n--- Realizar Pagamento ---");
        try {
            System.out.print("ID do Ticket: ");
            int ticketId = scanner.nextInt();
            
            scanner.nextLine(); // Limpar buffer

            Ticket ticket = ticketController.getTicketById(ticketId);
            if (ticket == null) {
                System.out.println("❌ Ticket não encontrado!");
                System.err.println("[PagamentoView] Tentativa de pagamento com ticket inexistente: ID " + ticketId);
                return;
            }
            
            System.out.println("Ticket encontrado: " + ticket.toString());
            System.out.print("Valor a pagar: ");
            double valor = scanner.nextDouble();
            
            scanner.nextLine(); // Limpar buffer

            System.out.print("Forma de pagamento (DINHEIRO, CARTAO_CREDITO, CARTAO_DEBITO, PIX): ");
            String formaPagamento = scanner.nextLine().toUpperCase();

            String resultado = pagamentoController.pagar(ticket, valor, formaPagamento);
            System.out.println(resultado);
            System.out.println("[PagamentoView] Pagamento realizado para ticket ID " + ticketId);

        } catch (IllegalArgumentException e) {
            System.err.println("[PagamentoView] IllegalArgumentException em realizarPagamento: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("[PagamentoView] Exceção geral em realizarPagamento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void listarPagamentos() {
        System.out.println("\n--- Lista de Pagamentos ---");
        try {
            List<String> pagamentos = pagamentoController.listarPagamentos();
            if (pagamentos.isEmpty()) {
                System.out.println("Não há pagamentos registrados.");
            } else {
                pagamentos.forEach(System.out::println);
            }
            System.out.println("[PagamentoView] Listagem de pagamentos concluída.");
        } catch (Exception e) {
            System.err.println("[PagamentoView] Erro interno ao listar pagamentos: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    private void editarPagamento() {
        System.out.println("\n--- Editar Pagamento ---");
        try {
            System.out.print("ID do pagamento para editar: ");
            int id = scanner.nextInt();
            
            scanner.nextLine(); // Limpar buffer

            String resultado = pagamentoController.editarPagamentoPorID(id);
            System.out.println(resultado);
        } catch (InputMismatchException e) {
            System.err.println("[PagamentoView] Entrada inválida (InputMismatchException) em editarPagamento: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("[PagamentoView] IllegalArgumentException em editarPagamento: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("[PagamentoView] Exceção geral em editarPagamento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void removerPagamento() {
        System.out.println("\n--- Remover Pagamento ---");
        try {
            System.out.print("ID do pagamento para remover: ");
            int id = scanner.nextInt();
            
            scanner.nextLine(); // Limpar buffer

            String resultado = pagamentoController.removerPagamentoPorId(id);
            System.out.println(resultado);
            System.out.println("[PagamentoView] Tentativa de remoção para pagamento ID " + id);

        } catch (InputMismatchException e) {
            System.err.println("[PagamentoView] Entrada inválida (InputMismatchException) em removerPagamento: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("[PagamentoView] IllegalArgumentException em removerPagamento: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("[PagamentoView] Exceção geral em removerPagamento: " + e.getMessage());
            e.printStackTrace();
        }
    }
}