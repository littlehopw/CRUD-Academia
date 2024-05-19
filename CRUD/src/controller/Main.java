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
import model.AcademiaDAO;
import model.Academia;
import model.ExercicioAplicacao;        
import model.ExercicioAplicacaoDAO;
import model.Exercicio;
import model.ExercicioDAO;
import model.MensalidadeVigente;
import model.MensalidadeVigenteDAO;
import model.MovimentacaoFinanceira;
import model.MovimentacaoFinanceiraDAO;
import model.Treino;
import model.TreinoDAO;
import view.Menus;

public class Main {

    public Main() {

        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner scanner = new Scanner(System.in);
        AlunoPagamentoMensalidadeDAO mensalidadeDAO = new AlunoPagamentoMensalidadeDAO();
        TreinoAplicacaoDAO treinoaplicacaoDAO = new TreinoAplicacaoDAO();
        AvaliacaoFisicaDAO avaliacaofisicaDAO = new AvaliacaoFisicaDAO();
        //novos
        AcademiaDAO academiaDAO = new AcademiaDAO();
        ExercicioAplicacaoDAO aplicacaoDAO = new ExercicioAplicacaoDAO();
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        TreinoDAO treinoDAO = new TreinoDAO();
        MovimentacaoFinanceiraDAO financeiraDAO = new MovimentacaoFinanceiraDAO();
        MensalidadeVigenteDAO mensalidadevigenteDAO = new MensalidadeVigenteDAO(); 
        
        Pessoa[] pessoas = pessoaDAO.getPessoa();
        AlunoPagamentoMensalidade[] alunospagamentos = mensalidadeDAO.getAlunoPagamentoMensalidade();
        TreinoAplicacao[] treinosaplicacao = treinoaplicacaoDAO.getTreinoAplicacao();
        AvaliacaoFisica[] avaliacaofisica = avaliacaofisicaDAO.getAvaliacoes();
        Menus novoMenu = new Menus(pessoas, alunospagamentos, treinosaplicacao, avaliacaofisica, avaliacaofisicaDAO);
        //novos
        Academia[] academias = academiaDAO.getAcademias();
        ExercicioAplicacao [] aplicacoes = aplicacaoDAO.getAplicacoes();
        Exercicio [] exercicios = exercicioDAO.getExercicios();
        Treino [] treinos = treinoDAO.getTreino();
        MovimentacaoFinanceira [] movimentacoes = financeiraDAO.getMovimentacaoFinanceira();
        MensalidadeVigente [] mensalidades = mensalidadevigenteDAO.getMensalidadesVigente();
        
        pessoaDAO.inserirPessoaExemplo();
        avaliacaofisicaDAO.inserirAvaliacaoExemplo();
        mensalidadeDAO.inserirMensalidadeExemplo();
        treinoaplicacaoDAO.inserirTreinoAplicacaoExemplo();
        //novos
        academiaDAO.inserirAcademiaExemplo();
        aplicacaoDAO.inserirAplicacaoExemplo();
        exercicioDAO.inserirExercicioExemplo();
        treinoDAO.inserirTreinoExemplo();
        financeiraDAO.inserirMovimentacaoFinanceiraExemplo();
        mensalidadevigenteDAO.inserirMensalidadeExemplo();
        

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
                    
                    System.out.println("CADASTRO DE ALUNO:\n ");
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
