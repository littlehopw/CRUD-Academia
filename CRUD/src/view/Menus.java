package view;

import java.util.Scanner;
import model.Pessoa;

public class Menus {
    private Pessoa[] pessoas; 
    private Scanner scanner;

    public Menus(Pessoa[] pessoas) {
        this.pessoas = pessoas;
        this.scanner = new Scanner(System.in);
    }
    
     public int menuInicial(){
        System.out.println("Bem vindo ao sistema de academia!\n1 - Fazer Login\n2 - Cadastrar-se\nDigite sua opção:");
        return Integer.parseInt(scanner.nextLine());
    }
     
    public Pessoa menuLogin(){
        System.out.println("Faça seu login\n");
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();
       
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido!");
                return pessoa;
            }
        }
       
        System.out.println("Login ou senha incorretos.");
        return null;
    }
}
