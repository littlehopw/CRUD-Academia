/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.AvaliacaoFisica;

/**
 *
 * @author Ana Clara
 */
public class AvaliacaoFisicaDAO{
    
    AvaliacaoFisica [] avaliacoes = new AvaliacaoFisica [10];
    
    
  public void inserirAvaliacoes(AvaliacaoFisica avaliacao){
      for (int i = 0; i < avaliacoes.length; i++){
          if(null == avaliacoes[i]){
              avaliacoes[i] = avaliacao;
              break;
          } 
      }
  }
  
   public void mostrarAvaliacoes(){
      for (int i = 0; i < avaliacoes.length; i++){
          if(null != avaliacoes[i]){
          System.out.println(avaliacoes[i].toString());
          }
      }
  }

    public AvaliacaoFisica[] getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(AvaliacaoFisica[] avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
