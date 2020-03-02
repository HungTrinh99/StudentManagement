/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.*;

/**
 *
 * @author Minh Hung
 */
public class SortStudentByGPA implements Comparator<Student> {

    @Override
    public int compare(Student stu1, Student stu2) {
        return (stu1.getGPA() > stu2.getGPA() ) ? 1 : -1;
    }
}
