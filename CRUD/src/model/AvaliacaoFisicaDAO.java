package model;

import model.AvaliacaoFisica;

public class AvaliacaoFisicaDAO{
    
    AvaliacaoFisica [] avaliacoes = new AvaliacaoFisica [10];
    
    public void inserirAvaliacaoExemplo() {
    AvaliacaoFisica exemplo1 = new AvaliacaoFisica();
    
    exemplo1.setPessoa("ana");
    exemplo1.setUltimoTreino("Treino C");
    exemplo1.setPeso("63kg");
    exemplo1.setAltura("1.56");
    exemplo1.setImc("25.89");
    exemplo1.setSatisfacao("Mais ou menos");

    inserirAvaliacoes(exemplo1);
}
    
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
