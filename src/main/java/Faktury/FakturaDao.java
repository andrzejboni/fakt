package Faktury;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


// database object
public class FakturaDao {

    public boolean saveStudentIntoDataBase(Faktura faktura) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(faktura);
            //zamyka transak i zatwierdza zmiany
            transaction.commit();
        } catch (SecurityException se) {
            //w razie błędu przyweóci stan sprzed transakcji
            if (transaction != null) {

                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public List<Faktura> getAllStudentsFromDataBase() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Query<Faktura> query = session.createQuery("from Faktura st", Faktura.class);
            List<Faktura> faktury = query.list();
            return faktury;
        } catch (SecurityException se) {
            //jeśli coś pójdzie nietak - wypiszmy komunikat
            //
            System.err.println("nie udało się pobrać z bazy");

        }
        return new ArrayList<>();
    }
}
