package model;

import java.time.LocalDate;

public class AlunoPagamentoMensalidade{
    
    private long id;
    private static long serial;
    private String pessoa;
    private String modalidade;
    private String mensalidadeVigente;
    private Double valorPago;
    private LocalDate data;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //constructor
    public AlunoPagamentoMensalidade(){
        id = ++AlunoPagamentoMensalidade.serial;
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

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getMensalidadeVigente() {
        return mensalidadeVigente;
    }

    public void setMensalidadeVigente(String mensalidadeVigente) {
        this.mensalidadeVigente = mensalidadeVigente;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
    
    @Override
    public String toString() {
        return "Aluno: " + pessoa + ", Data de pagamento: " + data + ", Valor: " + valorPago +
               ", Status: " + mensalidadeVigente + ", Modalidade: " + modalidade;
    }
    
     
}
