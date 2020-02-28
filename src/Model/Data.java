package Model;

import java.io.*;
import org.junit.Test;

public class Data {
	@Test
	public void selectVersion() throws IOException {
		if(true) fileVersion();
		if(true) dbVersion();
	}
	
	@Test
	// database version
	public void dbVersion() {
		
	}

	@Test
	// File version
	public void fileVersion() throws IOException {
		if(true) writeIn();
		if(true) read();
	}
	
	@Test
	// at the beginning
	public void writeIn() throws IOException {
		String path = "D:\\Desktop\\ptt.txt";
		File ptt = new File(path);
		FileWriter fw = new FileWriter(ptt);
		BufferedWriter bw = new BufferedWriter(fw);
		
		if(!ptt.exists()) ptt.createNewFile();
		
		//write in 
		bw.append("a\r\n");
		bw.write("b\r\n");
		bw.flush();
		bw.close();
	}
	
	@Test
	// at the end
	public void read() throws IOException {
		String path = "D:\\Desktop\\ptt.txt";
		File ptt = new File(path);
		FileReader fr = new FileReader(ptt);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		line = br.readLine();
		while(line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
}
