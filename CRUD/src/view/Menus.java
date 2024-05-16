package view;

import java.time.LocalDate;
import java.util.Scanner;
import model.Pessoa;
import model.AlunoPagamentoMensalidade;
import model.AlunoPagamentoMensalidadeDAO;
import model.TreinoAplicacao;
import model.AvaliacaoFisica;
import model.PessoaDAO;
import model.Treino;
import model.TreinoDAO;
import model.AvaliacaoFisicaDAO;
import model.TreinoAplicacaoDAO;

public class Menus {

    private Pessoa[] pessoas;
    private AlunoPagamentoMensalidade[] alunospagamentos;
    private TreinoAplicacao[] treinos;
    private AvaliacaoFisica[] avaliacoesfisicas;
    private Scanner scanner;
    private AvaliacaoFisicaDAO avaliacaoFisicaDAO;

    public Menus(Pessoa[] pessoas, AlunoPagamentoMensalidade[] alunospagamentos, TreinoAplicacao[] treinos, AvaliacaoFisica[] avaliacoesfisicas, AvaliacaoFisicaDAO avaliacaoFisicaDAO) {
        this.pessoas = pessoas;
        this.alunospagamentos = alunospagamentos;
        this.treinos = treinos;
        this.avaliacoesfisicas = avaliacoesfisicas;
        this.avaliacaoFisicaDAO = avaliacaoFisicaDAO;
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

    public void menuLoginProfessor(String login, String senha) {
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
                    break;
                case 4:
                    System.out.println("Ficha de Treino do Aluno");
                    System.out.println("Informe o login do aluno:");
                    String alunoLogin = scanner.next();
                    scanner.nextLine();
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontrado = false;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLogin) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontrado = true;
                            break;
                        }
                    }

                    if (alunoEncontrado) {
                        for (TreinoAplicacao treino : treinos) {
                            if (treino != null && treino.getTreino().equals(alunoLogin)) {
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
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 5:
                    System.out.println("Consultar Avaliação Física de um Aluno");
                    System.out.println("Informe o login do aluno:");
                    String alunoLoginAvaliacao = scanner.nextLine();
                    scanner.nextLine();

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontradoAvaliacao = false;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLoginAvaliacao) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontradoAvaliacao = true;
                            break;
                        }
                    }

                    if (alunoEncontradoAvaliacao) {
                        boolean encontrouAvaliacao = false;
                        for (AvaliacaoFisica avaliacao : avaliacoesfisicas) {
                            if (avaliacao != null && avaliacao.getPessoa().equals(alunoLoginAvaliacao)) {
                                encontrouAvaliacao = true;
                                System.out.println("Detalhes da Avaliação Física de " + avaliacao.getPessoa());
                                System.out.println("Último Treino: " + avaliacao.getUltimoTreino());
                                System.out.println("Peso: " + avaliacao.getPeso());
                                System.out.println("Altura: " + avaliacao.getAltura());
                                System.out.println("IMC: " + avaliacao.getImc());
                                System.out.println("Satisfação: " + avaliacao.getSatisfacao());
                                System.out.println();
                                break;
                            }
                        }
                        if (!encontrouAvaliacao) {
                            System.out.println("Nenhuma avaliação física encontrada para o aluno " + alunoLoginAvaliacao);
                        }
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void menuLoginAdministrador(String login, String senha) {
        AlunoPagamentoMensalidadeDAO alunoPagamentoMensalidadeDAO = new AlunoPagamentoMensalidadeDAO();
        TreinoAplicacaoDAO treinoAplicacaoDAO = new TreinoAplicacaoDAO();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("Bem vindo, administrador! Escolha sua opção:\n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar treino");
            System.out.println("3 - Entrar na Academia");
            System.out.println("4 - Ver ficha de treino do aluno");
            System.out.println("5 - Ver avaliação física dos alunos");
            System.out.println("6 - Movimentações Financeiras");
            System.out.println("7 - Sair do sistema");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    Pessoa novoAluno = new Pessoa();
                    System.out.println("Cadastro de Novo Aluno");
                    System.out.println("Nome do aluno:");
                    novoAluno.setNome(scanner.nextLine());
                    scanner.nextLine();
                    System.out.println("Sexo do aluno:");
                    novoAluno.setSexo(scanner.nextLine());
                    System.out.println("Data de nascimento:");
                    novoAluno.setNascimento(scanner.nextLine());
                    System.out.println("Login do aluno:");
                    novoAluno.setLogin(scanner.nextLine());
                    System.out.println("Senha do aluno:");
                    novoAluno.setSenha(scanner.nextLine());
                    novoAluno.setTipoUsuario("aluno");

                    PessoaDAO pessoaDAO = new PessoaDAO();
                    pessoaDAO.inserirPessoa(novoAluno);

                    System.out.println("Aluno cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Cadastro de Novo Treino");
                    System.out.println("Login do aluno que realizará o treino:");
                    String loginAlunoTreino = scanner.nextLine();
                    scanner.nextLine(); 

                    boolean alunotTreinoEncontrado = false;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa != null && pessoa.getLogin().equals(loginAlunoTreino) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunotTreinoEncontrado = true;
                            break;
                        }
                    }

                    if (alunotTreinoEncontrado) {
                        TreinoAplicacao novoTreino = new TreinoAplicacao();

                        System.out.println("Exercício do treino:");
                        novoTreino.setExercicio(scanner.nextLine());
                        System.out.println("Aplicação do exercício (repetições):");
                        novoTreino.setExercicioAplicacao(scanner.nextLine());
                        System.out.println("Divisão de treino (A,B,C):");
                        novoTreino.setDivisaoTreino(scanner.nextLine());
                        System.out.println("Divisão de treino músculo (Perna, Ombro):");
                        novoTreino.setDivisaoTreinoMusculo(scanner.nextLine());
                        novoTreino.setTreino(loginAlunoTreino); // Associa o treino ao aluno
                        novoTreino.setDataCriacao(LocalDate.now());
                        novoTreino.setDataModificacao(LocalDate.now());

                        boolean treinoEncontrado = false;
                        for (int i = 0; i < treinoAplicacaoDAO.getTreinoAplicacao().length; i++) {
                            TreinoAplicacao treino = treinoAplicacaoDAO.getTreinoAplicacao()[i];
                            if (treino != null && treino.getTreino().equals(loginAlunoTreino)) {

                                treino.setExercicio(novoTreino.getExercicio());
                                treino.setExercicioAplicacao(novoTreino.getExercicioAplicacao());
                                treino.setDivisaoTreino(novoTreino.getDivisaoTreino());
                                treino.setDivisaoTreinoMusculo(novoTreino.getDivisaoTreinoMusculo());
                                treino.setDataModificacao(LocalDate.now());
                                treinoEncontrado = true;
                                break;
                            }
                        }

                        if (!treinoEncontrado) {
                            treinoAplicacaoDAO.inserirTreinoAplicacao(novoTreino);
                        }

                        System.out.println("Treino cadastrado/atualizado com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 3:
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
                    break;
                case 4:
                    System.out.println("Ficha de Treino do Aluno");
                    System.out.println("Informe o login do aluno:");
                    String alunoLogin = scanner.next();
                    scanner.nextLine();
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontrado = false;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLogin) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontrado = true;
                            break;
                        }
                    }

                    if (alunoEncontrado) {
                        for (TreinoAplicacao treino : treinos) {
                            if (treino != null && treino.getTreino().equals(alunoLogin)) {
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
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 5:
                    System.out.println("Consultar Avaliação Física de um Aluno");
                    System.out.println("Informe o login do aluno:");
                    String alunoLoginAvaliacao = scanner.nextLine();
                    scanner.nextLine();

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontradoAvaliacao = false;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLoginAvaliacao) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontradoAvaliacao = true;
                            break;
                        }
                    }

                    if (alunoEncontradoAvaliacao) {
                        boolean encontrouAvaliacao = false;
                        for (AvaliacaoFisica avaliacao : avaliacoesfisicas) {
                            if (avaliacao != null && avaliacao.getPessoa().equals(alunoLoginAvaliacao)) {
                                encontrouAvaliacao = true;
                                System.out.println("Detalhes da Avaliação Física de " + avaliacao.getPessoa());
                                System.out.println("Último Treino: " + avaliacao.getUltimoTreino());
                                System.out.println("Peso: " + avaliacao.getPeso());
                                System.out.println("Altura: " + avaliacao.getAltura());
                                System.out.println("IMC: " + avaliacao.getImc());
                                System.out.println("Satisfação: " + avaliacao.getSatisfacao());
                                System.out.println();
                                break;
                            }
                        }
                        if (!encontrouAvaliacao) {
                            System.out.println("Nenhuma avaliação física encontrada para o aluno " + alunoLoginAvaliacao);
                        }
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 6:
                    System.out.println("Movimentações Financeiras:\n1 - Ver mensalidades\n2 - Registrar pagamento de aluno\nDigite sua opção:");
                    int opcaoFinanceira = scanner.nextInt();
                    switch (opcaoFinanceira) {
                        case 1:
                            for (AlunoPagamentoMensalidade pagamento : alunospagamentos) {
                                if (pagamento != null) {
                                    System.out.println("Aluno: " + pagamento.getPessoa());
                                    System.out.println("Data de pagamento: " + pagamento.getData());
                                    System.out.println("Valor: " + pagamento.getValorPago());
                                    System.out.println("Status: " + pagamento.getMensalidadeVigente());
                                    System.out.println("Modalidade: " + pagamento.getModalidade());
                                    System.out.println();
                                }
                            }
                            alunoPagamentoMensalidadeDAO.mostrarAlunoPagamentoMensalidade();
                            break;
                        case 2:
                            System.out.println("Digite o login do aluno:");
                            String loginAluno = scanner.next();
                            AlunoPagamentoMensalidade novoPagamento = new AlunoPagamentoMensalidade();
                            novoPagamento.setPessoa(loginAluno);
                            System.out.println("Digite o valor do pagamento:");
                            double valorPagamento = scanner.nextDouble();
                            novoPagamento.setValorPago(valorPagamento);
                            alunoPagamentoMensalidadeDAO.inserirAlunoPagamentoMensalidade(novoPagamento);
                            System.out.println("Pagamento registrado com sucesso!");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

}
