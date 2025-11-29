package lab2.lab2_12;

public class Course {
    String courseId;
    String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseInfo() {
        return courseId + ": " + courseName;
    }
}
