package com.hibernatedemo.util;

import com.hibernatedemo.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;
  public static final Logger LOGGER = LogManager.getLogger(HibernateUtil.class);

  public static SessionFactory getSessionFactory() {

    if (sessionFactory == null) {
      try {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        Map<String, String> settings = new HashMap<>();
        settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        settings.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/Logs");
        settings.put("hibernate.connection.username", "postgres");
        settings.put("hibernate.connection.password", "root");
        settings.put("hibernate.show.sql", "true");
        settings.put("hibernate.hbm2ddl.auto", "create-drop");

        registryBuilder.applySettings(settings);
        registry = registryBuilder.build();

        MetadataSources sources =
            new MetadataSources(registry)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Comments.class);

        Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();

        LOGGER.info("Session Factory has been created.");

      } catch (Exception e) {
        LOGGER.error("Session Factory Object is not created.");
        if (registry != null) {
          StandardServiceRegistryBuilder.destroy(registry);
        }
      }
    }

    return sessionFactory;
  }

  public static void shutdown() {
    if (registry != null) {
      LOGGER.info("This is HibernateUtil shutdown method");
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }
}
