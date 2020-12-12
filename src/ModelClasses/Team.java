package ModelClasses;

import java.util.ArrayList;

public class Team
{
    private static ArrayList<TeamMember> teamMembers;

    public Team()
    {
        teamMembers = new ArrayList<>();
    }

    public static ArrayList<TeamMember> getTheRoster() {
        return teamMembers;
    }

    public TeamMember getTeamMemberById(String teamMemberId)
    {
        for (int i = 0; i < teamMembers.size(); i++)
        {
            if (teamMembers.get(i).getTeamMemberId().equals(teamMemberId))
            {
                return teamMembers.get(i);
            }
        }
        throw new IllegalArgumentException();
    }

    //getTeamMemberByProject should be in project

    public void editRole(String teamMemberId, Role role)
    {
        for (int i = 0; i < teamMembers.size(); i++)
        {
            if (teamMembers.get(i).getTeamMemberId().equals(teamMemberId))
            {
                teamMembers.get(i).setRole(role);
            }
        }
    }

    public void addTeamMember(TeamMember teamMember)
    {
        teamMembers.add(teamMember);
    }

    public void removeTeamMember(String teamMemberId)
    {
        boolean doesExist = false;
        for (int i = 0; i < teamMembers.size(); i++)
        {
            if (teamMembers.get(i).getTeamMemberId().equals(teamMemberId))
            {
                doesExist = true;
                TeamMember member = teamMembers.get(i);
                teamMembers.remove(member);
            }
        }
        if (!doesExist) throw new IllegalArgumentException();
    }

    public boolean isIdTaken(String teamMemberId)
    {
        for (int i = 0; i < teamMembers.size(); i++)
        {
            if (teamMembers.get(i).isExisting(teamMemberId))
            {
                return true;
            }
        }
        return false;

    }


}
