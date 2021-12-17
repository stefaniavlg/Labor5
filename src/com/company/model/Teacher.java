package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * teacher model class
 */
public class Teacher extends Person {


    private List<Course> courses = new ArrayList<>();

    public Teacher(String name, String name1) {
    }

    public Teacher() {

    }

    public <R> Teacher(String s, String s1, R collect) {
    }

    /**
     * getter list of courses
     * @return courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * setter list of courses
     * @param courses -
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    /**
     * Adds a course into his list
     * @param course -
     * @return this
     */
    public Teacher addCourse(Course course) {
        courses.add(course);
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
