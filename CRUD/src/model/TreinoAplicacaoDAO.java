/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.TreinoAplicacao;

/**
 *
 * @author Ana Clara
 */
public class TreinoAplicacaoDAO {
    TreinoAplicacao [] treinoAplicacoes = new TreinoAplicacao [10];
    
    
  public void inserirTreinoAplicacao(TreinoAplicacao treinoaplicacao){
      for (int i = 0; i < treinoAplicacoes.length; i++){
          if(null == treinoAplicacoes[i]){
              treinoAplicacoes[i] = treinoaplicacao;
              break;
          } 
      }
  }
  
   public void mostrarTreinoAplicacao(){
      for (int i = 0; i < treinoAplicacoes.length; i++){
          if(null != treinoAplicacoes[i]){
          System.out.println(treinoAplicacoes[i].toString());
          }
      }
  }

    public TreinoAplicacao[] getTreinoAplicacao() {
        return treinoAplicacoes;
    }

    public void setTreino(TreinoAplicacao[] treinoAplicacoes) {
        this.treinoAplicacoes = treinoAplicacoes;
    }
}