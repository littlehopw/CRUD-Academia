/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.MovimentacaoFinanceira;

/**
 *
 * @author Ana Clara
 */
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
