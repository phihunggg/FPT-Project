package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class School {
    private ArrayList<Student> students;
    private List<Student> studentList;

    public School() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!checkStudentId(student.getId())) {
            studentList.add(student);
            System.out.println("New student added successfully.");
        } else {
            System.out.println("A student with that ID already exists.");
        }
    }

    public void printStudents() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    public void searchStudent(String searchOption) {
        List<Student> searchResult = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        switch (searchOption) {
            case "ID":
                System.out.print("Enter student ID: ");
                String id = scanner.nextLine();

                for (Student student : studentList) {
                    if (student.getId().equals(id)) {
                        searchResult.add(student);
                    }
                }

                break;
            case "Name":
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                for (Student student : studentList) {
                    if (student.getName().equals(name)) {
                        searchResult.add(student);
                    }
                }

                break;
            case "Average":
                System.out.print("Enter student average: ");
                double average = scanner.nextDouble();

                for (Student student : studentList) {
                    if (student.getAverage() == average) {
                        searchResult.add(student);
                    }
                }

                break;
        }

        if (searchResult.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Matching students:");
            for (Student student : searchResult) {
                System.out.println(student.toString());
            }
        }
    }

    public void sortStudents(String sortOption) {
        switch (sortOption) {
            case "ID":
                Collections.sort(studentList, Comparator.comparing(Student::getId));
                break;
            case "Name":
                Collections.sort(studentList, Comparator.comparing(Student::getName));
                break;
            case "Average":
                Collections.sort(studentList, Comparator.comparing(Student::getAverage));
                break;
        }

        System.out.println("Sorted students:");
        printStudents();
    }
    public boolean checkStudentId(String id) {
    for (Student student : studentList) {
        if (student.getId().equals(id)) {
            return true;
        }
    }
    return false;
}
    public void writeStudentsToFile(List<Student> students) {
    try {
        // Get the path of the sch.txt file
        File file = new File("sch.txt");
        String filePath = file.getAbsolutePath();

        // Create a new file writer
        FileWriter fileWriter = new FileWriter(filePath);

        // Loop through the students and write each one to the file
        for (Student student : students) {
            fileWriter.write(student.getId() + "," + student.getName() + "," + student.getAverage() + "\n");
        }

        // Close the file writer
        fileWriter.close();
        System.out.println("Student data has been written to file.");
    } catch (IOException e) {
        System.out.println("An error occurred while writing student data to file.");
        e.printStackTrace();
    }
}

    public void loadDataFromFile() {
        try{
            File file = new File("sch.txt");
            String filePath = file.getAbsolutePath();
            
            Scanner scanner = new Scanner(new File(filePath));
            
            while (scanner.hasNextLine()) {
            
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            double average = Double.parseDouble(parts[2]);
            Student student = new Student(id, name, average);
            studentList.add(student);
            
        }
            scanner.close();
            System.out.println("Student data has been loaded from file!");
        }catch (IOException e){
            System.out.println("An error occured while loading student data from file!");
            e.printStackTrace();
        }
        
    }
    
    public void removeStudent(String id){
        for(Student student : studentList){
            if(student.getId().equals(id)){
                studentList.remove(student);
                System.out.println("student with id" + id + "has been removed.");
                return;
            }
        }
        System.out.println("No student with id" + id + "found.");
    }

    public List<Student> getStudents() {
    return studentList;
    }
   

}