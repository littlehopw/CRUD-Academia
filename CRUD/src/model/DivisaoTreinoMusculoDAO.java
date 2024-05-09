package model;

public class DivisaoTreinoMusculoDAO {
  DivisaoTreinoMusculo [] divisaomusculos = new DivisaoTreinoMusculo [10];
    
    
  public void inserirTreinoMusculo(DivisaoTreinoMusculo musculo){
      for (int i = 0; i < divisaomusculos.length; i++){
          if(null == divisaomusculos[i]){
              divisaomusculos[i] = musculo;
              break;
          } 
      }
  }
  
   public void mostrarTreinoMusculo(){
      for (int i = 0; i < divisaomusculos.length; i++){
          if(null != divisaomusculos[i]){
          System.out.println(divisaomusculos[i].toString());
          }
      }
  }

    public DivisaoTreinoMusculo[] getTreinoMusculo() {
        return divisaomusculos;
    }

    public void setTreinoMusculo(DivisaoTreinoMusculo[] divisaomusculos) {
        this.divisaomusculos = divisaomusculos;
    }
}
