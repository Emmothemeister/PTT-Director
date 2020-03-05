package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 *  This class is only used for reading file
 */
public class Reader {
	private ArrayList<TeachingRequest> CDtoA = new ArrayList<>();
	private ArrayList<TeachingRequest> AtoP = new ArrayList<>();
	private ArrayList<TeachingRequest> PtoCDT = new ArrayList<>();
	private ArrayList<TeachingRequest> TtoR = new ArrayList<>();
	private ArrayList<TeachingFinished> CDtoT = new ArrayList<>();
	private ArrayList<TeachingFinished> CDtoT2 = new ArrayList<>();
	private ArrayList<TeachingFinished> TtoF = new ArrayList<>();
	private String a,b,c,d,e,f,g,line;
	
	public Reader() {   //Constructor
		
		a = "TypeA";
		b = "TypeB";
		c = "TypeC";
		d = "TypeD";
		e = "TypeE";
		f = "TypeF";
		g = "TypeG";
		
		FileReader fr = null;
		try {
			String readLocalDatabase = "/Users/joshua/Desktop/aa.txt";
			fr = new FileReader(readLocalDatabase);
			Scanner s = new Scanner(fr);
			
			while(s.hasNextLine()) {
				line = s.nextLine();
				String[] tokens = line.split(" ");
				String dataType = tokens[0];
				if(dataType.equals(a)) {
					String courseDate = tokens[1];
					String courseTitle = tokens[2];
					
					String[] dym = courseDate.split("/");
				    int d = Integer.parseInt(dym[0]);
				    int y = Integer.parseInt(dym[1]);
				    int m = Integer.parseInt(dym[2]);
				    CDtoA.add(new TeachingRequest(new ClassDate(d,y,m), courseTitle, ""));
				    continue;
					
				}else if(dataType.equals(b)) {
					String courseDate = tokens[1];
					String courseTitle = tokens[2];
					String teacher = tokens[3];
					
					String[] dym = courseDate.split("/");
				    int d = Integer.parseInt(dym[0]);
				    int y = Integer.parseInt(dym[1]);
				    int m = Integer.parseInt(dym[2]);
				    AtoP.add(new TeachingRequest(new ClassDate(d,y,m),courseTitle,teacher));
				    continue;
					
				}else if(dataType.equals(c)) {
					String courseDate = tokens[1];
					String courseTitle = tokens[2];
					String teacher = tokens[3];
					
					String[] dym = courseDate.split("/");
				    int d = Integer.parseInt(dym[0]);
				    int y = Integer.parseInt(dym[1]);
				    int m = Integer.parseInt(dym[2]);
				    PtoCDT.add(new TeachingRequest(new ClassDate(d,y,m),courseTitle,teacher));
				    continue;
					
				}else if(dataType.equals(d)) {
					String courseDate = tokens[1];
					String courseTitle = tokens[2];
					String teacher = tokens[3];
					
					String[] dym = courseDate.split("/");
				    int d = Integer.parseInt(dym[0]);
				    int y = Integer.parseInt(dym[1]);
				    int m = Integer.parseInt(dym[2]);
				    TtoR.add(new TeachingRequest(new ClassDate(d,y,m),courseTitle,teacher));
				    continue;
					
				}else if(dataType.equals(e)) {
					String courseDate = tokens[1];
					String courseTitle = tokens[2];
					String teacher = tokens[3];
					
					String[] dym = courseDate.split("/");
				    int d = Integer.parseInt(dym[0]);
				    int y = Integer.parseInt(dym[1]);
				    int m = Integer.parseInt(dym[2]);
				    double c = 0.0;
				    CDtoT.add(new TeachingFinished(new TeachingRequest(new ClassDate(d,y,m),courseTitle,teacher), c));
				    continue;
					
				}else if(dataType.equals(f)) {
					String courseDate = tokens[1];
					String courseTitle = tokens[2];
					String teacher = tokens[3];
					
					String[] dym = courseDate.split("/");
				    int d = Integer.parseInt(dym[0]);
				    int y = Integer.parseInt(dym[1]);
				    int m = Integer.parseInt(dym[2]);
				    double c = 0.0;
				    CDtoT2.add(new TeachingFinished(new TeachingRequest(new ClassDate(d,y,m),courseTitle,teacher), c));
				    continue;
					
				}else if(dataType.equals(g)) {
					String courseDate = tokens[1];
					String courseTitle = tokens[2];
					String teacher = tokens[3];
					String claimAmount = tokens[4];
					
					String[] dym = courseDate.split("/");
				    int d = Integer.parseInt(dym[0]);
				    int y = Integer.parseInt(dym[1]);
				    int m = Integer.parseInt(dym[2]);
				    double c = Double.parseDouble(claimAmount);
				    TtoF.add(new TeachingFinished(new TeachingRequest(new ClassDate(d,y,m),courseTitle,teacher), c));
				    continue;
				}
							
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public ArrayList<TeachingRequest> getCDtoA(){
		return CDtoA;
	}
	
	public ArrayList<TeachingRequest> getAtoP(){
		return AtoP;
	}
	
	public ArrayList<TeachingRequest> getPtoCDT(){
		return PtoCDT;
	}
	
	public ArrayList<TeachingRequest> getTtoR(){
		return TtoR;
	}
	
	public ArrayList<TeachingFinished> getCDtoT(){
		return CDtoT;
	}
	public ArrayList<TeachingFinished> getCDtoT2(){
		return CDtoT2;
	}
	
	public ArrayList<TeachingFinished> getTtoF(){
		return TtoF;
	}

}
