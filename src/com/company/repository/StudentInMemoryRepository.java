package com.company.repository;



import com.company.model.Student;

import java.util.List;

public class StudentInMemoryRepository implements ICrudRepository<Student> {

    private List<Student> students;

    public StudentInMemoryRepository setStudents(List<Student> students) {
        this.students = students;

        return this;
    }

    @Override
    public Student findOne(Long idEntity){
        for(Student student : students){
            if(student.getStudentId()== idEntity){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll(){
        return students;
    }


    @Override
    public Student save(Student entity){
        if(findOne(entity.getStudentId())==null){
            students.add(entity);
            return null;
        }
        return findOne((entity.getStudentId()));
    }

    @Override
    public Student delete(Long idEntity){
        if(findOne(idEntity)!=null) {
            Student s = new Student();
            s= findOne(idEntity);
            students.remove(findOne(idEntity));
            return s;
        }
        return null;
    }

    @Override
    public Student update(Student entity){
        if(findOne(entity.getStudentId())!=null) {
            for (int i = 0; i <= students.size(); i++) {
                if (students.get(i).getStudentId() == entity.getStudentId()) {
                    students.get(i).setFirstName(entity.getFirstName());
                    students.get(i).setLastName(entity.getLastName());
                    students.get(i).setTotalCredits(entity.getTotalCredits());
                    return null;
                }
            }
        }
        return entity;
    }
}
