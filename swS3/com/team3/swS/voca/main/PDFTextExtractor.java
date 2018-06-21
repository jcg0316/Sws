package team3.swS.voca.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFTextExtractor {
	
	public static List<String> readParaFromPDF(String pdfPath, int pageNo, String strStartIndentifier,
			String strEndIdentifier) {
		String returnString = "";
		String pdfFileInText = "";
		List<String> array2 = null;
		Pattern regex = Pattern.compile("[^a-zA-Z]");
		try {
			PDDocument document = PDDocument.load(new File(pdfPath));
			document.getClass();
			if (!document.isEncrypted()) {
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper tStripper = new PDFTextStripper();
				tStripper.setStartPage(tStripper.getStartPage());
				tStripper.setEndPage(tStripper.getEndPage());
				pdfFileInText = tStripper.getText(document);
//				System.out.println(pdfFileInText);

				array2 = new ArrayList<String>();
				Pattern p = Pattern.compile("[a-zA-Z'-]{4,}");
				Matcher matcher = p.matcher(pdfFileInText);
				while (matcher.find()) {
					// System.out.println(matcher.group());
					array2.add(matcher.group().toLowerCase());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "No ParaGraph Found";
		}
		return array2;
		// return "반환값: " + returnString;
	}
	
}
