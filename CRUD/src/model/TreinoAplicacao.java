package model;

import java.time.LocalDate;

public class TreinoAplicacao {
    
    private long id;
    private String treino;
    private String exercicio;
    private String exercicioAplicacao;
    private String divisaoTreino;
    private String divisaoTreinoMusculo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //constructor
    public TreinoAplicacao(){
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTreino() {
        return treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public String getExercicioAplicacao() {
        return exercicioAplicacao;
    }

    public void setExercicioAplicacao(String exercicioAplicacao) {
        this.exercicioAplicacao = exercicioAplicacao;
    }

    public String getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setDivisaoTreino(String divisaoTreino) {
        this.divisaoTreino = divisaoTreino;
    }

    public String getDivisaoTreinoMusculo() {
        return divisaoTreinoMusculo;
    }

    public void setDivisaoTreinoMusculo(String divisaoTreinoMusculo) {
        this.divisaoTreinoMusculo = divisaoTreinoMusculo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
}