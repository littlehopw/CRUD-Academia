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

public class GerarTreinoAplicacao {
    public static final String DEST = "TreinoAplicacao.pdf";

    public void createPdf(String dest, String pessoa) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        // Initialize PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();  
        
        // Add title
        Paragraph title = new Paragraph("Treinos Aplicados de " + pessoa);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        
        document.add(new Paragraph("\n\n"));

        Image image = Image.getInstance("imagem.png");
        image.scaleAbsolute(200, 200);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);
        
        
        
        Paragraph title1 = new Paragraph("Professor que amamos");
        title1.setAlignment(Element.ALIGN_CENTER);
        document.add(title1);
                       
        document.add(new Paragraph("\n"));

        // Add title for Treino Aplicação
        Paragraph titleTreino = new Paragraph("Detalhes dos treinos de " + pessoa);
        titleTreino.setAlignment(Element.ALIGN_CENTER);
        document.add(titleTreino);

        document.add(new Paragraph("\n"));

        // Create a Table for Treinos Aplicados
        PdfPTable tableTreinos = new PdfPTable(7);
        tableTreinos.setWidthPercentage(100);
        // Add table header
        tableTreinos.addCell(new PdfPCell(new Phrase("Treino")));
        tableTreinos.addCell(new PdfPCell(new Phrase("Exercício")));
        tableTreinos.addCell(new PdfPCell(new Phrase("Aplicação")));
        tableTreinos.addCell(new PdfPCell(new Phrase("Divisão Treino")));
        tableTreinos.addCell(new PdfPCell(new Phrase("Divisão Músculo")));
        tableTreinos.addCell(new PdfPCell(new Phrase("Data Criação")));
        tableTreinos.addCell(new PdfPCell(new Phrase("Data Modificação")));
        
        // Fetch data from database
        TreinoAplicacaoDAO treinoDao = new TreinoAplicacaoDAO();
        List<TreinoAplicacao> treinos = treinoDao.getTreinoAplicacao(pessoa);

        for (TreinoAplicacao treino : treinos) {
            tableTreinos.addCell(new PdfPCell(new Phrase(treino.getTreino())));
            tableTreinos.addCell(new PdfPCell(new Phrase(treino.getExercicio())));
            tableTreinos.addCell(new PdfPCell(new Phrase(treino.getExercicioAplicacao())));
            tableTreinos.addCell(new PdfPCell(new Phrase(treino.getDivisaoTreino())));
            tableTreinos.addCell(new PdfPCell(new Phrase(treino.getDivisaoTreinoMusculo())));
            tableTreinos.addCell(new PdfPCell(new Phrase(treino.getDataCriacao().toString())));
            tableTreinos.addCell(new PdfPCell(new Phrase(treino.getDataModificacao().toString())));
        }

        document.add(new Paragraph("\n\n"));
        document.add(tableTreinos);

        // Close document
        document.close();
    }
}
