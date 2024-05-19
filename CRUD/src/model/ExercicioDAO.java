package model;

public class ExercicioDAO {
  Exercicio [] exercicios = new Exercicio [10];
    
  public void inserirExercicioExemplo(){
    Exercicio exemplo1 = new Exercicio();
    exemplo1.setNome("Elevação Pélvica");
    exemplo1.setDescricaoFoto("Fortalece os glúteos e músculos do core.");
    inserirExercicio(exemplo1);

    Exercicio exemplo2 = new Exercicio();
    exemplo2.setNome("Rosca Direta");
    exemplo2.setDescricaoFoto("Fortalece os bíceps.");
    inserirExercicio(exemplo2);

    Exercicio exemplo3 = new Exercicio();
    exemplo3.setNome("Agachamento");
    exemplo3.setDescricaoFoto("Fortalece as pernas e glúteos.");
    inserirExercicio(exemplo3);

    Exercicio exemplo4 = new Exercicio();
    exemplo4.setNome("Crucifixo");
    exemplo4.setDescricaoFoto("Fortalece os músculos do peito.");
    inserirExercicio(exemplo4);

    Exercicio exemplo5 = new Exercicio();
    exemplo5.setNome("Remada Curvada");
    exemplo5.setDescricaoFoto("Fortalece as costas e bíceps.");
    inserirExercicio(exemplo5);

    Exercicio exemplo6 = new Exercicio();
    exemplo6.setNome("Prancha");
    exemplo6.setDescricaoFoto("Fortalece o core.");
    inserirExercicio(exemplo6);
  }  
  
  public void inserirExercicio(Exercicio exercicio){
      for (int i = 0; i < exercicios.length; i++){
          if(null == exercicios[i]){
              exercicios[i] = exercicio;
              break;
          } 
      }
  }
  
   public void mostrarExercicio(){
      for (int i = 0; i < exercicios.length; i++){
          if(null != exercicios[i]){
          System.out.println(exercicios[i].toString());
          }
      }
  }

    public Exercicio[] getExercicios() {
        return exercicios;
    }

    public void setPessoa(Exercicio[] exercicios) {
        this.exercicios = exercicios;
    }
}
