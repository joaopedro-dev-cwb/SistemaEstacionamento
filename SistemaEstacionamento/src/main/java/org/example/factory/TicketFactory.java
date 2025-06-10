package org.example.factory;

import java.time.LocalDateTime;

import org.example.model.Ticket;
import org.example.model.Vaga;
import org.example.model.Veiculo;

public class TicketFactory {
    public static Ticket criarTicket(int id, Veiculo veiculo, Vaga vaga, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida, double valor)throws Exception {
        try {
            return new Ticket(id, veiculo, vaga, dataHoraEntrada, dataHoraSaida, valor);
        } catch (Exception e) {
            System.err.println("[Factory] Erro ao criar ticket: " + e.getMessage());
            throw new Exception("Erro ao criar ticket: " + e.getMessage(), e);
        }

    }
}
