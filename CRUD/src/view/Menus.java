package view;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;

public class Menus {

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
        this.treinoaplicacaoDAO = treinoaplicacaoDAO;
        this.avaliacaofisicaDAO = avaliacaofisicaDAO;
        this.scanner = new Scanner(System.in);
    }

    public int menuInicial() {
        System.out.println("Bem vindo ao sistema de academia!\n1 - Fazer Login\n2 - Cadastrar-se\nDigite sua opção:");
        return Integer.parseInt(scanner.nextLine());
    }

    public Pessoa menuLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Faça seu login\n");
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();

        Pessoa pessoa = pessoaDAO.buscarLogin(login);

        if (pessoa != null && pessoa.getSenha().equals(senha)) {
            System.out.println("Login bem-sucedido!");
            return pessoa;
        } else {
            System.out.println("Login ou senha incorretos.");
            return null;
        }
    }

    public void menuLoginAluno(String login, String senha) throws DocumentException, BadElementException, IOException {

        int opcao = 0;
        int escolha;

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

                    boolean mensalidadeEmDia = new AlunoPagamentoMensalidadeDAO().verificarMensalidadeEmDia(login);

                    if (mensalidadeEmDia) {
                        System.out.println("Acesso permitido na academia.");
                    } else {
                        System.out.println("Você não tem a mensalidade em dia. Por favor, entre em contato com a administração.");
                    }
                    break;

                case 2:
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    List<TreinoAplicacao> treinos = treinoaplicacaoDAO.getTreinoAplicacao(login);
                    boolean encontrouTreino = !treinos.isEmpty();

                    if (encontrouTreino) {
                        System.out.println("Detalhes do seu treino!");
                        System.out.println();

                        for (TreinoAplicacao treino : treinos) {
                            System.out.println("Exercício: " + treino.getExercicio());
                            System.out.println("Exercício Aplicação: " + treino.getExercicioAplicacao());
                            System.out.println("Divisão do Treino: " + treino.getDivisaoTreino());
                            System.out.println("Divisão do Treino Muscular: " + treino.getDivisaoTreinoMusculo());
                            System.out.println("Data de Criação: " + treino.getDataCriacao());
                            System.out.println("Data de Modificação: " + treino.getDataModificacao());
                            System.out.println();
                        }

                        System.out.println("Deseja gerar PDF?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        escolha = scanner.nextInt();

                        if (escolha == 1) {
                            GerarTreinoAplicacao gerarPdf = new GerarTreinoAplicacao();
                            String destino = "FichaTreino_" + login + ".pdf";
                            try {
                                gerarPdf.createPdf(destino, login);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println("Nenhum treino encontrado para o usuário " + login);
                    }
                    break;

                case 3:

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    List<AvaliacaoFisica> avaliacoes = avaliacaofisicaDAO.buscarPorPessoa(login);
                    boolean encontrouavaliacao = !avaliacoes.isEmpty();

                    // Verifica se encontrou alguma avaliação física para o usuário
                    if (encontrouavaliacao) {
                        System.out.println("Detalhes das Avaliações Físicas de " + login + ":");
                        for (AvaliacaoFisica avaliacao : avaliacoes) {
                            System.out.println("Último Treino: " + avaliacao.getUltimoTreino());
                            System.out.println("Peso: " + avaliacao.getPeso());
                            System.out.println("Altura: " + avaliacao.getAltura());
                            System.out.println("IMC: " + avaliacao.getImc());
                            System.out.println("Satisfação: " + avaliacao.getSatisfacao());
                            System.out.println();
                        }

                        System.out.println("Deseja gerar PDF?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        escolha = scanner.nextInt();

                        if (escolha == 1) {
                            GerarPdfAvaliacaoFisica gerarPdf = new GerarPdfAvaliacaoFisica();

                            String destino = "AvaliacaoFisica_" + login + ".pdf";
                            try {
                                gerarPdf.createPdf(destino, login);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println("Nenhuma avaliação física encontrada para o usuário " + login);
                    }
                    break;
            }

            if (opcao == 4) {
                System.out.println("Saindo do sistema...");

            }
        }
    }

    public void menuLoginProfessor(String login, String senha) throws DocumentException, BadElementException, IOException {
        int opcao = 0;
        TreinoAplicacaoDAO treinoAplicacaoDAO = new TreinoAplicacaoDAO();

        while (opcao != 5) {
            System.out.println("Bem vindo, professor! Escolha sua opção:\n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Entrar na Academia");
            System.out.println("3 - Monitorar treinos dos alunos");
            System.out.println("4 - Monitorar avaliações fisicas dos alunos");
            System.out.println("5 - Sair do sistema");
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
                    novoAluno.setDataCriacao(LocalDate.now());
                    novoAluno.setDataModificacao(LocalDate.now());

                    pessoaDAO.adicionar(novoAluno);

                    System.out.println("Aluno cadastrado com sucesso!\n");
                    break;
                case 2:
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    // Verificação de mensalidade em dia
                    boolean mensalidadeEmDia = new AlunoPagamentoMensalidadeDAO().verificarMensalidadeEmDia(login);

                    if (mensalidadeEmDia) {
                        for (int i = 0; i < 30; ++i) {
                            System.out.println();
                        }
                        System.out.println("Acesso permitido na academia.");
                    } else {
                        System.out.println("Você não tem a mensalidade em dia. Por favor, entre em contato com a administração.");
                    }
                    break;
                case 3:
                    // Limpa a tela
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    System.out.println("Monitoramento de Treino");
                    System.out.println("Digite o login do aluno que deseja monitorar o treino:");
                    String loginAlunoTreino = scanner.nextLine();

                    boolean alunoTreinoEncontrado = false;

                    Pessoa pessoa = pessoaDAO.buscarLogin(loginAlunoTreino);

                    if (pessoa != null && pessoa.getTipoUsuario().equals("aluno")) {
                        alunoTreinoEncontrado = true;
                    }

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    if (alunoTreinoEncontrado) {
                        System.out.println("Você está monitorando o treino de:\n" + pessoa.getNome());
                        System.out.println();
                        System.out.println("1 - Cadastrar exercício no treino");
                        System.out.println("2 - Excluir exercício no treino");
                        System.out.println("3 - Ver ficha de treino do aluno");
                        System.out.println("4 - Gerar PDF das fichas de treino");
                        System.out.println("5 - Sair da opção");
                        int opcaoTreino = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        switch (opcaoTreino) {
                            case 1:
                                // Implementação para cadastrar exercício no treino
                                for (int i = 0; i < 30; ++i) {
                                    System.out.println();
                                }

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

                                treinoAplicacaoDAO.inserir(novoTreino);

                                System.out.println("Treino cadastrado com sucesso!");

                                break;
                            case 2:
                                List<TreinoAplicacao> treinos = treinoAplicacaoDAO.getTreinoAplicacao(loginAlunoTreino);

                                if (!treinos.isEmpty()) {
                                    for (int i = 0; i < 30; ++i) {
                                        System.out.println();
                                    }

                                    System.out.println("Treinos encontrados:");
                                    for (TreinoAplicacao treino : treinos) {
                                        System.out.println("Exercício: " + treino.getExercicio());
                                        System.out.println("Divisão de Treino: " + treino.getDivisaoTreino());
                                        System.out.println();
                                    }

                                    System.out.println("Qual exercício deseja excluir? Digite o nome do exercício:");
                                    String exercicioExcluir = scanner.nextLine();

                                    boolean exercicioEncontrado = false;
                                    for (TreinoAplicacao treino : treinos) {
                                        if (treino.getExercicio().equals(exercicioExcluir)) {
                                            treinoAplicacaoDAO.remover(exercicioExcluir, loginAlunoTreino);
                                            exercicioEncontrado = true;
                                            break;
                                        }
                                    }

                                    if (!exercicioEncontrado) {
                                        System.out.println("Exercício não encontrado no treino do aluno.");
                                    } else {
                                        System.out.println("Exercício excluído com sucesso!");
                                    }
                                } else {
                                    System.out.println("Nenhum treino encontrado para o aluno.");
                                }
                                break;
                            case 3:
                                for (int i = 0; i < 30; ++i) {
                                    System.out.println();
                                }

                                boolean alunoEncontrado = false;

                                Pessoa pessoatreino = pessoaDAO.buscarLogin(loginAlunoTreino);

                                if (pessoatreino != null && pessoatreino.getTipoUsuario().equals("aluno")) {
                                    alunoEncontrado = true;
                                }

                                if (alunoEncontrado) {
                                    treinos = treinoaplicacaoDAO.getTreinoAplicacao(loginAlunoTreino);
                                    boolean encontrouTreino = !treinos.isEmpty();

                                    for (TreinoAplicacao treino : treinos) {
                                        System.out.println("Detalhes do Treino de " + treino.getTreino());
                                        System.out.println("Exercício: " + treino.getExercicio());
                                        System.out.println("Exercício Aplicação: " + treino.getExercicioAplicacao());
                                        System.out.println("Divisão do Treino: " + treino.getDivisaoTreino());
                                        System.out.println("Divisão do Treino Muscular: " + treino.getDivisaoTreinoMusculo());
                                        System.out.println("Data de Criação: " + treino.getDataCriacao());
                                        System.out.println("Data de Modificação: " + treino.getDataModificacao());
                                        System.out.println();
                                    }

                                    if (!encontrouTreino) {
                                        System.out.println("Nenhum treino encontrado para o usuário " + loginAlunoTreino);
                                    }
                                } else {
                                    System.out.println("Aluno não encontrado ou não é um aluno.");
                                }
                                break;
                            case 4:
                                for (int i = 0; i < 30; ++i) {
                                    System.out.println();
                                }

                                boolean alunoEncontradoPdf = false;

                                Pessoa pessoatreinoPdf = pessoaDAO.buscarLogin(loginAlunoTreino);

                                if (pessoatreinoPdf != null && pessoatreinoPdf.getTipoUsuario().equals("aluno")) {
                                    alunoEncontradoPdf = true;
                                }

                                if (alunoEncontradoPdf) {
                                    treinos = treinoaplicacaoDAO.getTreinoAplicacao(loginAlunoTreino);
                                    boolean encontrouTreino = !treinos.isEmpty();

                                    for (TreinoAplicacao treino : treinos) {
                                        System.out.println("Detalhes do Treino de " + treino.getTreino());
                                        System.out.println("Exercício: " + treino.getExercicio());
                                        System.out.println("Exercício Aplicação: " + treino.getExercicioAplicacao());
                                        System.out.println("Divisão do Treino: " + treino.getDivisaoTreino());
                                        System.out.println("Divisão do Treino Muscular: " + treino.getDivisaoTreinoMusculo());
                                        System.out.println("Data de Criação: " + treino.getDataCriacao());
                                        System.out.println("Data de Modificação: " + treino.getDataModificacao());
                                        System.out.println();
                                    }

                                    System.out.println("Deseja gerar PDF?");
                                    System.out.println("1 - Sim");
                                    System.out.println("2 - Não");
                                    int escolhaPdf = scanner.nextInt();

                                    scanner.nextLine(); // Consumir a quebra de linha

                                    if (escolhaPdf == 1) {
                                        GerarTreinoAplicacao gerarPdf = new GerarTreinoAplicacao();
                                        String destino = "FichaTreino_" + loginAlunoTreino + ".pdf";
                                        try {
                                            gerarPdf.createPdf(destino, loginAlunoTreino);
                                            System.out.println("PDF gerado com sucesso!");
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    if (!encontrouTreino) {
                                        System.out.println("Nenhum treino encontrado para o usuário " + loginAlunoTreino);
                                    }
                                } else {
                                    System.out.println("Aluno não encontrado ou não é um aluno.");
                                }
                                break;
                            case 5:
                                System.out.println("Saindo da opção de monitoramento de treino.");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 4:
                    // Limpa a tela
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    System.out.println("Monitoramento de avaliação física do aluno!");
                    System.out.println();
                    System.out.println("Informe o login do aluno:");
                    String alunoLoginAvaliacao = scanner.nextLine();

                    // Limpa a tela
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    boolean alunoEncontradoAvaliacao = false;
                    Pessoa pessoaavaliacao = pessoaDAO.buscarLogin(alunoLoginAvaliacao);

                    if (pessoaavaliacao != null && pessoaavaliacao.getTipoUsuario().equals("aluno")) {
                        alunoEncontradoAvaliacao = true;
                    }

                    if (alunoEncontradoAvaliacao) {
                        System.out.println("Você está monitorando as avaliações físicas de:\n" + pessoaavaliacao.getNome());
                        System.out.println();
                        System.out.println("1 - Ver avaliações físicas do aluno");
                        System.out.println("2 - Adicionar nova avaliação física");
                        System.out.println("3 - Gerar PDF das avaliações físicas");
                        System.out.println("4 - Sair da opção");
                        int opcaoAvaliacao = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        switch (opcaoAvaliacao) {
                            case 1:
                                List<AvaliacaoFisica> avaliacoes;
                                try {
                                    avaliacoes = avaliacaofisicaDAO.buscarPorPessoa(alunoLoginAvaliacao);

                                    if (!avaliacoes.isEmpty()) {

                                        // Limpa a tela
                                        for (int i = 0; i < 30; ++i) {
                                            System.out.println();
                                        }

                                        System.out.println("Detalhes das Avaliações Físicas de " + alunoLoginAvaliacao + ":");
                                        for (AvaliacaoFisica avaliacao : avaliacoes) {
                                            System.out.println("Último Treino: " + avaliacao.getUltimoTreino());
                                            System.out.println("Peso: " + avaliacao.getPeso());
                                            System.out.println("Altura: " + avaliacao.getAltura());
                                            System.out.println("IMC: " + avaliacao.getImc());
                                            System.out.println("Satisfação: " + avaliacao.getSatisfacao());
                                            System.out.println("Data de Criação: " + avaliacao.getDataCriacao());
                                            System.out.println("Data de Modificação: " + avaliacao.getDataModificacao());
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("Nenhuma avaliação física encontrada para o aluno " + alunoLoginAvaliacao);
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println("Erro ao buscar avaliações físicas: " + e.getMessage());
                                }
                                break;

                            case 2:
                                AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica();
                                novaAvaliacao.setPessoa(alunoLoginAvaliacao);

                                System.out.println("Informe a data do último treino:");
                                novaAvaliacao.setUltimoTreino(scanner.nextLine());
                                System.out.println("Informe o peso:");
                                novaAvaliacao.setPeso(scanner.nextDouble());
                                System.out.println("Informe a altura:");
                                novaAvaliacao.setAltura(scanner.nextDouble());
                                double imc = novaAvaliacao.getPeso() / (novaAvaliacao.getAltura() * novaAvaliacao.getAltura());
                                novaAvaliacao.setImc(imc);
                                scanner.nextLine(); // Consumir a quebra de linha
                                System.out.println("Informe a satisfação:");
                                novaAvaliacao.setSatisfacao(scanner.nextLine());
                                novaAvaliacao.setDataCriacao(LocalDate.now());
                                novaAvaliacao.setDataModificacao(LocalDate.now());

                                try {
                                    avaliacaofisicaDAO.adicionar(novaAvaliacao);
                                    System.out.println("Nova avaliação física adicionada com sucesso!");
                                } catch (RuntimeException e) {
                                    System.out.println("Erro ao adicionar a nova avaliação física: " + e.getMessage());
                                }
                                break;

                            case 3:
                                GerarPdfAvaliacaoFisica gerarPdf = new GerarPdfAvaliacaoFisica();
                                String destino = "AvaliacaoFisica_" + alunoLoginAvaliacao + ".pdf";
                                try {
                                    gerarPdf.createPdf(destino, alunoLoginAvaliacao);
                                    System.out.println("PDF gerado com sucesso!");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 4:
                                System.out.println("Saindo da opção de consulta de avaliação física.");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void menuLoginAdministrador(String login, String senha) throws DocumentException, BadElementException, IOException {
        AlunoPagamentoMensalidadeDAO alunoPagamentoMensalidadeDAO = new AlunoPagamentoMensalidadeDAO();
        TreinoAplicacaoDAO treinoAplicacaoDAO = new TreinoAplicacaoDAO();
        int opcao = 0;
        int escolha;

        while (opcao != 7) {
            System.out.println("Bem vindo, administrador! Escolha sua opção:\n");
            System.out.println("1 - Monitorar usuários");
            System.out.println("2 - Entrar na academia");
            System.out.println("3 - Monitorar treinos dos alunos");
            System.out.println("4 - Monitorar avaliações físicas dos alunos");
            System.out.println("5 - Movimentações Financeiras");
            System.out.println("6 - Relatórios");
            System.out.println("7 - Sair do sistema");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    System.out.println("Monitoramento de usuários:");
                    System.out.println("1 - Adicionar Usuário");
                    System.out.println("2 - Excluir Usuário");
                    int opcaousuario = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do scanner

                    switch (opcaousuario) {
                        case 1:
                            for (int i = 0; i < 30; ++i) {
                                System.out.println();
                            }

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
                            System.out.println("Informe o Login:");
                            novoAluno.setLogin(scanner.nextLine());
                            System.out.println("Informe a Senha:");
                            novoAluno.setSenha(scanner.nextLine());
                            novoAluno.setDataCriacao(LocalDate.now());
                            novoAluno.setDataModificacao(LocalDate.now());

                            pessoaDAO.adicionar(novoAluno);

                            System.out.println("Usuario cadastrado com sucesso!");

                            break;

                        case 2:
                            for (int i = 0; i < 30; ++i) {
                                System.out.println();
                            }

                            System.out.println("Lista de todos os usuários:");
                            System.out.println();

                            List<Pessoa> usuarios = pessoaDAO.listarTodos();
                            for (Pessoa usuario : usuarios) {
                                System.out.println(" Nome: " + usuario.getNome() + ", Login: " + usuario.getLogin() + ", Tipo: " + usuario.getTipoUsuario());
                            }

                            System.out.println();
                            System.out.println();
                            System.out.println("Digite o login do usuário a ser excluído:");
                            String loginParaExcluir = scanner.nextLine();

                            Pessoa pessoaParaExcluir = pessoaDAO.buscarLogin(loginParaExcluir);

                            if (pessoaParaExcluir != null) {
                                pessoaDAO.remover(pessoaParaExcluir);
                                System.out.println("Usuário excluído com sucesso!");
                            } else {
                                System.out.println("Usuário não encontrado.");
                            }
                            break;
                    }
                    break;

                case 2:
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    // Verificação de mensalidade em dia
                    boolean mensalidadeEmDia = new AlunoPagamentoMensalidadeDAO().verificarMensalidadeEmDia(login);

                    if (mensalidadeEmDia) {
                        for (int i = 0; i < 30; ++i) {
                            System.out.println();
                        }
                        System.out.println("Acesso permitido na academia.");
                    } else {
                        System.out.println("Você não tem a mensalidade em dia. Por favor, entre em contato com a administração.");
                    }
                    break;
                case 3:
                    // Limpa a tela
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }
                    System.out.println("Monitoramento de Treino");
                    System.out.println("Digite o login do aluno que deseja monitorar o treino:");
                    String loginAlunoTreino = scanner.nextLine();

                    boolean alunoTreinoEncontrado = false;

                    Pessoa pessoa = pessoaDAO.buscarLogin(loginAlunoTreino);

                    if (pessoa != null && pessoa.getTipoUsuario().equals("aluno")) {
                        alunoTreinoEncontrado = true;
                    }

                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    if (alunoTreinoEncontrado) {
                        System.out.println("Você está monitorando o treino de:\n" + pessoa.getNome());
                        System.out.println();
                        System.out.println("1 - Cadastrar exercício no treino");
                        System.out.println("2 - Excluir exercício no treino");
                        System.out.println("3 - Ver ficha de treino do aluno");
                        System.out.println("4 - Gerar PDF das fichas de treino");
                        System.out.println("5 - Sair da opção");
                        int opcaoTreino = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        switch (opcaoTreino) {
                            case 1:
                                // Implementação para cadastrar exercício no treino
                                for (int i = 0; i < 30; ++i) {
                                    System.out.println();
                                }

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

                                treinoAplicacaoDAO.inserir(novoTreino);

                                System.out.println("Treino cadastrado com sucesso!");

                                break;
                            case 2:
                                List<TreinoAplicacao> treinos = treinoAplicacaoDAO.getTreinoAplicacao(loginAlunoTreino);

                                if (!treinos.isEmpty()) {
                                    for (int i = 0; i < 30; ++i) {
                                        System.out.println();
                                    }

                                    System.out.println("Treinos encontrados:");
                                    for (TreinoAplicacao treino : treinos) {
                                        System.out.println("Exercício: " + treino.getExercicio());
                                        System.out.println("Divisão de Treino: " + treino.getDivisaoTreino());
                                        System.out.println();
                                    }

                                    System.out.println("Qual exercício deseja excluir? Digite o nome do exercício:");
                                    String exercicioExcluir = scanner.nextLine();

                                    boolean exercicioEncontrado = false;
                                    for (TreinoAplicacao treino : treinos) {
                                        if (treino.getExercicio().equals(exercicioExcluir)) {
                                            treinoAplicacaoDAO.remover(exercicioExcluir, loginAlunoTreino);
                                            exercicioEncontrado = true;
                                            break;
                                        }
                                    }

                                    if (!exercicioEncontrado) {
                                        System.out.println("Exercício não encontrado no treino do aluno.");
                                    } else {
                                        System.out.println("Exercício excluído com sucesso!");
                                    }
                                } else {
                                    System.out.println("Nenhum treino encontrado para o aluno.");
                                }
                                break;
                            case 3:
                                for (int i = 0; i < 30; ++i) {
                                    System.out.println();
                                }

                                boolean alunoEncontrado = false;

                                Pessoa pessoatreino = pessoaDAO.buscarLogin(loginAlunoTreino);

                                if (pessoatreino != null && pessoatreino.getTipoUsuario().equals("aluno")) {
                                    alunoEncontrado = true;
                                }

                                if (alunoEncontrado) {
                                    treinos = treinoaplicacaoDAO.getTreinoAplicacao(loginAlunoTreino);
                                    boolean encontrouTreino = !treinos.isEmpty();

                                    for (TreinoAplicacao treino : treinos) {
                                        System.out.println("Detalhes do Treino de " + treino.getTreino());
                                        System.out.println("Exercício: " + treino.getExercicio());
                                        System.out.println("Exercício Aplicação: " + treino.getExercicioAplicacao());
                                        System.out.println("Divisão do Treino: " + treino.getDivisaoTreino());
                                        System.out.println("Divisão do Treino Muscular: " + treino.getDivisaoTreinoMusculo());
                                        System.out.println("Data de Criação: " + treino.getDataCriacao());
                                        System.out.println("Data de Modificação: " + treino.getDataModificacao());
                                        System.out.println();
                                    }

                                    if (!encontrouTreino) {
                                        System.out.println("Nenhum treino encontrado para o usuário " + loginAlunoTreino);
                                    }
                                } else {
                                    System.out.println("Aluno não encontrado ou não é um aluno.");
                                }
                                break;
                            case 4:
                                for (int i = 0; i < 30; ++i) {
                                    System.out.println();
                                }

                                boolean alunoEncontradoPdf = false;

                                Pessoa pessoatreinoPdf = pessoaDAO.buscarLogin(loginAlunoTreino);

                                if (pessoatreinoPdf != null && pessoatreinoPdf.getTipoUsuario().equals("aluno")) {
                                    alunoEncontradoPdf = true;
                                }

                                if (alunoEncontradoPdf) {
                                    treinos = treinoaplicacaoDAO.getTreinoAplicacao(loginAlunoTreino);
                                    boolean encontrouTreino = !treinos.isEmpty();

                                    for (TreinoAplicacao treino : treinos) {
                                        System.out.println("Detalhes do Treino de " + treino.getTreino());
                                        System.out.println("Exercício: " + treino.getExercicio());
                                        System.out.println("Exercício Aplicação: " + treino.getExercicioAplicacao());
                                        System.out.println("Divisão do Treino: " + treino.getDivisaoTreino());
                                        System.out.println("Divisão do Treino Muscular: " + treino.getDivisaoTreinoMusculo());
                                        System.out.println("Data de Criação: " + treino.getDataCriacao());
                                        System.out.println("Data de Modificação: " + treino.getDataModificacao());
                                        System.out.println();
                                    }

                                    System.out.println("Deseja gerar PDF?");
                                    System.out.println("1 - Sim");
                                    System.out.println("2 - Não");
                                    int escolhaPdf = scanner.nextInt();

                                    scanner.nextLine(); // Consumir a quebra de linha

                                    if (escolhaPdf == 1) {
                                        GerarTreinoAplicacao gerarPdf = new GerarTreinoAplicacao();
                                        String destino = "FichaTreino_" + loginAlunoTreino + ".pdf";
                                        try {
                                            gerarPdf.createPdf(destino, loginAlunoTreino);
                                            System.out.println("PDF gerado com sucesso!");
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    if (!encontrouTreino) {
                                        System.out.println("Nenhum treino encontrado para o usuário " + loginAlunoTreino);
                                    }
                                } else {
                                    System.out.println("Aluno não encontrado ou não é um aluno.");
                                }
                                break;
                            case 5:
                                System.out.println("Saindo da opção de monitoramento de treino.");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 4:
                    // Limpa a tela
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    System.out.println("Monitoramento de avaliação física do aluno!");
                    System.out.println();
                    System.out.println("Informe o login do aluno:");
                    String alunoLoginAvaliacao = scanner.nextLine();

                    // Limpa a tela
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    boolean alunoEncontradoAvaliacao = false;
                    Pessoa pessoaavaliacao = pessoaDAO.buscarLogin(alunoLoginAvaliacao);

                    if (pessoaavaliacao != null && pessoaavaliacao.getTipoUsuario().equals("aluno")) {
                        alunoEncontradoAvaliacao = true;
                    }

                    if (alunoEncontradoAvaliacao) {
                        System.out.println("Você está monitorando as avaliações físicas de:\n" + pessoaavaliacao.getNome());
                        System.out.println();
                        System.out.println("1 - Ver avaliações físicas do aluno");
                        System.out.println("2 - Adicionar nova avaliação física");
                        System.out.println("3 - Gerar PDF das avaliações físicas");
                        System.out.println("4 - Sair da opção");
                        int opcaoAvaliacao = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        switch (opcaoAvaliacao) {
                            case 1:
                                List<AvaliacaoFisica> avaliacoes;
                                try {
                                    avaliacoes = avaliacaofisicaDAO.buscarPorPessoa(alunoLoginAvaliacao);

                                    if (!avaliacoes.isEmpty()) {

                                        // Limpa a tela
                                        for (int i = 0; i < 30; ++i) {
                                            System.out.println();
                                        }

                                        System.out.println("Detalhes das Avaliações Físicas de " + alunoLoginAvaliacao + ":");
                                        for (AvaliacaoFisica avaliacao : avaliacoes) {
                                            System.out.println("Último Treino: " + avaliacao.getUltimoTreino());
                                            System.out.println("Peso: " + avaliacao.getPeso());
                                            System.out.println("Altura: " + avaliacao.getAltura());
                                            System.out.println("IMC: " + avaliacao.getImc());
                                            System.out.println("Satisfação: " + avaliacao.getSatisfacao());
                                            System.out.println("Data de Criação: " + avaliacao.getDataCriacao());
                                            System.out.println("Data de Modificação: " + avaliacao.getDataModificacao());
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("Nenhuma avaliação física encontrada para o aluno " + alunoLoginAvaliacao);
                                    }
                                } catch (RuntimeException e) {
                                    System.out.println("Erro ao buscar avaliações físicas: " + e.getMessage());
                                }
                                break;

                            case 2:
                                AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica();
                                novaAvaliacao.setPessoa(alunoLoginAvaliacao);

                                System.out.println("Informe a data do último treino:");
                                novaAvaliacao.setUltimoTreino(scanner.nextLine());
                                System.out.println("Informe o peso:");
                                novaAvaliacao.setPeso(scanner.nextDouble());
                                System.out.println("Informe a altura:");
                                novaAvaliacao.setAltura(scanner.nextDouble());
                                double imc = novaAvaliacao.getPeso() / (novaAvaliacao.getAltura() * novaAvaliacao.getAltura());
                                novaAvaliacao.setImc(imc);
                                scanner.nextLine(); // Consumir a quebra de linha
                                System.out.println("Informe a satisfação:");
                                novaAvaliacao.setSatisfacao(scanner.nextLine());
                                novaAvaliacao.setDataCriacao(LocalDate.now());
                                novaAvaliacao.setDataModificacao(LocalDate.now());

                                try {
                                    avaliacaofisicaDAO.adicionar(novaAvaliacao);
                                    System.out.println("Nova avaliação física adicionada com sucesso!");
                                } catch (RuntimeException e) {
                                    System.out.println("Erro ao adicionar a nova avaliação física: " + e.getMessage());
                                }
                                break;

                            case 3:
                                GerarPdfAvaliacaoFisica gerarPdf = new GerarPdfAvaliacaoFisica();
                                String destino = "AvaliacaoFisica_" + alunoLoginAvaliacao + ".pdf";
                                try {
                                    gerarPdf.createPdf(destino, alunoLoginAvaliacao);
                                    System.out.println("PDF gerado com sucesso!");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 4:
                                System.out.println("Saindo da opção de consulta de avaliação física.");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    } else {
                        System.out.println("Aluno não encontrado ou não é um aluno.");
                    }
                    break;
                case 5:
                    // Limpa a tela
                    for (int i = 0; i < 30; ++i) {
                        System.out.println();
                    }

                    System.out.println("Movimentações Financeiras:\n1 - Ver mensalidades\n2 - Registrar pagamento de aluno\nDigite sua opção:");
                    int opcaoFinanceira = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoFinanceira) {
                        case 1:
                            // Limpa a tela
                            for (int i = 0; i < 30; ++i) {
                                System.out.println();
                            }

                            System.out.println("Digite o login do aluno para ver as mensalidades:");
                            String loginAlunoVerMensalidades = scanner.nextLine();

                            boolean alunoFinanceiroEncontrado = false;

                            Pessoa pessoafinanceiro = pessoaDAO.buscarLogin(loginAlunoVerMensalidades);

                            if (pessoafinanceiro != null && pessoafinanceiro.getTipoUsuario().equals("aluno")) {
                                alunoFinanceiroEncontrado = true;
                            }

                            if (alunoFinanceiroEncontrado) {
                                List<AlunoPagamentoMensalidade> pagamentos = alunoPagamentoMensalidadeDAO.buscarTodos();
                                boolean pagamentosEncontrados = false;

                                for (AlunoPagamentoMensalidade pagamento : pagamentos) {
                                    if (pagamento != null && pagamento.getPessoa().equals(loginAlunoVerMensalidades)) {
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
                            // Limpa a tela
                            for (int i = 0; i < 30; ++i) {
                                System.out.println();
                            }
                            System.out.println("Digite o login do aluno:");
                            String loginAlunoPagamento = scanner.nextLine();

                            boolean alunoParaPagamentoEncontrado = false;

                            Pessoa pessoapagamento = pessoaDAO.buscarLogin(loginAlunoPagamento);

                            if (pessoapagamento != null && pessoapagamento.getTipoUsuario().equals("aluno")) {
                                alunoParaPagamentoEncontrado = true;
                            }

                            if (alunoParaPagamentoEncontrado) {
                                AlunoPagamentoMensalidade novoPagamento = new AlunoPagamentoMensalidade();
                                novoPagamento.setPessoa(loginAlunoPagamento);

                                System.out.println("Digite o valor do pagamento:");
                                double valorPagamento = scanner.nextDouble();
                                novoPagamento.setValorPago(valorPagamento);

                                System.out.println("Digite a modalidade:");
                                scanner.nextLine();  // Limpa o buffer do scanner
                                String modalidade = scanner.nextLine();
                                novoPagamento.setModalidade(modalidade);

                                novoPagamento.setData(LocalDate.now());

                                if (modalidade.equals("mensalidade") && valorPagamento == 100) {
                                    novoPagamento.setMensalidadeVigente("valido");
                                } else {
                                    novoPagamento.setMensalidadeVigente("invalido");
                                }

                                alunoPagamentoMensalidadeDAO.inserirAlunoPagamentoMensalidade(novoPagamento);

                                System.out.println("Pagamento registrado com sucesso!");
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;
                case 6:
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

                            System.out.println();
                            alunoPagamentoMensalidadeDAO.relatorioAlunosPagaramAteFimDoMes(mesRelatorio, anoRelatorio);
                            System.out.println();

                            System.out.println("Deseja gerar PDF?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            escolha = scanner.nextInt();

                            if (escolha == 1) {
                                GerarPdfRelatorioPagamentos gerarPdf = new GerarPdfRelatorioPagamentos();
                                try {
                                    gerarPdf.createPdf("RelatorioPagamentos.pdf", mesRelatorio, anoRelatorio);
                                } catch (DocumentException | IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            break;
                        case 2:
                            System.out.println("Informe o mês (1 a 12):");
                            int mesMovimentacao = scanner.nextInt();
                            System.out.println("Informe o ano:");
                            int anoMovimentacao = scanner.nextInt();

                            System.out.println();
                            alunoPagamentoMensalidadeDAO.relatorioMovimentacaoAcademiaMes(mesMovimentacao, anoMovimentacao);
                            System.out.println();

                            System.out.println("Deseja gerar PDF?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            escolha = scanner.nextInt();

                            if (escolha == 1) {
                                GerarPdfRelatorioPagamentos gerarPdf = new GerarPdfRelatorioPagamentos();
                                try {
                                    gerarPdf.createPdf("RelatorioPagamentos.pdf", mesMovimentacao, anoMovimentacao);
                                } catch (DocumentException | IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Finalizando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        }

    }
}
