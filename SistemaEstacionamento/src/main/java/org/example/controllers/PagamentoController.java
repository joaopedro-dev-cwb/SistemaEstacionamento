package org.example.controllers;

import org.example.factory.PagamentoFactory;
import org.example.model.Pagamento;
import org.example.model.Ticket;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class PagamentoController {
    List<Pagamento> pagamentos;

    PagamentoController() {
        pagamentos = new ArrayList<Pagamento>();
    }

    public String pagar(Ticket ticket, double valor, String formaDePagamento) throws Exception {
        int id = 1;
        if(!pagamentos.isEmpty()){id = pagamentos.getLast().getId();}
        try{
            Pagamento pagamento = PagamentoFactory.criarPagamento(id, ticket, valor, formaDePagamento);
            pagamentos.add(pagamento);
            if(pagamento != null){

            }
            return "pagamento criado com sucesso!";
        } catch (IllegalFormatException e) {
            throw new Exception("Argumentos errados de pagamento" + e.getMessage());
        }

    }

}
