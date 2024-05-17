package model;

import java.time.LocalDate;

public class PessoaDAO {

    Pessoa[] pessoas = new Pessoa[40];

    public void inserirPessoaExemplo() {
        inserirPessoa(new Pessoa("Ana Clara", "Feminino", "14/07/2004", "ana", "ana", "administrador"));
        inserirPessoa(new Pessoa("João Pedro", "Masculino", "22/03/2005", "joao", "joao", "administrador"));
        inserirPessoa(new Pessoa("Maria Silva", "Feminino", "15/05/2003", "maria", "maria123", "professor"));
        inserirPessoa(new Pessoa("Carlos Souza", "Masculino", "09/09/2002", "carlos", "carlos123", "professor"));
        inserirPessoa(new Pessoa("Lucia Ferreira", "Feminino", "12/12/2001", "lucia", "lucia123", "aluno"));
        inserirPessoa(new Pessoa("Roberto Santos", "Masculino", "17/02/2000", "roberto", "roberto123", "aluno")); 
    }

    public void inserirPessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                pessoas[i] = pessoa;
                break;
            }
        }
    }

    public void mostrarPessoa() {
        for (int i = 0; i < pessoas.length; i++) {
            if (null != pessoas[i]) {
                System.out.println(pessoas[i].toString());
            }
        }
    }

    public Pessoa[] getPessoa() {
        return pessoas;
    }

    public void setPessoa(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }
}
