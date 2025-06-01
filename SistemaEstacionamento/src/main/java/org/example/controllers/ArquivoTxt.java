package org.example.controllers;

import org.example.model.Veiculo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTxt {

    public static void salvarVeiculo(String caminho, List<String> alunos)
            throws IOException {

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            for (String aluno : alunos) {
                escritor.write(aluno);
                escritor.newLine();
            }
        }
    }

    public List<Veiculo> lerAlunos(String caminho) throws IOException, IllegalArgumentException {
        List<Veiculo> lista = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(",");
                lista.add(Veiculo.criarVeiculo(campos[0]), Float.parseFloat(campos[1]));
            }
        }

    }
}
