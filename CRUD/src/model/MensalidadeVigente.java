package model;

import java.time.LocalDate;

public class MensalidadeVigente {
    
    private long id;
    private Double valor;
    private LocalDate inicio;
    private LocalDate termino;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //DEFAULT
    public MensalidadeVigente() {
        // Default constructor
    }

    //CONSTRUCTOR
    public MensalidadeVigente(Double valor, LocalDate inicio, LocalDate termino) {
        this.valor = valor;
        this.inicio = inicio;
        this.termino = termino;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
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