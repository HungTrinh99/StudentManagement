package studentmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Minh Hung
 */
public class StudentList {
    
    private List<Student> list = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);
    private StudentFile studentFile;
//  Default Constructor

    public StudentList() {
        studentFile = new StudentFile();
        list = studentFile.readFile();
    }

//    Add student
    public void addStudent() {
        int ID;
        if (list == null) {
            ID = 0;
        } else {
            ID = list.size() + 1;
        }
        System.out.println("Your student ID is:" + ID);
        System.out.print("Enter student name:");
        String name = input.nextLine();
        System.out.print("Enter student age:");
        int age = Integer.parseInt(input.nextLine());
        System.out.print("Enter student address:");
        String address = input.nextLine();
        System.out.print("Enter Student GPA:");
        float GPA = input.nextFloat();
//        Create new Student instance
        Student newStudent = new Student(name, address, age, GPA, ID);
//        add NEW student into array
        list.add(newStudent);
        studentFile.writeFile(list);
    }

//    Edit Student
    public void editStudent(String studentName) {
        //Find Student isExist?
        boolean isExist = false;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(studentName)) {
                index = i;
                isExist = true;
                break;
            }
        }
//        Edit student infor
        if (!isExist) {
            System.out.print("STUDENT " + studentName + " does not exist\n");
        } else {
            System.out.print("Information of student " + list.get(index).getName() + "\n");
            showOneStudent(list.get(index));
            System.out.println("1. Edit name");
            System.out.println("2. Edit age");
            System.out.println("3. Edit address");
            System.out.println("4. Edit GPA");
            int options;
            do {
                System.out.print("Please enter feature that you want to edit:");
                options = input.nextInt();
                switch (options) {
                    case 1:
                        System.out.print("Enter new name:");
                        String name;
                        name = input.nextLine();
                        list.get(index).setName(name);
                        break;
                    case 2:
                        System.out.print("Enter new age:");
                        int age;
                        age = input.nextInt();
                        list.get(index).setAge(age);
                        break;
                    case 3:
                        System.out.print("Enter new address:");
                        String address;
                        address = input.nextLine();
                        list.get(index).setAddress(address);
                        break;
                    case 4:
                        System.out.println("Enter new GPA:");
                        float GPA;
                        GPA = input.nextFloat();
                        list.get(index).setGPA(GPA);
                        break;
                    default:
                        System.out.println("Your option is not available, please choose again!");
                }
                System.out.println("Do you want to continue editing? \n\t1. Yes: press 1\n\t2. No: press 2");
                int isContinue;
                System.out.print("Enter your choice:");
                isContinue = input.nextInt();
                if (isContinue == 1) {
                    continue;
                } else {
                    studentFile.writeFile(list);
                }
                break;
            } while (options >= 1 && options <= 4);
        }
    }

//    Delete student
    public void deleteStudent(String studentName) {
        boolean isExist = false;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(studentName)) {
                index = i;
                isExist = true;
                break;
            }
        }
        
        if (!isExist) {
            System.out.println("Student is not found!!!");
        } else {
            list.remove(index);
            studentFile.writeFile(list);
            System.out.println("Delete successfully...");
        }
    }

//    Sort student by name
    public void sortStudentByName() {
        Collections.sort(list, new SortStudentByName());
    }

//    Sort student by GPA
    public void sortStudentByGPA() {
        Collections.sort(list, new SortStudentByGPA());
    }
//    Show infor all students

    public void show() {
        int i = 1;
        for (Student stu : list) {
            System.out.println("STUDENT " + i + ":");
            System.out.print("\tID:" + stu.getID() + "\n");
            System.out.print("\tName: " + stu.getName() + "\n");
            System.out.print("\tAge:" + stu.getAge() + "\n");
            System.out.print("\tAddress:" + stu.getAddress() + "\n");
            System.out.print("\tGPA:" + stu.getGPA() + "\n\n");
            i++;
        }
    }

//    Show infor one student
    public void showOneStudent(Student stu) {
        System.out.print("\tID:" + stu.getID() + "\n");
        System.out.print("\tName: " + stu.getName() + "\n");
        System.out.print("\tAge:" + stu.getAge() + "\n");
        System.out.print("\tAddress:" + stu.getAddress() + "\n");
        System.out.print("\tGPA:" + stu.getGPA() + "\n\n");
    }
}
