package Crud;

import Entities.EEntity;
import jdbc.Connect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

public class SqlCRUD implements CRUDInterface<EEntity> {
    Connection connection;
    List<EEntity> list = new ArrayList<>();

    public SqlCRUD() {
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(EEntity Entity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(EEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(Entity);

            session.getTransaction().commit();
        }
    }

    @Override
    public List<EEntity> read() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(EEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            list = (List<EEntity>) session.createQuery("from EEntity").list();

            session.getTransaction().commit();
        }

        return list;
    }

    @Override
    public void update(int id, EEntity Entity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(EEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            EEntity updatedEEntity = new EEntity(id, Entity.getImg(), Entity.getName(), Entity.getPrice());
            session.update(updatedEEntity);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(EEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(session.get(EEntity.class, id));

            session.getTransaction().commit();
        }
    }






}
