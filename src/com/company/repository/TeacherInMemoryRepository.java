package com.company.repository;



import com.company.model.Teacher;

import java.util.List;

public class TeacherInMemoryRepository implements ICrudRepository<Teacher> {

    private List<Teacher> teachers;

    public TeacherInMemoryRepository setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;

        return this;
    }

    @Override
    public Teacher findOne(Long idEntity) {
        for (Teacher teacher : teachers) {
            if (teacher.getIdPerson() == idEntity) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Iterable<Teacher> findAll() {
        return teachers;
    }

    @Override
    public Teacher save(Teacher entity) {
        if (findOne(entity.getIdPerson()) != null) {
            teachers.add(entity);
            return null;
        }
        return findOne(entity.getIdPerson());
    }

    @Override
    public Teacher delete(Long idEntity) {
        if (findOne(idEntity) != null) {
            Teacher tea = new Teacher();
            tea = findOne(idEntity);
            teachers.remove(idEntity);
            return tea;
        }
        return null;
    }

    @Override
    public Teacher update(Teacher entity) {
        if (findOne(entity.getIdPerson()) != null) {
            for (Teacher teacher : teachers) {
                if (teacher.getIdPerson()==entity.getIdPerson()) {
                    teacher.setFirstName(teacher.getLastName());
                    teacher.setLastName(teacher.getLastName());
                    teacher.setCourses(teacher.getCourses());
                }
                return null;
            }
        }
        return entity;
    }
}
