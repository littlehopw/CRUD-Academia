package controller;

import java.util.Scanner;
import model.PessoaDAO;
import view.Menus;
import model.Pessoa;

public class Main {
    
    public Main() {
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa[] pessoas = pessoaDAO.getPessoa();
        Menus novoMenu = new Menus(pessoas);   
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;
               
        pessoaDAO.inserirPessoaExemplo();
     
        while (opcao == 1 && opcao == 2){
           opcao = novoMenu.menuInicial();
           for (int i = 0; i < 30; ++i) System.out.println();
           
        switch (opcao) {
            
        case 1: 
            int tentarNovamente = 0;
            Pessoa pessoaLogada;
            do {
                for (int i = 0; i < 30; ++i) System.out.println();
                pessoaLogada = novoMenu.menuLogin();
                for (int i = 0; i < 5; ++i) System.out.println();
                if (pessoaLogada == null) {
                    System.out.println("Deseja tentar novamente?\n1 - Sim\n2 - Não");
                    tentarNovamente = scanner.nextInt();
                }
            } while (pessoaLogada == null && tentarNovamente == 1);

        break;
     
        case 2:
            System.out.println("Opção de cadastro ainda não implementada.");
            break;
        default:
            System.out.println("Opção inválida. Tente novamente.");
        }
        }
        
    }
    
    public static void main(String[] args){
       new Main(); 
    }
}
