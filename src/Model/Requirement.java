package Model;

public class Requirement {
	private int requirementID;
	private String content;
	private Classes submitClass;
	private Time submitTime;
	
	public Requirement(String cont, Classes cla) {
		requirementID = requirementID++;
		content = cont;
		submitClass = cla;
		submitTime = new Time();
	}
	
	public String getContt() {
		return content;
	}
	
	public Classes getClasses() {
		return submitClass;
	}
}
