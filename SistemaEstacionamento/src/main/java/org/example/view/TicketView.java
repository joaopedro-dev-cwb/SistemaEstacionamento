package org.example.view;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.example.controllers.TicketController;
import org.example.controllers.VagaController;
import org.example.model.Ticket;
import org.example.model.Vaga;
import org.example.model.Veiculo;

public class TicketView {

    private TicketController ticketController;
    private Scanner scanner;

    public TicketView(TicketController ticketController) {
        this.ticketController = ticketController;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Tickets ---");
            System.out.println("1. Gerar Ticket");
            System.out.println("2. Listar Tickets");
            System.out.println("3. Buscar Ticket por ID");
            System.out.println("4. Atualizar Ticket");
            System.out.println("5. Remover Ticket");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerarTicket();
                    break;
                case 2:
                    listarTickets();
                    break;
                case 3:
                    buscarTicketPorId();
                    break;
                case 4:
                    atualizarTicket();
                    break;
                case 5:
                    removerTicket();
                    break;
            }
        } while (opcao != 0);
    }

    private void gerarTicket() {
        System.out.print("Placa do veículo: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = ticketController.getTickets().stream()
                .map(Ticket::getVeiculo)
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }
        System.out.print("ID da vaga: ");
        int idVaga = scanner.nextInt();
        scanner.nextLine();
        Vaga vaga = VagaController.buscarVagaPorNumero(idVaga);
        if (vaga == null) {
            System.out.println("Vaga não encontrada.");
            return;
        }
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        Ticket ticket = ticketController.gerarTicket(veiculo, vaga, valor);
        System.out.println("Ticket gerado: " + ticket);
    }

    private void listarTickets() {
        List<Ticket> tickets = ticketController.getTickets();
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket cadastrado.");
        } else {
            for (Ticket t : tickets) {
                System.out.println(t);
            }
        }
    }

    private void buscarTicketPorId() {
        System.out.print("ID do ticket: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Ticket ticket = ticketController.getTicketById(id);
        if (ticket != null) {
            System.out.println(ticket);
        } else {
            System.out.println("Ticket não encontrado.");
        }
    }

    private void atualizarTicket() {
        System.out.print("ID do ticket: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Ticket ticket = ticketController.getTicketById(id);
        if (ticket == null) {
            System.out.println("Ticket não encontrado.");
            return;
        }
        System.out.print("Nova placa do veículo: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = ticketController.getTickets().stream()
                .map(Ticket::getVeiculo)
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }
        System.out.print("ID da vaga: ");
        int idVaga = scanner.nextInt();
        scanner.nextLine();
        Vaga vaga = VagaController.buscarVagaPorNumero(idVaga);
        if (vaga == null) {
            System.out.println("Vaga não encontrada.");
            return;
        }
        System.out.print("Nova data/hora de entrada (yyyy-MM-ddTHH:mm): ");
        LocalDateTime entrada = LocalDateTime.parse(scanner.nextLine());
        System.out.print("Nova data/hora de saída (yyyy-MM-ddTHH:mm): ");
        LocalDateTime saida = LocalDateTime.parse(scanner.nextLine());
        System.out.print("Novo valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        boolean atualizado = ticketController.atualizarTicket(id, veiculo, vaga, entrada, saida, valor);
        if (atualizado) {
            System.out.println("Ticket atualizado!");
        } else {
            System.out.println("Erro ao atualizar ticket.");
        }
    }

    private void removerTicket() {
        System.out.print("ID do ticket: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean removido = ticketController.removerTicket(id);
        if (removido) {
            System.out.println("Ticket removido!");
        } else {
            System.out.println("Ticket não encontrado.");
        }
    }
}
