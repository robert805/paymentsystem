package com.other;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;


public class Pdf {

	public String danenadawcy;
	public String adresnadawcy;
	public String kodnadawcy;
	public String daneodbiorcy;
    public String adresodbiorcy;
    public String kododbiorcy;
    public String kwota;
    public String datazawarcia;
    public String tytuloperacji;
    public Email email;
	public Pdf(String danenadawcy, String adresnadawcy, String kodnadawcy, String daneodbiorcy, String adresodbiorcy, String kododbiorcy, String kwota,
			String datazawarcia, String tytuloperacji) {
		
		this.danenadawcy = danenadawcy;
		this.adresnadawcy = adresnadawcy;
		this.kodnadawcy = kodnadawcy;
		this.daneodbiorcy = daneodbiorcy;
		this.adresodbiorcy = adresodbiorcy;
		this.kododbiorcy = kododbiorcy;
		this.kwota = kwota;
		this.datazawarcia = datazawarcia;
		this.tytuloperacji = tytuloperacji;
	}
    
    public boolean create() throws DocumentException, IOException{
    	 Document document = new Document(PageSize.A4);
    	 document.addCreationDate();
    	 
    	 BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
    	 Font helvetica16=new Font(helvetica,16);
    	 Font title= new Font(helvetica, 40);
    	
    	  
    	 
    	try {
    	// krok 2
    	PdfWriter.getInstance(document, new FileOutputStream("PotwierdzeniePrzelewu.pdf"));
    	// krok 3
    	document.open();
    	// krok 4
    	
    	//tytu³
    	Paragraph titleparagraph = new Paragraph("System p³atnoœci", title);
    	titleparagraph.setAlignment(Element.ALIGN_CENTER);
    	document.add(titleparagraph);
    	document.add(new Paragraph(" ", helvetica16));
    	//temat
    	document.add(new Paragraph("Potwierdzenie przelewu", helvetica16));
    	//document.add(Image.getInstance("przerywnik.png"));
    	document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
    	document.add(new Paragraph("Dane nadawcy  : ", helvetica16));
    	document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
    	document.add(new Paragraph("Nazwa nadawcy : " + danenadawcy , helvetica16));
    	document.add(new Paragraph("Adres nadawcy : " + adresnadawcy , helvetica16));
    	document.add(new Paragraph("Kod pocztowy  : " + kodnadawcy , helvetica16));
    	//document.add(Image.getInstance("przerywnik.png"));
    	document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
    	document.add(new Paragraph("Dane odbiorcy : ", helvetica16));
    	document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
    	document.add(new Paragraph("Nazwa odbiorcy : " + daneodbiorcy , helvetica16));
    	document.add(new Paragraph("Adres odbiorcy : " + adresodbiorcy , helvetica16));
    	document.add(new Paragraph("Kod pocztowy   : " + kodnadawcy , helvetica16));
    	//document.add(Image.getInstance("przerywnik.png"));
    	document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
    	document.add(new Paragraph("Kwota: " + kwota , helvetica16));
    	document.add(new Paragraph("Data zawarcia  : " + datazawarcia , helvetica16));
    	document.add(new Paragraph("Tytu³ przelewu : " + tytuloperacji , helvetica16));
    	//document.add(Image.getInstance("przerywnik.png"));
    	document.add(new Paragraph("----------------------------------------------------------------------------------------------------------"));
    	} catch (DocumentException de) {
    	System.err.println(de.getMessage());
    	} catch (IOException ioe) {
    	System.err.println(ioe.getMessage());
    	}
    	// krok 5
    	document.close();
    	return true;
    }
    
	
}
