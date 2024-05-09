package model;

public class PagamentoRecorrenteDAO{
    
    PagamentoRecorrente [] pagamentos = new PagamentoRecorrente [10];
    
    
  public void inserirPessoa(PagamentoRecorrente pagamento){
      for (int i = 0; i < pagamentos.length; i++){
          if(null == pagamentos[i]){
              pagamentos[i] = pagamento;
              break;
          } 
      }
  }
  
   public void mostrarPagamentoRecorrente(){
      for (int i = 0; i < pagamentos.length; i++){
          if(null != pagamentos[i]){
          System.out.println(pagamentos[i].toString());
          }
      }
  }

    public PagamentoRecorrente[] getPagamentoRecorrente() {
        return pagamentos;
    }

    public void setPagamentoRecorrente(PagamentoRecorrente[] pagamento) {
        this.pagamentos = pagamentos;
    }
}
