package ModelClasses;

import java.util.ArrayList;

/**
 * A class of Project ArrayLists.
 *
 * @author Group 1
 * @version 1.0 - 14.12.20
 */
public class ProjectList
{
    public ArrayList<Project> projects;

    /**
     * No-argument constructor creating a new ArrayList of Project objects.
     */
    public ProjectList()
    {
        projects = new ArrayList<>();
    }

    /**
     * Getting a project by it's title.
     *
     * @param title
     *         String of projects title
     *
     * @return Project object
     * @throws IllegalArgumentException
     *         If no project was found with the given title
     */
    public Project getProjectByTitle(String title)
    {
        int index = 0;
        for (Project e : projects)
        {
            if (e.getTitle().equals(title))
            {
                index = projects.indexOf(e);
            }
            else
            {
                throw new IllegalArgumentException("No project found with the given title");
            }
        }
        return projects.get(index);
    }
    public Project getProjectByID(String projectID) {
        for(int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getProjectId().equals(projectID))
                return projects.get(i);
        }
        throw new IllegalArgumentException("Project with such ID was not found " + ".The project ID: " + projectID);
    }

    /**
     * Getting an ended project by it's title.
     *
     * @param title
     *         String of projects title
     *
     * @return Project object
     * @throws IllegalArgumentException
     *         If no ended project was found with the given title
     */
    public Project getEndedProjectByTitle(String title)
    {
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

    /**
     * Calling Project class constructor.
     *
     * @param title
     *         Needs to consist of a combination of no more than 24 letters and/or numbers
     * @param projectId
     *         Needs to be unique ID consisting of a combination of no less than 2 letters and/or numbers
     * @param customerId
     *         Needs to consist of a combination of no more than 24 letters and/or numbers
     * @param deadline
     *         The day needs to be greater than zero and does not exceeds the referenced month's number of days, the
     *         month needs to be greater than zero and less than 12 and the year needs to be greater than zero and
     *         lesser than the current year
     * @param comment
     *         Needs to consist of less than 250 letters
     * @throws IllegalArgumentException
     *         If the given title consists of a combination of more than 24 characters or contains other characters
     *         than letters and/or numbers
     *         If the given project ID consists of a combination of less than 2 or more than 7 characters or contains
     *         other characters than letters and/or numbers
     *         If the given customer ID consists of a combination of more than 7 characters or contains other
     *         characters than letters and/or numbers
     *         If MyDate object's day field isn't greater than zero or exceeds the referenced month's number of days
     *         If MyDate object's month field isn't greater than zero or exceeds 12
     *         If MyDate object's year field isn't greater than zero or is lesser than the current year
     *         If the comment consist of more than 249 characters or contains other than letters and/or numbers
     */
    public void addProject(String title, String projectId, String customerId, MyDate deadline, String comment)
    {
        Project n = new Project(title, projectId, customerId, deadline, comment);
        projects.add(n);
    }

    /**
     * Removing a project by it's title.
     *
     * @param title
     *         String of projects title
     *
     * @throws IllegalArgumentException
     *         If no project was found with the given title
     */
    public void removeProject(String title)
    {
        projects.forEach((e) ->
        {
            if (e.getTitle().equals(title))
            {
                projects.remove(e);
            }
            else
            {
                throw new IllegalArgumentException("No project found with the given title");
            }
        });
    }

    /**
     * Getting an ArrayList of all projects in the system.
     *
     * @return ArrayList of Project objects
     */
    public ArrayList<Project> getAllProjects()
    {
        return projects;
    }

    /**
     * Converting an ArrayList of projects into a string.
     *
     * @return String of all current projects' titles
     */
    @Override
    public String toString()
    {
        String s = "Current Projects:\n";
        for (Project project : projects)
        {
            s += project.getTitle() + "\n";
        }
        return s;
    }
}
