package model;

public class ExercicioAplicacaoDAO{
    
    ExercicioAplicacao [] aplicacoes = new ExercicioAplicacao [5];
    
    
  public void inserirAplicacao(ExercicioAplicacao aplicacao){
      for (int i = 0; i < aplicacoes.length; i++){
          if(null == aplicacoes[i]){
              aplicacoes[i] = aplicacao;
              break;
          } 
      }
  }
  
   public void mostrarAplicacao(){
      for (int i = 0; i < aplicacoes.length; i++){
          if(null != aplicacoes[i]){
          System.out.println(aplicacoes[i].toString());
          }
      }
  }

    public ExercicioAplicacao[] getAplicacoes() {
        return aplicacoes;
    }

    public void setAcademias(ExercicioAplicacao[] aplicacoes) {
        this.aplicacoes = aplicacoes;
    }
}
