/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Treino;

/**
 *
 * @author Ana Clara
 */
public class TreinoDAO {
    Treino [] treinos = new Treino [10];
    
    
  public void inserirTreino(Treino treino){
      for (int i = 0; i < treinos.length; i++){
          if(null == treinos[i]){
              treinos[i] = treino;
              break;
          } 
      }
  }
  
   public void mostrarTreino(){
      for (int i = 0; i < treinos.length; i++){
          if(null != treinos[i]){
          System.out.println(treinos[i].toString());
          }
      }
  }

    public Treino[] getTreino() {
        return treinos;
    }

    public void setTreino(Treino[] treinos) {
        this.treinos = treinos;
    }
}