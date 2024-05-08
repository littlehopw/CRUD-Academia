/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Exercicio;

/**
 *
 * @author Ana Clara
 */
public class ExercicioDAO {
  Exercicio [] exercicios = new Exercicio [10];
    
    
  public void inserirExercicio(Exercicio exercicio){
      for (int i = 0; i < exercicios.length; i++){
          if(null == exercicios[i]){
              exercicios[i] = exercicio;
              break;
          } 
      }
  }
  
   public void mostrarExercicio(){
      for (int i = 0; i < exercicios.length; i++){
          if(null != exercicios[i]){
          System.out.println(exercicios[i].toString());
          }
      }
  }

    public Exercicio[] getExercicios() {
        return exercicios;
    }

    public void setPessoa(Exercicio[] exercicios) {
        this.exercicios = exercicios;
    }
}
