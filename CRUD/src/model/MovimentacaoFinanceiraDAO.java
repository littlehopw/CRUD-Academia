package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoFinanceiraDAO {

    private String sql;
    private MovimentacaoFinanceira movimentacaoFinanceira;

    // Método para inserir exemplos de movimentações financeiras
    public void inserirMovimentacaoFinanceiraExemplo() {
//        MovimentacaoFinanceira exemplo1 = new MovimentacaoFinanceira(150.75, "Entrada", "Pagamento de mensalidade");
//        inserirMovimentacaoFinanceira(exemplo1);
//
//        MovimentacaoFinanceira exemplo2 = new MovimentacaoFinanceira(250.00, "Saída", "Compra de equipamentos");
//        inserirMovimentacaoFinanceira(exemplo2);
//
//        MovimentacaoFinanceira exemplo3 = new MovimentacaoFinanceira(75.50, "Entrada", "Venda de suplementos");
//        inserirMovimentacaoFinanceira(exemplo3);
//
//        MovimentacaoFinanceira exemplo4 = new MovimentacaoFinanceira(400.00, "Saída", "Pagamento de aluguel");
//        inserirMovimentacaoFinanceira(exemplo4);
//
//        MovimentacaoFinanceira exemplo5 = new MovimentacaoFinanceira(90.00, "Entrada", "Aula particular");
//        inserirMovimentacaoFinanceira(exemplo5);
//
//        MovimentacaoFinanceira exemplo6 = new MovimentacaoFinanceira(125.00, "Saída", "Compra de material de limpeza");
//        inserirMovimentacaoFinanceira(exemplo6);
    }

    //INSERT
    public void adicionar(MovimentacaoFinanceira movimentacaoFinanceira) {
        sql = "INSERT INTO movimentacao_financeira (valor, tipo, descricao, data_criacao, data_modificacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, movimentacaoFinanceira.getValor());
            ps.setString(2, movimentacaoFinanceira.getTipo());
            ps.setString(3, movimentacaoFinanceira.getDescricao());
            ps.setObject(4, movimentacaoFinanceira.getDataCriacao());
            ps.setObject(5, movimentacaoFinanceira.getDataModificacao());

            ps.execute();

            System.out.println("\nMovimentação financeira inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa movimentação financeira no banco!", e);
        }
    }

    //SELECT
    public List<MovimentacaoFinanceira> listar() {
        sql = "SELECT * FROM movimentacao_financeira";
        List<MovimentacaoFinanceira> movimentacoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MovimentacaoFinanceira movimentacao = new MovimentacaoFinanceira();
                movimentacao.setId(rs.getLong("id"));
                movimentacao.setValor(rs.getDouble("valor"));
                movimentacao.setTipo(rs.getString("tipo"));
                movimentacao.setDescricao(rs.getString("descricao"));
                movimentacoes.add(movimentacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível listar as movimentações financeiras!", e);
        }

        return movimentacoes;
    }

    //SELECT ID
    public MovimentacaoFinanceira buscar(long id) {
        sql = "SELECT * FROM movimentacao_financeira WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                movimentacaoFinanceira = new MovimentacaoFinanceira();

                if (rs.next()) {
                    movimentacaoFinanceira.setId(rs.getLong("id"));
                    movimentacaoFinanceira.setValor(rs.getDouble("valor"));
                    movimentacaoFinanceira.setTipo(rs.getString("tipo"));
                    movimentacaoFinanceira.setDescricao(rs.getString("descricao"));
                } else {
                    throw new SQLException("Movimentação financeira não encontrada");
                }

                return movimentacaoFinanceira;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a movimentação financeira!", e);
        }
    }

    //DELETE
    public void remover(MovimentacaoFinanceira movimentacaoFinanceira) {
        sql = "DELETE FROM movimentacao_financeira WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, movimentacaoFinanceira.getId());
            ps.execute();

            System.out.println("\nMovimentação financeira removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a movimentação financeira!", e);
        }
    }

    //UPDATE
    public void alterar(MovimentacaoFinanceira movimentacaoFinanceira, MovimentacaoFinanceira novaMovimentacaoFinanceira) {
        sql = "UPDATE movimentacao_financeira SET valor = ?, tipo = ?, descricao = ? WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, novaMovimentacaoFinanceira.getValor());
            ps.setString(2, novaMovimentacaoFinanceira.getTipo());
            ps.setString(3, novaMovimentacaoFinanceira.getDescricao());
            ps.setLong(4, movimentacaoFinanceira.getId());

            ps.execute();

            System.out.println("\nMovimentação financeira alterada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a movimentação financeira!", e);
        }
    }
}
