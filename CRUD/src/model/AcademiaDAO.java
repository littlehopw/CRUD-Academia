package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AcademiaDAO {
    
    List<Academia> academias = new ArrayList<>();
    private Academia a;
    private String sql;
    
     public void  inserirAcademiaExemplo() {
//    Academia exemplo1 = new Academia();
//    exemplo1.setNome("Academia IFTM - Und 1");
//    exemplo1.setEndereco("Av. Dr. Florestan Fernandes, 131");
//    inserirAcademia(exemplo1);
//    
//    Academia exemplo2 = new Academia();
//    exemplo2.setNome("Academia IFTM - Und 2");
//    exemplo2.setEndereco("Av. Edilson Lamartine Mendes, 300");
//    inserirAcademia(exemplo2);
   }
 

    // INSERT
    public void adicionar(Academia academia) {
        sql = "INSERT INTO academia (nome, endereco, dataCriacao, dataModificacao) VALUES (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            // VALORES
            ps.setString(1, academia.getNome());
            ps.setString(2, academia.getEndereco());
            ps.setDate(3, java.sql.Date.valueOf(academia.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(academia.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Academia inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa academia no banco!", e);
        }
    }

    // REMOVE
    public void remover(Academia academia) {
        sql = "DELETE FROM academia WHERE id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, academia.getId());
            ps.execute();
            
            System.out.println("\n Academia removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível remover a academia!", e);
        }
    }

    // UPDATE
    public void alterar(Academia academia, Academia novaacademia) {
        sql = "UPDATE academia SET nome = ?, endereco = ?, dataModificacao = ? where id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            // VALORES
            ps.setString(1, novaacademia.getNome());
            ps.setString(2, novaacademia.getEndereco());
            ps.setDate(3, java.sql.Date.valueOf(novaacademia.getDataModificacao()));
            ps.setLong(4, academia.getId());
            
            ps.execute();
            
            System.out.println("\n Academia alterada com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a academia!", e);
        }
    }

    //BUSCAR ID
    public Academia buscar(long id) {
        sql = "SELECT * FROM academia WHERE id = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                a = new Academia();
                
                if (rs.next()) {
                    a.setId(rs.getLong("id"));
                    a.setNome(rs.getString("nome"));
                    a.setEndereco(rs.getString("endereco"));
                    a.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    a.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                } else {
                    throw new SQLException("Academia não encontrada");
                }

                return a;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a academia!", e);
        }
    }

    //ACHAR NOME
    public Academia buscarNome(String nome) {
        sql = "SELECT * FROM academia WHERE nome = ?";
        
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                a = new Academia();
                
                if (rs.next()) {
                    a.setId(rs.getLong("id"));
                    a.setNome(rs.getString("nome"));
                    a.setEndereco(rs.getString("endereco"));
                    a.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    a.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                } else {
                    throw new SQLException("Academia não encontrada");
                }

                return a;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a academia!", e);
        }
    }
}
