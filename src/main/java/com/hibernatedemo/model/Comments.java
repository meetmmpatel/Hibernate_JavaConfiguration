package com.hibernatedemo.model;

// One Post can have many comments

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "commentID")
  private long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "text", nullable = false)
  private String text;

  public Comments() {}

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "Comments{" + "id=" + id + ", title='" + title + '\'' + ", text='" + text + '\'' + '}';
  }
}
