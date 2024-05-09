package model;

public class DivisaoTreinoDAO{
    
    DivisaoTreino [] divisoes = new DivisaoTreino [10];
    
    
  public void inserirDivisaoTreino(DivisaoTreino divisao){
      for (int i = 0; i < divisoes.length; i++){
          if(null == divisoes[i]){
              divisoes[i] = divisao;
              break;
          } 
      }
  }
  
   public void mostrarDivisaoTreino(){
      for (int i = 0; i < divisoes.length; i++){
          if(null != divisoes[i]){
          System.out.println(divisoes[i].toString());
          }
      }
  }

    public DivisaoTreino[] getDivisaoTreino() {
        return divisoes;
    }

    public void setDivisaoTreino(DivisaoTreino[] divisoes) {
        this.divisoes = divisoes;
    }
}
