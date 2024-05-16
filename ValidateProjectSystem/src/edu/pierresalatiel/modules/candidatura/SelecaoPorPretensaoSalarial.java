package edu.pierresalatiel.modules.candidatura;

import edu.pierresalatiel.modules.input_output.CandidatosInputOutput;
import edu.pierresalatiel.modules.interfaces.ProcessoSeletivoInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelecaoPorPretensaoSalarial implements ProcessoSeletivoInterface {

    final double salarioBase;
    private static final int MAX_TENTATIVAS_LIGACAO = 3;

    public SelecaoPorPretensaoSalarial(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public List<CandidatosInputOutput> selecionar(List<CandidatosInputOutput> candidatos, int numeroDeVagas) {
        Random random = new Random();
        List<CandidatosInputOutput> contratados = new ArrayList<>();
        int vagasPreenchidas = 0;

        while (vagasPreenchidas < numeroDeVagas && !candidatos.isEmpty()) {
            int indiceAleatorio = random.nextInt(candidatos.size());
            CandidatosInputOutput candidatoSelecionado = candidatos.get(indiceAleatorio);

            if (candidatoSelecionado.getPretensaoSalarial() <= salarioBase) {
                System.out.println("\nNome: " + candidatoSelecionado.getNome() + ", Pretensão Salarial: " + candidatoSelecionado.getPretensaoSalarial());

                if (fazerLigacao(candidatoSelecionado)) {
                    contratados.add(candidatoSelecionado);

                    vagasPreenchidas++;
                } else {
                    fazerContraProposta(candidatoSelecionado);
                    contratados.add(candidatoSelecionado);

                    vagasPreenchidas++;
                }
            }

            candidatos.remove(indiceAleatorio);
        }

        return contratados;
    }

    @Override
    public boolean fazerLigacao(CandidatosInputOutput candidato) {
        Random random = new Random();
        boolean atendeLigacao = random.nextBoolean();

        System.out.println("  Tentando ligação...");

        for (int i = 0; i < MAX_TENTATIVAS_LIGACAO; i++) {
            System.out.println("    Tentativa " + (i + 1) + ":");

            if (atendeLigacao) {
                System.out.println("      Ligação atendida pelo candidato " + candidato.getNome());
                
                return true;
            } else {
                System.out.println("      Ligação não atendida pelo candidato " + candidato.getNome());
            }
        }

        return false;
    }

    @Override
    public void fazerContraProposta(CandidatosInputOutput candidato) {
        Random random = new Random();
        double contraProposta = salarioBase + random.nextDouble() * 2000;

        System.out.println("  Gerando contra proposta para o candidato " + candidato.getNome() + ": " + contraProposta);

        boolean aceitaProposta = random.nextBoolean();

        if (aceitaProposta) {
            System.out.println("  O candidato " + candidato.getNome() + " aceitou a contra proposta!");
        } else {
            System.out.println("  O candidato " + candidato.getNome() + " recusou a contra proposta.");
        }
    }
}
