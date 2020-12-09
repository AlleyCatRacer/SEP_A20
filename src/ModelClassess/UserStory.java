package ModelClassess;

import java.util.ArrayList;

public class UserStory extends Requirement {

  //Should type be final?
  private final String type;
  private TimeSpent timeSpent;
  //Sums the estimates of all the tasks
  private Estimate estimate;
  private String priority;
  //ArrayList of tasks seems to make more sense
  private ArrayList<Task> tasks;
  //Deadline as an instance variable of a sub class, not super class
  private MyDate deadline;

  public UserStory(String REQUIREMENTID, String description, TimeSpent timeSpent, String priority, MyDate deadline) {
    super(REQUIREMENTID, description);
    this.type = "User Story";
    this.timeSpent = timeSpent;
    this.estimate = calculateEstimate();
    this.priority = priority;
    this.tasks = new ArrayList<Task>();
    this.deadline = deadline;
  }

  public String getType() {
    return type;
  }
  public TimeSpent getTimeSpent() {
    return timeSpent;
  }
  public Estimate calculateEstimate() {
        double hours=0;
        String id=getREQUIREMENTID();
        for (int i = 0; i < tasks.size(); i++) {
            hours += tasks.get(i).getEstimate().getHours();
        }
        Estimate estimate = new Estimate(hours,id);
        return estimate;
  }
  public String getPriority() {
    return priority;
  }
  public ArrayList<Task> getTasks() {
    return tasks;
  }
  public MyDate getDeadline() {
    return deadline;
  }
  public void updateTimeSpent(TimeSpent timeSpent) {
    this.timeSpent = timeSpent;
  }
  public void changePriority(String priority) {
    this.priority = priority;
  }

  public void addTask(Task task) {
    if(isLegalTaskID(task)) {
      tasks.add(task);
      calculateEstimate();
    }
  }
  //for all the taskID's I don't know will they be final
  //Should we have a second parameter of type TeamMember?
  public void assignTask(String taskID, TeamMember teamMember) {
    for(int i = 0; i < tasks.size(); i++) {
      if(tasks.get(i).getTaskID.equals(taskID)) {
        tasks.get(i).setResponsibleTeamMember(teamMember);
        break;
      }
    }

  }
  public void editTask(String taskID) {

  }
  public void removeTask(String taskID) {
    for(int i = 0; i < tasks.size(); i++) {
      if(tasks.get(i).getTaskID.equals(taskID)) {
        tasks.remove(i);
        calculateEstimate();
        break;
      }
    }

  }
  public boolean isLegalTaskID(Task task) {
    int count = 0;
    for(int i = 0; i < tasks.size(); i++) {
      if(tasks.get(i).getTaskID.equals(task.getTaskID))
        count++;
    }
    return(count == 0);

  }
  public void changeDeadline(MyDate deadline) {
    this.deadline = deadline;
  }
  public boolean isLegalDeadline(MyDate deadline) {

  }
  //if all the tasks have status "Ended", the requirement automatically becomes "Testing"
  public boolean completionCheck() {
  }












  public boolean equals(Object banana) {

  }
  public String toString() {

  }

}
