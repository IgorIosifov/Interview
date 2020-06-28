import org.hibernate.Session;
import java.util.List;

public class StudentsDAO {

    public void save(Student student,Session session) {
        session.save(student);
    }

    public void update(Student student,Session session) {
        session.update(student);
    }

    public Student findById(long id,Session session) {
        return (Student) session.get(Student.class, id);
    }

    public void delete(Student student,Session session) {
        session.delete(student);
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAll(Session session) {
        return (List<Student>) session.createQuery("from Student").list();
    }

    public void deleteAll(Session session) {
        List<Student> students = findAll(session);
        for (Student student : students) {
            delete(student,session);
        }
    }

}
