import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class CourseManager {

    private ArrayList<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    public void viewCourses() {

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n===== COURSE LIST =====");

        for (Course course : courses) {
            System.out.println(course);
            System.out.println("----------------------");
        }
    }

    // ==========================
    // Recursive Search Method
    // ==========================
    private Course recursiveSearch(String courseCode, int index) {

        // Base case
        if (index >= courses.size()) {
            return null;
        }

        Course course = courses.get(index);

        if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
            return course;
        }

        // Recursive call
        return recursiveSearch(courseCode, index + 1);
    }

    // ==========================
    // Search Course
    // ==========================
    public void searchCourse(String courseCode) {

        courseCode = courseCode.trim().toUpperCase();

        Course result = recursiveSearch(courseCode, 0);

        if (result != null) {
            System.out.println("\nCourse Found!");
            System.out.println(result);
        } else {
            System.out.println("Course not found.");
        }
    }

    public void computeTotalUnits() {

        int totalUnits = 0;

        for (Course course : courses) {
            totalUnits += course.getUnit();
        }

        System.out.println("Total Units: " + totalUnits);
    }

    public void saveToFile(String fileName) {

        if (courses.isEmpty()) {
            System.out.println("No courses to save.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Course course : courses) {

                writer.write(course.getCourseCode() + "," +
                             course.getCourseTitle() + "," +
                             course.getUnit());

                writer.newLine();
            }

            System.out.println("Courses saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving file: " + e.getMessage());

        }
    }

    public void loadFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            courses.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String code = data[0];
                String title = data[1];
                int unit = Integer.parseInt(data[2]);

                Course course = new Course(code, title, unit);

                courses.add(course);
            }

            System.out.println("Courses loaded successfully.");

        } catch (IOException e) {

            System.out.println("Error loading file: " + e.getMessage());

        }
    }
}