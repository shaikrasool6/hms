package com.rest.java.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.rest.java.dto.HospitalDto;
import com.rest.java.dto.PatientDto;

public class PatientPdfDocumentView {

	public static ByteArrayInputStream patientPdfReport(PatientDto patient, HospitalDto hospital) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// Add Text to PDF file ->
		try {
			PdfWriter writer=PdfWriter.getInstance(document, out);
			document.open();
			Font font = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 18, BaseColor.DARK_GRAY);
			Paragraph para = new Paragraph(hospital.getName() + " Hospital", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			Chunk linebreak = new Chunk(new LineSeparator());
			document.add(linebreak);
			Paragraph para1=new Paragraph("Discharge Summary",new Font(Font.FontFamily.TIMES_ROMAN,14, Font.BOLDITALIC));
			para1.setAlignment(Element.ALIGN_CENTER);
			document.add(para1);
									
			// Create Paragraph
			Paragraph paragraph = new Paragraph("Patient Details",
					new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD));
			//paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.add(linebreak);
			 
			paragraph.add(new Paragraph("Patient id: " + patient.getPid()+"                                             "+
								  "Hospital Id : "+hospital.getHospId()));
			
			
			
			paragraph.add(new Paragraph("Name: " + patient.getName()+"                                         "+
								  		"Age : "+patient.getAge()+" Years                                    "+
										"Gender:  "+patient.getGender()));
			paragraph.add(new Paragraph("Blood Group: " + patient.getBloodGroup()+"                                  "+
				                     	"Disease: " + patient.getDiseases()));
			paragraph.add(new Paragraph("Address: "+patient.getAddress()));
			paragraph.add(new Paragraph("Admit Date:  " + patient.getAdmitDate()+"                                                                 "+
										"Discharge Date: "+patient.getDischargeDate()));

			document.add(paragraph);
			document.add(linebreak);
			document.add(new Paragraph(new Date().toString()));

			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return new ByteArrayInputStream(out.toByteArray());

	}

}
