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
import java.util.List;

public class GerarPdfAvaliacaoFisica {
    public static final String DEST = "AvaliacaoFisica.pdf";

    public void createPdf(String dest, String pessoa) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        // Initialize PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        
        Paragraph title2 = new Paragraph("Informações da Avaliação Física");
        title2.setAlignment(Element.ALIGN_CENTER);
        document.add(title2);       
        
        document.add(new Paragraph("\n\n"));
        
        Paragraph title1 = new Paragraph("Professor que amamos");
        title1.setAlignment(Element.ALIGN_CENTER);
        document.add(title1);
        
        Image image = Image.getInstance("imagem.png");
        image.scaleAbsolute(200, 200);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);
               
        document.add(new Paragraph("\n"));
        
        // Add title
        Paragraph title = new Paragraph("Avaliações físicas de " + pessoa);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        
        document.add(new Paragraph("\n"));
        
        // Create a Table
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        // Add table header
        //table.addCell(new PdfPCell(new Phrase("ID")));
        table.addCell(new PdfPCell(new Phrase("Pessoa")));
        table.addCell(new PdfPCell(new Phrase("Último Treino")));
        table.addCell(new PdfPCell(new Phrase("Peso")));
        table.addCell(new PdfPCell(new Phrase("Altura")));
        table.addCell(new PdfPCell(new Phrase("IMC")));
        table.addCell(new PdfPCell(new Phrase("Satisfação")));
        table.addCell(new PdfPCell(new Phrase("Data Criação")));
        

        // Fetch data from database
        AvaliacaoFisicaDAO dao = new AvaliacaoFisicaDAO();
        List<AvaliacaoFisica> avaliacoes = dao.buscarPorPessoa(pessoa);

        for (AvaliacaoFisica avaliacao : avaliacoes) {
            //table.addCell(new PdfPCell(new Phrase(String.valueOf(avaliacao.getId()))));
            table.addCell(new PdfPCell(new Phrase(avaliacao.getPessoa())));
            table.addCell(new PdfPCell(new Phrase(avaliacao.getUltimoTreino())));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(avaliacao.getPeso() + " kg"))));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(avaliacao.getAltura() + " cm"))));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(avaliacao.getImc()))));
            table.addCell(new PdfPCell(new Phrase(avaliacao.getSatisfacao())));
            table.addCell(new PdfPCell(new Phrase(avaliacao.getDataCriacao().toString())));
        }
        document.add(new Paragraph("\n\n"));

        // Add table to document
        document.add(table);

        // Close document
        document.close();
    }
}