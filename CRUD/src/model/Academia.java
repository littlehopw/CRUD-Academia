package model;

import java.time.LocalDate;

public class Academia {
    
    private long id;
    private String nome;
    private String endereco;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //DEFAULT
    public Academia() {
        // Default constructor
    }
    
    //CONSTRUCTOR
    public Academia(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
