/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.PagamentoRecorrente;

/**
 *
 * @author Ana Clara
 */
public class PagamentoRecorrenteDAO{
    
    PagamentoRecorrente [] pagamentos = new PagamentoRecorrente [10];
    
    
  public void inserirPessoa(PagamentoRecorrente pagamento){
      for (int i = 0; i < pagamentos.length; i++){
          if(null == pagamentos[i]){
              pagamentos[i] = pagamento;
              break;
          } 
      }
  }
  
   public void mostrarPagamentoRecorrente(){
      for (int i = 0; i < pagamentos.length; i++){
          if(null != pagamentos[i]){
          System.out.println(pagamentos[i].toString());
          }
      }
  }

    public PagamentoRecorrente[] getPagamentoRecorrente() {
        return pagamentos;
    }

    public void setPagamentoRecorrente(PagamentoRecorrente[] pagamento) {
        this.pagamentos = pagamentos;
    }
}
