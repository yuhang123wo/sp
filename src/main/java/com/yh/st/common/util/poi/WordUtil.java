package com.yh.st.common.util.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 * 
 * @author yh
 * @Date 2017年12月18日
 * @desc
 */
public class WordUtil {
	/**
	 * 
	 * @Title: getTextFromWord
	 * @Description: 读取word
	 * @param filePath
	 *            文件路径
	 * @return: String 读出的Word的内容
	 */
	@SuppressWarnings("resource")
	public static String getTextFromWord(File file) {
		String result = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			WordExtractor wordExtractor = new WordExtractor(fis);
			result = wordExtractor.getText();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static String getTextFromWord07(String filePath) throws Exception {
		try {
			OPCPackage opcPackage = POIXMLDocument.openPackage(filePath);
			POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
			String text2007 = extractor.getText();
			return text2007;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: getTextFromPdf
	 * @Description: 读取pdf文件内容
	 * @param filePath
	 * @return: 读出的pdf的内容
	 */
	public static String getTextFromPdf(String filePath) {
		String result = null;
		FileInputStream is = null;
		PDDocument document = null;
		try {
			is = new FileInputStream(filePath);
			PDFParser parser = new PDFParser(is);
			parser.parse();
			document = parser.getPDDocument();
			PDFTextStripper stripper = new PDFTextStripper();
			result = stripper.getText(document);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
