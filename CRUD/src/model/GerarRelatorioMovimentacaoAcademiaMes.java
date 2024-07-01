package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class GerarRelatorioMovimentacaoAcademiaMes{
    public static final String DEST = "MovimentacaoAcademia.pdf";

    public void createPdf(String dest, int mes, int ano) throws FileNotFoundException, DocumentException {
        // Inicializa o documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        // Adiciona o título ao documento
        Paragraph title = new Paragraph("Relatório de Movimentação da Academia - " + mes + "/" + ano);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph("\n"));
        
    
        
        document.add(new Paragraph());

        // Cria uma tabela com 5 colunas
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);

        // Adiciona o cabeçalho da tabela
        table.addCell(new PdfPCell(new Phrase("Pessoa")));
        table.addCell(new PdfPCell(new Phrase("Modalidade")));
        table.addCell(new PdfPCell(new Phrase("Mensalidade Vigente")));
        table.addCell(new PdfPCell(new Phrase("Valor Pago")));
        table.addCell(new PdfPCell(new Phrase("Data")));

        // Obtém os dados do banco de dados
        AlunoPagamentoMensalidadeDAO dao = new AlunoPagamentoMensalidadeDAO();
        List<AlunoPagamentoMensalidade> pagamentos = dao.buscarTodos();
        
        double totalRecebido=0;
        for (AlunoPagamentoMensalidade pagamento : pagamentos) {
            if (pagamento.getData() != null) {
                LocalDate dataPagamento = pagamento.getData();
                if (dataPagamento.getMonthValue() == mes && dataPagamento.getYear() == ano) {
                    totalRecebido = totalRecebido + pagamento.getValorPago();
                }
            }
        }
        // Adiciona a tabela ao documento
        document.add(new Paragraph("oi"));
        document.add(new Paragraph("Total Recebido: R$ " + totalRecebido));
        
        document.add(new Paragraph(" oi"));
        
        document.add(new Paragraph("Total Recebido: R$ " + totalRecebido));
        // Adiciona o total recebido ao documento
        document.add(new Paragraph("\n"));
        Paragraph total = new Paragraph("Total Recebido: R$" + totalRecebido);
        total.setAlignment(Element.ALIGN_CENTER);
        document.add(total);
        
        //double totalRecebido = 0;
        for (AlunoPagamentoMensalidade pagamento : pagamentos) {
            if (pagamento.getData() != null) {
                LocalDate dataPagamento = pagamento.getData();
                if (dataPagamento.getMonthValue() == mes && dataPagamento.getYear() == ano) {
                    table.addCell(new PdfPCell(new Phrase(pagamento.getPessoa())));
                    table.addCell(new PdfPCell(new Phrase(pagamento.getModalidade())));
                    table.addCell(new PdfPCell(new Phrase(pagamento.getMensalidadeVigente())));
                    table.addCell(new PdfPCell(new Phrase("R$" + pagamento.getValorPago())));
                    table.addCell(new PdfPCell(new Phrase(dataPagamento.toString())));

                    totalRecebido = totalRecebido + pagamento.getValorPago();
                }
            }
        }

        // Adiciona a tabela ao documento
        document.add(new Paragraph("oi"));
        document.add(new Paragraph("Total Recebido: R$ " + totalRecebido));
        document.add(table);
        document.add(new Paragraph(" oi"));
        
        document.add(new Paragraph("Total Recebido: R$ " + totalRecebido));
        // Adiciona o total recebido ao documento
        document.add(new Paragraph("\n"));
        Paragraph total1 = new Paragraph("Total Recebido: R$" + totalRecebido);
        total.setAlignment(Element.ALIGN_CENTER);
        document.add(total1);

        // Fecha o documento
        document.close();
    }
}