package com.company.repository;

import com.company.model.Course;
import com.company.model.Person;

import java.util.Scanner;


public class CourseDatabaseRepository {

    private static CourseDBCrud courseCRUD = new CourseDBCrud();
    public CourseDatabaseRepository() {}
    public CourseDBCrud getCourseDBCRUD() {
        return courseCRUD;
    }

    //@Override
    public Course add() {
        // TODO Auto-generated method stub
        Course cour = new Course();

        Scanner scanner = new Scanner(System.in);
        System.out.println("idCourse: ");
        Long id = scanner.nextLong();
        cour.setIdCourse(id);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        cour.setName(name);

        int maxEnroll = scanner.nextInt();
        System.out.println("MaxEnrollment: ");
        cour.setMaxEnrollment(maxEnroll);

        return cour;
    }

    //@Override
    public void find() {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("name: ");
        String name = scanner.next();
        courseCRUD.showAll().stream().filter(cour -> cour.equals(name)).findFirst().ifPresent(System.out::println);
    }

    //@Override
    public void delete() {
        // TODO Auto-generated method stub
        System.out.println("ID: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        courseCRUD.showAll().stream().filter(cour -> cour.getName().equals(name)).findFirst().ifPresent(cour -> courseCRUD.delete(cour.getIdCourse()));
    }

    //@Override
    public void update() {
        // TODO Auto-generated method stub
        System.out.println("name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        courseCRUD.showAll().stream().filter(cour -> cour.getName().equals(name)).findFirst().ifPresent(cour -> courseCRUD.update(cour, add()));
    }

}
