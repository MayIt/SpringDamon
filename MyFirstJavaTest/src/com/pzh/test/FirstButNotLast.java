package com.pzh.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

public class FirstButNotLast {
	static final int i=0;
	final int b=1;
	public static void needToStudy(){
		System.out.println("good study"+1);
		System.out.println("day day up"+i+1);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String name="D:/a.pdf";
		pdfToDoc(name);
		
	}
	public static void pdfToDoc(String name1)
		    throws IOException
		  {
		    PDDocument doc = PDDocument.load(name1);
		    int pagenumber = doc.getNumberOfPages();
		    
		    name1 = name1.substring(0, name1.lastIndexOf("."));
		    
		    String dirName = name1;
		    
		    String fileName = dirName + ".doc";
		    createFile(fileName);
		    FileOutputStream fos = new FileOutputStream(fileName);
		    Writer writer = new OutputStreamWriter(fos, "UTF-8");
		    PDFTextStripper stripper = new PDFTextStripper();
		    
		    stripper.setSortByPosition(true);
		    
		    stripper.setStartPage(1);
		    stripper.setEndPage(pagenumber);
		    stripper.writeText(doc, writer);
		    writer.close();
		    doc.close();
		    System.out.println("pdfת��word�ɹ���");
		  }
		  
		  private static void createDir(String destDirName)
		  {
		    File dir = new File(destDirName);
		    if (dir.exists()) {
		      System.out.println("����Ŀ¼ʧ�ܣ�Ŀ��Ŀ¼�Ѵ��ڣ�");
		    }
		    if (!destDirName.endsWith(File.separator)) {
		      destDirName = destDirName + File.separator;
		    }
		    if (dir.mkdirs()) {
		      System.out.println("����Ŀ¼�ɹ���" + destDirName);
		    } else {
		      System.out.println("����Ŀ¼ʧ�ܣ�");
		    }
		  }
		  
		  public static void createFile(String filePath)
		  {
		    File file = new File(filePath);
		    if (file.exists()) {
		      System.out.println("Ŀ���ļ��Ѵ���" + filePath);
		    }
		    if (filePath.endsWith(File.separator)) {
		      System.out.println("Ŀ���ļ�����ΪĿ¼��");
		    }
		    if (!file.getParentFile().exists())
		    {
		      System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");
		      if (!file.getParentFile().mkdirs()) {
		        System.out.println("����Ŀ���ļ����ڵ�Ŀ¼ʧ�ܣ�");
		      }
		    }
		    try
		    {
		      if (file.createNewFile()) {
		        System.out.println("�����ļ��ɹ�:" + filePath);
		      } else {
		        System.out.println("�����ļ�ʧ�ܣ�");
		      }
		    }
		    catch (IOException e)
		    {
		      e.printStackTrace();
		      System.out.println("�����ļ�ʧ�ܣ�" + e.getMessage());
		    }
		  }
}
