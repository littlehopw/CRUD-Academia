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