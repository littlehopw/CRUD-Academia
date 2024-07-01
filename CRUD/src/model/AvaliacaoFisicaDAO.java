package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoFisicaDAO {

    private AvaliacaoFisica a;
    private String sql;

    // INSERT
    public void adicionar(AvaliacaoFisica avaliacao) {
        sql = "INSERT INTO avaliacao_fisica (pessoa, ultimo_treino, peso, altura, imc, satisfacao, data_criacao, data_modificacao) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, avaliacao.getPessoa());
            ps.setString(2, avaliacao.getUltimoTreino());
            ps.setDouble(3, avaliacao.getPeso());
            ps.setDouble(4, avaliacao.getAltura());
            ps.setDouble(5, avaliacao.getImc());
            ps.setString(6, avaliacao.getSatisfacao());
            ps.setDate(7, java.sql.Date.valueOf(avaliacao.getDataCriacao()));
            ps.setDate(8, java.sql.Date.valueOf(avaliacao.getDataModificacao()));

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar a avaliação física no banco!", e);
        }
    }

    // REMOVE
    public void remover(AvaliacaoFisica avaliacao) {
        sql = "DELETE FROM avaliacao_fisica WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, avaliacao.getId());
            ps.execute();

            System.out.println("\n Avaliação física removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a avaliação física!", e);
        }
    }

    // UPDATE
    public void alterar(AvaliacaoFisica avaliacao, AvaliacaoFisica novaAvaliacao) {
        sql = "UPDATE avaliacao_fisica SET pessoa = ?, ultimo_treino = ?, peso = ?, altura = ?, imc = ?, satisfacao = ?, data_modificacao = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, novaAvaliacao.getPessoa());
            ps.setString(2, novaAvaliacao.getUltimoTreino());
            ps.setDouble(3, novaAvaliacao.getPeso());
            ps.setDouble(4, novaAvaliacao.getAltura());
            ps.setDouble(5, novaAvaliacao.getImc());
            ps.setString(6, novaAvaliacao.getSatisfacao());
            ps.setDate(7, java.sql.Date.valueOf(novaAvaliacao.getDataModificacao()));
            ps.setLong(8, avaliacao.getId());

            ps.execute();

            System.out.println("\n Avaliação física alterada com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a avaliação física!", e);
        }
    }

    // BUSCAR ID
    public AvaliacaoFisica buscar(long id) {
        sql = "SELECT * FROM avaliacao_fisica WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                a = new AvaliacaoFisica();

                if (rs.next()) {
                    a.setId(rs.getLong("id"));
                    a.setPessoa(rs.getString("pessoa"));
                    a.setUltimoTreino(rs.getString("ultimoTreino"));
                    a.setPeso(rs.getDouble("peso"));
                    a.setAltura(rs.getDouble("altura"));
                    a.setImc(rs.getDouble("imc"));
                    a.setSatisfacao(rs.getString("satisfacao"));
                    a.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    a.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                } else {
                    throw new SQLException("Avaliação física não encontrada");
                }

                return a;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a avaliação física!", e);
        }
    }

    // ACHAR POR PESSOA
    public List<AvaliacaoFisica> buscarPorPessoa(String pessoa) {
        List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
        sql = "SELECT * FROM avaliacao_fisica WHERE pessoa = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, pessoa);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AvaliacaoFisica avaliacao = new AvaliacaoFisica();
                    avaliacao.setId(rs.getLong("id"));
                    avaliacao.setPessoa(rs.getString("pessoa"));
                    avaliacao.setUltimoTreino(rs.getString("ultimo_treino"));
                    avaliacao.setPeso(rs.getDouble("peso"));
                    avaliacao.setAltura(rs.getDouble("altura"));
                    avaliacao.setImc(rs.getDouble("imc"));
                    avaliacao.setSatisfacao(rs.getString("satisfacao"));
                    avaliacao.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    avaliacao.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());

                    avaliacoes.add(avaliacao);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar as avaliações físicas por pessoa!", e);
        }

        return avaliacoes;
    }
}
