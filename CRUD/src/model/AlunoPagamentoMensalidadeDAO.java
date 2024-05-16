package model;

public class AlunoPagamentoMensalidadeDAO{
    
    AlunoPagamentoMensalidade [] alunospagamentos = new AlunoPagamentoMensalidade [10];
    
    
    public void inserirMensalidadeExemplo() {
    AlunoPagamentoMensalidade exemplo1 = new AlunoPagamentoMensalidade();
    
    exemplo1.setPessoa("ana");
    exemplo1.setMensalidadeVigente("valida");

    inserirAlunoPagamentoMensalidade(exemplo1);
}
    
    public void inserirAlunoPagamentoMensalidade(AlunoPagamentoMensalidade alunopagamento) {
        boolean alunoExistente = false;
        for (int i = 0; i < alunospagamentos.length; i++) {
            if (alunospagamentos[i] != null && alunospagamentos[i].getPessoa().equals(alunopagamento.getPessoa())) {
                
                alunospagamentos[i].setMensalidadeVigente(alunopagamento.getMensalidadeVigente());
                alunospagamentos[i].setData(alunopagamento.getData());
                alunospagamentos[i].setValorPago(alunopagamento.getValorPago());
                alunospagamentos[i].setModalidade(alunopagamento.getModalidade());
                alunoExistente = true;
                break;
            } else if (alunospagamentos[i] == null) {
                
                alunospagamentos[i] = alunopagamento;
                alunoExistente = true;
                break;
            }
        }
        if (!alunoExistente) {
            System.out.println("Limite de pagamentos atingido. Não é possível adicionar mais pagamentos.");
        }
    }
  
   public void mostrarAlunoPagamentoMensalidade(){
      for (int i = 0; i < alunospagamentos.length; i++){
          if(null != alunospagamentos[i]){
          System.out.println(alunospagamentos[i].toString());
          }
      }
  }

    public AlunoPagamentoMensalidade[] getAlunoPagamentoMensalidade() {
        return alunospagamentos;
    }

    public void setAlunoPagamentoMensalidade(AlunoPagamentoMensalidade[] alunospagamentos) {
        this.alunospagamentos = alunospagamentos;
    }
}