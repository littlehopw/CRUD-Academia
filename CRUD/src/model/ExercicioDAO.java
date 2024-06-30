package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {

    private String sql;
    private Exercicio exercicio;

    // Método para inserir exemplos de exercícios
    public void inserirExercicioExemplo() {
//        Exercicio exemplo1 = new Exercicio("Elevação Pélvica", "Fortalece os glúteos e músculos do core.");
//        adicionar(exemplo1);
//
//        Exercicio exemplo2 = new Exercicio("Rosca Direta", "Fortalece os bíceps.");
//        adicionar(exemplo2);
//
//        Exercicio exemplo3 = new Exercicio("Agachamento", "Fortalece as pernas e glúteos.");
//        adicionar(exemplo3);
//
//        Exercicio exemplo4 = new Exercicio("Crucifixo", "Fortalece os músculos do peito.");
//        adicionar(exemplo4);
//
//        Exercicio exemplo5 = new Exercicio("Remada Curvada", "Fortalece as costas e bíceps.");
//        adicionar(exemplo5);
//
//        Exercicio exemplo6 = new Exercicio("Prancha", "Fortalece o core.");
//        adicionar(exemplo6);
    }

    // INSERT
    public void adicionar(Exercicio exercicio) {
        sql = "INSERT INTO exercicio (nome, descricao_foto) VALUES (?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, exercicio.getNome());
            ps.setString(2, exercicio.getDescricaoFoto());

            ps.execute();

            System.out.println("\nExercício inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar esse exercício no banco!", e);
        }
    }

    // REMOVE
    public void remover(Exercicio exercicio) {
        sql = "DELETE FROM exercicio WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, exercicio.getId());
            ps.execute();

            System.out.println("\nExercício removido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover o exercício!", e);
        }
    }

    // UPDATE
    public void alterar(Exercicio exercicio, Exercicio novoExercicio) {
        sql = "UPDATE exercicio SET nome = ?, descricao_foto = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, novoExercicio.getNome());
            ps.setString(2, novoExercicio.getDescricaoFoto());
            ps.setLong(3, exercicio.getId());

            ps.execute();

            System.out.println("\nExercício alterado com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar o exercício!", e);
        }
    }

    // BUSCAR ID
    public Exercicio buscar(long id) {
        sql = "SELECT * FROM exercicio WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                exercicio = new Exercicio();

                if (rs.next()) {
                    exercicio.setId(rs.getLong("id"));
                    exercicio.setNome(rs.getString("nome"));
                    exercicio.setDescricaoFoto(rs.getString("descricao_foto"));
                } else {
                    throw new SQLException("Exercício não encontrado");
                }

                return exercicio;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar o exercício!", e);
        }
    }

    // LISTAR TODOS OS EXERCÍCIOS
    public List<Exercicio> listar() {
        sql = "SELECT * FROM exercicio";
        List<Exercicio> exercicios = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setId(rs.getLong("id"));
                exercicio.setNome(rs.getString("nome"));
                exercicio.setDescricaoFoto(rs.getString("descricao_foto"));
                exercicios.add(exercicio);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar os exercícios!", e);
        }

        return exercicios;
    }
}
