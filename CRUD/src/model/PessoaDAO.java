/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Ana Clara
 */
public class PessoaDAO{
    
    Pessoa [] pessoas = new Pessoa [10];
    
    public void inserirPessoaExemplo() {
        Pessoa exemplo1 = new Pessoa();
        
        exemplo1.setNome("Ana Clara");
        exemplo1.setSexo("Feminino");
        exemplo1.setNascimento("14/07/2004");
        exemplo1.setLogin("ana");
        exemplo1.setSenha("ana");
        exemplo1.setTipoUsuario("Administrado");

        inserirPessoa(exemplo1);
    }
    
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