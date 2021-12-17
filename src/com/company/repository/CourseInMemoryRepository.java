package com.company.repository;



import com.company.model.Course;

import java.util.List;

public class CourseInMemoryRepository implements ICrudRepository<Course> {

    private List<Course> courses;
    public CourseInMemoryRepository setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }

    @Override
    public Course findOne(Long idEntity){
        for (Course course:courses) {
            if(course.getIdCourse()== idEntity){
                return course;
            }
        }
        return null;
    }

    @Override
    public Iterable<Course> findAll(){
        return courses;
    }

    @Override
    public Course save(Course entity){
        if(findOne(entity.getIdCourse())==null){
            courses.add(entity);
            return null;
        }
        return findOne(entity.getIdCourse());
    }

    @Override
    public Course delete(Long id){
        if(findOne(id)!=null){
            Course c = new Course();
            c = findOne(id);
            courses.remove(id);
            return c;
        }
        return null;
    }

    @Override
    public Course update(Course entity){
        if(findOne(entity.getIdCourse())!=null){
            for (Course course : courses) {
                if(course.getIdCourse()==entity.getIdCourse()){
                    course.setName(entity.getName());
                    course.setMaxEnrollment(entity.getMaxEnrollment());
                    course.setCredits(entity.getCredits());
                    course.setTeacher(entity.getTeacher());
                    course.setStudentsEnrolled(entity.getStudentsEnrolled());
                }
                return null;
            }
        }
        return entity;
    }
}
