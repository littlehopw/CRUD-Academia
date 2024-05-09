package model;

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
