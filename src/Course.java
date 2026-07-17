public class Course {

    private String courseCode;
    private String courseTitle;
    private int unit;

    public Course(String courseCode, String courseTitle, int unit) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.unit = unit;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode +
               "\nCourse Title: " + courseTitle +
               "\nUnit: " + unit;
    }
}