package ModelClasses;

import ModelClasses.Requirement.*;
import java.util.ArrayList;
import java.util.IllegalFormatWidthException;

public class Project
{
  private String title;
  private final String customerId;
  private final String projectId;
  private MyDate deadline;
  private String comment;
  private double timeSpent;
  private String currentStatus;
  private ArrayList<Requirement> requirements;

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

  public String getTitle()
  {
    return title;
  }

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
   requirements.forEach((e) -> {

   });
  }

  public void addNonFunctional(String requirementId, String description){
    NonFunctional n=new NonFunctional(requirementId,description);
    String id = n.getRequirementId();
    isValidRequirementID(id);
    isValidComment(description);
    requirements.forEach((e) -> {
      if(e.getRequirementId().equals(id))
      {
        throw new IllegalArgumentException();
      }
    });
    requirements.add(n);
  }
  
  public void addUserStory(String REQUIREMENTID, String description, MyDate deadline){
    UserStory u=new UserStory(REQUIREMENTID,description,deadline);
    String id = u.getRequirementId();
    isValidRequirementID(id);
    setDeadline(deadline);
    isValidComment(description);
    requirements.forEach((e) -> {
      if(e.getRequirementId().equals(id))
      {
        throw new IllegalArgumentException();
      }
    });
    requirements.add(u);
  }

  public void addProjectRelatedRequirement(String requirementId, String description, MyDate deadline){
    ProjectRelated r = new ProjectRelated(requirementId,description,deadline);
    String id = r.getRequirementId();
    isValidRequirementID(id);
    r.getDeadline().isValidDate(r.getDeadline());
    isValidTime(timeSpent);
    isValidComment(description);
        requirements.forEach((e) -> {
           if(e.getRequirementId().equals(id))
           {
             throw new IllegalArgumentException("Please enter a requirement ID containing 2 or more letters and/or numbers that is unique withing the project");
           }
         });
        requirements.add(r);
  }
  public boolean isValidProjectId(String projectId){
    if (!projectId.matches("[a-zA-Z0-9]*")){
      IllegalArgumentException e=new IllegalArgumentException("Please enter a unique project ID containing 2 or more letters and/or numbers");
      throw e;
    }else if (projectId.length()>8){
      throw new IllegalFormatWidthException(this.projectId.length());
    }else{
      return true;
    }
  }
  //project id must not contain anything else then numbers and letters/capital letters and should be 8 digits/chars for now
  public boolean isValidTitle(String title){
    if (!title.matches("[a-zA-Z]*")){
      throw new IllegalArgumentException();
    }else if (title.length()>25){
     throw new IllegalFormatWidthException(this.title.length());
    }else{
      return true;
    }
  }
  //can only contain letters and max 25 chars for now
  public boolean isValidCustomerId(String customerId){
    if (!customerId.matches("[a-zA-Z0-9]*")){
      throw new IllegalArgumentException();
    }else if (customerId.length()>8){
      throw new IllegalFormatWidthException(this.customerId.length());
    }else{
      return true;
    }
  }
  //same as projectID for now
  public boolean isValidComment(String comment){
    if (!comment.matches("[a-zA-Z]*")){
      throw new IllegalArgumentException();
    }else if (comment.length()>250){
      throw new IllegalFormatWidthException(this.comment.length());
    }else{
      return true;
    }
  }
  //can only contain letters and max 250 chars for now
  public boolean isValidRequirementID(String requirementId) {
    if (!requirementId.matches("[a-zA-Z0-9]*")){
      IllegalArgumentException e=new IllegalArgumentException("Please enter a requirement ID containing 2 or more letters and/or numbers that is unique withing the project");
      throw e;
    }else if (requirementId.length()>=2){
      throw new IllegalFormatWidthException(requirementId.length());
    }else{
      return true;
    }
  }
  public boolean isValidTime(double hours)
  {
    if (hours%0.5==0)
    {
      return true;
    }
    else
    {
      IllegalArgumentException e=new IllegalArgumentException("Please enter only whole and/or half hours");
      throw e;
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

