package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExercicioAplicacaoDAO {

    private String sql;
    private ExercicioAplicacao exercicioAplicacao;

    // Método para inserir exemplos de aplicações de exercícios
    public void inserirAplicacaoExemplo() {
//        ExercicioAplicacao exemplo1 = new ExercicioAplicacao("Elevação Pélvica", "3x15");
//        inserirAplicacao(exemplo1);
//
//        ExercicioAplicacao exemplo2 = new ExercicioAplicacao("Rosca Direta", "4x12");
//        inserirAplicacao(exemplo2);
//
//        ExercicioAplicacao exemplo3 = new ExercicioAplicacao("Agachamento", "4x10");
//        inserirAplicacao(exemplo3);
//
//        ExercicioAplicacao exemplo4 = new ExercicioAplicacao("Crucifixo", "3x12");
//        inserirAplicacao(exemplo4);
//
//        ExercicioAplicacao exemplo5 = new ExercicioAplicacao("Remada Curvada", "4x10");
//        inserirAplicacao(exemplo5);
//
//        ExercicioAplicacao exemplo6 = new ExercicioAplicacao("Prancha", "3 séries de 1 minuto.");
//        inserirAplicacao(exemplo6);
    }

    // INSERT
    public void adicionar(ExercicioAplicacao exercicioAplicacao) {
        sql = "INSERT INTO exercicio_aplicacao (nome, descricao, data_criacao, data_modificacao) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, exercicioAplicacao.getNome());
            ps.setString(2, exercicioAplicacao.getDescricao());
            ps.setObject(3, exercicioAplicacao.getDataCriacao());
            ps.setObject(4, exercicioAplicacao.getDataModificacao());

            ps.execute();

            System.out.println("\nExercício aplicação inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa aplicação de exercício no banco!", e);
        }
    }

    // REMOVE
    public void remover(ExercicioAplicacao exercicioAplicacao) {
        sql = "DELETE FROM exercicio_aplicacao WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, exercicioAplicacao.getId());
            ps.execute();

            System.out.println("\nExercício aplicação removido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a aplicação de exercício!", e);
        }
    }

    // UPDATE
    public void alterar(ExercicioAplicacao exercicioAplicacao, ExercicioAplicacao novaExercicioAplicacao) {
        sql = "UPDATE exercicio_aplicacao SET nome = ?, descricao = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, novaExercicioAplicacao.getNome());
            ps.setString(2, novaExercicioAplicacao.getDescricao());
            ps.setLong(3, exercicioAplicacao.getId());

            ps.execute();

            System.out.println("\nExercício aplicação alterado com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a aplicação de exercício!", e);
        }
    }

    // BUSCAR ID
    public ExercicioAplicacao buscar(long id) {
        sql = "SELECT * FROM exercicio_aplicacao WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                exercicioAplicacao = new ExercicioAplicacao();

                if (rs.next()) {
                    exercicioAplicacao.setId(rs.getLong("id"));
                    exercicioAplicacao.setNome(rs.getString("nome"));
                    exercicioAplicacao.setDescricao(rs.getString("descricao"));
                } else {
                    throw new SQLException("Exercício aplicação não encontrada");
                }

                return exercicioAplicacao;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a aplicação de exercício!", e);
        }
    }

    // LISTAR TODAS AS APLICAÇÕES DE EXERCÍCIOS
    public List<ExercicioAplicacao> listar() {
        sql = "SELECT * FROM exercicio_aplicacao";
        List<ExercicioAplicacao> aplicacoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ExercicioAplicacao aplicacao = new ExercicioAplicacao();
                aplicacao.setId(rs.getLong("id"));
                aplicacao.setNome(rs.getString("nome"));
                aplicacao.setDescricao(rs.getString("descricao"));
                aplicacoes.add(aplicacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar as aplicações de exercício!", e);
        }

        return aplicacoes;
    }
}
