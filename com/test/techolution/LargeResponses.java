package com.test.techolution;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LargeResponses {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\Mohan\\Desktop\\test_large.txt";
		getLargeRespnseDetails(filePath);
	}

	private static int [] getLargeRespnseDetails(String filePath) {
		
		int lines = 0 ;
		try {
			File file =new File(filePath);
			String filename = file.getName().substring(0, file.getName().lastIndexOf('.'));
			long output[]= countLinesInFile(file);
			for (long l : output) {
				System.out.println(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static long[] countLinesInFile(File file) {
		long output[] = null;
		int linenumber = 0;
		int no_of_large_bytes_records = 0;
		long largeBytesSize = 0;
		
		int maxRecordsAllowd = (int) Math.pow(10, 5);
		long maxAllowedBytes = (long) Math.pow(10,12);
		
		try(FileReader fr = new FileReader(file);
				LineNumberReader lnr = new LineNumberReader(fr)){
			String line = "";
			output = new long[2];
			while ( (line = lnr.readLine()) != null){
				String lastWord = line.substring(line.lastIndexOf(" ")+1);
				int size = Integer.parseInt(lastWord);
				
				//checking constrains
				linenumber++;
				if(linenumber > maxRecordsAllowd) {
					return output;
				}
				if(size > maxAllowedBytes) {
					return output;
				}else if(size > 5000) {
					largeBytesSize = largeBytesSize + size;
					no_of_large_bytes_records ++;
				}
			}
			lnr.close();
			output[0] = no_of_large_bytes_records;
			output[1] = largeBytesSize;
			return output;
		}catch(IOException e){
			e.printStackTrace();
		}
		return output;
	}
}
