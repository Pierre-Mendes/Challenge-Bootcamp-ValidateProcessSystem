package edu.pierresalatiel.modules.interfaces;

import edu.pierresalatiel.modules.input_output.CandidatosInputOutput;
import java.util.List;

public interface ProcessoSeletivoInterface {

    List<CandidatosInputOutput> selecionar(List<CandidatosInputOutput> candidatos, int numeroDeVagas);

    boolean fazerLigacao(CandidatosInputOutput candidato);

    void fazerContraProposta(CandidatosInputOutput candidato);
}
