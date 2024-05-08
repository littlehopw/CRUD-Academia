/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;

/**
 *
 * @author Ana Clara
 */
public class AvaliacaoFisica {
    
    private long id;
    private static long serial;
    private String pessoa;
    private String ultimoTreino;
    private String peso;
    private String altura;
    private String imc;
    private String satisfacao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //constructor
    public AvaliacaoFisica(){
        id = ++AvaliacaoFisica.serial;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
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
