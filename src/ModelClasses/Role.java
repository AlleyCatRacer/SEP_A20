package ModelClasses;

/**
 * An enum of Role constants.
 *
 * @author Allie, Lili, Luke & Yoana
 * @version 1.0 - 14.12.20
 */
public enum Role
{
    TEAM_MEMBER("Team member"), SCRUM_MASTER("Scrum master"), PRODUCT_OWNER("Product owner");
    private final String roleString;

    /**
     * One-argument constructor.
     *
     * @param roleString
     *         String value of enum constant
     */
    Role(String roleString)
    {
        this.roleString = roleString;
    }

    /**
     * Getting String value of a Role
     *
     * @return String of the enum constant's role
     */
    public String getRoleString()
    {
        return roleString;
    }
}
