package org.example;

import org.example.controllers.ArquivoTxt;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        try {
            ArquivoTxt.salvarAlunos("veiculos.txt", controller.listarVeiculos());
        } catch (Exception e) {

        }

    }
}
