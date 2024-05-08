/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.DivisaoTreino;

/**
 *
 * @author Ana Clara
 */
public class DivisaoTreinoDAO{
    
    DivisaoTreino [] divisoes = new DivisaoTreino [10];
    
    
  public void inserirDivisaoTreino(DivisaoTreino divisao){
      for (int i = 0; i < divisoes.length; i++){
          if(null == divisoes[i]){
              divisoes[i] = divisao;
              break;
          } 
      }
  }
  
   public void mostrarDivisaoTreino(){
      for (int i = 0; i < divisoes.length; i++){
          if(null != divisoes[i]){
          System.out.println(divisoes[i].toString());
          }
      }
  }

    public DivisaoTreino[] getDivisaoTreino() {
        return divisoes;
    }

    public void setDivisaoTreino(DivisaoTreino[] divisoes) {
        this.divisoes = divisoes;
    }
}
