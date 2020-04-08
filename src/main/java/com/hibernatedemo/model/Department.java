package com.hibernatedemo.model;

import javax.persistence.*;

@Entity
@Table(name = "DEPARMENT")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "DPT_ID")
  private long id;

  @Column(name = "NAME", nullable = false, unique = true)
  private String name;

  public Department() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
