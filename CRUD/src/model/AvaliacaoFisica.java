package model;

import java.time.LocalDate;

public class AvaliacaoFisica {

    private long id;
    private String pessoa;
    private String ultimoTreino;
    private Double peso;
    private Double altura;
    private Double imc;
    private String satisfacao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //DEFAULT
    public AvaliacaoFisica() {
        // Default constructor
    }

    //CONSTRUCTOR
    public AvaliacaoFisica(String pessoa, String ultimoTreino, Double peso, Double altura, Double imc, String satisfacao) {
        this.pessoa = pessoa;
        this.ultimoTreino = ultimoTreino;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.satisfacao = satisfacao;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getUltimoTreino() {
        return ultimoTreino;
    }

    public void setUltimoTreino(String ultimoTreino) {
        this.ultimoTreino = ultimoTreino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getSatisfacao() {
        return satisfacao;
    }

    public void setSatisfacao(String satisfacao) {
        this.satisfacao = satisfacao;
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
