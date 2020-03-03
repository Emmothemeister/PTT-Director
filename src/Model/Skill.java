package Model;

public class Skill {
	
	private String content;
	
	public Skill(String c) {
		content = c;
	}
	
	public String toString() {
		return "Skill Name:" + content;
	}
	
	public String getSkillName() {
		return content;
	}
}
