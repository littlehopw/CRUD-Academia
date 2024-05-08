/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.AlunoPagamentoMensalidade;

/**
 *
 * @author Ana Clara
 */
public class AlunoPagamentoMensalidadeDAO{
    
    AlunoPagamentoMensalidade [] alunospagamentos = new AlunoPagamentoMensalidade [10];
    
    
  public void inserirAlunoPagamentoMensalidade(AlunoPagamentoMensalidade alunopagamento){
      for (int i = 0; i < alunospagamentos.length; i++){
          if(null == alunospagamentos[i]){
              alunospagamentos[i] = alunopagamento;
              break;
          } 
      }
  }
  
   public void mostrarAlunoPagamentoMensalidade(){
      for (int i = 0; i < alunospagamentos.length; i++){
          if(null != alunospagamentos[i]){
          System.out.println(alunospagamentos[i].toString());
          }
      }
  }

    public AlunoPagamentoMensalidade[] getAlunoPagamentoMensalidade() {
        return alunospagamentos;
    }

    public void setAlunoPagamentoMensalidade(AlunoPagamentoMensalidade[] alunospagamentos) {
        this.alunospagamentos = alunospagamentos;
    }
}