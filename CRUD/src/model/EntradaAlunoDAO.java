package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EntradaAlunoDAO {

    private String sql;
    private EntradaAluno entradaAluno;

    // INSERT
    public void adicionar(EntradaAluno entradaAluno) {
        sql = "INSERT INTO entrada_aluno (data, nascimento, data_criacao, data_modificacao) VALUES (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setTimestamp(1, Timestamp.valueOf(entradaAluno.getData()));
            ps.setString(2, entradaAluno.getNascimento());
            ps.setDate(3, java.sql.Date.valueOf(entradaAluno.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(entradaAluno.getDataModificacao()));

            ps.execute();

            System.out.println("\nEntrada de aluno inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa entrada de aluno no banco!", e);
        }
    }

    // REMOVE
    public void remover(EntradaAluno entradaAluno) {
        sql = "DELETE FROM entrada_aluno WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, entradaAluno.getId());
            ps.execute();

            System.out.println("\nEntrada de aluno removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a entrada de aluno!", e);
        }
    }

    // UPDATE
    public void alterar(EntradaAluno entradaAluno, EntradaAluno novaEntradaAluno) {
        sql = "UPDATE entrada_aluno SET data = ?, nascimento = ?, data_modificacao = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setTimestamp(1, Timestamp.valueOf(novaEntradaAluno.getData()));
            ps.setString(2, novaEntradaAluno.getNascimento());
            ps.setDate(3, java.sql.Date.valueOf(novaEntradaAluno.getDataModificacao()));
            ps.setLong(4, entradaAluno.getId());

            ps.execute();

            System.out.println("\nEntrada de aluno alterada com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a entrada de aluno!", e);
        }
    }

    // BUSCAR ID
    public EntradaAluno buscar(long id) {
        sql = "SELECT * FROM entrada_aluno WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                entradaAluno = new EntradaAluno();

                if (rs.next()) {
                    entradaAluno.setId(rs.getLong("id"));
                    entradaAluno.setData(rs.getTimestamp("data").toLocalDateTime());
                    entradaAluno.setNascimento(rs.getString("nascimento"));
                    entradaAluno.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    entradaAluno.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                } else {
                    throw new SQLException("Entrada de aluno não encontrada");
                }

                return entradaAluno;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a entrada de aluno!", e);
        }
    }

    // LISTAR TODAS AS ENTRADAS DE ALUNOS
    public List<EntradaAluno> listar() {
        sql = "SELECT * FROM entrada_aluno";
        List<EntradaAluno> entradasAlunos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EntradaAluno entradaAluno = new EntradaAluno();
                entradaAluno.setId(rs.getLong("id"));
                entradaAluno.setData(rs.getTimestamp("data").toLocalDateTime());
                entradaAluno.setNascimento(rs.getString("nascimento"));
                entradaAluno.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                entradaAluno.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                entradasAlunos.add(entradaAluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar as entradas de alunos!", e);
        }

        return entradasAlunos;
    }
}
