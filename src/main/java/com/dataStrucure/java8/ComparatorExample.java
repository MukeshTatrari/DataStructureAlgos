package com.dataStrucure.java8;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ComparatorExample {

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        int x = comparator.compare(2, 5);
        System.out.println("Data :::" + x);

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Mukesh", 30, 1000),
                new Employee("Suresh", 32, 2000),
                new Employee("Suresh", 32, 2001)
        ));
        Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge);
        Comparator<Employee> salaryComparator = Comparator.comparing(Employee::getSalary).reversed();
        List<Employee> emps = employees.stream().sorted(ageComparator.thenComparing(salaryComparator))
                .collect(Collectors.toList());
        List<Employee> employees1 = employees.stream().sorted(Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println(emps);
        System.out.println(employees1);

    }
}
