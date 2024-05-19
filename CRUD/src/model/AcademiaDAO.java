package model;

public class AcademiaDAO{
    
    Academia [] academias = new Academia [5];
    
   public void  inserirAcademiaExemplo() {
    Academia exemplo1 = new Academia();
    exemplo1.setNome("Academia IFTM - Und 1");
    exemplo1.setEndereco("Av. Dr. Florestan Fernandes, 131");
    inserirAcademia(exemplo1);
    
    Academia exemplo2 = new Academia();
    exemplo2.setNome("Academia IFTM - Und 2");
    exemplo2.setEndereco("Av. Edilson Lamartine Mendes, 300");
    inserirAcademia(exemplo2);
   }
    
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
