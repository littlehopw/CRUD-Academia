package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MensalidadeVigenteDAO {

    private String sql;
    private MensalidadeVigente mensalidadeVigente;

    // Método para inserir exemplos de mensalidades vigentes
    public void inserirMensalidadeExemplo() {
//        MensalidadeVigente exemplo1 = new MensalidadeVigente(150.00, LocalDate.parse("2024-08-01"), LocalDate.parse("2025-07-31"));
//        inserirMensalidadeVigente(exemplo1);
//
//        MensalidadeVigente exemplo2 = new MensalidadeVigente(200.00, LocalDate.parse("2024-09-01"), LocalDate.parse("2025-08-31"));
//        inserirMensalidadeVigente(exemplo2);
//
//        MensalidadeVigente exemplo3 = new MensalidadeVigente(180.00, LocalDate.parse("2024-10-01"), LocalDate.parse("2025-09-30"));
//        inserirMensalidadeVigente(exemplo3);
//
//        MensalidadeVigente exemplo4 = new MensalidadeVigente(220.00, LocalDate.parse("2024-11-01"), LocalDate.parse("2025-10-31"));
//        inserirMensalidadeVigente(exemplo4);
//
//        MensalidadeVigente exemplo5 = new MensalidadeVigente(160.00, LocalDate.parse("2024-12-01"), LocalDate.parse("2025-11-30"));
//        inserirMensalidadeVigente(exemplo5);
//
//        MensalidadeVigente exemplo6 = new MensalidadeVigente(210.00, LocalDate.parse("2025-01-01"), LocalDate.parse("2025-12-31"));
//        inserirMensalidadeVigente(exemplo6);
    }

    // INSERT
    public void adicionar(MensalidadeVigente mensalidadeVigente) {
        sql = "INSERT INTO mensalidade_vigente (valor, inicio, termino, data_criacao, data_modificacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, mensalidadeVigente.getValor());
            ps.setDate(2, java.sql.Date.valueOf(mensalidadeVigente.getInicio()));
            ps.setDate(3, java.sql.Date.valueOf(mensalidadeVigente.getTermino()));
            ps.setObject(4, mensalidadeVigente.getDataCriacao());
            ps.setObject(5, mensalidadeVigente.getDataModificacao());

            ps.execute();

            System.out.println("\nMensalidade vigente inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa mensalidade vigente no banco!", e);
        }
    }

    // REMOVE
    public void remover(MensalidadeVigente mensalidadeVigente) {
        sql = "DELETE FROM mensalidade_vigente WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, mensalidadeVigente.getId());
            ps.execute();

            System.out.println("\nMensalidade vigente removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a mensalidade vigente!", e);
        }
    }

    // UPDATE
    public void alterar(MensalidadeVigente mensalidadeVigente, MensalidadeVigente novaMensalidadeVigente) {
        sql = "UPDATE mensalidade_vigente SET valor = ?, inicio = ?, termino = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, novaMensalidadeVigente.getValor());
            ps.setDate(2, java.sql.Date.valueOf(novaMensalidadeVigente.getInicio()));
            ps.setDate(3, java.sql.Date.valueOf(novaMensalidadeVigente.getTermino()));
            ps.setLong(4, mensalidadeVigente.getId());

            ps.execute();

            System.out.println("\nMensalidade vigente alterada com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a mensalidade vigente!", e);
        }
    }

    // BUSCAR ID
    public MensalidadeVigente buscar(long id) {
        sql = "SELECT * FROM mensalidade_vigente WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                mensalidadeVigente = new MensalidadeVigente();

                if (rs.next()) {
                    mensalidadeVigente.setId(rs.getLong("id"));
                    mensalidadeVigente.setValor(rs.getDouble("valor"));
                    mensalidadeVigente.setInicio(rs.getDate("inicio").toLocalDate());
                    mensalidadeVigente.setTermino(rs.getDate("termino").toLocalDate());
                } else {
                    throw new SQLException("Mensalidade vigente não encontrada");
                }

                return mensalidadeVigente;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a mensalidade vigente!", e);
        }
    }

    // LISTAR TODAS AS MENSALIDADES VIGENTES
    public List<MensalidadeVigente> listar() {
        sql = "SELECT * FROM mensalidade_vigente";
        List<MensalidadeVigente> mensalidades = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MensalidadeVigente mensalidade = new MensalidadeVigente();
                mensalidade.setId(rs.getLong("id"));
                mensalidade.setValor(rs.getDouble("valor"));
                mensalidade.setInicio(rs.getDate("inicio").toLocalDate());
                mensalidade.setTermino(rs.getDate("termino").toLocalDate());
                mensalidades.add(mensalidade);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar as mensalidades vigentes!", e);
        }

        return mensalidades;
    }
}
