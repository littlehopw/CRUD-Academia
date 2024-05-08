/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.DivisaoTreinoMusculo;

/**
 *
 * @author Ana Clara
 */
public class DivisaoTreinoMusculoDAO {
  DivisaoTreinoMusculo [] divisaomusculos = new DivisaoTreinoMusculo [10];
    
    
  public void inserirTreinoMusculo(DivisaoTreinoMusculo musculo){
      for (int i = 0; i < divisaomusculos.length; i++){
          if(null == divisaomusculos[i]){
              divisaomusculos[i] = musculo;
              break;
          } 
      }
  }
  
   public void mostrarTreinoMusculo(){
      for (int i = 0; i < divisaomusculos.length; i++){
          if(null != divisaomusculos[i]){
          System.out.println(divisaomusculos[i].toString());
          }
      }
  }

    public DivisaoTreinoMusculo[] getTreinoMusculo() {
        return divisaomusculos;
    }

    public void setTreinoMusculo(DivisaoTreinoMusculo[] divisaomusculos) {
        this.divisaomusculos = divisaomusculos;
    }
}
