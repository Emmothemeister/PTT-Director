package Model;


public class TeachingRequest {
	private ClassDate classDate;
	private String courseTitle;
	private String teacher;
	
	public TeachingRequest(ClassDate tDate, String courseTitle, String teacher) {
		this.classDate = tDate;
		this.courseTitle = courseTitle;
		this.teacher = teacher;
	}
	
	public String toString() {
		return classDate.toString() + " " + courseTitle;
	}
	
//	public String getClassDateString() {
//		return classDate.toString();
//	}
	
	public ClassDate getClassDate() {
		return classDate;
	}
	
	public String getCourseTitle() {
		return courseTitle;
	}
	
	public String getTeacher() {
		return teacher;
	}

}
