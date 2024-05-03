package com.piyush.joshi.stream.operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        //Find list of students whose first name starts with alphabet A
        List<Student> listOfFilteredStudentsByName = list.stream().filter(student -> student.getFirstName().startsWith("A")).collect(Collectors.toList());
        printList(listOfFilteredStudentsByName);// can collect in list as well

        //Group The Student By Department Names
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        collect.keySet().stream().forEach(key -> System.out.println(key + " --> " + collect.get(key)));

        //Find the total count of student using stream
        System.out.println(list.stream().count());

        //Find the max age of student
        System.out.println(list.stream().mapToInt(student -> student.getAge()).max());
//        System.out.println(list.stream().map(student -> student.getAge()).mapToInt());

        //Find all departments names
        System.out.println(list.stream().map(student -> student.getDepartmantName()).distinct());  // observe distinct here

        //Find the count of student in each department
        Map<String, Long> collectedCounts = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        collectedCounts.keySet().stream().forEach(key -> System.out.println(key + " --> " + collectedCounts.get(key)));

        //Find the list of students whose age is less than 30
        List<Student> filteredStudents = list.stream().filter(dt -> dt.getAge() < 30).collect(Collectors.toList());
        System.out.println("List of students whose age is less than 30 : " + filteredStudents);

        //Find the list of students whose rank is in between 50 and 100
        List<Student> filteredStudentsWithAgeRange = list.stream().filter(dt -> dt.getRank() > 50 && dt.getRank() < 100)
                .collect(Collectors.toList());
        System.out.println("List of students whose rank is between 50 and 100 : " + filteredStudentsWithAgeRange);

        // Find the average age of male and female students
        Map<String, Double> averageAgeMappingByGender = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        averageAgeMappingByGender.keySet().stream().forEach(key -> System.out.println(key + " --> " + averageAgeMappingByGender.get(key)));

        //Find the department who is having maximum number of students
        Map.Entry<String, Long> stringLongEntry = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(stringLongEntry);

        //Find the Students who stays in Delhi and sort them by their names
        List<Student> delhiStudents = list.stream().filter(student -> student.getCity().equalsIgnoreCase("Delhi")).sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
        printList(delhiStudents);

        //Find the average rank in all departments
        Map<String, Double> averageAgeInAllDepts = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
        System.out.println("Average rank in all departments  : "+averageAgeInAllDepts);

        //Find the student who has second rank
        List<Student> limit = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).limit(1).collect(Collectors.toList());
        printList(limit);
    }

    private static void printList(List<Student> list) {
        list.stream().forEach(student -> System.out.println(student.getFirstName()));
    }
}