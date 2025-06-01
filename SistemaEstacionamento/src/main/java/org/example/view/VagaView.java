package org.example.view;

import java.util.List;
import java.util.Scanner;

import org.example.controllers.VagaController;
import org.example.model.Vaga;

public class VagaView {

    private Scanner scanner;

    public VagaView() {
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Vagas ---");
            System.out.println("1. Criar Vagas");
            System.out.println("2. Listar Vagas");
            System.out.println("3. Buscar Vaga por Número");
            System.out.println("4. Remover Vaga");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarVagas();
                    break;
                case 2:
                    listarVagas();
                    break;
                case 3:
                    buscarVagaPorNumero();
                    break;
                case 4:
                    removerVaga();
                    break;
            }
        } while (opcao != 0);
    }

    private void criarVagas() {
        System.out.print("Quantas vagas deseja criar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        List<Vaga> vagasCriadas = VagaController.criarVagas(quantidade); 
        System.out.println("Vagas criadas: ");
        for (Vaga vaga : vagasCriadas) {
            System.out.println(vaga);
        }
    }

    private void listarVagas() {
        List<Vaga> vagas = VagaController.listarVagas();
        if (vagas.isEmpty()) {
            System.out.println("Nenhuma vaga cadastrada.");
        } else {
            for (Vaga vaga : vagas) {
                System.out.println(vaga);
            }
        }
    }

    private void buscarVagaPorNumero() {
        System.out.print("Número da vaga: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        Vaga vaga = VagaController.buscarVagaPorNumero(numero);
        if (vaga != null) {
            System.out.println(vaga);
        } else {
            System.out.println("Vaga não encontrada.");
        }
    }

    private void removerVaga() {
        System.out.print("Número da vaga: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        VagaController.removerVaga(numero);
        System.out.println("Vaga removida (se existia).");
    }
}