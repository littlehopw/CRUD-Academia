package model;

import java.time.LocalDate;

public class DivisaoTreino{
    
    private long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //DEFAULT
    public DivisaoTreino() {
        // Default constructor
    }
    
    //CONSTRUCTOR
    public DivisaoTreino(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
