package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRecorrenteDAO {

    private String sql;
    private PagamentoRecorrente pagamentoRecorrente;

    //INSERT
    public void adicionar(PagamentoRecorrente pagamentoRecorrente) {
        sql = "INSERT INTO pagamento_recorrente (pessoa, data, cartaode_credito, valor, meses_autorizados, data_inicio, data_criacao, data_modificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, pagamentoRecorrente.getPessoa());
            ps.setObject(2, pagamentoRecorrente.getData());
            ps.setString(3, pagamentoRecorrente.getCartaodeCredito());
            ps.setDouble(4, pagamentoRecorrente.getValor());
            ps.setInt(5, pagamentoRecorrente.getMesesAutorizados());
            ps.setObject(6, pagamentoRecorrente.getDataInicio());
            ps.setObject(7, pagamentoRecorrente.getDataCriacao());
            ps.setObject(8, pagamentoRecorrente.getDataModificacao());

            ps.execute();

            System.out.println("\nPagamento recorrente inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar esse pagamento recorrente no banco!", e);
        }
    }

    //SELECT
    public List<PagamentoRecorrente> listar() {
        sql = "SELECT * FROM pagamento_recorrente";
        List<PagamentoRecorrente> pagamentosRecorrentes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PagamentoRecorrente pagamento = new PagamentoRecorrente();
                pagamento.setId(rs.getLong("id"));
                pagamento.setPessoa(rs.getString("pessoa"));
                pagamento.setData(rs.getObject("data", LocalDate.class));
                pagamento.setCartaodeCredito(rs.getString("cartaode_credito"));
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setMesesAutorizados(rs.getInt("meses_autorizados"));
                pagamento.setDataInicio(rs.getObject("data_inicio", LocalDate.class));
                pagamento.setDataCriacao(rs.getObject("data_criacao", LocalDate.class));
                pagamento.setDataModificacao(rs.getObject("data_modificacao", LocalDate.class));
                pagamentosRecorrentes.add(pagamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar os pagamentos recorrentes!", e);
        }

        return pagamentosRecorrentes;
    }

    //SELECT COM ID
    public PagamentoRecorrente buscar(long id) {
        sql = "SELECT * FROM pagamento_recorrente WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                pagamentoRecorrente = new PagamentoRecorrente();

                if (rs.next()) {
                    pagamentoRecorrente.setId(rs.getLong("id"));
                    pagamentoRecorrente.setPessoa(rs.getString("pessoa"));
                    pagamentoRecorrente.setData(rs.getObject("data", LocalDate.class));
                    pagamentoRecorrente.setCartaodeCredito(rs.getString("cartaode_credito"));
                    pagamentoRecorrente.setValor(rs.getDouble("valor"));
                    pagamentoRecorrente.setMesesAutorizados(rs.getInt("meses_autorizados"));
                    pagamentoRecorrente.setDataInicio(rs.getObject("data_inicio", LocalDate.class));
                    pagamentoRecorrente.setDataCriacao(rs.getObject("data_criacao", LocalDate.class));
                    pagamentoRecorrente.setDataModificacao(rs.getObject("data_modificacao", LocalDate.class));
                } else {
                    throw new SQLException("Pagamento recorrente não encontrado");
                }

                return pagamentoRecorrente;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar o pagamento recorrente!", e);
        }
    }

    //DELETE
    public void remover(PagamentoRecorrente pagamentoRecorrente) {
        sql = "DELETE FROM pagamento_recorrente WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, pagamentoRecorrente.getId());
            ps.execute();

            System.out.println("\nPagamento recorrente removido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover o pagamento recorrente!", e);
        }
    }

    //UPDATE
    public void alterar(PagamentoRecorrente pagamentoRecorrente, PagamentoRecorrente novoPagamentoRecorrente) {
        sql = "UPDATE pagamento_recorrente SET pessoa = ?, data = ?, cartaode_credito = ?, valor = ?, meses_autorizados = ?, data_inicio = ?, data_criacao = ?, data_modificacao = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, novoPagamentoRecorrente.getPessoa());
            ps.setObject(2, novoPagamentoRecorrente.getData());
            ps.setString(3, novoPagamentoRecorrente.getCartaodeCredito());
            ps.setDouble(4, novoPagamentoRecorrente.getValor());
            ps.setInt(5, novoPagamentoRecorrente.getMesesAutorizados());
            ps.setObject(6, novoPagamentoRecorrente.getDataInicio());
            ps.setObject(7, novoPagamentoRecorrente.getDataCriacao());
            ps.setObject(8, novoPagamentoRecorrente.getDataModificacao());
            ps.setLong(9, pagamentoRecorrente.getId());

            ps.execute();

            System.out.println("\nPagamento recorrente alterado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar o pagamento recorrente!", e);
        }
    }
}
