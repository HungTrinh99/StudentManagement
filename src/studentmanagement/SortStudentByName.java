/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.Comparator;

/**
 *
 * @author Minh Hung
 */
public class SortStudentByName implements Comparator<Student> {

    @Override
    public int compare(Student stu1, Student stu2) {
        return stu1.getName().compareTo(stu2.getName());
    }
}
