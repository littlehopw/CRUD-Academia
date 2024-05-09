package model;

public class AvaliacaoFisicaDAO{
    
    AvaliacaoFisica [] avaliacoes = new AvaliacaoFisica [10];
    
    
  public void inserirAvaliacoes(AvaliacaoFisica avaliacao){
      for (int i = 0; i < avaliacoes.length; i++){
          if(null == avaliacoes[i]){
              avaliacoes[i] = avaliacao;
              break;
          } 
      }
  }
  
   public void mostrarAvaliacoes(){
      for (int i = 0; i < avaliacoes.length; i++){
          if(null != avaliacoes[i]){
          System.out.println(avaliacoes[i].toString());
          }
      }
  }

    public AvaliacaoFisica[] getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(AvaliacaoFisica[] avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
