package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreinoDAO {

    private String sql;
    private Treino t;

    public void inserirTreinoExemplo() {
//    Treino exemplo1 = new Treino();
//    exemplo1.setDataInicio(LocalDate.parse("2024-05-01"));
//    exemplo1.setDataTermino(LocalDate.parse("2024-08-01"));
//    exemplo1.setDivisaoTreino("A-B-C");
//    exemplo1.setObjetivo("Hipertrofia");
//    inserirTreino(exemplo1);
//
//    Treino exemplo2 = new Treino();
//    exemplo2.setDataInicio(LocalDate.parse("2024-06-01"));
//    exemplo2.setDataTermino(LocalDate.parse("2024-09-01"));
//    exemplo2.setDivisaoTreino("A-B");
//    exemplo2.setObjetivo("Emagrecimento");
//    inserirTreino(exemplo2);
//
//    Treino exemplo3 = new Treino();
//    exemplo3.setDataInicio(LocalDate.parse("2024-07-01"));
//    exemplo3.setDataTermino(LocalDate.parse("2024-10-01"));
//    exemplo3.setDivisaoTreino("A-B-C-D");
//    exemplo3.setObjetivo("Condicionamento físico");
//    inserirTreino(exemplo3);
//
//    Treino exemplo4 = new Treino();
//    exemplo4.setDataInicio(LocalDate.parse("2024-08-01"));
//    exemplo4.setDataTermino(LocalDate.parse("2024-11-01"));
//    exemplo4.setDivisaoTreino("Full Body");
//    exemplo4.setObjetivo("Manutenção");
//    inserirTreino(exemplo4);
//
//    Treino exemplo5 = new Treino();
//    exemplo5.setDataInicio(LocalDate.parse("2024-09-01"));
//    exemplo5.setDataTermino(LocalDate.parse("2024-12-01"));
//    exemplo5.setDivisaoTreino("A-B-C");
//    exemplo5.setObjetivo("Força");
//    inserirTreino(exemplo5);
//
//    Treino exemplo6 = new Treino();
//    exemplo6.setDataInicio(LocalDate.parse("2024-10-01"));
//    exemplo6.setDataTermino(LocalDate.parse("2024-12-31"));
//    exemplo6.setDivisaoTreino("A-B");
//    exemplo6.setObjetivo("Resistência");
//    inserirTreino(exemplo6);
    }

    // INSERT
    public void inserir(Treino treino) {
        sql = "INSERT INTO treino (objetivo, divisao_treino, data_inicio, data_termino, data_criacao, data_modificacao)"
                + "VALUES (?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, treino.getObjetivo());
            ps.setString(2, treino.getDivisaoTreino());
            ps.setDate(3, java.sql.Date.valueOf(treino.getDataInicio()));
            ps.setDate(4, java.sql.Date.valueOf(treino.getDataTermino()));
            ps.setDate(5, java.sql.Date.valueOf(treino.getDataCriacao()));
            ps.setDate(6, java.sql.Date.valueOf(treino.getDataModificacao()));

            ps.execute();

            System.out.println("\n Treino inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar o treino no banco!", e);
        }
    }

    // REMOVE
    public void remover(long id) {
        sql = "DELETE FROM treino WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ps.execute();

            System.out.println("\n Treino removido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Treino removido com sucesso!", e);
        }
    }

    // UPDATE
    public void alterar(Treino treino) {
        sql = "UPDATE treino SET objetivo = ?, divisao_treino = ?, data_inicio = ?, data_termino = ?, data_modificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, treino.getObjetivo());
            ps.setString(2, treino.getDivisaoTreino());
            ps.setDate(3, java.sql.Date.valueOf(treino.getDataInicio()));
            ps.setDate(4, java.sql.Date.valueOf(treino.getDataTermino()));
            ps.setDate(5, java.sql.Date.valueOf(treino.getDataModificacao()));
            ps.setLong(6, treino.getId());

            ps.execute();

            System.out.println("\n Treino alterado com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar o treino!", e);
        }
    }
}
