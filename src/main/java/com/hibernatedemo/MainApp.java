package com.hibernatedemo;

import com.hibernatedemo.model.*;
import com.hibernatedemo.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {
  public static final Logger LOGGER = LogManager.getLogger(MainApp.class);

  public static void main(String[] args) {
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();

      Comments commentOne = new Comments();
      commentOne.setTitle("Java Title");
      commentOne.setText("Java comment text");

      Comments commentTwo = new Comments();
      commentTwo.setTitle("Hibernate Title");
      commentTwo.setText("Hibernate comment text");

      Post postOne = new Post();
      postOne.setPostName("Java Post");
      postOne.getCommentsList().add(commentOne);
      postOne.getCommentsList().add(commentTwo);

      Address addressOne = new Address();
      addressOne.setCity("Falls Church");
      addressOne.setState("VA");
      addressOne.setAddressType(AddressType.COMMUNICAION);
      addressOne.setPhone(Phone.MOBILE);
      session.save(addressOne);

      Department departmentOne = new Department();
      departmentOne.setName("IT");

      Employee employeeOne = new Employee();
      employeeOne.setName("Mike Miller");
      employeeOne.setDesiganation("Sr, Developer");
      employeeOne.setDepartment(departmentOne);

      Employee employeeTwo = new Employee();
      employeeTwo.setName("John Wilber");
      employeeTwo.setDesiganation("Project Manager");
      employeeTwo.setDepartment(departmentOne);

      session.save(postOne);
      session.save(departmentOne);
      session.save(employeeOne);
      session.save(employeeTwo);

      transaction.commit();

      LOGGER.info("Address has been added into Database");

    } catch (Exception e) {
      if (transaction != null) {
        LOGGER.error("Transaction is being rolled back");
        e.printStackTrace();
        transaction.rollback();
      }
    } finally {
      LOGGER.info("Shutdown the hibernate connection");
      HibernateUtil.shutdown();
    }
  }
}
