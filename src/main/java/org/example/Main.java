package org.example;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
          1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
          1.1 Найти максимальное
          1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
          1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
         */
        runFirstHalfOfHomework();

        /*
        2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
        2.1 Создать список из 10-20 сотрудников
        2.2 Вывести список всех различных отделов (department) по списку сотрудников
        2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        */

        runSecondHalfOfHomework();


    }
    public static void runFirstHalfOfHomework() {
        // 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        Random random = new Random();
        List<Integer> list = random.ints(1000, 1, 1000000).boxed().toList();

        // 1.1 Найти максимальное
        Integer max = list.stream().max(Integer::compare).orElse(0);
        list.forEach(System.out::println);
        System.out.println("\n1.1 Max number: " + max);

        // 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        int sum = list.stream().filter(n -> n > 500000).map(n -> n * 5 - 150).mapToInt(Integer::intValue).sum();
        System.out.println("1.2 Sum of numbers: " + sum);

        // 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        long count = list.stream().filter(n -> n * n < 100000).count();
        System.out.println("1.3 Count: " + count);
    };

    public static void runSecondHalfOfHomework() {
        List<Employee> employeeList = createEmployeeList();

        // 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        Set<String> departmentSet = employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println("\n2.2 Departments: " + departmentSet);

        // 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        System.out.print("2.3\n");
        employeeList.stream().filter(s -> s.getSalary() < 10_000).peek(s -> s.setSalary(s.getSalary() * 1.2))
                .forEach(System.out::println);


        // 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> departmentMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\n2.4");
        departmentMap.forEach((key, value) -> System.out.println(key + " " + value));


        // 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> salaryMap = employeeList.stream().collect(Collectors.
                groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\n2.5");
        salaryMap.forEach((key, value) -> System.out.println(key + " " + value));

    }




    public static List<Employee> createEmployeeList() {
        // 2.1 Создать список из 10-20 сотрудников
        return List.of(
                new Employee("Josh", 45, 60_000, "Engineering"),
                new Employee("Sam", 45, 35_000, "IT"),
                new Employee("Marty", 45, 7_000, "Art"),
                new Employee("Paul", 45, 50_000, "IT"),
                new Employee("Ivan", 45, 60_000, "Finance"),
                new Employee("Sarah", 45, 100_000, "Trading"),
                new Employee("Jessie", 45, 9_000, "Medicine"),
                new Employee("Arthur", 45, 8_500, "Engineering"),
                new Employee("Pavel", 45, 5_000, "Trading"),
                new Employee("Miko", 45, 60_000, "IT"),
                new Employee("Gleb", 45, 20_000, "Finance"));
    }
}