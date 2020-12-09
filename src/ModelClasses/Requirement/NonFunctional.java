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
}
