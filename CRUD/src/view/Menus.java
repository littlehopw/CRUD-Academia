package view;

import java.time.LocalDate;
import java.util.Scanner;
import model.*;

public class Menus {

    private AlunoPagamentoMensalidade[] alunospagamentos;
    private Scanner scanner;
    private AvaliacaoFisicaDAO avaliacaofisicaDAO = new AvaliacaoFisicaDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private TreinoAplicacaoDAO treinoaplicacaoDAO = new TreinoAplicacaoDAO();

    public Menus(AcademiaDAO academiaDAO, AlunoPagamentoMensalidadeDAO mensalidadeDAO, AvaliacaoFisicaDAO avaliacaofisicaDAO,
            DivisaoTreinoDAO divisaotreinoDAO, DivisaoTreinoMusculoDAO divisaotreinoMusculoDAO, EntradaAlunoDAO entradaalunoDAO,
            ExercicioDAO exercicioDAO, ExercicioAplicacaoDAO aplicacaoDAO, MensalidadeVigenteDAO mensalidadevigenteDAO,
            MovimentacaoFinanceiraDAO financeiraDAO, PagamentoRecorrenteDAO pagamentorecorrenteDAO, PessoaDAO pessoaDAO,
            TreinoDAO treinoDAO, TreinoAplicacaoDAO treinoaplicacaoDAO) {
        this.pessoaDAO = pessoaDAO;
        this.alunospagamentos = mensalidadeDAO.getAlunosPagamentos();
        this.alunospagamentos = alunospagamentos;
        this.treinoaplicacaoDAO = treinoaplicacaoDAO;
        this.avaliacaofisicaDAO = avaliacaofisicaDAO;
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

        for (Pessoa pessoa : pessoaDAO.getPessoa()) {
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

            switch (opcao) {
                case 1:
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

                case 2:
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean encontrouTreino = false;
                    for (TreinoAplicacao treino : treinoaplicacaoDAO.getTreinoAplicacao()) {
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
                    break;

                case 3:
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean encontrouAvaliacao = false;
                    for (AvaliacaoFisica avaliacao : avaliacaofisicaDAO.getAvaliacoes()) {
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

                    break;
            }

            if (opcao == 4) {
                System.out.println("Saindo do sistema...");

            }
        }
    }

    public void menuLoginProfessor(String login, String senha) {
        int opcao = 0;
        TreinoAplicacaoDAO treinoAplicacaoDAO = new TreinoAplicacaoDAO();

        while (opcao != 6) {
            System.out.println("Bem vindo, professor! Escolha sua opção:\n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar treino");
            System.out.println("3 - Entrar na Academia");
            System.out.println("4 - Ver ficha de treino do aluno");
            System.out.println("5 - Ver avaliação física dos alunos");
            System.out.println("6 - Sair do sistema");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
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
                case 2:
                    System.out.println("Cadastro de Novo Treino");
                    System.out.println("Login do aluno que realizará o treino:");
                    String loginAlunoTreino = scanner.nextLine();

                    boolean alunoTreinoEncontrado = false;
                    for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                        if (pessoa != null && pessoa.getLogin().equals(loginAlunoTreino) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoTreinoEncontrado = true;
                            break;
                        }
                    }

                    if (alunoTreinoEncontrado) {
                        TreinoAplicacao novoTreino = new TreinoAplicacao();

                        System.out.println("Exercício do treino:");
                        novoTreino.setExercicio(scanner.nextLine());
                        System.out.println("Aplicação do exercício (repetições):");
                        novoTreino.setExercicioAplicacao(scanner.nextLine());
                        System.out.println("Divisão de treino (A,B,C):");
                        novoTreino.setDivisaoTreino(scanner.nextLine());
                        System.out.println("Divisão de treino músculo (Perna, Ombro):");
                        novoTreino.setDivisaoTreinoMusculo(scanner.nextLine());
                        novoTreino.setTreino(loginAlunoTreino);
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
                    String alunoLogin = scanner.nextLine();
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontrado = false;
                    for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLogin) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontrado = true;
                            break;
                        }
                    }

                    if (alunoEncontrado) {
                        for (TreinoAplicacao treino : treinoaplicacaoDAO.getTreinoAplicacao()) {
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

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontradoAvaliacao = false;
                    for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLoginAvaliacao) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontradoAvaliacao = true;
                            break;
                        }
                    }

                    if (alunoEncontradoAvaliacao) {
                        boolean encontrouAvaliacao = false;
                        for (AvaliacaoFisica avaliacao : avaliacaofisicaDAO.getAvaliacoes()) {
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

        while (opcao != 8) {
            System.out.println("Bem vindo, administrador! Escolha sua opção:\n");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Cadastrar treino");
            System.out.println("3 - Entrar na Academia");
            System.out.println("4 - Ver ficha de treino do aluno");
            System.out.println("5 - Ver avaliação física dos alunos");
            System.out.println("6 - Movimentações Financeiras");
            System.out.println("7 - Relatórios");
            System.out.println("8 - Sair do sistema");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    Pessoa novoAluno = new Pessoa();
                    System.out.println("\nCADASTRO DE NOVO USUARIO\n");
                    System.out.println("Informe o tipo de Usuario:");
                    novoAluno.setTipoUsuario(scanner.nextLine());
                    System.out.println("Informe o Nome:");
                    novoAluno.setNome(scanner.nextLine());
                    System.out.println("Informe o Sexo:");
                    novoAluno.setSexo(scanner.nextLine());
                    System.out.println("Informe a Data de nascimento:");
                    novoAluno.setNascimento(scanner.nextLine());
                    System.out.println("Informe o Login");
                    novoAluno.setLogin(scanner.nextLine());
                    System.out.println("Informe a Senha:");
                    novoAluno.setSenha(scanner.nextLine());

                    pessoaDAO.inserirPessoa(novoAluno);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Cadastro de Novo Treino");
                    System.out.println("Login do aluno que realizará o treino:");
                    String loginAlunoTreino = scanner.nextLine();

                    boolean alunoTreinoEncontrado = false;
                    for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                        if (pessoa != null && pessoa.getLogin().equals(loginAlunoTreino) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoTreinoEncontrado = true;
                            break;
                        }
                    }

                    if (alunoTreinoEncontrado) {
                        TreinoAplicacao novoTreino = new TreinoAplicacao();

                        System.out.println("Exercício do treino:");
                        novoTreino.setExercicio(scanner.nextLine());
                        System.out.println("Aplicação do exercício (repetições):");
                        novoTreino.setExercicioAplicacao(scanner.nextLine());
                        System.out.println("Divisão de treino (A,B,C):");
                        novoTreino.setDivisaoTreino(scanner.nextLine());
                        System.out.println("Divisão de treino músculo (Perna, Ombro):");
                        novoTreino.setDivisaoTreinoMusculo(scanner.nextLine());
                        novoTreino.setTreino(loginAlunoTreino);
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

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontrado = false;
                    for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLogin) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontrado = true;
                            break;
                        }
                    }

