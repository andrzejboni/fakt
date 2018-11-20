package Faktury;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//niezbędna klasa jako punkt konfiguracyjny połączenia z hibernate'm
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        //Tworzymy sobie obiekt który pobiera konfiguracje z pliku hibernate cfg xml
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //metadata to informacje dotyczące plikow. zdanych załadowanych wcześniej
        //tworzymy sobie obiekt metadata.
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        //stworzynie sesji z danych zawartych w pliku hibernate cfg xml
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
