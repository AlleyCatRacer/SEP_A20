package ModelClasses;

public class NonFunctional extends Requirement
{
    //Should type be final?
    private final String type;

    public NonFunctional(String REQUIREMENTID, String description)
    {

        super(REQUIREMENTID, description);
        this.type = "Non Functional";
    }

    public String getType()
    {
        return type;
    }
}
