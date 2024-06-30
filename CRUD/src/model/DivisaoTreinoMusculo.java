package model;

import java.time.LocalDate;

public class DivisaoTreinoMusculo {
    
    private long id;

    private String descricao;
    private String divisaoTreino;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //DEFAULT
    public DivisaoTreinoMusculo() {
        // Default constructor
    }
    
    //CONSTRUCTOR
    public DivisaoTreinoMusculo(String descricao, String divisaoTreino) {
        this.descricao = descricao;
        this.divisaoTreino = divisaoTreino;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }
  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setDivisaoTreino(String divisaoTreino) {
        this.divisaoTreino = divisaoTreino;
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