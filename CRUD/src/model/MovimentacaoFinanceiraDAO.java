package model;

public class MovimentacaoFinanceiraDAO{
    
    MovimentacaoFinanceira [] movimentacoes = new MovimentacaoFinanceira [10];
    
      public void inserirMovimentacaoFinanceiraExemplo() {
        // Exemplo 1
        MovimentacaoFinanceira exemplo1 = new MovimentacaoFinanceira();
        exemplo1.setValor(150.75);
        exemplo1.setTipo("Entrada");
        exemplo1.setDescricao("Pagamento de mensalidade");
        inserirMovimentacaoFinanceira(exemplo1);

        // Exemplo 2
        MovimentacaoFinanceira exemplo2 = new MovimentacaoFinanceira();
        exemplo2.setValor(250.00);
        exemplo2.setTipo("Saida");
        exemplo2.setDescricao("Compra de equipamentos");
        inserirMovimentacaoFinanceira(exemplo2);

        // Exemplo 3
        MovimentacaoFinanceira exemplo3 = new MovimentacaoFinanceira();
        exemplo3.setValor(75.50);
        exemplo3.setTipo("Entrada");
        exemplo3.setDescricao("Venda de suplementos");
        inserirMovimentacaoFinanceira(exemplo3);

        // Exemplo 4
        MovimentacaoFinanceira exemplo4 = new MovimentacaoFinanceira();
        exemplo4.setValor(400.00);
        exemplo4.setTipo("Saida");
        exemplo4.setDescricao("Pagamento de aluguel");
        inserirMovimentacaoFinanceira(exemplo4);

        // Exemplo 5
        MovimentacaoFinanceira exemplo5 = new MovimentacaoFinanceira();
        exemplo5.setValor(90.00);
        exemplo5.setTipo("Entrada");
        exemplo5.setDescricao("Aula particular");
        inserirMovimentacaoFinanceira(exemplo5);

        // Exemplo 6
        MovimentacaoFinanceira exemplo6 = new MovimentacaoFinanceira();
        exemplo6.setValor(125.00);
        exemplo6.setTipo("Saida");
        exemplo6.setDescricao("Compra de material de limpeza");
        inserirMovimentacaoFinanceira(exemplo6);
      }  
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
