package com.hibernatedemo.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EMP_ID")
  private long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "DESIGANATION")
  private String desiganation;

  @ManyToOne
  @JoinColumn(name = "DPT_ID", foreignKey = @ForeignKey(name = "DPT_ID_FK"))
  private Department department;

  public Employee() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesiganation() {
    return desiganation;
  }

  public void setDesiganation(String desiganation) {
    this.desiganation = desiganation;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", desiganation='"
        + desiganation
        + '\''
        + ", department="
        + department
        + '}';
  }
}
