package ModelClasses;

public enum Role
{
    TEAM_MEMBER("Team member"), SCRUM_MASTER("Scrum master"), PRODUCT_OWNER("Product owner");
    private final String roleString;

    public Role(String roleString)
    {
        this.roleString = roleString;
    }

    public String getRoleString()
    {
        return roleString;
    }
}
