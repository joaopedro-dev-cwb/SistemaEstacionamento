package org.example.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.example.factory.TicketFactory;
import org.example.model.Ticket;
import org.example.model.Vaga;
import org.example.model.Veiculo;

public class TicketController {

    private List<Ticket> tickets;

    public TicketController() {
        this.tickets = new ArrayList<>();
    }

    public Ticket gerarTicket(Veiculo veiculo, Vaga vaga, double valor) {
        int id = 1;
        if (!tickets.isEmpty()) {
            id = tickets.get(tickets.size() - 1).getId() + 1;
        }
        LocalDateTime dataHoraEntrada = veiculo.getDataHoraEntrada();
        LocalDateTime dataHoraSaida = LocalDateTime.now();
        int horasTotais = dataHoraEntrada.getHour() - dataHoraSaida.getHour();

        Double valorTotal = valor * horasTotais;
        Ticket ticket = TicketFactory.criarTicket(id, veiculo, vaga, dataHoraEntrada, dataHoraSaida, valorTotal);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Ticket getTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public boolean atualizarTicket(int id, Veiculo veiculo, Vaga vaga, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, double valor) {
        Ticket ticket = getTicketById(id);
        if (ticket != null) {
            ticket.setVeiculo(veiculo);
            ticket.setVaga(vaga);
            ticket.setDataHoraEntrada(dataHoraEntrada);
            ticket.setDataHoraSaida(dataHoraSaida);
            ticket.setValor(valor);
            return true;
        }
        return false;
    }

    public boolean removerTicket(int id) {
        return tickets.removeIf(ticket -> ticket.getId() == id);
    }
}