package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * student model class
 */
public class Student extends Person {

    private long studentId;
    private int totalCredits;
    private List<Course> enrolledCourses = new ArrayList<>();

    /**
     * constructor
     * @param studentId -
     * @param totalCredits -
     * @param enrolledCourses -
     */
    public Student(long studentId, int totalCredits, List<Course> enrolledCourses) {
        this.studentId = studentId;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }

    /**
     * constructor
     */
    //public Student(String name, String name2, int i, int i1){}

    public Student() {}
    public <R> Student(String s, String s1, R collect) {}


    /**
     * getter student id
     * @return studentId
     */
    public long getStudentId() {
        return studentId;
    }

    /**
     * setter studentId
     * @param studentId -
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * getter total credits
     * @return totalCredits
     */
    public int getTotalCredits() {
        return totalCredits;
    }

    /**
     * setter total credits
     * @param totalCredits -
     */
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    /**
     * getter enrolled courses
     * @return enrolledCourses
     */
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * setter enrolled coureses
     * @param enrolledCourses -
     */
    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    /**
     * Adds a course into the list of courses and updates the credits of this student
     * @param course -
     * @return this
     */
    public Student addCourse(Course course) {
        enrolledCourses.add(course);
        setTotalCredits(totalCredits + course.getCredits());

        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " " + totalCredits;
    }
}
