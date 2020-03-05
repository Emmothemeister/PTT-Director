package Model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	private String words;
	
	public Writer(String words) {
		this.words = words;
		FileWriter fw = null;
		try {
			fw = new FileWriter("/Users/joshua/Desktop/aa.txt", true);
			fw.write(words);
			fw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();		
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

