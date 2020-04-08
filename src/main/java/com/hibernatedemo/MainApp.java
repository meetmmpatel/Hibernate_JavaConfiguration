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

      session.save(departmentOne);
      session.save(employeeOne);
      session.save(employeeTwo);

      transaction.commit();

      LOGGER.info("Address has been added into Database");

    } catch (Exception e) {
      if (transaction != null) {
        LOGGER.error("Transaction is being rolled back");
        transaction.rollback();
      }
    } finally {
      LOGGER.info("Shutdown the hibernate connection");
      HibernateUtil.shutdown();
    }
  }
}
