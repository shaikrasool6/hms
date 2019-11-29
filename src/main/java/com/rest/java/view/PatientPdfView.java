package com.rest.java.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rest.java.dto.PatientDto;

public class PatientPdfView {

	public static ByteArrayInputStream patientPdfReport(PatientDto patient) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// Add Text to PDF file ->
		try {
			PdfWriter.getInstance(document, out);
            document.open();
          
			Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
			Paragraph para = new Paragraph("Patient Data", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(5);

			Stream.of("pid", "name", "gender", "diseases", "email").forEach(headerTitle -> {
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle, headFont));
				table.addCell(header);

			});
			
			PdfPCell idCell = new PdfPCell(new Phrase(patient.getPid().toString()));
			idCell.setPaddingLeft(4);
			idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(idCell);

			PdfPCell name = new PdfPCell(new Phrase(patient.getName()));
			name.setPaddingLeft(4);
			name.setVerticalAlignment(Element.ALIGN_MIDDLE);
			name.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(name);

			PdfPCell gender = new PdfPCell(new Phrase(patient.getGender()));
			gender.setPaddingLeft(4);
			gender.setVerticalAlignment(Element.ALIGN_MIDDLE);
			gender.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(gender);

			PdfPCell diseases = new PdfPCell(new Phrase(patient.getDiseases()));
			diseases.setPaddingLeft(4);
			diseases.setVerticalAlignment(Element.ALIGN_MIDDLE);
			diseases.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(diseases);

			PdfPCell email = new PdfPCell(new Phrase(patient.getEmail()));
			email.setPaddingLeft(4);
			email.setVerticalAlignment(Element.ALIGN_MIDDLE);
			email.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(email);

			document.add(table);
			
			document.add(new Paragraph(new Date().toString()));
			document.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return new ByteArrayInputStream(out.toByteArray());

	}
}
/*

@Component
public class PatientPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=patient.pdf");
		
		Paragraph p=new Paragraph("Appollo Hospital");
		document.add(p);
		
		@SuppressWarnings("unchecked")
		PatientDto patient=(PatientDto) model.get("listOfPatients");
		
		PdfPTable t=new PdfPTable(2);
		t.addCell("Name");
		t.addCell("Address");
		
			t.addCell(patient.getName());
			t.addCell(patient.getAddress());
		
		
		document.add(t);
		
		document.add(new Paragraph(new Date().toString()));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		writer.getInstance(document, os);
		response.getOutputStream().write(os.toByteArray());
		
	}

}
*/