package model;

import model.AvaliacaoFisica;

public class AvaliacaoFisicaDAO{
    
    AvaliacaoFisica [] avaliacoes = new AvaliacaoFisica [10];
    
    public void inserirAvaliacaoExemplo() {
    AvaliacaoFisica exemplo1 = new AvaliacaoFisica();
    exemplo1.setPessoa("lucia");
    exemplo1.setUltimoTreino("Treino C");
    exemplo1.setPeso("63kg");
    exemplo1.setAltura("1.56");
    exemplo1.setImc("25.89");
    exemplo1.setSatisfacao("Mais ou menos");
    inserirAvaliacoes(exemplo1);
    
    AvaliacaoFisica exemplo2 = new AvaliacaoFisica();
    exemplo2.setPessoa("roberto");
    exemplo2.setUltimoTreino("Treino A");
    exemplo2.setPeso("70kg");
    exemplo2.setAltura("1.75");
    exemplo2.setImc("22.86");
    exemplo2.setSatisfacao("Muito satisfeito");
    inserirAvaliacoes(exemplo2);

    AvaliacaoFisica exemplo3 = new AvaliacaoFisica();
    exemplo3.setPessoa("maria");
    exemplo3.setUltimoTreino("Treino B");
    exemplo3.setPeso("55kg");
    exemplo3.setAltura("1.62");
    exemplo3.setImc("20.96");
    exemplo3.setSatisfacao("Satisfeita");
    inserirAvaliacoes(exemplo3);

    AvaliacaoFisica exemplo4 = new AvaliacaoFisica();
    exemplo4.setPessoa("carlos");
    exemplo4.setUltimoTreino("Treino D");
    exemplo4.setPeso("82kg");
    exemplo4.setAltura("1.80");
    exemplo4.setImc("25.31");
    exemplo4.setSatisfacao("Insatisfeito");
    inserirAvaliacoes(exemplo4);

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
