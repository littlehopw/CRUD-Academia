package model;

public class ExercicioAplicacaoDAO{
    
    ExercicioAplicacao [] aplicacoes = new ExercicioAplicacao [5];
    
  
  public void inserirAplicacaoExemplo(){
    ExercicioAplicacao exemplo1 = new ExercicioAplicacao();
    exemplo1.setNome("Elevação Pélvica");
    exemplo1.setDescricao("3x15");
    inserirAplicacao(exemplo1);

    ExercicioAplicacao exemplo2 = new ExercicioAplicacao();
    exemplo2.setNome("Rosca Direta");
    exemplo2.setDescricao("4x12");
    inserirAplicacao(exemplo2);

    ExercicioAplicacao exemplo3 = new ExercicioAplicacao();
    exemplo3.setNome("Agachamento");
    exemplo3.setDescricao("4x10");
    inserirAplicacao(exemplo3);

    ExercicioAplicacao exemplo4 = new ExercicioAplicacao();
    exemplo4.setNome("Crucifixo");
    exemplo4.setDescricao("3x12");
    inserirAplicacao(exemplo4);

    ExercicioAplicacao exemplo5 = new ExercicioAplicacao();
    exemplo5.setNome("Remada Curvada");
    exemplo5.setDescricao("4x10");
    inserirAplicacao(exemplo5);

    ExercicioAplicacao exemplo6 = new ExercicioAplicacao();
    exemplo6.setNome("Prancha");
    exemplo6.setDescricao("3 series de 1 minuto.");
    inserirAplicacao(exemplo6);
  }
    
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
