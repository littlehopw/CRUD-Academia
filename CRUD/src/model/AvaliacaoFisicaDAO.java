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
    
    AvaliacaoFisica exemplo2 = new AvaliacaoFisica();
    exemplo2.setPessoa("joão");
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

    AvaliacaoFisica exemplo5 = new AvaliacaoFisica();
    exemplo5.setPessoa("juliana");
    exemplo5.setUltimoTreino("Treino E");
    exemplo5.setPeso("68kg");
    exemplo5.setAltura("1.70");
    exemplo5.setImc("23.53");
    exemplo5.setSatisfacao("Satisfeita");
    inserirAvaliacoes(exemplo5);

    AvaliacaoFisica exemplo6 = new AvaliacaoFisica();
    exemplo6.setPessoa("lucas");
    exemplo6.setUltimoTreino("Treino F");
    exemplo6.setPeso("90kg");
    exemplo6.setAltura("1.85");
    exemplo6.setImc("26.30");
    exemplo6.setSatisfacao("Muito satisfeito");
    inserirAvaliacoes(exemplo6);

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
