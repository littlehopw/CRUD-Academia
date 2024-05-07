/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.EntradaAluno;

/**
 *
 * @author Ana Clara
 */
public class EntradaAlunoDAO{
    
    EntradaAluno [] entradasalunos = new EntradaAluno [10];
    
    
  public void inserirEntradaAluno(EntradaAluno entradaaluno){
      for (int i = 0; i < entradasalunos.length; i++){
          if(null == entradasalunos[i]){
              entradasalunos[i] = entradaaluno;
              break;
          } 
      }
  }
  
   public void mostrarEntradaAluno(){
      for (int i = 0; i < entradasalunos.length; i++){
          if(null != entradasalunos[i]){
          System.out.println(entradasalunos[i].toString());
          }
      }
  }

    public EntradaAluno[] getEntradaAluno() {
        return entradasalunos;
    }

    public void setEntradaAluno(EntradaAluno[] entradasalunos) {
        this.entradasalunos = entradasalunos;
    }
}
