package Model;

public class Requirement {
	private int requirementID;
	private int newID = 0;
	private String content;
	private Class submitClass;
	private Time submitTime;
	
	public Requirement(String cont, Class cla) {
		newID++;
		requirementID = newID;
		content = cont;
		submitClass = cla;
		submitTime = new Time();
	}
}