                    if (alunoEncontrado) {
                        for (TreinoAplicacao treino : treinoaplicacaoDAO.getTreinoAplicacao()) {
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

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    boolean alunoEncontradoAvaliacao = false;
                    for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                        if (pessoa != null && pessoa.getLogin().equals(alunoLoginAvaliacao) && pessoa.getTipoUsuario().equals("aluno")) {
                            alunoEncontradoAvaliacao = true;
                            break;
                        }
                    }

                    if (alunoEncontradoAvaliacao) {
                        boolean encontrouAvaliacao = false;
                        for (AvaliacaoFisica avaliacao : avaliacaofisicaDAO.getAvaliacoes()) {
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
                    scanner.nextLine();

                    switch (opcaoFinanceira) {
                        case 1:
                            System.out.println("Digite o login do aluno para ver as mensalidades:");
                            String loginAlunoVerMensalidades = scanner.nextLine();
                            boolean alunoFinanceiroEncontrado = false;
                            for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                                if (pessoa != null && pessoa.getLogin().equals(loginAlunoVerMensalidades) && pessoa.getTipoUsuario().equals("aluno")) {
                                    alunoFinanceiroEncontrado = true;
                                    break;
                                }
                            }

                            if (alunoFinanceiroEncontrado) {
                                AlunoPagamentoMensalidade[] pagamentos = alunoPagamentoMensalidadeDAO.getPagamentosPorAluno(loginAlunoVerMensalidades);
                                boolean pagamentosEncontrados = false;
                                for (AlunoPagamentoMensalidade pagamento : pagamentos) {
                                    if (pagamento != null) {
                                        System.out.println(pagamento.toString());
                                        pagamentosEncontrados = true;
                                    }
                                }
                                if (!pagamentosEncontrados) {
                                    System.out.println("Nenhuma mensalidade encontrada para o aluno: " + loginAlunoVerMensalidades);
                                }
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                            break;

                        case 2:
                            System.out.println("Digite o login do aluno:");
                            String loginAlunoPagamento = scanner.nextLine();
                            boolean alunoParaPagamentoEncontrado = false;
                            for (Pessoa pessoa : pessoaDAO.getPessoa()) {
                                if (pessoa != null && pessoa.getLogin().equals(loginAlunoPagamento) && pessoa.getTipoUsuario().equals("aluno")) {
                                    alunoParaPagamentoEncontrado = true;
                                    break;
                                }
                            }

                            if (alunoParaPagamentoEncontrado) {
                                AlunoPagamentoMensalidade novoPagamento = new AlunoPagamentoMensalidade();
                                novoPagamento.setPessoa(loginAlunoPagamento);
                                System.out.println("Digite o valor do pagamento:");
                                double valorPagamento = scanner.nextDouble();
                                novoPagamento.setValorPago(valorPagamento);
                                novoPagamento.setData(LocalDate.now());
                                System.out.println("Digite a modalidade:");
                                scanner.nextLine();
                                novoPagamento.setModalidade(scanner.nextLine());
                                System.out.println("Digite o status da mensalidade (valido ou invalido):");
                                novoPagamento.setMensalidadeVigente(scanner.nextLine());

                                alunoPagamentoMensalidadeDAO.inserirAlunoPagamentoMensalidade(novoPagamento);
                                System.out.println("Pagamento registrado com sucesso!");
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                    }
                    break;

                case 7:
                    System.out.println("Relatórios:");
                    System.out.println("1 - Alunos que pagaram até o fim de um mês");
                    System.out.println("2 - Movimentação da academia de um mês");
                    int opcaoRelatorio = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    switch (opcaoRelatorio) {
                        case 1:
                            System.out.println("Informe o mês (1 a 12):");
                            int mesRelatorio = scanner.nextInt();
                            System.out.println("Informe o ano:");
                            int anoRelatorio = scanner.nextInt();
                            alunoPagamentoMensalidadeDAO.relatorioAlunosPagaramAteFimDoMes(mesRelatorio, anoRelatorio);
                            break;
                        case 2:
                            System.out.println("Informe o mês (1 a 12):");
                            int mesMovimentacao = scanner.nextInt();
                            System.out.println("Informe o ano:");
                            int anoMovimentacao = scanner.nextInt();
                            alunoPagamentoMensalidadeDAO.relatorioMovimentacaoAcademiaMes(mesMovimentacao, anoMovimentacao);
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Finalizando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        }

    }
}
