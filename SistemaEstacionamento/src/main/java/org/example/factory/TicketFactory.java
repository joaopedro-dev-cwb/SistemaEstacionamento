package org.example.factory;

import org.example.model.Ticket;
import org.example.model.Vaga;
import org.example.model.Veiculo;

import java.time.LocalDateTime;

public class TicketFactory {
    public static Ticket criarTicket(int id, Veiculo veiculo, Vaga vaga, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, double valor) {
        return new Ticket(id, veiculo, vaga, dataHoraEntrada, dataHoraSaida, valor);

    }
}
