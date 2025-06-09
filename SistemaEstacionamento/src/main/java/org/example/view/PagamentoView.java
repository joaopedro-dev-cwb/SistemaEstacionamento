package org.example.view;

import java.util.Scanner;

import org.example.controllers.PagamentoController;
import org.example.controllers.TicketController;
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
        do {
            System.out.println("\n--- Menu de Pagamentos ---");
            System.out.println("1. Realizar Pagamento");
            System.out.println("2. Listar Pagamentos");
            System.out.println("3. Editar Pagamento");
            System.out.println("4. Remover Pagamento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 ->
                    realizarPagamento();
                case 2 ->
                    listarPagamentos();
                case 3 ->
                    editarPagamento();
                case 4 ->
                    removerPagamento();
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void realizarPagamento() {
        try {
            System.out.print("ID do Ticket: ");
            int ticketId = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            Ticket ticket = ticketController.getTicketById(ticketId);
            if (ticket == null) {
                System.out.println("Ticket não encontrado!");
                return;
            }

            System.out.println("Ticket encontrado: " + ticket);
            System.out.print("Valor a pagar: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpar buffer

            System.out.print("Forma de pagamento (DINHEIRO, CARTAO_CREDITO, CARTAO_DEBITO, PIX): ");
            String formaPagamento = scanner.nextLine().toUpperCase();

            String resultado = pagamentoController.pagar(ticket, valor, formaPagamento);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao realizar pagamento: " + e.getMessage());
        }
    }

    private void listarPagamentos() {
        try {
            System.out.println("\nLista de Pagamentos:");
            pagamentoController.listarPagamentos().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }
    }

    private void editarPagamento() {
        try {
            System.out.print("ID do pagamento para editar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            String resultado = pagamentoController.editarPagamentoPorID(id);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao editar pagamento: " + e.getMessage());
        }
    }

    private void removerPagamento() {
        try {
            System.out.print("ID do pagamento para remover: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            String resultado = pagamentoController.removerPagamentoPorId(id);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao remover pagamento: " + e.getMessage());
        }
    }
}
