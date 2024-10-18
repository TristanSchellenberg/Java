import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeManagementSystem {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // Prompt for the number of students
        System.out.print("Enter the total number of students: ");
        int totalStudents = inputScanner.nextInt();

        List<String> studentNamesList = new ArrayList<>();
        List<Double> gradeList = new ArrayList<>();

        // Collecting names and grades for each student
        for (int studentIndex = 0; studentIndex < totalStudents; studentIndex++) {
            System.out.print("Enter the name of student " + (studentIndex + 1) + ": ");
            String studentName = inputScanner.next();
            studentNamesList.add(studentName);

            System.out.print("Enter the grade of student " + (studentIndex + 1) + ": ");
            double studentGrade = inputScanner.nextDouble();
            gradeList.add(studentGrade);
        }

        // Calculate the average grade
        double averageGrade = calculateAverageGrade(gradeList);

        // Display the results
        System.out.println("\nStudent Grades Report:");
        for (int studentIndex = 0; studentIndex < totalStudents; studentIndex++) {
            System.out.println(studentNamesList.get(studentIndex) + ": " + gradeList.get(studentIndex));
        }

        System.out.println("\nClass Average Grade: " + averageGrade);
    }

    // Method to calculate the average of a list of grades
    private static double calculateAverageGrade(List<Double> gradeList) {
        double totalSum = 0.0;
        for (double grade : gradeList) {
            totalSum += grade;
        }
        return totalSum / gradeList.size();
    }
}
