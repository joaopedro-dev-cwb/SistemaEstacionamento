package org.example.view;

import java.util.Scanner;

import org.example.controllers.EstacionamentoController;
import org.example.model.Carro;
import org.example.model.Moto;

public class EstacionamentoView {
    private EstacionamentoController estacionamentoController;
    private Scanner scanner;

    public EstacionamentoView(EstacionamentoController estacionamentoController) {
        this.estacionamentoController = estacionamentoController;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Estacionamento ---");
            System.out.println("1. Cadastrar Estacionamento");
            System.out.println("2. Alocar Carro");
            System.out.println("3. Alocar Moto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEstacionamento();
                    break;
                case 2:
                    alocarCarro();
                    break;
                case 3:
                    alocarMoto();
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarEstacionamento() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Número de vagas: ");
        int numeroDeVagas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        estacionamentoController.cadastrarEstacionamento(nome, numeroDeVagas, endereco, telefone, email);
        System.out.println("Estacionamento cadastrado com sucesso!");
    }

    private void alocarCarro() {
        try {
            // Supondo que o VeiculoView já coletou os dados e criou o objeto Carro
            System.out.print("Informe a placa do carro já cadastrado: ");
            String placa = scanner.nextLine();
            Carro carro = buscarCarroPorPlaca(placa); // Método utilitário para buscar o carro já cadastrado
            if (carro == null) {
                System.out.println("Carro não encontrado. Cadastre o veículo primeiro.");
                return;
            }
            String resultado = estacionamentoController.alocarCarro(carro);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao alocar carro: " + e.getMessage());
        }
    }

    private void alocarMoto() {
        try {
            // Supondo que o VeiculoView já coletou os dados e criou o objeto Moto
            System.out.print("Informe a placa da moto já cadastrada: ");
            String placa = scanner.nextLine();
            Moto moto = buscarMotoPorPlaca(placa); // Método utilitário para buscar a moto já cadastrada
            if (moto == null) {
                System.out.println("Moto não encontrada. Cadastre o veículo primeiro.");
                return;
            }
            String resultado = estacionamentoController.alocarMoto(moto);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao alocar moto: " + e.getMessage());
        }
    }

    // Métodos utilitários para buscar veículos já cadastrados
    private Carro buscarCarroPorPlaca(String placa) {
        // Implemente a busca no seu sistema de veículos cadastrados
        // Exemplo: return VeiculoController.buscarCarroPorPlaca(placa);
        return null;
    }

    private Moto buscarMotoPorPlaca(String placa) {
        // Implemente a busca no seu sistema de veículos cadastrados
        // Exemplo: return VeiculoController.buscarMotoPorPlaca(placa);
        return null;
    }
}
