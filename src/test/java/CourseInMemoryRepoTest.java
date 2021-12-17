

import com.company.model.Course;
import com.company.model.Person;
import com.company.model.Student;
import com.company.repository.CourseInMemoryRepository;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CourseInMemoryRepoTest {

    private List<Course> courses = new ArrayList<>();
    private Person teacher1 = new Person(Long.valueOf(32),"Ion","Acel");
    private List<Student> students = new ArrayList<>();

    private CourseInMemoryRepository courseRepo = new CourseInMemoryRepository();
    private Course course = new Course(Long.valueOf(45),"Math",teacher1,30,students,60);


    /**
     * test for findOne
     */
    @Test
    public void findOneTest() {
        courseRepo.save(course);
        assertEquals(course, courseRepo.findOne(Long.valueOf(45)));
    }

    /**
     * test for findALL
     */
    @Test
    public void findAllTest() {
        courseRepo.save(course);

    }

    /**
     * test for save
     */
    @Test
    public void saveTest() {
        assertEquals(null, courseRepo.save(course));
    }

    /**
     * test for delete
     */
    @Test
    public void deleteTest() {
       assertEquals(null,courseRepo.delete(Long.valueOf(45)));
    }

    /**
     * test for update
     */
    @Test
    public void updateTest() {
        assertEquals(course,courseRepo.update(course));

    }

}
