package org.example.factory;

import org.example.model.Pagamento;
import org.example.model.Ticket;

public class PagamentoFactory {
    public static Pagamento criarPagamento(int id, Ticket ticket,double valor, String formaPagamento) throws Exception{
        try{
            Pagamento pagamento = new Pagamento(id, ticket, valor, formaPagamento);
            return pagamento;
        }catch(Exception e){
            System.err.println("[Factory] Erro ao criar pagamento: " + e.getMessage());
            throw new Exception("Erro ao criar pagamento " + e.getMessage());
        }
    }
}
