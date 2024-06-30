package model;

import java.time.LocalDate;

public class PagamentoRecorrente {

    private long id;
    private String pessoa;
    private LocalDate data;
    private String cartaodeCredito;
    private Double valor;
    private int mesesAutorizados;
    private LocalDate dataInicio;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //DEFAULT
    public PagamentoRecorrente() {
        // Default constructor
    }

    //CONSTRUCTOR
    public PagamentoRecorrente(String pessoa, LocalDate data, String cartaodeCredito, Double valor, int mesesAutorizados, LocalDate dataInicio) {
        this.pessoa = pessoa;
        this.data = data;
        this.cartaodeCredito = cartaodeCredito;
        this.valor = valor;
        this.mesesAutorizados = mesesAutorizados;
        this.dataInicio = dataInicio;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCartaodeCredito() {
        return cartaodeCredito;
    }

    public void setCartaodeCredito(String cartaodeCredito) {
        this.cartaodeCredito = cartaodeCredito;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getMesesAutorizados() {
        return mesesAutorizados;
    }

    public void setMesesAutorizados(int mesesAutorizados) {
        this.mesesAutorizados = mesesAutorizados;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
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
