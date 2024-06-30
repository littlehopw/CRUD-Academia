package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntradaAluno {

    private long id;
    private LocalDateTime data;
    private String nascimento;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //DEFAULT
    public EntradaAluno() {
        // Default constructor
    }

    //CONSTRUCTOR
    public EntradaAluno(LocalDateTime data, String nascimento) {
        this.data = data;
        this.nascimento = nascimento;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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
