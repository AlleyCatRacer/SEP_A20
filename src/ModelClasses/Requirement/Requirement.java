package ModelClasses.Requirement;

import ModelClasses.Status;
import ModelClasses.TeamMember;

import java.util.ArrayList;

//It does not make sense that deadline is in the superclass because NonFunctional requirements do not have deadlines
//It seems that Requirement should be abstract
public abstract class Requirement
{

    //Having the ID final follows the logic of immutable ID
    private final String REQUIREMENTID;
    private String description;
    private Status status;
    //Added an additional instance variable to actually know who is responsible for the requirement
    private TeamMember responsibleTeamMember;
    ArrayList<Requirement> requirementList;

    public Requirement(String requirementId, String description)
    {
        this.REQUIREMENTID = requirementId;
        this.description = description;
        this.status = Status.WAITING;
        this.responsibleTeamMember=null;
        this.requirementList = new ArrayList<>();
    }

    public String getRequirementId()
    {
        return REQUIREMENTID;
    }

    public String getDescription()
    {
        return description;
    }

    public Status getStatus()
    {
        return status;
    }

    public void assignResponsibleTeamMember(TeamMember responsibleTeamMember)
    {
        this.responsibleTeamMember = responsibleTeamMember;
    }

    public TeamMember getResponsibleTeamMember()
    {
        return responsibleTeamMember;
    }

    public void changeDescription(String description)
    {
        this.description = description;
    }

    public void changeStatus(Status status)
    {
        this.status = status;
    }

//  //It should be checked in the project class. And in the UserStory class the validity of TaskID should be checked
//  public boolean isValidRequirementId(String requirementId) {
//
//  }


}
