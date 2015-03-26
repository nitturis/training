package com.mydomain;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

public class LineReader {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("src/com/mydomain/LineReader.java");
		
		FileOutputStream fos = new FileOutputStream("src/com/mydomain/LineReaderNew.java");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-16");
		
		System.out.println("File encoding: "+fr.getEncoding());
		LineNumberReader lnr = new LineNumberReader(fr);
		String line=null;
		
		while((line=lnr.readLine())!=null){
			System.out.println(line);
			osw.write(line+"\n");
		}
		osw.close();
		fr.close();
	}
}
