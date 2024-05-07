import controller.AcademiaDAO;
import controller.PessoaDAO;
import java.time.LocalDate;
import model.Academia;
import model.Pessoa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ana Clara
 */
public class main {
   
    AcademiaDAO academiadao = new AcademiaDAO();
    Academia novaacademia = new Academia();
    
    public void menu(){
        
        novaacademia.setId(1);  
        novaacademia.setNome("SmartFIT");
        novaacademia.setEndereco("Putaquepariu");
        novaacademia.setDataCriacao(LocalDate.now());
        novaacademia.setDataModificacao(LocalDate.now());  
        academiadao.inserirAcademia(novaacademia);
        academiadao.mostrarAcademia();
        
    }
    
    public static void main(String[] args){
       new main(); 
    }
    
    public main(){
       menu();
    }
}
