package view;

import control.School;
import model.Student;
import java.util.Scanner;


public class SchoolManagement {
    private School school;

    public SchoolManagement() {
        school = new School();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        while (selection != 8) {
            System.out.println("\nSchool Management System\n");
            System.out.println("------------------------");
            System.out.println("1. List all students");
            System.out.println("2. Search student");
            System.out.println("3. Add new student");
            System.out.println("4. Sorting display");
            System.out.println("5. Load data from file");
            System.out.println("6. Write data to file");
            System.out.println("7. Remove student");
            System.out.println("8. Exit");
            System.out.println("------------------------");
            System.out.print("Enter selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    school.printStudents();
                    break;
                case 2:
                    searchMenu();
                    break;
                case 3:
                    addStudent();
                    break;
                case 4:
                    sortMenu();
                    break;
 
                case 5:
                    school.loadDataFromFile();
                    break;
                case 6:
                    school.writeStudentsToFile(school.getStudents());
                    break;
                case 7:
                    removeStudent();
                    break;
                    
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private void searchMenu() {
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        while (selection != 4) {
            System.out.println("\nStudent Search\n");
            System.out.println("------------------------");
            System.out.println("1. Search by ID");
            System.out.println("2. Search by name");
            System.out.println("3. Search by average");
            System.out.println("4. Back");
            System.out.println("------------------------");
            System.out.print("Enter selection: ");
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    school.searchStudent("ID");
                    break;
                case 2:
                    school.searchStudent("Name");
                    break;
                case 3:
                    school.searchStudent("Average");
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private void sortMenu() {
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        while (selection != 4) {
            System.out.println("\nSorting Display\n");
            System.out.println("------------------------");
            System.out.println("1. Sort by ID");
            System.out.println("2. Sort by name");
            System.out.println("3. Sort by average");
            System.out.println("4. Back");
            System.out.println("------------------------");
            System.out.print("Enter selection: ");
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    school.sortStudents("ID");
                    break;
                case 2:
                    school.sortStudents("Name");
                    break;
                case 3:
                    school.sortStudents("Average");
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdd New Student\n");
        System.out.println("------------------------");
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        while (school.checkStudentId(id)) {
            System.out.println("Student ID already exists. Please try again.");
            System.out.print("Enter student ID: ");
            id = scanner.nextLine();
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student average: ");
        double average = scanner.nextDouble();

        while (average < 0 || average > 10) {
            System.out.println("Invalid average. Please try again.");
            System.out.print("Enter student average: ");
            average = scanner.nextDouble();
        }

        Student student = new Student(id, name, average);
        school.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private boolean removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRemove student\n");
        System.out.println("-------------------");
        System.out.println("Enter student ID you want to remove: ");
        String id = scanner.nextLine();
        
        if (removeStudent()){
            System.out.println("Student with ID" + id + "has been removed successfully. ");
        }else{
            System.out.println("Student with ID" + id + "does not exist. ");
        }
        return true;
    }

   
}
