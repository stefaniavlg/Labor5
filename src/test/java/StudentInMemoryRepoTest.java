package test.java;

import com.company.model.Course;
import com.company.model.Student;
import com.company.repository.StudentInMemoryRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class StudentInMemoryRepoTest {

    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    private StudentInMemoryRepository studentrepo = new StudentInMemoryRepository();
    private Student student = new Student(Long.valueOf(12), 12, courses);

    /**
     * test for findOne
     */
    @Test
    public void findOneTest() {
        studentrepo.save(student);
        assertEquals(student, studentrepo.findOne(Long.valueOf(12)));
    }

    /**
     * test for findALL
     */
    @Test
    public void findAllTest() {
        studentrepo.save(student);

    }

    /**
     * test for save
     */
    @Test
    public void saveTest() {
        assertEquals(null, studentrepo.save(student));
    }

    /**
     * test for delete
     */
    @Test
    public void deleteTest() {
        assertEquals(null,studentrepo.delete(Long.valueOf(12)));
    }

    /**
     * test for update
     */
    @Test
    public void updateTest() {
        assertEquals(student,studentrepo.update(student));

    }
}
