import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static CourseManager manager = new CourseManager();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n========================================");
            System.out.println(" STUDENT COURSE MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Compute Total Units");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Course Code: ");
                    String code = scanner.nextLine().trim().toUpperCase();

                    System.out.print("Enter Course Title: ");
                    String title = scanner.nextLine().trim();

                    int unit;

                    try {
                        System.out.print("Enter Course Unit: ");
                        unit = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid unit. Please enter a number.");
                        scanner.nextLine();
                        break;
                    }

                    Course course = new Course(code, title, unit);
                    manager.addCourse(course);
                    break;

                case 2:
                    manager.viewCourses();
                    break;

                case 3:

                    System.out.print("Enter Course Code to Search: ");
                    String searchCode = scanner.nextLine();

                    manager.searchCourse(searchCode);
                    break;

                case 4:
                    manager.computeTotalUnits();
                    break;

                case 5:
                    manager.saveToFile("courses.txt");
                    break;

                case 6:
                    manager.loadFromFile("courses.txt");
                    break;

                case 7:
                    System.out.println("Thank you for using the Student Course Management System.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid menu option. Please choose between 1 and 7.");
            }
        }

        scanner.close();
    }
}