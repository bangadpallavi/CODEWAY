import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
        } else {
            System.out.println("Course is full. Cannot enroll more students.");
        }
    }

    public void removeStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        } else {
            System.out.println("No students to remove from the course.");
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\nEnrolled Students: " + enrolledStudents + "\n";
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent();
    }

    public void removeCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent();
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses.size() + "\n";
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Sample courses
        Course course1 = new Course("CS101", "Introduction to Programming", "Learn programming basics", 30, "Mon/Wed 10:00 AM - 11:30 AM");
        Course course2 = new Course("ENG201", "English Literature", "Explore classic literature", 25, "Tue/Thu 2:00 PM - 3:30 PM");
        Course course3 = new Course("MATH301", "Calculus", "Study advanced calculus concepts", 40, "Mon/Wed/Fri 1:00 PM - 2:30 PM");

        // Sample students
        Student student1 = new Student(101, "John Doe");
        Student student2 = new Student(102, "Jane Smith");

        // Display available courses
        displayCourseListing(course1, course2, course3);

        // Student registration
        student1.registerForCourse(course1);
        student1.registerForCourse(course2);
        student2.registerForCourse(course2);
        student2.registerForCourse(course3);

        // Display student information and registered courses
        displayStudentInformation(student1);
        displayStudentInformation(student2);

        // Student removal of a course
        student1.removeCourse(course2);

        // Display updated student information and registered courses
        displayStudentInformation(student1);
        displayStudentInformation(student2);
    }

    private static void displayCourseListing(Course... courses) {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void displayStudentInformation(Student student) {
        System.out.println("Student Information:");
        System.out.println(student);
        System.out.println("Registered Courses:");
        for (Course course : student.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println();
    }
}
