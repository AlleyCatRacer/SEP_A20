package ModelClasses;

import java.util.ArrayList;

public class Team
{
    private ArrayList<TeamMember> team;
    private ArrayList<TeamMember> allTeamMembers;
    private ArrayList<Team> allTeams;

    public Team(String teamId)
    {
        this.team = new ArrayList<>();
        addNewTeam(team);
    }

    public Team()
    {
        this.allTeamMembers=new ArrayList<>();
        this.allTeams=new ArrayList<>();
    }

    public void editRole(String teamMemberId, String role) throws //exception
    {
        for (int i = 0; i < team.size(); i++)
        {
            if (!(role.equalsIgnoreCase(team.get(i).getRole())))
            {
                team.get(i).editRole(role);
            }
            else
            {
                throw //exception
            }
        }
    }

    public void addNewTeamMember(String name, String teamMemberId)
    {
        TeamMember tm = new TeamMember(name,teamMemberId);
        allTeamMembers.add(tm);
    }

    public void addNewTeam(Team team)
    {
        allTeams.add(team);
    }

    public ArrayList<TeamMember> getAllTeamMembers()
    {
        return TeamMember.getAllTeamMembers();
    }
}
