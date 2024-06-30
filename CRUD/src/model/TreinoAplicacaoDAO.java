package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoAplicacaoDAO {

    private String sql;
    private TreinoAplicacao t;

    public void inserirTreinoAplicacaoExemplo() {

    }

    // INSERT
    public void inserir(TreinoAplicacao treinoaplicacao) {
        sql = "INSERT INTO treino_aplicacao (treino, exercicio, exercicio_aplicacao, divisao_treino, divisao_treino_musculo, data_criacao, data_modificacao) "
                + "VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, treinoaplicacao.getTreino());
            ps.setString(2, treinoaplicacao.getExercicio());
            ps.setString(3, treinoaplicacao.getExercicioAplicacao());
            ps.setString(4, treinoaplicacao.getDivisaoTreino());
            ps.setString(5, treinoaplicacao.getDivisaoTreinoMusculo());
            ps.setDate(6, java.sql.Date.valueOf(treinoaplicacao.getDataCriacao()));
            ps.setDate(7, java.sql.Date.valueOf(treinoaplicacao.getDataModificacao()));

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar o treino no banco!", e);
        }
    }

    // REMOVE
    public void remover(String exercicio, String treino) {
        sql = "DELETE FROM treino_aplicacao WHERE exercicio = ? and treino = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, exercicio);
            ps.setString(2, treino);

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover o exercício!", e);
        }
    }

    // UPDATE
    public void alterar(TreinoAplicacao treinoaplicacao) {
        sql = "UPDATE treino_aplicacao SET treino = ?, exercicio = ?, exercicio_aplicacao = ?, divisao_treino = ?, divisao_treino_musculo = ?, data_modificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            // VALORES
            ps.setString(1, treinoaplicacao.getTreino());
            ps.setString(2, treinoaplicacao.getExercicio());
            ps.setString(3, treinoaplicacao.getExercicioAplicacao());
            ps.setString(4, treinoaplicacao.getDivisaoTreino());
            ps.setString(5, treinoaplicacao.getDivisaoTreinoMusculo());
            ps.setDate(6, java.sql.Date.valueOf(treinoaplicacao.getDataModificacao()));
            ps.setLong(7, treinoaplicacao.getId());

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar o treino!", e);
        }
    }

    //ACHAR NOME
    public List<TreinoAplicacao> getTreinoAplicacao(String login) {
        List<TreinoAplicacao> treinos = new ArrayList<>();
        sql = "SELECT * FROM treino_aplicacao WHERE treino = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TreinoAplicacao treino = new TreinoAplicacao();
                    treino.setId(rs.getLong("id"));
                    treino.setTreino(rs.getString("treino"));
                    treino.setExercicio(rs.getString("exercicio"));
                    treino.setExercicioAplicacao(rs.getString("exercicio_aplicacao"));
                    treino.setDivisaoTreino(rs.getString("divisao_treino"));
                    treino.setDivisaoTreinoMusculo(rs.getString("divisao_treino_musculo"));
                    treino.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    treino.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());

                    treinos.add(treino);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar treinos aplicados!", e);
        }

        return treinos;
    }
}
