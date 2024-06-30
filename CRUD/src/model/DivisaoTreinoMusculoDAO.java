package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DivisaoTreinoMusculoDAO {

    private String sql;
    private DivisaoTreinoMusculo divisaoTreinoMusculo;

    // INSERT
    public void adicionar(DivisaoTreinoMusculo divisaoTreinoMusculo) {
        sql = "INSERT INTO divisao_treino_musculo (descricao, divisaoTreino, data_criacao, data_modificacao) VALUES (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, divisaoTreinoMusculo.getDescricao());
            ps.setString(2, divisaoTreinoMusculo.getDivisaoTreino());
            ps.setDate(3, java.sql.Date.valueOf(divisaoTreinoMusculo.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(divisaoTreinoMusculo.getDataModificacao()));

            ps.execute();

            System.out.println("\nDivisão de treino músculo inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa divisão de treino músculo no banco!", e);
        }
    }

    // REMOVE
    public void remover(DivisaoTreinoMusculo divisaoTreinoMusculo) {
        sql = "DELETE FROM divisao_treino_musculo WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, divisaoTreinoMusculo.getId());
            ps.execute();

            System.out.println("\nDivisão de treino músculo removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a divisão de treino músculo!", e);
        }
    }

    // UPDATE
    public void alterar(DivisaoTreinoMusculo divisaoTreinoMusculo, DivisaoTreinoMusculo novaDivisaoTreinoMusculo) {
        sql = "UPDATE divisao_treino_musculo SET descricao = ?, divisaoTreino = ?, data_modificacao = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, novaDivisaoTreinoMusculo.getDescricao());
            ps.setString(2, novaDivisaoTreinoMusculo.getDivisaoTreino());
            ps.setDate(3, java.sql.Date.valueOf(novaDivisaoTreinoMusculo.getDataModificacao()));
            ps.setLong(4, divisaoTreinoMusculo.getId());

            ps.execute();

            System.out.println("\nDivisão de treino músculo alterada com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a divisão de treino músculo!", e);
        }
    }

    // BUSCAR ID
    public DivisaoTreinoMusculo buscar(long id) {
        sql = "SELECT * FROM divisao_treino_musculo WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                divisaoTreinoMusculo = new DivisaoTreinoMusculo();

                if (rs.next()) {
                    divisaoTreinoMusculo.setId(rs.getLong("id"));
                    divisaoTreinoMusculo.setDescricao(rs.getString("descricao"));
                    divisaoTreinoMusculo.setDivisaoTreino(rs.getString("divisaoTreino"));
                    divisaoTreinoMusculo.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    divisaoTreinoMusculo.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                } else {
                    throw new SQLException("Divisão de treino músculo não encontrada");
                }

                return divisaoTreinoMusculo;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a divisão de treino músculo!", e);
        }
    }

    // BUSCAR NOME
    public DivisaoTreinoMusculo buscarNome(String nome) {
        sql = "SELECT * FROM divisao_treino_musculo WHERE divisaoTreino = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                divisaoTreinoMusculo = new DivisaoTreinoMusculo();

                if (rs.next()) {
                    divisaoTreinoMusculo.setId(rs.getLong("id"));
                    divisaoTreinoMusculo.setDescricao(rs.getString("descricao"));
                    divisaoTreinoMusculo.setDivisaoTreino(rs.getString("divisaoTreino"));
                    divisaoTreinoMusculo.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    divisaoTreinoMusculo.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                } else {
                    throw new SQLException("Divisão de treino músculo não encontrada");
                }

                return divisaoTreinoMusculo;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a divisão de treino músculo!", e);
        }
    }

    // LISTAR TODAS AS DIVISÕES DE TREINO MÚSCULO
    public List<DivisaoTreinoMusculo> listar() {
        sql = "SELECT * FROM divisao_treino_musculo";
        List<DivisaoTreinoMusculo> divisoesMusculos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DivisaoTreinoMusculo divisaoMusculo = new DivisaoTreinoMusculo();
                divisaoMusculo.setId(rs.getLong("id"));
                divisaoMusculo.setDescricao(rs.getString("descricao"));
                divisaoMusculo.setDivisaoTreino(rs.getString("divisaoTreino"));
                divisaoMusculo.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                divisaoMusculo.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                divisoesMusculos.add(divisaoMusculo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar as divisões de treino músculo!", e);
        }

        return divisoesMusculos;
    }
}
