package jpa;

import Entities.EEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {

    //JPA connection
        List<EEntity> entityes;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(EEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new EEntity(1, "assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000));
            session.save(new EEntity(2, "assets/HUSKY-TSV.jpg", "HUSKY TSV", 1200));
            session.save(new EEntity(3, "assets/BATT-UMG.jfif", "BATT UMG", 900));

            entityes = (List<EEntity>) session.createQuery("from Entity").list();

            session.getTransaction().commit();
        }

        System.out.println("---JPA---");
        for(EEntity entity : entityes) {
            System.out.println(entity);
        }
        System.out.println("SUCCESS!");
    }
}
