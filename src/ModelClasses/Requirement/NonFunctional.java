package ModelClasses.Requirement;

public class NonFunctional extends Requirement
{
    //Should type be final?
    private final String type;

    public NonFunctional(String requirementId, String description)
    {
        super(requirementId, description);
        this.type = "Non Functional";
    }

    public String getType()
    {
        return type;
    }
    public boolean equals(Object banana) {
        if(!(banana instanceof NonFunctional))
            return false;
        NonFunctional temp = (NonFunctional) banana;
        return(temp.type.equals(type) && temp.getStatus().equals(getStatus()) && temp.getRequirementId().equals(getRequirementId()) && temp.getDescription().equals(getDescription()) && temp.getResponsibleTeamMember().equals(getResponsibleTeamMember()));
    }

    @Override public String toString()
    {
        return "NonFunctional{" + "type='" + type + '\'' + '}';
    }
}
