package model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GerarPdfRelatorioPagamentos {
    public static final String DEST = "RelatorioPagamentos.pdf";

    public void createPdf(String dest, int mes, int ano) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        // Initialize PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        
        Paragraph title = new Paragraph("Relatório de Pagamentos dos Alunos");
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);   
        
        document.add(new Paragraph("\n\n"));
        
        Paragraph title1 = new Paragraph("Professor que amamos");
        title1.setAlignment(Element.ALIGN_CENTER);
        document.add(title1);
        
        Image image = Image.getInstance("imagem.png");
        image.scaleAbsolute(200, 200);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);
               
        document.add(new Paragraph("\n"));
        
        document.add(new Paragraph("Mês/Ano: " + mes + "/" + ano));
        document.add(new Paragraph("\n"));
        
        // Create a Table
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        // Add table header
        table.addCell(new PdfPCell(new Phrase("Pessoa")));
        table.addCell(new PdfPCell(new Phrase("Modalidade")));
        table.addCell(new PdfPCell(new Phrase("Mensalidade Vigente")));
        table.addCell(new PdfPCell(new Phrase("Valor Pago")));
        table.addCell(new PdfPCell(new Phrase("Data de Pagamento")));
        table.addCell(new PdfPCell(new Phrase("Data de Criação")));
        
        // Fetch data from database
        AlunoPagamentoMensalidadeDAO dao = new AlunoPagamentoMensalidadeDAO();
        List<AlunoPagamentoMensalidade> pagamentos = dao.buscarTodos();

        for (AlunoPagamentoMensalidade pagamento : pagamentos) {
            LocalDate dataPagamento = pagamento.getData();
            if (dataPagamento.getMonthValue() == mes && dataPagamento.getYear() == ano) {
                table.addCell(new PdfPCell(new Phrase(pagamento.getPessoa())));
                table.addCell(new PdfPCell(new Phrase(pagamento.getModalidade())));
                table.addCell(new PdfPCell(new Phrase(pagamento.getMensalidadeVigente())));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(pagamento.getValorPago()))));
                table.addCell(new PdfPCell(new Phrase(dataPagamento.toString())));
                table.addCell(new PdfPCell(new Phrase(pagamento.getDataCriacao().toString())));
            }
        }
        
        // Add table to document
        document.add(table);

        // Close document
        document.close();
    }
}
