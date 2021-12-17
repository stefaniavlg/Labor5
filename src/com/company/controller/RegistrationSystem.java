package com.company.controller;


import com.company.model.Course;
import com.company.model.Student;
import com.company.repository.ICrudRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationSystem {

    private ICrudRepository repository;

    /**
     * @param repository
     */
    public RegistrationSystem(ICrudRepository repository) {
        this.repository = repository;
    }

    /**
     * @return ICrudRepository
     */
    public ICrudRepository getRepository() {
        return repository;
    }

    /**
     * Checks if there is space for a new user and if the users credits do not exceed 30
     * Adds him to the course, and the course to the student
     *
     * @param course
     * @param student
     * @return boolean
     */
    public boolean register(Course course, Student student){
        if(course.getMaxEnrollment() >= getNrOfFreePlaces(course)){
            if(student.getTotalCredits() + course.getCredits() <= 30) {
                course.addStudent(student);
                student.addCourse(course);
                return true;
            }
        }

        return false;
    }

    /**
     * Goes over all the courses, and checks if the course has any available spaces
     * Builds a list with all the courses that meet the criteria, and returns it
     *
     * @return List<Course>
     */
    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> coursesWithFreePlaces = new ArrayList<>();
        for(Course course : getAllCourses()){
            if(getNrOfFreePlaces(course) != 0){
                coursesWithFreePlaces.add(course);
            }
        }

        return coursesWithFreePlaces;
    }

    /**
     * Returns the list of students from a course
     *
     * @param course
     * @return List<Student>
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        return course.getStudentsEnrolled();
    }

    /**
     * Returns a list of all courses
     *
     * @return List<Course>
     */
    public List<Course> getAllCourses(){
        return (List<Course>) repository.findAll();
    }

    /**
     * Serches for the course and deletes it and returns the course if it was succesfully deleted, or null otherwise
     *
     * @param course
     * @return Course
     */
    public Course deleteCourseByTeacher(Course course){
        if (course != null) {
            repository.delete(course.getIdCourse());
            for(Student student : retrieveStudentsEnrolledForACourse(course)){
                student.setTotalCredits(student.getTotalCredits() - course.getCredits());
            }
            return course;
        }

        return null;
    }

    /**
     * Calculetes the free places for a course
     *
     * @param course
     * @return int
     */
    public int getNrOfFreePlaces(Course course){
        if(course.getStudentsEnrolled() == null){
            return course.getMaxEnrollment();
        }

        return course.getMaxEnrollment() - course.getStudentsEnrolled().size();
    }

    /**
     * Sorts the students by first name
     *
     * @param students
     * @return List<Student>
     */
    public List<Student> sortStudents(List<Student> students){
        List<Student> sortedList = new ArrayList<>();
        sortedList.addAll(students);
        Collections.sort(sortedList,new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
            }
        });
        return sortedList;
    }

    /**
     * Filters the courses with a specific number of credits
     *
     * @param credits
     * @return List<Course>
     */
    public List<Course> filterCoursesByCredits(int credits){
        return getAllCourses().stream()
                .filter(course -> course.getCredits() == credits)
                .collect(Collectors.toList());
    }



}
