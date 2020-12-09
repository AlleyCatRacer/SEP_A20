package ModelClasses;

import java.util.ArrayList;

public class TeamMember
{
    private String name;
    private String teamMemberId;
    private ArrayList<Task> tasks;
    private Role role;

    public TeamMember(String name, String teamMemberId)
    {
        this.name = name;
        this.teamMemberId = teamMemberId;
        role = Role.TEAM_MEMBER;
        tasks = new ArrayList<Task>();
    }

    public void logHours(double hours, String taskId)
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            if (tasks.get(i).getTaskId().equals(taskId))
            {
                tasks.get(i).logHours(hours);
            }
        }
    }

    public Task getTaskById(String taskId)
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            if (tasks.get(i).getTaskId().equals(taskId))
            {
                return tasks.get(i);
            }
        }
        IllegalArgumentException e = new IllegalArgumentException("No task found with given ID");
        throw e;
    }

    public double getTimeSpent()
    {
        //TODO
        throw new IllegalArgumentException();
    }

    public String getTeamMemberId()
    {
        return teamMemberId;
    }

    public String getName()
    {
        return name;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public void addNewTeamMember(String name, String teamMemberId)
    {
        if (!(isExisting(teamMemberId)))
        {
            TeamMember newTeamMember = new TeamMember(name, teamMemberId);
        }
        throw new IllegalArgumentException();
    }

    public boolean isExisting(String teamMemberId)
    {
        return (this.teamMemberId.equals(teamMemberId));
    }

}
