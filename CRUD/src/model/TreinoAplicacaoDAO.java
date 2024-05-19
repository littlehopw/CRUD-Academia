package model;

public class TreinoAplicacaoDAO {
    TreinoAplicacao [] treinoAplicacoes = new TreinoAplicacao [10];
    
  public void  inserirTreinoAplicacaoExemplo() {
    TreinoAplicacao exemplo1 = new TreinoAplicacao();
    
    exemplo1.setTreino("ana");
    exemplo1.setExercicio("elevação pélvica");
    exemplo1.setExercicioAplicacao("4x12");
    exemplo1.setDivisaoTreino("C");
    exemplo1.setDivisaoTreinoMusculo("C = Perna");
    inserirTreinoAplicacao(exemplo1);
    
    TreinoAplicacao exemplo2 = new TreinoAplicacao();
    
    exemplo2.setTreino("joao");
    exemplo1.setExercicio("elevação pélvica");
    exemplo1.setExercicioAplicacao("4x12");
    exemplo1.setDivisaoTreino("C");
    exemplo1.setDivisaoTreinoMusculo("C = Perna");
    inserirTreinoAplicacao(exemplo2);
    
    // Exemplo 3
    TreinoAplicacao exemplo3 = new TreinoAplicacao();
    exemplo3.setTreino("maria");
    exemplo3.setExercicio("rosca direta");
    exemplo3.setExercicioAplicacao("4x15");
    exemplo3.setDivisaoTreino("B");
    exemplo3.setDivisaoTreinoMusculo("B = Bíceps");
    inserirTreinoAplicacao(exemplo3);

    // Exemplo 4
    TreinoAplicacao exemplo4 = new TreinoAplicacao();
    exemplo4.setTreino("carlos");
    exemplo4.setExercicio("agachamento");
    exemplo4.setExercicioAplicacao("4x10");
    exemplo4.setDivisaoTreino("C");
    exemplo4.setDivisaoTreinoMusculo("C = Perna");
    inserirTreinoAplicacao(exemplo4);

    // Exemplo 5
    TreinoAplicacao exemplo5 = new TreinoAplicacao();
    exemplo5.setTreino("lucia");
    exemplo5.setExercicio("crucifixo");
    exemplo5.setExercicioAplicacao("3x12");
    exemplo5.setDivisaoTreino("A");
    exemplo5.setDivisaoTreinoMusculo("A = Peito");
    inserirTreinoAplicacao(exemplo5);

    // Exemplo 6
    TreinoAplicacao exemplo6 = new TreinoAplicacao();
    exemplo6.setTreino("roberto");
    exemplo6.setExercicio("remada curvada");
    exemplo6.setExercicioAplicacao("4x8");
    exemplo6.setDivisaoTreino("B");
    exemplo6.setDivisaoTreinoMusculo("B = Costas");
    inserirTreinoAplicacao(exemplo6);
}
    
  public void inserirTreinoAplicacao(TreinoAplicacao treinoaplicacao){
      for (int i = 0; i < treinoAplicacoes.length; i++){
          if(null == treinoAplicacoes[i]){
              treinoAplicacoes[i] = treinoaplicacao;
              break;
          } 
      }
  }
  
   public void mostrarTreinoAplicacao(){
      for (int i = 0; i < treinoAplicacoes.length; i++){
          if(null != treinoAplicacoes[i]){
          System.out.println(treinoAplicacoes[i].toString());
          }
      }
  }

    public TreinoAplicacao[] getTreinoAplicacao() {
        return treinoAplicacoes;
    }

    public void setTreino(TreinoAplicacao[] treinoAplicacoes) {
        this.treinoAplicacoes = treinoAplicacoes;
    }
}