import java.util.Scanner;

// Step 2: Declare Subject class
class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

// Step 3 & 4: Declare Student class with members and array of Subject objects
class Student {
    String name;
    String usn;
    double SGPA;
    Scanner s;
    Subject subject[];

    // Step 5: Constructor to initialize Scanner and subject array
    Student() {
        s = new Scanner(System.in);
        subject = new Subject[8];  // Assuming 8 subjects
        for (int i = 0; i < 8; i++) {
            subject[i] = new Subject();
        }
    }

    // Step 6: Method to accept student details (name and USN)
    void getStudentDetails() {
        System.out.print("Enter Student Name: ");
        name = s.nextLine();
        System.out.print("Enter USN: ");
        usn = s.nextLine();
    }

    // Step 7: Method to accept marks and credits, calculate grades and validate marks
    void getMarks() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Subject " + (i + 1) + ":");
            // Accept marks
            while (true) {
                System.out.print("Enter marks (0 to 100): ");
                subject[i].subjectMarks = s.nextInt();
                if (subject[i].subjectMarks > 100) {
                    System.out.println("Marks cannot be more than 100. Please re-enter.");
                } else if (subject[i].subjectMarks < 0) {
                    System.out.println("Marks cannot be negative. Please re-enter.");
                } else {
                    break;
                }
            }
            // Accept credits
            System.out.print("Enter credits: ");
            subject[i].credits = s.nextInt();

            // Calculate grade based on marks
            subject[i].grade = (subject[i].subjectMarks / 10) + 1;

            if (subject[i].grade == 11) {
                subject[i].grade = 10;
            }
            if (subject[i].subjectMarks < 40) {
                // If marks less than 40, grade is 0 (fail)
                subject[i].grade = 0;
            }
        }
        s.nextLine(); // consume leftover newline
    }

    // Step 8: Method to calculate SGPA
    void computeSGPA() {
        int effectiveScore = 0;
        int totalCredits = 0;

        for (int i = 0; i < 8; i++) {
            effectiveScore += (subject[i].grade * subject[i].credits);
            totalCredits += subject[i].credits;
        }
        SGPA = (double) effectiveScore / (double) totalCredits;
    }

    // Method to display student details along with SGPA
    void display() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.printf("SGPA: %.2f\n", SGPA);
    }
}

// Step 9 & 10: Class with main method to test the program
public class StudentSGPA {
    public static void main(String[] args) {
        Student student = new Student();
        student.getStudentDetails();
        student.getMarks();
        student.computeSGPA();
        student.display();
    }
}

