package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DivisaoTreinoDAO {

    private String sql;
    private DivisaoTreino divisaoTreino;

    // INSERT
    public void adicionar(DivisaoTreino divisaoTreino) {
        sql = "INSERT INTO divisao_treino (nome, descricao, data_criacao, data_modificacao) VALUES (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, divisaoTreino.getNome());
            ps.setString(2, divisaoTreino.getDescricao());
            ps.setDate(3, java.sql.Date.valueOf(divisaoTreino.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(divisaoTreino.getDataModificacao()));

            ps.execute();

            System.out.println("\nDivisão de treino inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa divisão de treino no banco!", e);
        }
    }

    // REMOVE
    public void remover(DivisaoTreino divisaoTreino) {
        sql = "DELETE FROM divisao_treino WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, divisaoTreino.getId());
            ps.execute();

            System.out.println("\nDivisão de treino removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a divisão de treino!", e);
        }
    }

    // UPDATE
    public void alterar(DivisaoTreino divisaoTreino, DivisaoTreino novaDivisaoTreino) {
        sql = "UPDATE divisao_treino SET nome = ?, descricao = ?, data_modificacao = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, novaDivisaoTreino.getNome());
            ps.setString(2, novaDivisaoTreino.getDescricao());
            ps.setDate(3, java.sql.Date.valueOf(novaDivisaoTreino.getDataModificacao()));
            ps.setLong(4, divisaoTreino.getId());

            ps.execute();

            System.out.println("\nDivisão de treino alterada com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a divisão de treino!", e);
        }
    }

    //BUSCAR ID
    public DivisaoTreino buscar(long id) {
        sql = "SELECT * FROM divisao_treino WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                divisaoTreino = new DivisaoTreino();

                if (rs.next()) {
                    divisaoTreino.setId(rs.getLong("id"));
                    divisaoTreino.setNome(rs.getString("nome"));
                    divisaoTreino.setDescricao(rs.getString("descricao"));
                    divisaoTreino.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    divisaoTreino.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                } else {
                    throw new SQLException("Divisão de treino não encontrada");
                }

                return divisaoTreino;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a divisão de treino!", e);
        }
    }

    //BUSCAR NOME
    public DivisaoTreino buscarNome(String nome) {
        sql = "SELECT * FROM divisao_treino WHERE nome = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                divisaoTreino = new DivisaoTreino();

                if (rs.next()) {
                    divisaoTreino.setId(rs.getLong("id"));
                    divisaoTreino.setNome(rs.getString("nome"));
                    divisaoTreino.setDescricao(rs.getString("descricao"));
                    divisaoTreino.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    divisaoTreino.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                } else {
                    throw new SQLException("Divisão de treino não encontrada");
                }

                return divisaoTreino;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a divisão de treino!", e);
        }
    }

    // LISTAR TODAS AS DIVISÕES DE TREINO
    public List<DivisaoTreino> listar() {
        sql = "SELECT * FROM divisao_treino";
        List<DivisaoTreino> divisoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DivisaoTreino divisao = new DivisaoTreino();
                divisao.setId(rs.getLong("id"));
                divisao.setNome(rs.getString("nome"));
                divisao.setDescricao(rs.getString("descricao"));
                divisao.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                divisao.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                divisoes.add(divisao);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar as divisões de treino!", e);
        }

        return divisoes;
    }
}
