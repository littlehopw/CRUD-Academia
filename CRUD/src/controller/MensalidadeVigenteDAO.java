/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.MensalidadeVigente;

/**
 *
 * @author Ana Clara
 */
public class MensalidadeVigenteDAO{
    
    MensalidadeVigente [] mensalidades = new MensalidadeVigente [10];
    
    
  public void inserirMensalidadeVigente(MensalidadeVigente mensalidade){
      for (int i = 0; i < mensalidades.length; i++){
          if(null == mensalidades[i]){
              mensalidades[i] = mensalidade;
              break;
          } 
      }
  }
  
   public void mostrarMensalidadeVigente(){
      for (int i = 0; i < mensalidades.length; i++){
          if(null != mensalidades[i]){
          System.out.println(mensalidades[i].toString());
          }
      }
  }

    public MensalidadeVigente[] getMensalidadesVigente() {
        return mensalidades;
    }

    public void setPessoa(MensalidadeVigente[] mensalidades) {
        this.mensalidades = mensalidades;
    }
}
