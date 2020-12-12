package ModelClasses;

import java.util.ArrayList;

public class Team
{
    private static ArrayList<TeamMember> roster = new ArrayList<>();

    public Team()
    {
        roster = new ArrayList<>();
    }

    public static ArrayList<TeamMember> getTheRoster() {
        return roster;
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
        throw new IllegalArgumentException();
    }

    //getTeamMemberByProject should be in project

    public void editRole(String teamMemberId, Role role)
    {
        for (int i = 0; i < roster.size(); i++)
        {
            if (roster.get(i).getTeamMemberId().equals(teamMemberId))
            {
                roster.get(i).setRole(role);
            }
        }
    }

    public static void addTeamMember(String name, String id) {
        TeamMember human = new TeamMember(name, id);
        roster.add(human);
    }

    public static void removeMemberFromTheRoster(String teamMemberId)
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

//    public boolean isIdTaken(String teamMemberId)
//    {
//        for (int i = 0; i < roster.size(); i++)
//        {
//            if (roster.get(i).isExisting(teamMemberId))
//            {
//                return true;
//            }
//        }
//        return false;
//
//    }

}
