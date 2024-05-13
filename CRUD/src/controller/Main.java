package controller;

import java.util.Scanner;
import model.AlunoPagamentoMensalidade;
import model.AlunoPagamentoMensalidadeDAO;
import model.AvaliacaoFisica;
import model.PessoaDAO;
import model.Pessoa;
import model.TreinoAplicacao;
import model.TreinoAplicacaoDAO;
import model.AvaliacaoFisicaDAO;
import view.Menus;

public class Main {
    
    public Main() {
        
      PessoaDAO pessoaDAO = new PessoaDAO();
      Scanner scanner = new Scanner(System.in);
      AlunoPagamentoMensalidadeDAO mensalidadeDAO = new AlunoPagamentoMensalidadeDAO();
      TreinoAplicacaoDAO treinoaplicacaoDAO = new TreinoAplicacaoDAO();
      AvaliacaoFisicaDAO avaliacaofisicaDAO = new AvaliacaoFisicaDAO();
      Pessoa[] pessoas = pessoaDAO.getPessoa();
      AlunoPagamentoMensalidade[] alunospagamentos = mensalidadeDAO.getAlunoPagamentoMensalidade();
      TreinoAplicacao[] treinosaplicacao = treinoaplicacaoDAO.getTreinoAplicacao();
      AvaliacaoFisica[] avaliacaofisica = avaliacaofisicaDAO.getAvaliacoes();
      Menus novoMenu = new Menus(pessoas, alunospagamentos, treinosaplicacao, avaliacaofisica);
      

      pessoaDAO.inserirPessoaExemplo();
      avaliacaofisicaDAO.inserirAvaliacaoExemplo();
      mensalidadeDAO.inserirMensalidadeExemplo();
      treinoaplicacaoDAO.inserirTreinoAplicacaoExemplo();
      
      int opcao = 1;
     
        while (opcao == 1 || opcao == 2){
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
            
            if (pessoaLogada != null) {
            switch (pessoaLogada.getTipoUsuario()) {
              case "aluno":
                 novoMenu.menuLoginAluno(pessoaLogada.getLogin(), pessoaLogada.getSenha());
                 opcao = 3;
                 break;
              case "administrador":
               
              break;
              case "professor":
           
              break;
              default:
                System.out.println("Tipo de usuário não reconhecido.");
            }
           }
    
        break;
     
        case 2:
            System.out.println("Opção de cadastro ainda não implementada.");
            break;
        default:
            System.out.println("Opção inválida. Tente novamente.");
        }
        }
       System.out.println("Obrigada por utilizar o sistema de academia!");
    }
    
    public static void main(String[] args){
       new Main(); 
    }
}
