package com.company.view;

import com.company.controller.RegistrationSystem;
import com.company.exceptions.InvalidInputException;
import com.company.model.Course;
import com.company.model.Student;
import com.company.repository.StudentInMemoryRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private RegistrationSystem controller;
    private StudentInMemoryRepository studentRepository;

    /**
     * @param controller
     * @param studentRepository
     */
    public ConsoleView(RegistrationSystem controller, StudentInMemoryRepository studentRepository){
        this.controller = controller;
        this.studentRepository = studentRepository;
    }

    /**
     * Menu where all the functionalities are beeing used
     */
    public void consoleApp() {
        Scanner input = new Scanner(System.in);
        boolean next = true;
        int user = 1;
        while(next){
            System.out.println();
            System.out.println("Press 1 for Student");
            System.out.println("Press 2 for Teacher");
            System.out.println("Input: ");
            try {
                try {
                    user = input.nextInt();
                } catch (InputMismatchException e){
                    input.next();
                    throw new InvalidInputException();
                }
                switch (user) {
                    case 1:
                        next = false;
                        break;
                    case 2:
                        next = false;
                        break;
                    default:
                        throw new InvalidInputException();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        int value = 0;
        next = true;
        while(next){
            menu();
            if(user == 2){
                System.out.println("Press 7 to delete a course");
            }
            System.out.println("Input: ");
            try {
                try {
                    value = input.nextInt();
                } catch (InputMismatchException e){
                    input.next();
                    throw new InvalidInputException();
                }

                switch (value) {
                    case 0:
                        next = false;
                        break;
                    case 1:
                        while (true) {
                            printStudents();
                            System.out.println("Enter the ID of the student: ");
                            long idStudent = input.nextLong();
                            Student student = studentRepository.findOne(idStudent);
                            if (student == null) {
                                System.out.println("Student not found");
                                continue;
                            }
                            while (true) {
                                System.out.println("Enter the ID of the course: ");
                                long idCourse = input.nextLong();
                                Course course = (Course) controller.getRepository().findOne(idCourse);
                                if (course == null) {
                                    System.out.println("Course not found");
                                    continue;
                                }
                                if (course.getStudentsEnrolled() != null && course.getStudentsEnrolled().contains(student)) {
                                    System.out.println("Student already enrolled");
                                    continue;
                                }
                                if (controller.register(course, student)) {
                                    System.out.println("Student enrolled succesfully");
                                    break;
                                } else {
                                    System.out.println("No more spaces left or credits exceeded");
                                }
                            }
                            break;
                        }
                        break;
                    case 2:
                        printCourses(controller.getAllCourses());
                        break;
                    case 3:
                        printCoursesWithFreePlaces();
                        break;
                    case 4:
                        while (true) {
                            System.out.println("Enter the ID of the course: ");
                            long idCourse = input.nextLong();
                            Course course = (Course) controller.getRepository().findOne(idCourse);
                            if (course == null) {
                                System.out.println("Course not found");
                                continue;
                            }
                            printEnrolledStudents(course);
                            break;
                        }
                        break;
                    case 5:
                        printSortedStudents();
                        break;
                    case 6:
                        Scanner credits = new Scanner(System.in);
                        List<Course> courses = new ArrayList<>();
                        while(true){
                            System.out.println("Enter the number of credits: ");
                            courses = controller.filterCoursesByCredits(credits.nextInt());
                            if(courses.size() > 0) {
                                printCourses(courses);
                                break;
                            }
                            System.out.println("No Courses Found");
                        }
                        break;
                    case 7:
                        if (user == 1) {
                            System.out.println("Invalid input");
                            break;
                        }
                        while (true) {
                            System.out.println("Enter the ID of the course: ");
                            long idCourse = input.nextLong();
                            Course course = (Course) controller.getRepository().findOne(idCourse);
                            if (course == null) {
                                System.out.println("Course not found");
                                continue;
                            }
                            controller.deleteCourseByTeacher(course);
                            System.out.println("Course succesfully deleted");
                            break;
                        }
                        break;
                    default:
                        throw new InvalidInputException();
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    /**
     * Prints the menu with options to choose from
     */
    public void menu() {
        System.out.println();
        System.out.println("Press 0 to quit");
        System.out.println("Press 1 to enroll student");
        System.out.println("Press 2 to show courses");
        System.out.println("Press 3 to show courses with free places");
        System.out.println("Press 4 to show the enrolled students of a course");
        System.out.println("Press 5 to sort students");
        System.out.println("Press 6 to filter ");
    }

    /**
     * Prints all the created students
     */
    public void printStudents(){
        System.out.println();
        System.out.println("ID, First Name, Last Name, Total Credits");
        for (Object student : studentRepository.findAll()) {
            System.out.println(student);
        }
    }
    /**
     * Prints sorted students
     */
    public void printSortedStudents(){
        System.out.println();
        System.out.println("ID, First Name, Last Name, Total Credits");
        for (Object student : controller.sortStudents((List<Student>) studentRepository.findAll())) {
            System.out.println(student);
        }
    }

    /**
     * Prints all the created courses
     */
    public void printCourses(List<Course> courses){
        System.out.println();
        System.out.println("ID, Course Name, Teacher ID, Teacher Name, Maxim number of students, Students, Credits, Free Places");
        for (Course course : courses) {
            System.out.println(course + ", " + controller.getNrOfFreePlaces(course));
        }
    }

    /**
     * Prints all the courses with available places and their number
     */
    public void printCoursesWithFreePlaces(){
        System.out.println();
        System.out.println("ID, Course Name, Teacher ID, Teacher Name, Maxim number of students, Students, Credits, Free Places");
        for (Course course : controller.retrieveCoursesWithFreePlaces()) {
            System.out.println(course + ", " + controller.getNrOfFreePlaces(course));
        }
    }

    /**
     * Prints all the enrolled students from a course
     * @param course
     */
    public void printEnrolledStudents(Course course){
        System.out.println();
        System.out.println("ID, First Name, Last Name, Total Credits");
        for (Object student : course.getStudentsEnrolled()) {
            System.out.println(student);
        }
    }
}
