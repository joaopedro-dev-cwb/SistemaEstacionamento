package org.example.view;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.example.controllers.VeiculoController;
import org.example.model.Veiculo;

public class VeiculoView {

    private VeiculoController veiculoController;
    private Scanner scanner;

    public VeiculoView(VeiculoController veiculoController) {
        this.veiculoController = veiculoController;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Veículos ---");
            System.out.println("1. Cadastrar Carro");
            System.out.println("2. Cadastrar Moto");
            System.out.println("3. Listar Veículos");
            System.out.println("4. Buscar Veículo por Placa");
            System.out.println("5. Atualizar Veículo");
            System.out.println("6. Remover Veículo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    cadastrarMoto();
                    break;
                case 3:
                    listarVeiculos();
                    break;
                case 4:
                    buscarPorPlaca();
                    break;
                case 5:
                    atualizarVeiculo();
                    break;
                case 6:
                    removerVeiculo();
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarCarro() {
        try {
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Cor: ");
            String cor = scanner.nextLine();
            veiculoController.criarCarro(placa, modelo, cor, LocalDateTime.now());
            System.out.println("Carro cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar carro: " + e.getMessage());
        }
    }

    private void cadastrarMoto() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        veiculoController.criarMoto(placa, modelo, cor, LocalDateTime.now());
        System.out.println("Moto cadastrada com sucesso!");
    }

    private void listarVeiculos() {
        List<String> veiculos = veiculoController.listarVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
           veiculos.forEach(System.out::println);
        }
    }

    private void buscarPorPlaca() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = veiculoController.buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private void atualizarVeiculo() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Novo modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Nova cor: ");
        String cor = scanner.nextLine();
        Veiculo veiculo = veiculoController.atualizarVeiculo(placa, modelo, cor);
        if (veiculo != null) {
            System.out.println("Veículo atualizado!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private void removerVeiculo() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        veiculoController.removerVeiculo(placa);
        System.out.println("Veículo removido (se existia).");
    }
}