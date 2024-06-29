package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoPagamentoMensalidadeDAO {

    private String sql;
    private AlunoPagamentoMensalidade a;
    List<AlunoPagamentoMensalidade> alunopagamentomensalidade = new ArrayList<>();

    // INSERT
    public void inserirAlunoPagamentoMensalidade(AlunoPagamentoMensalidade alunopagamento) {
        sql = "INSERT INTO aluno_pagamento_mensalidade (pessoa, modalidade, mensalidade_vigente, valor_pago, data, data_criacao, data_modificacao) "
                + "VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, alunopagamento.getPessoa());
            ps.setString(2, alunopagamento.getModalidade());
            ps.setString(3, alunopagamento.getMensalidadeVigente());
            ps.setDouble(4, alunopagamento.getValorPago());
            ps.setDate(5, java.sql.Date.valueOf(alunopagamento.getData()));
            ps.setDate(6, java.sql.Date.valueOf(alunopagamento.getDataCriacao()));
            ps.setDate(7, java.sql.Date.valueOf(alunopagamento.getDataModificacao()));

            ps.execute();

            System.out.println("\n Pagamento de mensalidade inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar o pagamento de mensalidade no banco!", e);
        }
    }

    // REMOVE
    public void removerAlunoPagamentoMensalidade(long id) {
        sql = "DELETE FROM aluno_pagamento_mensalidade WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ps.execute();

            System.out.println("\n Pagamento de mensalidade removido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover o pagamento de mensalidade!", e);
        }
    }

    // UPDATE
    public void alterarAlunoPagamentoMensalidade(AlunoPagamentoMensalidade alunopagamento) {
        sql = "UPDATE aluno_pagamento_mensalidade SET pessoa = ?, modalidade = ?, mensalidade_vigente = ?, valor_pago = ?, data = ?, data_modificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, alunopagamento.getPessoa());
            ps.setString(2, alunopagamento.getModalidade());
            ps.setString(3, alunopagamento.getMensalidadeVigente());
            ps.setDouble(4, alunopagamento.getValorPago());
            ps.setDate(5, java.sql.Date.valueOf(alunopagamento.getData()));
            ps.setDate(6, java.sql.Date.valueOf(alunopagamento.getDataModificacao()));
            ps.setLong(7, alunopagamento.getId());

            ps.execute();

            System.out.println("\n Pagamento de mensalidade alterado com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar o pagamento de mensalidade!", e);
        }
    }

    //BUSCAR ID
    public AlunoPagamentoMensalidade buscar(long id) {
        sql = "SELECT * FROM aluno_pagamento_mensalidade WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                a = new AlunoPagamentoMensalidade();

                if (rs.next()) {

                    a.setPessoa(rs.getString("Pessoa: "));
                    a.setModalidade(rs.getString("Modalidade"));
                    a.setMensalidadeVigente(rs.getString("Mensalidade vigente:"));
                    a.setValorPago(rs.getDouble("Valor pago:"));
                    
                } else {
                    throw new SQLException("Pessoa não encontrada.");
                }

                return a;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a pessoa!", e);
        }
    }

    //ACHAR NOME
    public AlunoPagamentoMensalidade buscarNome(String pessoa) {
        sql = "SELECT * FROM academia WHERE pessoa = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, pessoa);
            
            try (ResultSet rs = ps.executeQuery()) {
                
                a = new AlunoPagamentoMensalidade();

                if (rs.next()) {
                    
                    a.setPessoa(rs.getString("Pessoa: "));
                    a.setModalidade(rs.getString("Modalidade"));
                    a.setMensalidadeVigente(rs.getString("Mensalidade vigente:"));
                    a.setValorPago(rs.getDouble("Valor pago:"));
                    
                } else {
                    throw new SQLException("Pessoa não encontrada.");
                }

                return a;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a pessoa!", e);
        }
    }

    //BUSCAR TUDO
    public List<AlunoPagamentoMensalidade> buscarTodos() {
        sql = "SELECT * FROM aluno_pagamento_mensalidade";

        List<AlunoPagamentoMensalidade> pagamentos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AlunoPagamentoMensalidade alunopagamento = new AlunoPagamentoMensalidade();
                alunopagamento.setId(rs.getLong("id"));
                alunopagamento.setPessoa(rs.getString("pessoa"));
                alunopagamento.setModalidade(rs.getString("modalidade"));
                alunopagamento.setMensalidadeVigente(rs.getString("mensalidade_vigente"));
                alunopagamento.setValorPago(rs.getDouble("valor_pago"));
                alunopagamento.setData(rs.getDate("data").toLocalDate());
                alunopagamento.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                alunopagamento.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());

                pagamentos.add(alunopagamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar os pagamentos de mensalidade!", e);
        }

        return pagamentos;
    }

    //PAGAMENTOS POR MES
    public void relatorioAlunosPagaramAteFimDoMes(int mes, int ano) {
        System.out.println("Relatório de Alunos que Pagaram até o Fim do Mês " + mes + "/" + ano);

        List<AlunoPagamentoMensalidade> pagamentos = buscarTodos();

        for (AlunoPagamentoMensalidade pagamento : pagamentos) {
            if (pagamento.getData() != null) {
                LocalDate dataPagamento = pagamento.getData();
                if (dataPagamento.getMonthValue() == mes && dataPagamento.getYear() == ano) {
                    System.out.println("Aluno: " + pagamento.getPessoa() + ", Data de Pagamento: " + dataPagamento);
                }
            }
        }
    }

    //PAGAMENTOS POR MES E ANO
    public void relatorioMovimentacaoAcademiaMes(int mes, int ano) {
        System.out.println("Relatório de Movimentação da Academia para o Mês " + mes + "/" + ano);

        double totalRecebido = 0;
        List<AlunoPagamentoMensalidade> pagamentos = buscarTodos();

        for (AlunoPagamentoMensalidade pagamento : pagamentos) {
            if (pagamento.getData() != null) {
                LocalDate dataPagamento = pagamento.getData();
                if (dataPagamento.getMonthValue() == mes && dataPagamento.getYear() == ano) {
                    totalRecebido += pagamento.getValorPago();
                }
            }
        }

        System.out.println("Total Recebido: R$" + totalRecebido);
    }
}
