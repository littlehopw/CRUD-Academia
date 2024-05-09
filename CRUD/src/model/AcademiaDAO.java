package model;

public class AcademiaDAO{
    
    Academia [] academias = new Academia [5];
    
  public void inserirAcademia(Academia acad){
      for (int i = 0; i < academias.length; i++){
          if(null == academias[i]){
              academias[i] = acad;
              break;
          } 
      }
  }
  
   public void mostrarAcademia(){
      for (int i = 0; i < academias.length; i++){
          if(null != academias[i]){
          System.out.println(academias[i].toString());
          }
      }
  }

    public Academia[] getAcademias() {
        return academias;
    }

    public void setAcademias(Academia[] academias) {
        this.academias = academias;
    }
   
}
