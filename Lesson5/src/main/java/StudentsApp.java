import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;


public class StudentsApp {
    public static void main(String[] args) {
        SessionFactory factory = HibernateSessionFactory.newSessionFactory();
        StudentsDAO studentsDAO = new StudentsDAO();
        Session session = null;
        try {
            System.out.println("============\n== DELETE_ALL ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
            studentsDAO.deleteAll(session);
            session.getTransaction().commit();

            System.out.println("============\n== FILL ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
            for (int i = 0; i < 10; i++) {
                Student student = new Student();
                student.setName("Name" + i);
                student.setMark(i);
                session.save(student);
            }
            session.getTransaction().commit();

            System.out.println("============\n== CREATE ==\n============");
            Student student = new Student();
            student.setName("Test1");
            student.setMark(11);
            session = factory.getCurrentSession();
            session.beginTransaction();
            studentsDAO.save(student, session);
            session.getTransaction().commit();

            long firstIndex = 0;
            System.out.println("============\n== SELECT ALL ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> students = studentsDAO.findAll(session);
            for (Student s : students) {
                System.out.println(s.toString());
            }
            firstIndex = students.get(0).getId();
            session.getTransaction().commit();

            System.out.println("============\n== FIND BY ID ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student s = studentsDAO.findById(firstIndex, session);
            System.out.println(s);
            session.getTransaction().commit();

            System.out.println("============\n== UPDATE ==\n============");
            session = factory.getCurrentSession();
            session.beginTransaction();
            s.setName("modified name");
            System.out.println(s);
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}

