package Model;

public class Requirement {
	private int requirementID;
	private int newID = 0;
	private String content;
	private Class submitClass;
	
	public Requirement(String cont, Class cla) {
		newID++;
		requirementID = newID;
		content = cont;
		submitClass = cla;
		
	}
}
