/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.Scanner;

/**
 *
 * @author Minh Hung
 */
public class StudentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        showMenu();
        StudentList studentList = new StudentList();
        int options;
        do {
            String name;
            System.out.print("Please, enter your options:");
            options = Integer.parseInt(scanner.nextLine());
            switch (options) {
                case 1:
                    studentList.addStudent();
                    break;
                case 2:
                    System.out.print("Enter student's name that you want to delete:");
                    name = scanner.nextLine();
                    studentList.deleteStudent(name);
                    break;
                case 3:
                    System.out.print("Enter student's name that you want to change:");
                    name = scanner.nextLine();
                    studentList.editStudent(name);
                    break;
                case 4:
                    studentList.show();
                    break;
                case 5:
                    studentList.sortStudentByGPA();
                    System.out.println("Sorting by GPA successfully");
                    break;
                case 6:
                       studentList.sortStudentByName();
                       System.out.println("Sorting by Name successfully");
                    break;
                case 7:
                    System.out.println("EXIT...");
                    break;
                default:
                    System.out.println("Your optionn is not available!\n");
            }
            if (options == 7) {
                break;
            }
        } while (options >= 1 || options <= 7);
    }

    public static void showMenu() {
        System.out.println("1. Add student");
        System.out.println("2. Delete student by Name");
        System.out.println("3. Edit student");
        System.out.println("4. Show student list");
        System.out.println("5. Sort student by GPA");
        System.out.println("6. Sort student by Name");
        System.out.println("7. Exit");
    }
}
