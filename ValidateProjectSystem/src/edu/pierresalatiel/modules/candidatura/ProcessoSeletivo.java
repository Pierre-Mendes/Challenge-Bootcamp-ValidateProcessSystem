package edu.pierresalatiel.modules.candidatura;

import edu.pierresalatiel.modules.input_output.CandidatosInputOutput;
import edu.pierresalatiel.modules.interfaces.ProcessoSeletivoInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessoSeletivo {

    private static final int NUMERO_DE_CANDIDATOS = 4;
    private static final int NUMERO_DE_VAGAS = 3;
    private static final double SALARIO_BASE = 5000.0;

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Processo Seletivo");

        Scanner scanner = new Scanner(System.in);
        List<CandidatosInputOutput> candidatos = new ArrayList<>();
        List<CandidatosInputOutput> contratados;

        System.out.println("\nInforme os dados dos candidatos:");

        for (int i = 0; i < NUMERO_DE_CANDIDATOS; i++) {
            System.out.println("\nCandidato " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            double pretensaoSalarial = obterPretensaoSalarial(scanner);
            candidatos.add(new CandidatosInputOutput(nome, pretensaoSalarial));
        }

        ProcessoSeletivoInterface estrategia = new SelecaoPorPretensaoSalarial(SALARIO_BASE);
        contratados = estrategia.selecionar(candidatos, NUMERO_DE_VAGAS);

        System.out.println("\nCandidatos contratados:");

        for (CandidatosInputOutput contratado : contratados) {
            System.out.println("- " + contratado.getNome());
        }
    }

    private static double obterPretensaoSalarial(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Pretensão salarial para a vaga: ");
                double pretensaoSalarial = Double.parseDouble(scanner.nextLine());
                return pretensaoSalarial;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um valor numérico válido.");
            }
        }
    }
}
