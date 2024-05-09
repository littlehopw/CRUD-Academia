package model;

public class MovimentacaoFinanceiraDAO{
    
    MovimentacaoFinanceira [] movimentacoes = new MovimentacaoFinanceira [10];
    
    
  public void inserirMovimentacaoFinanceira(MovimentacaoFinanceira movimentacao){
      for (int i = 0; i < movimentacoes.length; i++){
          if(null == movimentacoes[i]){
              movimentacoes[i] = movimentacao;
              break;
          } 
      }
  }
  
   public void mostrarMovimentacaoFinanceira(){
      for (int i = 0; i < movimentacoes.length; i++){
          if(null != movimentacoes[i]){
          System.out.println(movimentacoes[i].toString());
          }
      }
  }

    public MovimentacaoFinanceira[] getMovimentacaoFinanceira() {
        return movimentacoes;
    }

    public void setMovimentacaoFinanceira(MovimentacaoFinanceira[] movimentacao) {
        this.movimentacoes = movimentacoes;
    }
}
