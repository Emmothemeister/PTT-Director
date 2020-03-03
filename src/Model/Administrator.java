package Model;

import java.util.*;

public class Administrator extends Staff{
	
	private ArrayList<Teacher> toBeReplaced;
	private ArrayList<Teacher> replacement;
	private ArrayList<Staff> training;
	private ArrayList<Course> TBRCourses;
	
	public Administrator(String s, String u, String p, int c, School sch) {
		super(s,u,p,c,sch);
		toBeReplaced = new ArrayList<Teacher>();
		replacement = new ArrayList<Teacher>();
		training = new ArrayList<Staff>();
		TBRCourses = new ArrayList<Course>();
	}
	
	public void setToBeReplacedCourses(Teacher t) {
		TBRCourses = t.getPendingCourse();
	}
	
	public ArrayList<Course> getTBRC(){
		return TBRCourses;
	}
	
	
	public String[] getToBeReplacedCoursesStringArray() {
		String[] toBeReplacedCoursesStringArray = new String[TBRCourses.size()];
		for(int i=0; i<TBRCourses.size();i++) {
			toBeReplacedCoursesStringArray[i] = "Course: " + TBRCourses.get(i).getCourseName();
		}
		return toBeReplacedCoursesStringArray;
	}
	
	//initiate ArrayList toBeReplaced to store the teachers need to be replaced
	public void setToBeReplaced() {
		toBeReplaced.clear();
		school.setTeacherList();
		ArrayList<Teacher>teacherList = school.getTeacherList();
		for(int i=0; i<teacherList.size();i++) {
			if(teacherList.get(i).getAbsent() == true)
			toBeReplaced.add(teacherList.get(i));
		}
	}
	
	public ArrayList<Teacher> getToBeReplacedList(){
		return toBeReplaced;
	}
	
	public String[] getToBeReplacedStringArray() {
		String[] toBeReplacedStringArray = new String[toBeReplaced.size()];
		for(int i=0; i<toBeReplaced.size();i++) {
			toBeReplacedStringArray[i] = "SID: " + toBeReplaced.get(i).getSID() + "  , Staff Name: " + toBeReplaced.get(i).getSName() + "  Courses: " + toBeReplaced.get(i).getPendingCourseString();
		}
		return toBeReplacedStringArray;
	}
	
	//use course as the parameter to find suitable teachers for replacement
	public void setReplacement(Teacher t) {
		replacement.clear();
		ArrayList<Course> requires = t.getPendingCourse();
		school.setTeacherList();
		school.getTeacherList();
		for(int n=0; n <requires.size();n++) {
			Course course = requires.get(n);
			
			for(int i=0; i< school.getTeacherList().size();i++) {
				ArrayList<Course> courseList = school.getTeacherList().get(i).getPendingCourse();
				if(school.getTeacherList().get(i).getAbsent()==false && !courseList.contains(course)) {
					replacement.add(school.getTeacherList().get(i));
				}
			
			}
		}
	}
	
	public String[] getReplacementStringArray() {
		String[] replacementStringArray = new String[replacement.size()];
		for(int i=0; i<replacement.size();i++) {
			replacementStringArray[i] = "SID: " + replacement.get(i).getSID() + "  , Teacher Name: " + replacement.get(i).getSName() + "  Absent: " + replacement.get(i).getAbsent() + "  Skills: " + replacement.get(i).getSkills();
		}
		return replacementStringArray;
	}
	
	public ArrayList<Teacher> getReplacement(){
		return replacement;
	}
	
	//initiate and add Teachers, CourseD, ClassD and FND into training ArrayList
	public void setTraining() {
		training.clear();
		ArrayList<Staff>staffs = school.getStaffList();
		for(int i=0; i<staffs.size();i++) {
//		if(staffs.get(i) instanceof Teacher && staffs.get(i) instanceof CourseD && staffs.get(i) instanceof ClassD || staffs.get(i) instanceof FND) {
			training.add(staffs.get(i));
//		}
		}
	}
	
	public ArrayList<Staff> getTrainees(){
		return training;
	}
	
	public String[] getTrainingStringArray() {
		String[] traineeStringArray = new String[training.size()];
		for(int i=0; i<training.size();i++) {
			traineeStringArray[i] = "SID: " + training.get(i).getSID() + "  , Staff Name: " + training.get(i).getSName() + "  Skills: " + training.get(i).getSkills();
		}
		return traineeStringArray;
	}
	
}
