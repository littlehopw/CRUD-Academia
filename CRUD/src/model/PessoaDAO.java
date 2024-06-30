package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PessoaDAO {

    private Pessoa p;
    String sql;

    public void inserirPessoaExemplo() {
//        adicionar(new Pessoa("Ana Clara", "Feminino", "14/07/2004", "ana", "ana", "administrador"));
//        adicionar(new Pessoa("João Pedro", "Masculino", "22/03/2005", "joao", "joao", "administrador"));
//        adicionar(new Pessoa("Maria Silva", "Feminino", "15/05/2003", "maria", "maria", "professor"));
//        adicionar(new Pessoa("Carlos Souza", "Masculino", "09/09/2002", "carlos", "carlos", "professor"));
//        adicionar(new Pessoa("Lucia Ferreira", "Feminino", "12/12/2001", "lucia", "lucia", "aluno"));
//        adicionar(new Pessoa("Roberto Santos", "Masculino", "17/02/2000", "roberto", "roberto", "aluno"));
    }

    // INSERT
    public void adicionar(Pessoa pessoa) {
        sql = "INSERT INTO pessoa (nome, sexo, nascimento, login, senha, tipo_usuario, data_criacao, data_modificacao) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getSexo());
            ps.setString(3, pessoa.getNascimento());
            ps.setString(4, pessoa.getLogin());
            ps.setString(5, pessoa.getSenha());
            ps.setString(6, pessoa.getTipoUsuario());
            ps.setDate(7, java.sql.Date.valueOf(pessoa.getDataCriacao()));
            ps.setDate(8, java.sql.Date.valueOf(pessoa.getDataModificacao()));

            ps.execute();

            System.out.println("\n Pessoa inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa pessoa no banco!", e);
        }
    }

    // REMOVE
    public void remover(Pessoa pessoa) {
        sql = "DELETE FROM pessoa WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, pessoa.getId());
            ps.execute();

            System.out.println("\n Pessoa removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a pessoa!", e);
        }
    }

    // UPDATE
    public void alterar(Pessoa pessoa, Pessoa novapessoa) {
        sql = "UPDATE pessoa SET nome = ?, sexo = ?, nascimento = ?, login = ?, senha = ?, tipo_usuario = ?, data_modificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // VALORES
            ps.setString(1, novapessoa.getNome());
            ps.setString(2, novapessoa.getSexo());
            ps.setString(3, novapessoa.getNascimento());
            ps.setString(4, novapessoa.getLogin());
            ps.setString(5, novapessoa.getSenha());
            ps.setString(6, novapessoa.getTipoUsuario());
            ps.setDate(3, java.sql.Date.valueOf(novapessoa.getDataModificacao()));
            ps.setLong(4, novapessoa.getId());

            ps.execute();

            System.out.println("\n Dados da pessoa alterados com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar os dados da pessoa!", e);
        }
    }

    //ACHAR NOME
    public Pessoa buscarLogin(String login) {
        sql = "SELECT * FROM pessoa WHERE login = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                p = new Pessoa();

                if (rs.next()) {
                    p.setId(rs.getLong("id"));
                    p.setNome(rs.getString("nome"));
                    p.setSexo(rs.getString("sexo"));
                    p.setNascimento(rs.getString("nascimento"));
                    p.setLogin(rs.getString("login"));
                    p.setSenha(rs.getString("senha"));
                    p.setTipoUsuario(rs.getString("tipo_usuario"));
                    p.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
                    p.setDataModificacao(rs.getDate("data_modificacao").toLocalDate());
                } else {
                    System.out.println("Login ou senha incorretos.");
                    return null;
                }

                return p;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a pessoa!", e);
        }
    }
}
