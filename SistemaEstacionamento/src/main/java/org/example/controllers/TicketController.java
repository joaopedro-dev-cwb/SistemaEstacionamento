package org.example.controllers;

import org.example.factory.TicketFactory;
import org.example.model.Ticket;
import org.example.model.Vaga;
import org.example.model.Veiculo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketController {

    private List<Ticket> tickets;

    TicketController() {
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> gerarTicket(Veiculo veiculo) {
        int id = 1;
        if (!tickets.isEmpty()) {
            id = tickets.getLast().getId() + 1;
        }
        Vaga vaga = veiculo.;
        LocalDateTime dataHoraEntrada = veiculo.getDataHoraEntrada();
        Ticket ticket = TicketFactory.criarTicket(id, veiculo, vaga, dataHoraEntrada, LocalDateTime.now(), valor);
    }

}
