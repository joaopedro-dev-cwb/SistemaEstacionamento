package org.example.view;

import java.util.List;
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

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Pagamento ---");
            System.out.println("1. Realizar Pagamento");
            System.out.println("2. Editar Pagamento");
            System.out.println("3. Listar Pagamentos");
            System.out.println("4. Remover Pagamento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarPagamento();
                    break;
                case 2:
                    editarPagamento();
                    break;
                case 3:
                    listarPagamentos();
                    break;
                case 4:
                    removerPagamento();
                    break;
            }
        } while (opcao != 0);
    }

    private void realizarPagamento() {
        try {
            System.out.print("ID do ticket: ");
            int idTicket = scanner.nextInt();
            scanner.nextLine();
            Ticket ticket = ticketController.getTicketById(idTicket);
            if (ticket == null) {
                System.out.println("Ticket não encontrado.");
                return;
            }
            System.out.print("Valor: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Forma de pagamento: ");
            String forma = scanner.nextLine();
            String resultado = pagamentoController.pagar(ticket, valor, forma);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao realizar pagamento: " + e.getMessage());
        }
    }

    private void editarPagamento() {
        try {
            System.out.print("ID do pagamento: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            String resultado = pagamentoController.editarPagamentoPorID(id);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao editar pagamento: " + e.getMessage());
        }
    }

    private void listarPagamentos() {
        try {
            List<String> pagamentos = pagamentoController.listarPagamentos();
            if (pagamentos.isEmpty()) {
                System.out.println("Nenhum pagamento encontrado.");
            } else {
                pagamentos.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }
    }

    private void removerPagamento() {
        try {
            System.out.print("ID do pagamento: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            String resultado = pagamentoController.removerPagamentoPorId(id);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao remover pagamento: " + e.getMessage());
        }
    }
}