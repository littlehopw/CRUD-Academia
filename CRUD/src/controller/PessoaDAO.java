/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Pessoa;

/**
 *
 * @author Ana Clara
 */
public class PessoaDAO{
    
    Pessoa [] pessoas = new Pessoa [10];
    
    
  public void inserirPessoa(Pessoa pessoa){
      for (int i = 0; i < pessoas.length; i++){
          if(null == pessoas[i]){
              pessoas[i] = pessoa;
              break;
          } 
      }
  }
  
   public void mostrarPessoa(){
      for (int i = 0; i < pessoas.length; i++){
          if(null != pessoas[i]){
          System.out.println(pessoas[i].toString());
          }
      }
  }

    public Pessoa[] getPessoa() {
        return pessoas;
    }

    public void setPessoa(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }
}
