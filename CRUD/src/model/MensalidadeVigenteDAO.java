package model;

import java.time.LocalDate;

public class MensalidadeVigenteDAO{
    
    MensalidadeVigente [] mensalidades = new MensalidadeVigente [10];
    
    public void inserirMensalidadeExemplo() {
    MensalidadeVigente exemplo1 = new MensalidadeVigente();
    exemplo1.setValor(150.00);
    exemplo1.setInicio(LocalDate.parse("2024-08-01"));
    exemplo1.setTermino(LocalDate.parse("2025-07-31"));
    inserirMensalidadeVigente(exemplo1);

    // Exemplo 2
    MensalidadeVigente exemplo2 = new MensalidadeVigente();
    exemplo2.setValor(200.00);
    exemplo2.setInicio(LocalDate.parse("2024-09-01"));
    exemplo2.setTermino(LocalDate.parse("2025-08-31"));
    inserirMensalidadeVigente(exemplo2);

    // Exemplo 3
    MensalidadeVigente exemplo3 = new MensalidadeVigente();
    exemplo3.setValor(180.00);
    exemplo3.setInicio(LocalDate.parse("2024-10-01"));
    exemplo3.setTermino(LocalDate.parse("2025-09-30"));
    inserirMensalidadeVigente(exemplo3);

    // Exemplo 4
    MensalidadeVigente exemplo4 = new MensalidadeVigente();
    exemplo4.setValor(220.00);
    exemplo4.setInicio(LocalDate.parse("2024-11-01"));
    exemplo4.setTermino(LocalDate.parse("2025-10-31"));
    inserirMensalidadeVigente(exemplo4);

    // Exemplo 5
    MensalidadeVigente exemplo5 = new MensalidadeVigente();
    exemplo5.setValor(160.00);
    exemplo5.setInicio(LocalDate.parse("2024-12-01"));
    exemplo5.setTermino(LocalDate.parse("2025-11-30"));
    inserirMensalidadeVigente(exemplo5);

    // Exemplo 6
    MensalidadeVigente exemplo6 = new MensalidadeVigente();
    exemplo6.setValor(210.00);
    exemplo6.setInicio(LocalDate.parse("2025-01-01"));
    exemplo6.setTermino(LocalDate.parse("2025-12-31"));
    inserirMensalidadeVigente(exemplo6);
    }
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
