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
        Ticket ticket = TicketFactory.criarTicket(id, veiculo, vaga, dataHoraEntrada, dataHoraSaida, valor);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}