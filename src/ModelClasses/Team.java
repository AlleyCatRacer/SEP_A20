package ModelClasses;

import java.util.ArrayList;

public class Team
{
    private static ArrayList<TeamMember> roster;

    public Team()
    {
        roster = new ArrayList<>();
    }

    public static ArrayList<TeamMember> getTheRoster() {
        return roster;
    }

    public void addTeamMember(TeamMember teamMember)
    {
        roster.add(teamMember);
    }

    public static TeamMember getTeamMemberById(String teamMemberId)
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
        boolean doesExist = false;
        for (int i = 0; i < roster.size(); i++)
        {
            if (roster.get(i).getTeamMemberId().equals(teamMemberId))
            {
                doesExist = true;
                roster.remove(roster.get(i));
            }
        }
        if (!doesExist) throw new IllegalArgumentException("Person with such id does not exist");
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

}
