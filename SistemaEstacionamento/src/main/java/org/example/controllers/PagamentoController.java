package org.example.controllers;

import org.example.factory.PagamentoFactory;
import org.example.model.Moto;
import org.example.model.Pagamento;
import org.example.model.Ticket;
import org.example.model.Veiculo;

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
                if(ticket.getVeiculo().getClass() == Moto.class){
                    ticket.getVaga().alterarDisponibilidadeMoto(true);
                }else{
                    ticket.getVaga().alterarDisponibilidade(true);
                }
                return "pagamento criado com sucesso!";
            }
            return "pagamento nao criado!";
        } catch (IllegalFormatException e) {
            throw new Exception("Argumentos errados de pagamento" + e.getMessage());
        }

    }

    public String editarPagamentoPorID(int id)throws Exception{
        try {
            Pagamento pagamento = pagamentos.stream().filter(p -> p.getId() == id).findFirst().get();
            if (pagamento != null) {
                return "pagamento editado com sucesso!";
            }
            return "pagamento não encontrado";
        }catch (Exception e){
            throw new Exception("pagamento não encontrado" + e.getMessage());
        }
    }

    public List<String> listarPagamentos()  throws Exception{
        try{
            return pagamentos.stream().map(Pagamento::toString).toList();
        } catch (Exception e) {
            throw new Exception("Nenhum pagamento encontrado" + e.getMessage());
        }
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public String removerPagamentoPorId(int id) throws Exception{
        try {
            Pagamento pg = pagamentos.stream().filter(p -> p.getId() == id).findFirst().get();
            pagamentos.remove(pg);
            return "pagamento excluido com sucesso!";
        }
        catch (Exception e){
            throw new Exception("Nenhum pagamento encontrado" + e.getMessage());
        }
    }
}
