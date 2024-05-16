package edu.pierresalatiel.modules.input_output;

public class CandidatosInputOutput {

    private String nome;
    private double pretensaoSalarial;

    public CandidatosInputOutput(String nome, double pretensaoSalarial) {
        this.nome = nome;
        this.pretensaoSalarial = pretensaoSalarial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPretensaoSalarial() {
        return pretensaoSalarial;
    }

    public void setPretensaoSalarial(double pretensaoSalarial) {
        this.pretensaoSalarial = pretensaoSalarial;
    }

}
