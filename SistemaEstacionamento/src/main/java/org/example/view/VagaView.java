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
            System.out.println("1. Listar Vagas");
            System.out.println("2. Buscar Vaga por Número");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarVagas();
                    break;
                case 2:
                    buscarVagaPorNumero();
                    break;

            }
        } while (opcao != 0);
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

}