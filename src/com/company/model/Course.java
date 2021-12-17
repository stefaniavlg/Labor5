package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Course model class
 */
public class Course {

    private long idCourse;
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private List<Student> studentsEnrolled = new ArrayList<>();
    private int credits;

    public <R> Course(String s, long parseLong, int parseInt, int parseInt1, R collect) {
    }


    /**
     * Getter name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name
     * @param name -
     */
    public void setName(String name) {
       this.name = name;
   }


    /**
     * GETTER teacher
     * @return teacher
     */
    public Person getTeacher() {
        return teacher;
    }

    /**
     * Setter teacher
     * @param teacher -
     */
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    /**
     * Getter max enrollment
     * @return maxEnrollment
     */
    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    /**
     * Setter max enrollment
     * @param maxEnrollment -
     */
    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    /**
     * Getter list of students enrolled
     * @return studentsEnrolled
     */
    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    /**
     * Setter studentsEnrolled
     * @param studentsEnrolled -
     */
    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    /**
     * Getter credits
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Setter Credits
     * @param credits -
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Constructor Course
     * @param idCourse -
     * @param name -
     * @param teacher -
     * @param maxEnrollment -
     * @param studentsEnrolled -
     * @param credits -
     */
    public Course(Long idCourse, String name, Person teacher, int maxEnrollment, List<Student> studentsEnrolled, int credits) {
        this.idCourse = idCourse;
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }

    /**
     * Construcotr
     */
    public Course(){}


    /**
     * Getter id
     * @return idCourse
     */
    public Long getIdCourse() {
        return idCourse;
    }

    /**
     * Setter id
     * @param idCourse -
     */
    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public Course addStudent(Student student){
        studentsEnrolled.add(student);

        return this;
    }



}
