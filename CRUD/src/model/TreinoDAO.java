package model;

import java.time.LocalDate;

public class TreinoDAO {
    Treino [] treinos = new Treino [10];
    
  
  public void  inserirTreinoExemplo() {
    Treino exemplo1 = new Treino();
    exemplo1.setDataInicio(LocalDate.parse("2024-05-01"));
    exemplo1.setDataTermino(LocalDate.parse("2024-08-01"));
    exemplo1.setDivisaoTreino("A-B-C");
    exemplo1.setObjetivo("Hipertrofia");
    inserirTreino(exemplo1);

    Treino exemplo2 = new Treino();
    exemplo2.setDataInicio(LocalDate.parse("2024-06-01"));
    exemplo2.setDataTermino(LocalDate.parse("2024-09-01"));
    exemplo2.setDivisaoTreino("A-B");
    exemplo2.setObjetivo("Emagrecimento");
    inserirTreino(exemplo2);

    Treino exemplo3 = new Treino();
    exemplo3.setDataInicio(LocalDate.parse("2024-07-01"));
    exemplo3.setDataTermino(LocalDate.parse("2024-10-01"));
    exemplo3.setDivisaoTreino("A-B-C-D");
    exemplo3.setObjetivo("Condicionamento físico");
    inserirTreino(exemplo3);

    Treino exemplo4 = new Treino();
    exemplo4.setDataInicio(LocalDate.parse("2024-08-01"));
    exemplo4.setDataTermino(LocalDate.parse("2024-11-01"));
    exemplo4.setDivisaoTreino("Full Body");
    exemplo4.setObjetivo("Manutenção");
    inserirTreino(exemplo4);

    Treino exemplo5 = new Treino();
    exemplo5.setDataInicio(LocalDate.parse("2024-09-01"));
    exemplo5.setDataTermino(LocalDate.parse("2024-12-01"));
    exemplo5.setDivisaoTreino("A-B-C");
    exemplo5.setObjetivo("Força");
    inserirTreino(exemplo5);

    Treino exemplo6 = new Treino();
    exemplo6.setDataInicio(LocalDate.parse("2024-10-01"));
    exemplo6.setDataTermino(LocalDate.parse("2024-12-31"));
    exemplo6.setDivisaoTreino("A-B");
    exemplo6.setObjetivo("Resistência");
    inserirTreino(exemplo6);
  }
    
  public void inserirTreino(Treino treino){
      for (int i = 0; i < treinos.length; i++){
          if(null == treinos[i]){
              treinos[i] = treino;
              break;
          } 
      }
  }
  
   public void mostrarTreino(){
      for (int i = 0; i < treinos.length; i++){
          if(null != treinos[i]){
          System.out.println(treinos[i].toString());
          }
      }
  }

    public Treino[] getTreino() {
        return treinos;
    }

    public void setTreino(Treino[] treinos) {
        this.treinos = treinos;
    }
}