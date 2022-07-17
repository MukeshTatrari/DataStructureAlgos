package com.dataStrucure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(100);
        priorityQueue.add(50);
        priorityQueue.add(200);
        priorityQueue.add(500);
        priorityQueue.add(900);
        priorityQueue.add(10);

        System.out.print(priorityQueue);

        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getSalary() - o1.getSalary();
            }
        };

        PriorityQueue<Employee> employees = new PriorityQueue<>(salaryComparator);
        employees.add(new Employee(101, 1000, "Mukesh"));
        employees.add(new Employee(102, 1200, "Suresh"));
        employees.add(new Employee(103, 1400, "Ramesh"));
        employees.add(new Employee(104, 900, "Radhika"));
        employees.add(new Employee(120, 1110, "Sonia"));

        System.out.println(employees.poll().toString());

    }
}

class Employee {
    private Integer id;
    private Integer salary;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(Integer id, Integer salary, String name) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}