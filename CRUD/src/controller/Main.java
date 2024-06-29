package controller;

import java.util.Scanner;
import model.*;
import view.Menus;

public class Main {

    public Main() {
        AcademiaDAO academiaDAO = new AcademiaDAO();
        AlunoPagamentoMensalidadeDAO mensalidadeDAO = new AlunoPagamentoMensalidadeDAO();
        AvaliacaoFisicaDAO avaliacaofisicaDAO = new AvaliacaoFisicaDAO();
        DivisaoTreinoDAO divisaotreinoDAO = new DivisaoTreinoDAO();
        DivisaoTreinoMusculoDAO divisaotreinoMusculoDAO = new DivisaoTreinoMusculoDAO();
        EntradaAlunoDAO entradaalunoDAO = new EntradaAlunoDAO();
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        ExercicioAplicacaoDAO aplicacaoDAO = new ExercicioAplicacaoDAO();
        MensalidadeVigenteDAO mensalidadevigenteDAO = new MensalidadeVigenteDAO();
        MovimentacaoFinanceiraDAO financeiraDAO = new MovimentacaoFinanceiraDAO();
        PagamentoRecorrenteDAO pagamentorecorrenteDAO = new PagamentoRecorrenteDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        TreinoDAO treinoDAO = new TreinoDAO();
        TreinoAplicacaoDAO treinoaplicacaoDAO = new TreinoAplicacaoDAO();
        
        Scanner scanner = new Scanner(System.in);
        
        pessoaDAO.inserirPessoaExemplo();
        avaliacaofisicaDAO.inserirAvaliacaoExemplo();
        treinoaplicacaoDAO.inserirTreinoAplicacaoExemplo();
        academiaDAO.inserirAcademiaExemplo();
        aplicacaoDAO.inserirAplicacaoExemplo();
        exercicioDAO.inserirExercicioExemplo();
        treinoDAO.inserirTreinoExemplo();
        financeiraDAO.inserirMovimentacaoFinanceiraExemplo();
        mensalidadevigenteDAO.inserirMensalidadeExemplo();
                
        
        Menus novoMenu = new Menus(academiaDAO, mensalidadeDAO, avaliacaofisicaDAO, divisaotreinoDAO, divisaotreinoMusculoDAO,
        entradaalunoDAO, exercicioDAO, aplicacaoDAO, mensalidadevigenteDAO, financeiraDAO, pagamentorecorrenteDAO, pessoaDAO,
        treinoDAO, treinoaplicacaoDAO);

        int opcao = 1;

        while (opcao == 1 || opcao == 2) {
            opcao = novoMenu.menuInicial();
            for (int i = 0; i < 30; ++i) {
                System.out.println();
            }

            switch (opcao) {

                case 1:
                    int tentarNovamente = 0;
                    Pessoa pessoaLogada;
                    do {
                        for (int i = 0; i < 30; ++i) {
                            System.out.println();
                        }
                        pessoaLogada = novoMenu.menuLogin();
                        for (int i = 0; i < 5; ++i) {
                            System.out.println();
                        }
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
                            case "professor":
                                novoMenu.menuLoginProfessor(pessoaLogada.getLogin(), pessoaLogada.getSenha());
                                opcao = 3;
                                break;
                            case "administrador":
                                novoMenu.menuLoginAdministrador(pessoaLogada.getLogin(), pessoaLogada.getSenha());
                                opcao = 3;
                                break;
                            default:
                                System.out.println("Tipo de usuário não reconhecido.");
                        }
                    }

                    break;

                case 2:
                    Pessoa novoAluno = new Pessoa();
                    
                    System.out.println("CADASTRO DE ALUNO\n ");
                    System.out.println("Informe seu nome: ");
                    novoAluno.setNome(scanner.nextLine());
                    System.out.println("\nInforme seu sexo: ");
                    novoAluno.setSexo(scanner.nextLine());
                    System.out.println("\nInforme seu nascimento: ");
                    novoAluno.setNascimento(scanner.nextLine());
                    System.out.println("\nInforme seu login: ");
                    novoAluno.setLogin(scanner.nextLine());
                    System.out.println("\nInforme sua senha: ");
                    novoAluno.setSenha(scanner.nextLine());
                    novoAluno.setTipoUsuario("aluno");
                    
                    pessoaDAO.inserirPessoa(novoAluno);

                    System.out.println("Aluno cadastrado com sucesso!\n");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Obrigado por utilizar o sistema de academia!");
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
