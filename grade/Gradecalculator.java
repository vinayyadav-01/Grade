
import java.util.Scanner;

public class GradeCalculator {

    static String getGrade(double average) {
        if (average >= 90) {
            return "A+"; 
        }else if (average >= 80) {
            return "A"; 
        }else if (average >= 70) {
            return "B"; 
        }else if (average >= 60) {
            return "C"; 
        }else if (average >= 50) {
            return "D"; 
        }else {
            return "F";
        }
    }

    static double readMarks(Scanner sc, int subjectNo) {
        while (true) {
            System.out.print("Enter marks for subject " + subjectNo + " (out of 100): ");
            if (sc.hasNextDouble()) {
                double marks = sc.nextDouble();
                if (marks >= 0 && marks <= 100) {
                    return marks;
                }
                System.out.println("Marks must be between 0 and 100. Try again.");
            } else {
                System.out.println("Please enter a valid number.");
                sc.next(); // discard invalid input
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Student Grade Calculator ===");

        // Input: number of subjects
        int numSubjects;
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (sc.hasNextInt()) {
                numSubjects = sc.nextInt();
                if (numSubjects > 0) {
                    break;
                }
                System.out.println("Number of subjects must be at least 1.");
            } else {
                System.out.println("Please enter a whole number.");
                sc.next();
            }
        }

        // Input: marks + Calculate total marks
        double totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            totalMarks += readMarks(sc, i);
        }

        // Calculate average percentage
        double average = totalMarks / numSubjects;

        // Grade calculation
        String grade = getGrade(average);

        // Display results
        System.out.println("\n--- Results ---");
        System.out.printf("Total Marks        : %.2f / %d%n", totalMarks, numSubjects * 100);
        System.out.printf("Average Percentage : %.2f%%%n", average);
        System.out.println("Grade              : " + grade);

        sc.close();
    }
}
