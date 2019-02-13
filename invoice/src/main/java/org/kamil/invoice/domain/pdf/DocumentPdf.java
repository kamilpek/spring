package org.kamil.invoice.domain.pdf;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kamil.invoice.domain.Client;
import org.kamil.invoice.domain.Product;
import org.kamil.invoice.domain.Seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.text.pdf.BaseFont;

@Controller
public class DocumentPdf {
		 	
	public Document generatePdf(org.kamil.invoice.domain.Document document, Client client, Seller seller, List<Product> products) {
		Document pdf = new Document();		
		
		try {
			PdfWriter writer = PdfWriter.getInstance(pdf, new FileOutputStream("faktura.pdf"));
			pdf.open();
			
			Font font_tilte = null;
			Font font_regular = null;
			BaseFont helvetica;
			
			try {
				helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
				font_regular = new Font(helvetica, 14);
				font_tilte = new Font(helvetica, 20);
			} catch (IOException e) {
				System.err.println("PDF font load error" + e.getMessage());	
			}
			
			Paragraph p_date = new Paragraph("Miejsce sprzeda¿y: " + document.getCity() + 
					Chunk.NEWLINE + "Data sprzeda¿y: " + document.getDate() + 
					Chunk.NEWLINE + "Termin p³atnoœci: " + document.getTerm() +
					Chunk.NEWLINE + "Sposób p³atnoœci: " + document.getPayment() +
					Chunk.NEWLINE + "ORYGINA£/KOPIA", font_regular);
			p_date.setAlignment(Element.ALIGN_RIGHT);
			pdf.add(p_date);
			pdf.add(Chunk.NEWLINE);
			
			Paragraph p_persons_head = new Paragraph("SPRZEDAWCA", font_regular);
			p_persons_head.add(new Chunk(new Chunk(new VerticalPositionMark())));
			p_persons_head.add("NABYWCA");
			pdf.add(p_persons_head);
			
			Paragraph p_persons_name = new Paragraph(seller.getName(), font_regular);
			p_persons_name.add(new Chunk(new Chunk(new VerticalPositionMark())));
			p_persons_name.add(client.getName());
			pdf.add(p_persons_name);
			
			Paragraph p_persons_nip = new Paragraph(seller.getNip(), font_regular);
			p_persons_nip.add(new Chunk(new Chunk(new VerticalPositionMark())));
			p_persons_nip.add(client.getNip());
			pdf.add(p_persons_nip);
			
			Paragraph p_persons_street = new Paragraph(seller.getStreet(), font_regular);
			p_persons_street.add(new Chunk(new Chunk(new VerticalPositionMark())));
			p_persons_street.add(client.getStreet());
			pdf.add(p_persons_street);
			
			Paragraph p_persons_city = new Paragraph(seller.getPost() + " " + seller.getCity(), font_regular);
			p_persons_city.add(new Chunk(new Chunk(new VerticalPositionMark())));
			p_persons_city.add(client.getPost() + " " + client.getCity());
			pdf.add(p_persons_city);			
			
			pdf.add(Chunk.NEWLINE);
			Paragraph p_title = new Paragraph("Faktura VAT numer " + document.getDocumentNumber(), font_tilte);
			p_title.setAlignment(Element.ALIGN_CENTER);
			pdf.add(p_title);	
			
			pdf.add(new Paragraph(Chunk.NEWLINE + " " + Chunk.NEWLINE));			
			PdfPTable table_top = new PdfPTable(6);
			table_top.setWidthPercentage(100);
			table_top.addCell(new Paragraph("LP", font_regular));
			table_top.addCell(new Paragraph("Nazwa", font_regular));
			table_top.addCell(new Paragraph("Iloœæ", font_regular));
			table_top.addCell(new Paragraph("Netto [PLN]", font_regular));
			table_top.addCell(new Paragraph("Brutto [PLN]", font_regular));
			table_top.addCell(new Paragraph("VAT [PLN]", font_regular));
			
			int i = 1;
			for(Product product : products) {
				table_top.addCell(new Paragraph(String.valueOf(i), font_regular));
				table_top.addCell(new Paragraph(product.getName(), font_regular));
				table_top.addCell(new Paragraph(String.valueOf(product.getQuantity()), font_regular));
				table_top.addCell(new Paragraph(String.valueOf(product.getSumNetto()), font_regular));
				table_top.addCell(new Paragraph(String.valueOf(product.getSumBrutto()), font_regular));
				table_top.addCell(new Paragraph(String.valueOf(product.getSumTax()), font_regular));
				i++;
			}

			pdf.add(table_top);
			
			pdf.add(Chunk.NEWLINE);
			Paragraph p_sums = new Paragraph("Suma netto: " + document.getNetto() + " PLN" + 
					Chunk.NEWLINE + "Suma podatku: " + document.getTax() + " PLN" + 
					Chunk.NEWLINE + "Suma brutto: " + document.getBrutto() + " PLN");
			p_sums.setAlignment(Element.ALIGN_RIGHT);
			pdf.add(p_sums);
			
			pdf.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("PDF file not found" + e.getMessage());			
		} catch (DocumentException e) {
			System.err.println("PDF error" + e.getMessage());			
		}		
		
		return pdf;		
	}
	
	@RequestMapping("/documents/documentPdf")
	public void downloadPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition","inline;filename="+ "faktura.pdf");
	    try {
	        File f = new File("faktura.pdf");
	        FileInputStream fis = new FileInputStream(f);
	        DataOutputStream os = new DataOutputStream(response.getOutputStream());
	        response.setHeader("Content-Length",String.valueOf(f.length()));
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = fis.read(buffer)) >= 0) {
	            os.write(buffer, 0, len);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
