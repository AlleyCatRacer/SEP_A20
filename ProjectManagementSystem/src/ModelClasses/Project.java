package ModelClasses;

import java.util.ArrayList;
import java.util.IllegalFormatWidthException;

public class Project
{
  private String title;
  private String customerId;
  private String projectId;
  private MyDate deadline;
  private String comment;
  private double timeSpent;
  private String currentStatus;
  private ArrayList<ProjectRelated> requirements;

  public Project(String title,String projectId,String customerId, MyDate deadline, String comment){
    requirements = new ArrayList<>();
    this.title=title;
    this.projectId=projectId;
    this.customerId=customerId;
    this.deadline=deadline;
    this.comment=comment;
    this.timeSpent=0;
    this.currentStatus=Status.WAITING.getStatusString();
  }
//constructor for Project class sets title, projectId, customerId, deadline and comment
//i need to add a way to add project to project list on creation
  public void editStatus(Status status ){
   this.currentStatus =status.getStatusString();
  }
//sets the currentStatus to the String value of Status status
  public void editComment(String comment)
  {
    this.comment = comment;
  }
//Basically a setter for comment
  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }
//Basically a setter for Deadline
  public void changeTitle(String title)
  {
    this.title = title;
  }
//Basically a setter for Title
  public void removeRequirement(String requirementId){
//404
  }
  public void editRequirement(String requirementId){
//404
  }
  public void addNonFunctional(String requirementId, String description,String status){
//404
  }
  
  public void addUserStory(String requirementId, String description,String status,MyDate deadline){
//404
  }

  public void addProjectRelatedRequirement(ProjectRelated requirement){
    String id = requirement.getREQUIREMENTID();
    isValidRequirementID(id);
        requirements.forEach((e) -> {
           if(e.getREQUIREMENTID().equals(id))
           {
             throw new IllegalArgumentException();
           }
         });
        requirements.add(requirement);
  }
  public boolean isValidProjectId(){
    if (!this.projectId.matches("[a-zA-Z0-9]*")){
      throw new IllegalArgumentException();
    }else if (this.projectId.length()>8){
      throw new IllegalFormatWidthException(this.projectId.length());
    }else{
      return true;
    }
  }
  //project id must not contain anything else then numbers and letters/capital letters and should be 8 digits/chars for now
  public boolean isValidTitle(){
    if (!this.title.matches("[a-zA-Z]*")){
      throw new IllegalArgumentException();
    }else if (this.title.length()>25){
     throw new IllegalFormatWidthException(this.title.length());
    }else{
      return true;
    }
  }
  //can only contain letters and max 25 chars for now
  public boolean isValidCustomerId(){
    if (!this.customerId.matches("[a-zA-Z0-9]*")){
      throw new IllegalArgumentException();
    }else if (this.customerId.length()>8){
      throw new IllegalFormatWidthException(this.customerId.length());
    }else{
      return true;
    }
  }
  //same as projectID for now
  public boolean isValidComment(){
    if (!this.comment.matches("[a-zA-Z]*")){
      throw new IllegalArgumentException();
    }else if (this.comment.length()>250){
      throw new IllegalFormatWidthException(this.comment.length());
    }else{
      return true;
    }
  }
  //can only contain letters and max 250 chars for now
  public boolean isValidRequirementID(String REQUIREMENTID) {
    if (REQUIREMENTID.matches("[a-zA-Z0-9]*")){
      throw new IllegalArgumentException();
    }else if (REQUIREMENTID.length()>2){
      throw new IllegalFormatWidthException(REQUIREMENTID.length());
    }else{
      return true;
    }
  }





  @Override public String toString()
  {
    return "Project{" + "title='" + title + '\'' + ", customerId='" + customerId
        + '\'' + ", projectId='" + projectId + '\'' + ", deadline=" + deadline
        + ", comment='" + comment + '\'' + ", timeSpent=" + timeSpent
        + ", currentStatus='" + currentStatus + '}';
  }
}

