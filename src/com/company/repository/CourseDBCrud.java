package com.company.repository;


import com.company.model.Course;
import com.company.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDBCrud {
    private ConnectToDB conDB = new ConnectToDB();
    public CourseDBCrud() {
        conDB = new ConnectToDB();
    }

    /**
     * CREATE course
     * @param cour
     */
    public void add(Course cour) {
        String query = "INSERT INTO `course`(`idCourse`, `name`, `maxEnrollment`) values(?, ?, ?)";
        try {
            conDB.connectDB();
            PreparedStatement stmt = conDB.getConnection().prepareStatement(query);

            stmt.setLong(1, cour.getIdCourse());
            stmt.setString(2, cour.getName());
            stmt.setInt(3, cour.getMaxEnrollment());

            stmt.execute();
        }catch(Exception ex) {
            System.out.println("Not Created");
        }
    }

    /**
     * Read
     * @return
     */
    public List<Course> showAll() {
        List<Course> courList = new ArrayList<>();
        try {
            conDB.connectDB();
            PreparedStatement stmt = conDB.getConnection().prepareStatement("SELECT * FROM course");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                long id = result.getLong("idCourse");
                String name = result.getString("name");
                int maxEnroll = result.getInt("maxEnrollemnt");

                Course cour = new Course(id, name, maxEnroll);
                courList.add(cour);

                System.out.println("Id: " + cour.getIdCourse() + ", name: " + cour.getName() + ", maxEnroll: " + cour.getMaxEnrollment());
            }
        }catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("No Course found");
        }
        return courList;
    }

    /**
     * UPDATE Course
     * @param oldCour
     * @param newCour
     */
    public void update(Course oldCour, Course newCour) {
        try {
            conDB.connectDB();
            String query = "UPDATE `course` SET `name`=?, `maxEnrollment`=? WHERE `idCourse`=" + oldCour.getIdCourse();
            PreparedStatement stmt = conDB.getConnection().prepareStatement(query);
            stmt.setString(1, newCour.getName());
            stmt.setInt(2, newCour.getMaxEnrollment());

            stmt.executeUpdate();
            System.out.println("Updated");
        }catch(Exception ex) {
            System.out.println("No Update");
        }
    }

    /**
     * DELETE Course
     * @param id
     */
    public void delete(long id) {
        try {
            conDB.connectDB();
            String query = "DELETE FROM `course` WHERE `idCourse`="+ id;
            PreparedStatement stmt = conDB.getConnection().prepareStatement(query);
            stmt.execute();
            System.out.println("Deleted");
        }catch(Exception ex) {
            System.out.println("No Delete");
        }
    }
    public void find(long id) {
        List<Course> courList= new ArrayList();
        try {
            conDB.connectDB();
            PreparedStatement stmt = conDB.getConnection().prepareStatement("SELECT * FROM `course` WHERE `idCourse`=" + id);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                long idC = result.getLong("idCourse");
                String name = result.getString("name");
                int maxEnroll = result.getInt("maxEnrollment");

                Course cour = new Course(idC, name, maxEnroll);
                courList.add(cour);

                System.out.println("Id: " + cour.getIdCourse() + ", name: " + cour.getName() + ", maxEnroll: " + cour.getMaxEnrollment());
            }
        }catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("No Course found");
        }
    }

}
