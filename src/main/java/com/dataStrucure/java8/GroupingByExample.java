package com.dataStrucure.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByExample {
    public static void main(String[] args) {
        GroupingByExample gt = new GroupingByExample();
//        gt.groupingByExample();
//        gt.groupingByGradeExample();
        gt.groupingByGradeExample1();

    }

    public void groupingByExample() {
        Map<String, List<Student>> studentsWithGender = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));
        System.out.println(studentsWithGender);
    }

    public void groupingByGradeExample() {
        Map<String, List<Student>> studentsWithGPA = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(student -> student.getGpa() > 3.8 ? "OUTSTANDING" : "AVERAGE"));
        System.out.println(studentsWithGPA);
    }

    public void groupingByGradeExample1() {
        Map<Integer, Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() > 3.8 ? "OUTSTANDING" : "AVERAGE")));
        System.out.println(studentMap);
    }
}
