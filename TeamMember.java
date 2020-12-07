package ModelClasses;

import java.util.ArrayList;

public class TeamMember
{
    private String name;
    private String teamMemberId;
    private String role;
    private ArrayList<Team> teams;
    private ArrayList<Requirement> responsibleForRequirement;
    private ArrayList<Task> responsibleForTask;

    enum Role
    {
        TEAM_MEMBER("Team member"), SCRUM_MASTER("Scrum master"), PRODUCT_OWNER("Product owner");
        private String role;

        Role(String role)
        {
            this.role = role;
        }

        private boolean isRole(String role)
        {
            return role.equalsIgnoreCase(TEAM_MEMBER.role) || role.equalsIgnoreCase(SCRUM_MASTER.role) || role.equalsIgnoreCase(PRODUCT_OWNER.role);
        }
    }

    TeamMember(String name, String teamMemberId) //needs a throws or call to GUI
    {
        if (!(name.equals(null)) || !(name.equals("")))
        {
            this.name = name;
        }
        if (isValidTeamMemberId(teamMemberId))
        {
            this.teamMemberId = teamMemberId;
        }
        else
        {
            //throw exception or call to GUI for another input
        }
        this.role = Role.TEAM_MEMBER.role;
    }

    public String getName()
    {
        return this.name;
    }

    public String getTeamMemberId()
    {
        return this.teamMemberId;
    }

    public String getRole()
    {
        return this.role;
    }

    public TeamMember[] getAllTeamMembers()
    {
        int counter=0;
        for (int i = 0; i<)
    }

    public void editRole(String role)
    {
        if (Role.TEAM_MEMBER.isRole(role))
        {
            this.role = Role.TEAM_MEMBER.role;
        }
        else if (Role.SCRUM_MASTER.isRole(role))
        {
            this.role = Role.SCRUM_MASTER.role;
        }
        else if (Role.PRODUCT_OWNER.isRole(role))
        {
            this.role = Role.PRODUCT_OWNER.role;
        }
    }

    public ArrayList<Team> getTeams(String teamMemberId)
    {
        for (int i = 0; i < Team.size(); i++)
        {
            if (teamMemberId.)
        }
    }

    public void logHours(double hours, String taskId)
    {

    }

    public Task getTaskById(String taskId)
    {

    }

    public TimeSpent getTimeSpent()
    {

    }

    private static boolean isValidTeamMemberId(String teamMemberId)
    {

    }

    @Override
    public boolean equals()
    {

    }

    @Override
    public String toString()
    {

    }
}
