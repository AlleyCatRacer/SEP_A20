package ModelClasses;

import java.util.ArrayList;

public class ProjectList
{
  public ArrayList<Project> projects;
  public ProjectList(){
    projects = new ArrayList<>();
  }
  public Project getProjectByTitle(String title){
    int index = 0;
    for (Project e : projects)
    {
      if (e.getTitle() == title)
      {
        index = projects.indexOf(e);
      }

    }

    return projects.get(index);
  }
  public Project getEndedProjectByTitle(String title){
    int index = 0;
    for (Project e : projects)
    {
      if (e.getTitle().equals(title) & e.getCurrentStatus().equals(Status.WAITING.getStatusString()))
      {
        index = projects.indexOf(e);
      }

    }

    return projects.get(index);
  }
  public void addProject(Project project){
      projects.add(project);
  }
  public void removeProject(String title){
    projects.forEach((e) -> {
      if (e.getTitle().equals(title)){
        projects.remove(e);
      }
    });
  }

  public ArrayList<Project> getAllProjects()
  {
    return projects;
  }

  @Override public String toString()
  {
    String s = "Current Projects:\n";
    for (Project project : projects)
    {
      s += project.getTitle()+"\n";
    }
    return s;
  }
}
