package ModelClasses;

public enum Role
{
    TEAM_MEMBER("Team member"), SCRUM_MASTER("Scrum master"), PRODUCT_OWNER("Product owner");
    private String role;

    Role(String role)
    {
        this.role = role;
    }
}
