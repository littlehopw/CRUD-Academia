package model;

import java.time.LocalDate;

public class AlunoPagamentoMensalidadeDAO {

    AlunoPagamentoMensalidade[] alunospagamentos = new AlunoPagamentoMensalidade[10];

    public void inserirMensalidadeExemplo() {
        AlunoPagamentoMensalidade exemplo1 = new AlunoPagamentoMensalidade();
        exemplo1.setPessoa("ana");
        exemplo1.setMensalidadeVigente("valida");
        exemplo1.setModalidade("Dinheiro");
        exemplo1.setValorPago(150.00);

        inserirAlunoPagamentoMensalidade(exemplo1);

        AlunoPagamentoMensalidade exemplo2 = new AlunoPagamentoMensalidade();
        exemplo2.setPessoa("lucia");
        exemplo2.setMensalidadeVigente("atrasada");
        exemplo2.setModalidade("Pix");
        exemplo2.setValorPago(120.00);
       
        inserirAlunoPagamentoMensalidade(exemplo2);

        AlunoPagamentoMensalidade exemplo3 = new AlunoPagamentoMensalidade();
        exemplo3.setPessoa("roberto");
        exemplo3.setMensalidadeVigente("valida");
        exemplo3.setModalidade("Debito");
        exemplo3.setValorPago(180.00);
        
        inserirAlunoPagamentoMensalidade(exemplo3);
        
        // Exemplo 4
        AlunoPagamentoMensalidade exemplo4 = new AlunoPagamentoMensalidade();
        exemplo4.setPessoa("maria");
        exemplo4.setMensalidadeVigente("valida");
        exemplo4.setModalidade("Recorrente");
        exemplo4.setValorPago(200.00);
        inserirAlunoPagamentoMensalidade(exemplo4);

        // Exemplo 5
        AlunoPagamentoMensalidade exemplo5 = new AlunoPagamentoMensalidade();
        exemplo5.setPessoa("carlos");
        exemplo5.setMensalidadeVigente("atrasada");
        exemplo5.setModalidade("Dinheiro");
        exemplo5.setValorPago(250.00);
        inserirAlunoPagamentoMensalidade(exemplo5);
    }

    public void inserirAlunoPagamentoMensalidade(AlunoPagamentoMensalidade alunopagamento) {
        boolean alunoExistente = false;
        for (int i = 0; i < alunospagamentos.length; i++) {
            if (alunospagamentos[i] != null && alunospagamentos[i].getPessoa().equals(alunopagamento.getPessoa())) {
                alunospagamentos[i].setMensalidadeVigente(alunopagamento.getMensalidadeVigente());
                alunospagamentos[i].setData(alunopagamento.getData());
                alunospagamentos[i].setValorPago(alunopagamento.getValorPago());
                alunospagamentos[i].setModalidade(alunopagamento.getModalidade());
                alunoExistente = true;
                break;
            } else if (alunospagamentos[i] == null) {
                alunospagamentos[i] = alunopagamento;
                alunoExistente = true;
                break;
            }
        }
        if (!alunoExistente) {
            System.out.println("Limite de pagamentos atingido. Não é possível adicionar mais pagamentos.");
        }
    }

    public void mostrarAlunoPagamentoMensalidade() {
        for (int i = 0; i < alunospagamentos.length; i++) {
            if (alunospagamentos[i] != null) {
                System.out.println(alunospagamentos[i].toString());
            }
        }
    }

    public AlunoPagamentoMensalidade[] getAlunoPagamentoMensalidade() {
        return alunospagamentos;
    }

    public void setAlunoPagamentoMensalidade(AlunoPagamentoMensalidade[] alunospagamentos) {
        this.alunospagamentos = alunospagamentos;
    }

    public AlunoPagamentoMensalidade[] getPagamentosPorAluno(String login) {
        AlunoPagamentoMensalidade[] pagamentosDoAluno = new AlunoPagamentoMensalidade[10];
        int count = 0;
        for (AlunoPagamentoMensalidade pagamento : alunospagamentos) {
            if (pagamento != null && pagamento.getPessoa().equals(login)) {
                pagamentosDoAluno[count++] = pagamento;
            }
        }
        return pagamentosDoAluno;
    }
    
     public void relatorioAlunosPagaramAteFimDoMes(int mes, int ano) {
        System.out.println("Relatório de Alunos que Pagaram até o Fim do Mês " + mes + "/" + ano);
        for (AlunoPagamentoMensalidade pagamento : alunospagamentos) {
            if (pagamento != null && pagamento.getData() != null) {
                LocalDate dataPagamento = pagamento.getData();
                if (dataPagamento.getMonthValue() == mes && dataPagamento.getYear() == ano) {
                    System.out.println("Aluno: " + pagamento.getPessoa() + ", Data de Pagamento: " + dataPagamento);
                }
         
            }
        }
    }

    public void relatorioMovimentacaoAcademiaMes(int mes, int ano) {
        System.out.println("Relatório de Movimentação da Academia para o Mês " + mes + "/" + ano);
        double totalRecebido = 0;
        for (AlunoPagamentoMensalidade pagamento : alunospagamentos) {
            if (pagamento != null && pagamento.getData() != null) {
                LocalDate dataPagamento = pagamento.getData();
                if (dataPagamento.getMonthValue() == mes && dataPagamento.getYear() == ano) {
                    totalRecebido += pagamento.getValorPago();
                }
            }
        }
        System.out.println("Total Recebido: R$" + totalRecebido);
    }
}
