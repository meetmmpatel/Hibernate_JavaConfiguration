package com.hibernatedemo.model;

// This is one to many example
// One Post can have many Comments

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "POST_ID")
  private long id;
  
  @Column(name = "postName", nullable = false, unique = true)
  private String postName;
  
  @OneToMany(cascade = CascadeType.ALL)
  private List<Comments> commentsList = new ArrayList<>();
  
  public Post() {
  }
  
  public void addCommnet(Comments comment){
    
    this.commentsList.add(comment);
    
  }
  
  public String getPostName() {
	return postName;
  }
  
  public void setPostName(String postName) {
	this.postName = postName;
  }
  
  public List<Comments> getCommentsList() {
	return commentsList;
  }
  
  public void setCommentsList(List<Comments> commentsList) {
	this.commentsList = commentsList;
  }
  
  @Override
  public String toString() {
	return "Post{" +
			"id=" + id +
			", postName='" + postName + '\'' +
			", comments=" + commentsList +
			'}';
  }
}
