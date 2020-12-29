package ModelClasses;

import java.util.ArrayList;

public class Team
{
    private static ArrayList<TeamMember> roster;

    public Team()
    {
        roster = new ArrayList<>();
    }

    public ArrayList<TeamMember> getTheRoster()
    {
        ArrayList<TeamMember> tmList=new ArrayList<>();
        for (int i = 0; i < roster.size(); i++)
        {
            tmList.add(roster.get(i));
        }
        return tmList;
    }

    public static ArrayList<TeamMember> getRoster()
    {
        return roster;
    }

    public static void addTeamMember(TeamMember teamMember)
    {
        roster.add(teamMember);
    }

    public TeamMember getTeamMemberById(String teamMemberId)
    {
        for (int i = 0; i < roster.size(); i++)
        {
            if (roster.get(i).getTeamMemberId().equals(teamMemberId))
            {
                return roster.get(i);
            }
        }
        throw new IllegalArgumentException("Person with such ID was not found in employees' roster");
    }

    //getTeamMemberByProject should be in project


    public static void hire(String name, String id) {
        if(isIdAvailable(id)) {
            TeamMember human = new TeamMember(name, id);
            roster.add(human);
        }
        else
            throw new IllegalArgumentException("This ID is already taken");
    }

    public static void fire(String teamMemberId)
    {

        for (int i = 0; i < roster.size(); i++)
        {
            if (roster.get(i).getTeamMemberId().equals(teamMemberId))
            {
                roster.remove(roster.get(i));
            }
        }

    }

    public static boolean isIdAvailable(String teamMemberId)
    {
        for (int i = 0; i < roster.size(); i++)
        {
            if (roster.get(i).getTeamMemberId().equals(teamMemberId))
            return false;
        }
        return true;
    }

    public void addTeamMembers(ArrayList<TeamMember> teamMembers)
    {
        for (int i = 0; i < teamMembers.size(); i++)
        {
            roster.add(teamMembers.get(i));
        }
    }
}
