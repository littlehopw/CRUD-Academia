package view;

import java.time.LocalDate;
import java.util.Scanner;
import model.Pessoa;
import model.AlunoPagamentoMensalidade;
import model.TreinoAplicacao;
import model.AvaliacaoFisica;
import model.PessoaDAO;
import model.Treino;
import model.TreinoDAO;

public class Menus {

    private Pessoa[] pessoas;
    private AlunoPagamentoMensalidade[] alunospagamentos;
    private TreinoAplicacao[] treinos;
    private AvaliacaoFisica[] avaliacoesfisicas;
    private Scanner scanner;

    public Menus(Pessoa[] pessoas, AlunoPagamentoMensalidade[] alunospagamentos, TreinoAplicacao[] treinos, AvaliacaoFisica[] avaliacoesfisicas) {
        this.pessoas = pessoas;
        this.alunospagamentos = alunospagamentos;
        this.treinos = treinos;
        this.avaliacoesfisicas = avaliacoesfisicas;
        this.scanner = new Scanner(System.in);
    }

    public int menuInicial() {
        System.out.println("Bem vindo ao sistema de academia!\n1 - Fazer Login\n2 - Cadastrar-se\nDigite sua opção:");
        return Integer.parseInt(scanner.nextLine());
    }

    public Pessoa menuLogin() {
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

    public void menuLoginAluno(String login, String senha) {

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("Bem vindo, aluno! Escolha sua opção:\n");
            System.out.println("1 - Entrar na Academia");
            System.out.println("2 - Ver ficha de treino");
            System.out.println("3 - Avaliação física");
            System.out.println("4 - Sair do sistema");
            opcao = scanner.nextInt();

            //entrar na academia
            if (opcao == 1) {
                for (int i = 0; i < 30; ++i) {
                    System.out.println();
                }
                boolean mensalidadeEmDia = false;
                for (AlunoPagamentoMensalidade alunopagamento : alunospagamentos) {
                    if (alunopagamento != null && alunopagamento.getPessoa().equals(login) && alunopagamento.getMensalidadeVigente().equals("valida")) {
                        mensalidadeEmDia = true;
                        break;
                    }
                }
                if (mensalidadeEmDia) {
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    System.out.println("Acesso permitido na academia.");

                } else {
                    System.out.println("Você não tem a mensalidade em dia. Por favor, entre em contato com a administração.");
                }
            }

            //ficha de treino
            if (opcao == 2) {
                for (int i = 0; i < 30; ++i) {
                    System.out.println();
                }
                boolean encontrouTreino = false;
                for (TreinoAplicacao treino : treinos) {
                    if (treino != null && treino.getTreino().equals(login)) {
                        encontrouTreino = true;
                        System.out.println("Detalhes do Treino de " + treino.getTreino());
                        System.out.println("Exercício: " + treino.getExercicio());
                        System.out.println("Exercício Aplicação: " + treino.getExercicioAplicacao());
                        System.out.println("Divisão do Treino: " + treino.getDivisaoTreino());
                        System.out.println("Divisão do Treino Muscular: " + treino.getDivisaoTreinoMusculo());
                        System.out.println("Data de Criação: " + treino.getDataCriacao());
                        System.out.println("Data de Modificação: " + treino.getDataModificacao());
                        System.out.println();
                    }
                }
                if (!encontrouTreino) {
                    System.out.println("Nenhum treino encontrado para o usuário " + login);
                }
            }

            if (opcao == 3) {
                for (int i = 0; i < 30; ++i) {
                    System.out.println();
                }
                boolean encontrouAvaliacao = false;
                for (AvaliacaoFisica avaliacao : avaliacoesfisicas) {
                    if (avaliacao != null && avaliacao.getPessoa().equals(login)) {
                        encontrouAvaliacao = true;
                        System.out.println("Detalhes da Avaliação Física de " + avaliacao.getPessoa());
                        System.out.println("Último Treino: " + avaliacao.getUltimoTreino());
                        System.out.println("Peso: " + avaliacao.getPeso());
                        System.out.println("Altura: " + avaliacao.getAltura());
                        System.out.println("IMC: " + avaliacao.getImc());
                        System.out.println("Satisfação: " + avaliacao.getSatisfacao());
                        System.out.println();
                    }
                }
                if (!encontrouAvaliacao) {
                    System.out.println("Nenhuma avaliação física encontrada para o usuário " + login);
                }
            }

            //sair do sistema
            if (opcao == 4) {
                System.out.println("Saindo do sistema...");
            }
        }
    }

    public void menuLoginProfessor() {
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Bem vindo, professor! Escolha sua opção:\n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar treino");
            System.out.println("3 - Entrar na Academia");
            System.out.println("4 - Ver ficha de treino do aluno");
            System.out.println("5 - Ver avaliação física dos alunos");
            System.out.println("6 - Sair do sistema");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    Pessoa novoAluno = new Pessoa();
                    System.out.println("Cadastro de Novo Aluno");
                    
                    System.out.println("Nome:");
                    novoAluno.setNome(scanner.nextLine());

                    scanner.nextLine();

                    System.out.println("Sexo:");
                    novoAluno.setSexo(scanner.nextLine());

                    System.out.println("Data de Nascimento (YYYY-MM-DD):");
                    novoAluno.setNascimento(scanner.nextLine());

                    System.out.println("Login:");
                    novoAluno.setLogin(scanner.nextLine());

                    System.out.println("Senha:");
                    novoAluno.setSenha(scanner.nextLine());

                    novoAluno.setTipoUsuario("aluno");

                    PessoaDAO pessoaDAO = new PessoaDAO();
                    pessoaDAO.inserirPessoa(novoAluno);

                    System.out.println("Aluno cadastrado com sucesso!");

                    break;
                case 2:
                    Treino novoTreino = new Treino();
                    System.out.println("Cadastro de Novo Treino");

                    System.out.println("Objetivo:");
                    novoTreino.setObjetivo(scanner.nextLine());
                    scanner.nextLine();

                    System.out.println("Divisão de Treino:");
                    novoTreino.setDivisaoTreino(scanner.nextLine());

                    System.out.println("Data de Início (YYYY-MM-DD):");
                    novoTreino.setDataInicio(LocalDate.parse(scanner.nextLine()));

                    System.out.println("Data de Término (YYYY-MM-DD):");
                    novoTreino.setDataTermino(LocalDate.parse(scanner.nextLine()));

                    novoTreino.setDataCriacao(LocalDate.now());
                    novoTreino.setDataModificacao(LocalDate.now());

                    TreinoDAO treinoDAO = new TreinoDAO();
                    treinoDAO.inserirTreino(novoTreino);

                    System.out.println("Treino cadastrado com sucesso!");
                    break;
                case 3:
                    // Lógica para entrada na academia
                    break;
                case 4:
                    // Lógica para ver ficha de treino do aluno
                    break;
                case 5:
                    // Lógica para ver avaliação física dos alunos
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
