package model;

import java.time.LocalDate;

public class Exercicio {
    
    private long id;
    private String nome;
    private String descricaoFoto;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //DEFAULT
    public Exercicio() {
        // Default constructor
    }

    //CONSTRUCTOR
    public Exercicio(String nome, String descricaoFoto) {
        this.nome = nome;
        this.descricaoFoto = descricaoFoto;
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

    public String getDescricaoFoto() {
        return descricaoFoto;
    }

    public void setDescricaoFoto(String descricaoFoto) {
        this.descricaoFoto = descricaoFoto;
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