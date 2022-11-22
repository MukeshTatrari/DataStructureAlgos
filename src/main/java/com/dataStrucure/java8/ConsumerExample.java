package com.dataStrucure.java8;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerExample {
    public static void main(String[] args) {
//        printStudents();
//        printActivities();
        printNameAndActivityUsingBiConsumer();
    }

    private static void printActivities() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        Consumer<Student> c1 = s -> System.out.print("Student  :: " + s.getName());
        Consumer<Student> c2 = s -> System.out.println(" , :: " + s.getActivities());
        Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
        Predicate<Student> p2 = s -> s.getGpa() > 3;
        studentList.stream()
                .filter(p1)
                .filter(p2)
                .forEach(c1.andThen(c2));
    }

    private static void printNameAndActivityUsingBiConsumer() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        BiConsumer<String, List<String>> c1 = (name, activities) ->
                System.out.println("Student  :: " + name + ":::: " + activities);
        Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
        Predicate<Student> p2 = s -> s.getGpa() > 3;
        BiPredicate<Integer, Double> p12 = (gradeLevel, cgpa) -> (gradeLevel >= 3 && cgpa > 3);
        studentList.stream()
                .filter(s -> p12.test(s.getGradeLevel(), s.getGpa()))
                .forEach(s -> c1.accept(s.getName(), s.getActivities()));

        studentList.stream()
                .filter(p1.and(p2).negate())
                .forEach(s -> c1.accept(s.getName(), s.getActivities()));
    }

    private static void printStudents() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        Consumer<Student> c1 = s -> System.out.println("Student s :: " + s);
        studentList.forEach(c1);
    }
}
